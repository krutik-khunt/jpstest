package com.krutik.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.krutik.model.PersonDetails;

@Component
public interface PersonDetailsService extends
		JpaRepository<PersonDetails, Integer> {

}
