package com.itec.FitFlowApp.mapper;

import com.itec.FitFlowApp.dto.request.NutritionistRequestDto;
import com.itec.FitFlowApp.dto.response.NutritionistResponseDto;
import com.itec.FitFlowApp.model.entity.Nutritionist;
import com.itec.FitFlowApp.util.Mapper;
import org.springframework.stereotype.Component;

@Component
public class NutritionistMapper implements Mapper<Nutritionist, NutritionistResponseDto, NutritionistRequestDto> {
    @Override
    public NutritionistResponseDto entityToDto(Nutritionist nutritionist) {
       NutritionistResponseDto nutritionistResponseDto = new NutritionistResponseDto();
        nutritionistResponseDto.setId(nutritionist.getId());
        nutritionistResponseDto.setName(nutritionist.getName());
        nutritionistResponseDto.setSurname(nutritionist.getSurname());
        nutritionistResponseDto.setDni(nutritionist.getDni());
        nutritionistResponseDto.setPhone(nutritionist.getPhone());
        nutritionistResponseDto.setAddress(nutritionist.getAddress());
        nutritionistResponseDto.setEmail(nutritionist.getEmail());
        nutritionistResponseDto.setActive(nutritionist.isActive());
        nutritionistResponseDto.setProfession(nutritionist.getProfession()); // Asumiendo que "profession" corresponde a "title" en Nutritionist
        nutritionistResponseDto.setAvailable(nutritionist.isAvailable());
        nutritionistResponseDto.setNutritionalPlanList(nutritionist.getNutritionalPlanList());
        nutritionistResponseDto.setClients(nutritionist.getClients());
        nutritionistResponseDto.setGym(nutritionist.getGym());

        return nutritionistResponseDto;

    }

    @Override
    public Nutritionist dtoToEntity(NutritionistRequestDto dtoRequest) {
        Nutritionist nutritionist = new Nutritionist();
        nutritionist.setId(dtoRequest.getId());
        nutritionist.setName(dtoRequest.getName());
        nutritionist.setSurname(dtoRequest.getSurname());
        nutritionist.setDni(dtoRequest.getDni());
        nutritionist.setPhone(dtoRequest.getPhone());
        nutritionist.setAddress(dtoRequest.getAddress());
        nutritionist.setEmail(dtoRequest.getEmail());
        nutritionist.setActive(dtoRequest.isActive());
        nutritionist.setProfession(dtoRequest.getProfession());
        nutritionist.setAvailable(dtoRequest.isAvailable());
        nutritionist.setNutritionalPlanList(dtoRequest.getNutritionalPlanList());
        nutritionist.setClients(dtoRequest.getClients());
        nutritionist.setGym(dtoRequest.getGym());

        return  nutritionist;
    }
}
