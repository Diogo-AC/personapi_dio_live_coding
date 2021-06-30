<<<<<<< HEAD
package one.digitalinnovation.personapi.controller;


import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
    @RequestMapping("/api/v1/people")
    public class PersonController{

        private PersonService personService;

        @Autowired
        public PersonController(PersonService personService) {
            this.personService = personService;
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
            return this.personService.create(personDTO);
        }

        @GetMapping
        public List<PersonDTO> listAll(){
            return this.personService.listAll();
        }

        @GetMapping("/{Id}")
        public PersonDTO findById(@PathVariable Long Id) throws PersonNotFoundException {
            return this.personService.findById(Id);
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void delete(@PathVariable Long id) throws PersonNotFoundException {
            this.personService.delete(id);
        }

        @PutMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
            return this.personService.update(id, personDTO);
        }

    }

=======
package one.digitalinnovation.personapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/people")
public class PersonController{

    @GetMapping
    public String getBook(){

        return "API Test!";

    }
}
>>>>>>> 0004f80a1e76904b84f614fb31cd9d8b84829238
