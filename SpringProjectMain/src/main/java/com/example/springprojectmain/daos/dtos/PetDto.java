package com.example.springprojectmain.daos.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PetDto(
Long id,
@NotBlank(message = "Name is mandatory") String name,
@NotBlank(message = "Animal type is mandatory") String animalType,
@NotBlank(message = "Breed is mandatory") String breed,
@NotNull(message = "Age is mandatory") Integer age
)   {
}
