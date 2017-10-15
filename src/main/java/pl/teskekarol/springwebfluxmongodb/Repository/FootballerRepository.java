package pl.teskekarol.springwebfluxmongodb.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pl.teskekarol.springwebfluxmongodb.Domain.Footballer;

@Repository
public interface FootballerRepository extends ReactiveMongoRepository<Footballer,String>{
}
