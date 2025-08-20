package com.mytests.spring.springBootSmokeTest.events;

import org.springframework.data.repository.CrudRepository;


interface PersonEventRepository extends CrudRepository<PersonEvent, Integer> {
}
