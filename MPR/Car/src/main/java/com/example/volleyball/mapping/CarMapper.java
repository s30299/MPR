package com.example.volleyball.mapping;


import com.example.volleyball.models.Car;
import com.example.volleyball.models.CarRequest;
import com.example.volleyball.models.CarResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface CarMapper {
//1
    @Mapping(target= "firstName", source = "name")
    Car mapToPlayer(CarRequest carRequest);

    CarResponse mapToPlayerResponse(Car Car);

}
