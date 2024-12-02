package com.example.volleyball.mapping;

import com.example.volleyball.models.Car;
import com.example.volleyball.models.CarRequest;
import com.example.volleyball.models.CarResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-18T17:25:02+0100",
    comments = "version: 1.6.2, compiler: javac, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public Car mapToPlayer(CarRequest carRequest) {
        if ( carRequest == null ) {
            return null;
        }

        Car car = new Car();

        car.setFirstName( carRequest.getName() );
        car.setLastName( carRequest.getLastName() );
        car.setAge( carRequest.getAge() );
        car.setHeight( carRequest.getHeight() );
        car.setRole( carRequest.getRole() );

        return car;
    }

    @Override
    public CarResponse mapToPlayerResponse(Car Car) {
        if ( Car == null ) {
            return null;
        }

        CarResponse carResponse = new CarResponse();

        carResponse.setFirstName( Car.getFirstName() );
        carResponse.setAge( Car.getAge() );
        carResponse.setHeight( Car.getHeight() );
        carResponse.setRole( Car.getRole() );

        return carResponse;
    }
}
