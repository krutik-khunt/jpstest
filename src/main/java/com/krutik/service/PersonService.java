package com.krutik.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component; 

import com.krutik.model.Person;

@Component
public interface PersonService extends JpaRepository<Person, Integer> {

}
