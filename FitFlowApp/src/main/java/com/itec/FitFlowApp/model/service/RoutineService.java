package com.itec.FitFlowApp.model.service;

import com.itec.FitFlowApp.dto.request.RoutineRequestDto;
import com.itec.FitFlowApp.dto.request.SessionRequestDto;
import com.itec.FitFlowApp.dto.response.RoutineResponseDto;
import com.itec.FitFlowApp.dto.response.SessionResponseDto;
import com.itec.FitFlowApp.exeption.EntityException;
import com.itec.FitFlowApp.mapper.RoutineMapper;
import com.itec.FitFlowApp.model.entity.Client;
import com.itec.FitFlowApp.model.entity.Routine;
import com.itec.FitFlowApp.model.entity.Session;
import com.itec.FitFlowApp.model.entity.Trainer;
import com.itec.FitFlowApp.model.repository.RoutineRepository;
import com.itec.FitFlowApp.util.CRUD;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class RoutineService implements CRUD<RoutineResponseDto, RoutineRequestDto> {
    private RoutineRepository routineRepository;
    private RoutineMapper routineMapper;
    private SessionService sessionService;
    private ClientService clientService;
    private TrainerService trainerService;


    @Override
    public RoutineResponseDto create(RoutineRequestDto routineRequestDto) {
        // Verificar si ya existe una rutina con el mismo ID
        if (routineRepository.findById(routineRequestDto.getId()).isPresent()) {
            throw new EntityException("Ya existe una rutina con el código " + routineRequestDto.getId());
        }

        // Buscar el cliente por DNI
        Client client = clientService.getClientByDniOrThrow(routineRequestDto.getClientDni());

        // Buscar el entrenador por DNI
        Trainer trainer = trainerService.getTrainerByDniOrThrow(routineRequestDto.getTrainerDni());

        // Verificar que el entrenador esté vinculado al cliente
        if (!trainer.getClients().contains(client)) {
            throw new IllegalArgumentException("El entrenador no está vinculado a este cliente.");
        }

        // Convertimos el request a entidad
        Routine routine = routineMapper.dtoToEntity(routineRequestDto);

        // Establecemos el cliente y el entrenador en la rutina
        routine.setClient(client);
        routine.setTrainer(trainer);

        // Guardamos la rutina en la base de datos
        routineRepository.save(routine);

        // Añadimos la rutina a la lista de rutinas del cliente
        client.getRoutines().add(routine);

        // Devolvemos la rutina creada como DTO
        return routineMapper.entityToDto(routine);
    }


    @Override
    public List<RoutineResponseDto> findAll() {
        List<Routine>routines = routineRepository.findAll();
        return routines.stream()
                .map(routineMapper::entityToDto)
                .collect(Collectors.toList());
    }

    private Routine getRoutineByCodeOrThrow(Long routineID) {
        return routineRepository.findById(routineID)
                .orElseThrow(() -> new EntityException("La rutina con el ID " + routineID + " no existe"));
    }

    @Override
    public RoutineResponseDto findById(String id) {
        Routine routine = getRoutineByCodeOrThrow(Long.parseLong(id));
        return routineMapper.entityToDto(routine);
    }

    @Override
    public RoutineResponseDto update(RoutineRequestDto routineRequestDto) {
        // Verificamos si la rutina existe por su ID, sino lanzamos excepción
        Routine existingRoutine = routineRepository.findById(routineRequestDto.getId())
                .orElseThrow(() -> new EntityException("Rutina no encontrada"));

        // Actualizamos solo los campos no nulos o no vacíos del DTO

        // Actualizamos el código de la rutina si no está vacío
        if (routineRequestDto.getRoutineCode() != null && !routineRequestDto.getRoutineCode().isEmpty()) {
            existingRoutine.setRoutineCode(routineRequestDto.getRoutineCode());
        }

        // Actualizamos el tipo de rutina si no está vacío
        if (routineRequestDto.getRoutineType() != null && !routineRequestDto.getRoutineType().isEmpty()) {
            existingRoutine.setRoutineType(routineRequestDto.getRoutineType());
        }

        // Actualizamos el entrenador si no está vacío
        if (routineRequestDto.getTrainerDni() != null) {
            Trainer trainer = trainerService.getTrainerByDniOrThrow(routineRequestDto.getTrainerDni());
            existingRoutine.setTrainer(trainer);
        }

        // Actualizamos el cliente si no está vacío
        if (routineRequestDto.getClientDni() != null) {
            Client client = clientService.getClientByDniOrThrow(routineRequestDto.getClientDni());
            existingRoutine.setClient(client);
        }

        // Actualizamos la fecha de creación si está presente
        if (routineRequestDto.getCreationDate() != null) {
            existingRoutine.setCreationDate(routineRequestDto.getCreationDate());
        }

        // Actualizamos la fecha de inicio si está presente
        if (routineRequestDto.getStartDate() != null) {
            existingRoutine.setStartDate(routineRequestDto.getStartDate());
        }

        // Actualizamos el estado activo
        existingRoutine.setActive(routineRequestDto.isActive());

        // Actualizamos el estado de la rutina si está presente
        if (routineRequestDto.getStatus() != null) {
            existingRoutine.setStatus(routineRequestDto.getStatus());
        }

        // Guardamos la rutina actualizada en la base de datos
        Routine updatedRoutine = routineRepository.save(existingRoutine);

        // Devolvemos el DTO actualizado usando el mapper
        return routineMapper.entityToDto(updatedRoutine);
    }


    @Override
    public void delete(String id) {
        Routine routine = getRoutineByCodeOrThrow(Long.parseLong(id));
        routineRepository.delete(routine);
    }

    @Transactional
    public RoutineResponseDto addSessionToRoutine(Long routineId, SessionRequestDto sessionRequestDto, Object exerciseIdentifier) {
        // Buscar la rutina por su ID
        Routine routine = getRoutineByCodeOrThrow(routineId);

        // Crear la nueva sesión
        SessionResponseDto sessionResponseDto = sessionService.create(sessionRequestDto);

        // Añadir el ejercicio a la sesión
        sessionService.addExerciseToSession(sessionResponseDto.getId(), exerciseIdentifier);

        // Buscar la sesión actualizada con el ejercicio asignado
        Session session = sessionService.getSessionByCodeOrThrow(sessionResponseDto.getId());

        // Añadir la sesión a la lista de sesiones de la rutina
        routine.getSessions().add(session);

        // Guardar la rutina actualizada
        Routine updatedRoutine = routineRepository.save(routine);

        // Devolver el DTO de la rutina actualizada usando el mapper
        return routineMapper.entityToDto(updatedRoutine);
    }

    @Transactional
    public RoutineResponseDto removeSessionFromRoutine(Long routineId, Object sessionId) {
        // Buscar la rutina por su ID
        Routine routine = getRoutineByCodeOrThrow(routineId);

        // Verificar si la sesión está en la lista
        Session sessionToRemove = routine.getSessions().stream()
                .filter(session -> session.getId().equals(sessionId))
                .findFirst()
                .orElseThrow(() -> new EntityException("La sesión con el ID " + sessionId + " no se encuentra en la rutina con ID " + routineId));

        // Eliminar la sesión de la lista de sesiones de la rutina
        routine.getSessions().remove(sessionToRemove);

        // Llamar al método delete del SessionService
        sessionService.delete(sessionId);

        // Guardar la rutina actualizada
        Routine updatedRoutine = routineRepository.save(routine);

        // Devolver el DTO de la rutina actualizada usando el mapper
        return routineMapper.entityToDto(updatedRoutine);
    }

    @Transactional
    public RoutineResponseDto editSessionInRoutine(Long routineId, SessionRequestDto sessionRequestDto) {
        // Buscar la rutina por su ID
        Routine routine = getRoutineByCodeOrThrow(routineId);

        // Actualizar la sesión utilizando SessionService
        SessionResponseDto updatedSessionDto = sessionService.update(sessionRequestDto);

        // No es necesario manipular la lista de sesiones directamente, ya que se ha actualizado en la base de datos
        // Guardar la rutina actualizada (aunque las sesiones ya están vinculadas)
        Routine updatedRoutine = routineRepository.save(routine);

        // Devolver el DTO de la rutina actualizada usando el mapper
        return routineMapper.entityToDto(updatedRoutine);
    }



}
