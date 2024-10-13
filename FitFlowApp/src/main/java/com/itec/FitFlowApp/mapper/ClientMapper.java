package com.itec.FitFlowApp.mapper;

import com.itec.FitFlowApp.dto.request.ClientRequestDto;
import com.itec.FitFlowApp.dto.response.ClientResponseDto;
import com.itec.FitFlowApp.model.entity.Client;
import com.itec.FitFlowApp.util.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper implements Mapper<Client, ClientResponseDto, ClientRequestDto> {
    @Override
    public ClientResponseDto entityToDto(Client client) {
        ClientResponseDto clientResponseDto = new ClientResponseDto();
        clientResponseDto.setDni(client.getDni());
        clientResponseDto.setName(client.getName());
        clientResponseDto.setSurname(client.getSurname());
        clientResponseDto.setAddress(client.getAddress());
        clientResponseDto.setPhone(client.getPhone());
        clientResponseDto.setEmail(client.getEmail());
        clientResponseDto.setInitState(client.getInitState());
        clientResponseDto.setCurrentState(client.getCurrentState());
        clientResponseDto.setGoal(client.getGoal());
        clientResponseDto.setGym(client.getGym());
        clientResponseDto.setTrainer(client.getTrainer());
        clientResponseDto.setNutritionist(client.getNutritionist());
        clientResponseDto.setRoutines(client.getRoutines());
        clientResponseDto.setNutritionalPlans(client.getNutritionalPlans());
        clientResponseDto.setNutritionalDiaryList(client.getNutritionalDiaryList());
        clientResponseDto.setTrainingDiaryList(client.getTrainingDiaryList());
        clientResponseDto.setRecord(client.getRecord());

        return clientResponseDto;
    }

    @Override
    public Client dtoToEntity(ClientRequestDto dtoRequest) {
        Client client = new Client();
        client.setDni(dtoRequest.getDni());
        client.setName(dtoRequest.getName());
        client.setSurname(dtoRequest.getSurname());
        client.setAddress(dtoRequest.getAddress());
        client.setPhone(dtoRequest.getPhone());
        client.setEmail(dtoRequest.getEmail());
        client.setInitState(dtoRequest.getInitState());
        client.setCurrentState(dtoRequest.getCurrentState());
        client.setGoal(dtoRequest.getGoal());
        client.setGym(dtoRequest.getGym());
        client.setTrainer(dtoRequest.getTrainer());
        client.setNutritionist(dtoRequest.getNutritionist());
        client.setRoutines(dtoRequest.getRoutines());
        client.setNutritionalPlans(dtoRequest.getNutritionalPlans());
        client.setNutritionalDiaryList(dtoRequest.getNutritionalDiaryList());
        client.setTrainingDiaryList(dtoRequest.getTrainingDiaryList());
        client.setRecord(dtoRequest.getRecord());

        return client;
    }
}
