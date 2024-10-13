package com.itec.FitFlowApp.util;

public interface Mapper <E, R, Q>{
    R entityToDto(E e) ;
    E dtoToEntity(Q dtoRequest);
}
