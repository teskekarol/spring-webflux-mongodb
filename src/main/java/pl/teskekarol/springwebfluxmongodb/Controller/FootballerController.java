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
        System.out.println(footballerRepository.count());

        return footballerRepository.findAll();

    }

    @PostMapping("/footballers")
    public Mono<Footballer> createFootballer(@Valid  @RequestBody Footballer footballer){
        footballerRepository.save(new Footballer("KT", 1990));
        return footballerRepository.save(footballer);
    }

    @GetMapping("footballers/{id}")
    public Mono<Footballer> getFootballerById(@PathVariable(value = "id") String footballerId){
        return footballerRepository.findById(footballerId);
    }
}
