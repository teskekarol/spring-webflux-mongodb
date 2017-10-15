package pl.teskekarol.springwebfluxmongodb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.teskekarol.springwebfluxmongodb.Domain.Footballer;
import pl.teskekarol.springwebfluxmongodb.Repository.FootballerRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class FootballerController {
    @Autowired
    FootballerRepository footballerRepository;

    @GetMapping("/footballers")
    public Flux<Footballer> getAllFootballers(){
        System.out.println("Hit");
        footballerRepository.save(new Footballer("Karol Teske", 1996));
        footballerRepository.save(new Footballer("Paulina Siwko", 1997));
        System.out.println("saved");
        System.out.println("out");
        return footballerRepository.findAll();
    }

    @PostMapping("/footballers")
    public Mono<Footballer> createFootballer(@Valid  @RequestBody Footballer footballer){
        return footballerRepository.save(footballer);
    }

    @GetMapping("footballers/{id}")
    public Mono<Footballer> getFootballerById(@PathVariable(value = "id") String footballerId){
        return footballerRepository.findById(footballerId);
    }
}
