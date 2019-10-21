package com.krutik.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private List<PersonDetails> pd;

	public Person() {
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	public List<PersonDetails> getPd() {
		return pd;
	}

	public void setPd(List<PersonDetails> pd) {
		this.pd = pd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", pd=" + pd + "]";
	}

}
