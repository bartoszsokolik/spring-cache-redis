package pl.solutions.software.sokolik.bartosz.redis.person.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    @Cacheable(value = "persons", key = "#personId", unless = "#result.followers < 12000")
    public Person getPerson(Long personId) {
        log.info("Getting person with id: {}", personId);
        return personRepository.findById(personId).orElseThrow(RuntimeException::new);
    }

    @CachePut(value = "persons", key = "#person.id")
    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }

    @CacheEvict(value = "persons", allEntries = true)
    public void deletePersonById(Long personId) {
        personRepository.deleteById(personId);
    }

}
