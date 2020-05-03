package pl.solutions.software.sokolik.bartosz.redis.person;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.solutions.software.sokolik.bartosz.redis.person.domain.Person;
import pl.solutions.software.sokolik.bartosz.redis.person.domain.PersonService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        return ResponseEntity.ok(personService.getPerson(id));
    }

    @PutMapping
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        return ResponseEntity.ok(personService.updatePerson(person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePersonById(id);
        return ResponseEntity.ok().build();
    }
}
