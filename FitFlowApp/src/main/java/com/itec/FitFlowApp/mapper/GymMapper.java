package com.itec.FitFlowApp.mapper;

import com.itec.FitFlowApp.dto.request.GymRequestDto;
import com.itec.FitFlowApp.dto.response.GymResponseDto;
import com.itec.FitFlowApp.model.entity.Gym;
import com.itec.FitFlowApp.util.Mapper;
import org.springframework.stereotype.Component;

@Component
public class GymMapper implements Mapper<Gym, GymResponseDto, GymRequestDto> {
    @Override
    public GymResponseDto entityToDto(Gym gym) {
        GymResponseDto gymResponseDto = new GymResponseDto();
        gymResponseDto.setGymCode(gym.getGymCode());
        gymResponseDto.setName(gym.getName());
        gymResponseDto.setAddress(gym.getAddress());
        gymResponseDto.setPhone(gym.getPhone());
        gymResponseDto.setEmail(gym.getEmail());
        gymResponseDto.setClientList(gym.getClientList());
        gymResponseDto.setTrainerList(gym.getTrainerList());
        gymResponseDto.setNutritionistList(gym.getNutritionistList());

        return gymResponseDto;
    }

    @Override
    public Gym dtoToEntity(GymRequestDto dtoRequest) {
        Gym gym = new Gym();
        gym.setId(dtoRequest.getId());
        gym.setGymCode(dtoRequest.getGymCode());
        gym.setName(dtoRequest.getName());
        gym.setAddress(dtoRequest.getAddress());
        gym.setPhone(dtoRequest.getPhone());
        gym.setEmail(dtoRequest.getEmail());

        return gym;
    }
}
