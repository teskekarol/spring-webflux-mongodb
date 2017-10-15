package pl.teskekarol.springwebfluxmongodb.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Document(collection = "footballers")
public class Footballer {
    @Id
    private int id;

    @NotBlank
    @Size(max = 150)
    private String name;

    @NotBlank
    private int yearOfBirth;

    @NotNull
    private LocalDate createdAt = LocalDate.now();

    public Footballer() {

    }

    public Footballer(@NotBlank @Size(max = 150) String name, @NotBlank int yearOfBirth) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
