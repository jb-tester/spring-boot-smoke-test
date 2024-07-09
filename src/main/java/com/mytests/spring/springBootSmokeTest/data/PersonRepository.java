package com.mytests.spring.springBootSmokeTest.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PersonRepository extends CrudRepository<Person, Integer> {

    List<Person> findAll();

    @Query("select e from Person e where e.lastname = :lname")
    List<Person> customByNameQuery(@Param("lname") String arg);

    List<Person> findByAgeGreaterThan(int age);

    // named native with conventional name
    List<Person> findByAge(int age);

    // named jpa with non-conventional name
    List<Person> myNamedQuery(String ln);
}
