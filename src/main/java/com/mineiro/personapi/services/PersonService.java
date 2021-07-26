package com.mineiro.personapi.services;

import com.mineiro.personapi.dto.mapper.PersonMapper;
import com.mineiro.personapi.dto.request.PersonDTO;
import com.mineiro.personapi.dto.response.MessageResponseDTO;
import com.mineiro.personapi.entities.Person;
import com.mineiro.personapi.exception.PersonNotFoundException;
import com.mineiro.personapi.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
//onde declara as Regras de Negocio
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    // cria usuarios
    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return createMessageResponse(savedPerson.getId(), "Pessoa criada com ID: ");
    }

    public List<PersonDTO> listall() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);
        return personMapper.toDTO(person);
    }

    public void deleteById(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);
        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatedPerson  = personRepository.save(personToUpdate);
        return createMessageResponse(updatedPerson.getId(), "Pessoa alterada com ID: ");
    }

    private MessageResponseDTO createMessageResponse(Long id, String s) {
        return MessageResponseDTO
                .builder()
                .message(s + id)
                .build();
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }
}
