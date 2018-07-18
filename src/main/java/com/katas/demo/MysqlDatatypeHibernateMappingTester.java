package com.katas.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MysqlDatatypeHibernateMappingTester implements ApplicationRunner {

    @Autowired
    PersonRepo repo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.debug("this is amit");
        System.out.println("this is amit again");
        Person p = new Person();
        p.setGender(Gender.M);
        p.setName("Amit");
        p.setFavouritefood(Favouritefood.uppit);
        repo.save(p);
    }



}


enum Gender {
    M, F
}

enum Favouritefood{
    puri, wada, pohe, uppit, idli
}



@Entity
@Data
class Person {

    @Id
    @GeneratedValue
    Long personId;

    @Enumerated(EnumType.STRING)
    Gender gender;

    String name;
    
    @Column(name="favfood",columnDefinition="enum('puri', 'wada', 'pohe', 'uppit', 'idli')")
    @Enumerated(EnumType.STRING)
    Favouritefood favouritefood;
    
}


interface PersonRepo extends JpaRepository<Person, Long> {

}
