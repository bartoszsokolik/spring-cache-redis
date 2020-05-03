package pl.solutions.software.sokolik.bartosz.redis.person.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PersonCommandLineRunner implements CommandLineRunner {

    private final PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        //Populating embedded database here
        log.info("Saving users. Current user count is {}.", personRepository.count());
        Person shubham = new Person("Shubham", 2000);
        Person pankaj = new Person("Pankaj", 29000);
        Person lewis = new Person("Lewis", 550);

        personRepository.save(shubham);
        personRepository.save(pankaj);
        personRepository.save(lewis);
        log.info("Done saving users. Data: {}.", personRepository.findAll());
    }
}
