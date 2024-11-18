package com.example.volleyball.repositories;

import com.example.volleyball.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {

   List<Car> findByFirstNameAndLastName(String firstName, String lastName);
   List<Car> findByFirstName(String firstName);
   List<Car> findByLastName(String lastName);
   List<Car> findByHeight(Integer height); // dorzuć pare funkcji. zespol po playerze i na odwrot


}
