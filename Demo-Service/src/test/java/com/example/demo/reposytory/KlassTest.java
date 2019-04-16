package com.example.demo.reposytory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

public class KlassTest {
	Klass klass = new Klass("4Z");
	School school = new School();

	@Test
	public void testHashCode() {
		assertThat(klass.hashCode(),is(2663));
	}

	@Test
	public void testGetId() {
		klass.setId(1);
		assertThat(klass.getId(),is(1));
	}

	@Test
	public void testSetId() {
		klass.setId(5);
		assertThat(klass.getId(),is(5));
	}

	@Test
	public void testGetNumber() {
		assertThat(klass.getNumber(),is("4Z"));
	}

	@Test
	public void testSetNumber() {
		klass.setNumber("4S");
		assertThat(klass.getNumber(),is("4S"));
	}

	@Test
	public void testGetSchool() {
		klass.setSchool(school);
		assertThat(klass.getSchool(),is(school));
	}

	@Test
	public void testSetSchool() {
		School school1 = new School();
		klass.setSchool(school1);
		assertThat(klass.getSchool(),is(school1));
	}

	@Test
	public void testEqualsObject() {
		assertThat(klass.equals(klass),is(klass.equals(klass)));
	}

	@Test
	public void testObject() {
		assertThat(klass.equals(null),is(false));
	}

	@Test
	public void testGetClass() {
		assertThat(klass.equals(klass.getClass()),is(false));
	}

	@Test
	public void testEqualsObject1() {
		assertThat(klass.equals(klass.getId()),is(false));
	}
	
	@Test
	public void testClone() {
		Klass klass2 = new Klass();
		assertThat(klass.equals(klass2.getId()),is(false));
	}

}
