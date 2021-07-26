package com.mineiro.personapi.dto.mapper;

import com.mineiro.personapi.dto.request.PersonDTO;
import com.mineiro.personapi.entities.Person;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(dateFormat = "dd-MM-yyyy", source = "dataNascimento", target = "dataNascimento")
    Person toModel(PersonDTO personDTO);

    @InheritInverseConfiguration
    PersonDTO toDTO(Person person);
}
