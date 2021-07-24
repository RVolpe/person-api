package com.mineiro.personapi.services;

import com.mineiro.personapi.dto.response.MessageResponseDTO;
import com.mineiro.personapi.entities.Person;
import com.mineiro.personapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//onde declara as Regras de Negocio
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // cria usuarios
    public MessageResponseDTO createPerson(Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Pessoa criada com ID: " + savedPerson.getId())
                .build();
    }

}
