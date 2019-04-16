package com.example.demo.reposytory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class SchoolTest {

	private School forTest() {
	Klass klass = new Klass("1Z");
	Klass klass1 = new Klass("2Z");
	Klass klass2 = new Klass("3Z");
	List<Klass> listкlass = new ArrayList<Klass>();
	listкlass.add(klass);
	listкlass.add(klass1);
	listкlass.add(klass2);
	School school = new School("School","Russia","123654",listкlass);
	school.setId(1);
	return school;
	}
	
	@Test
	public void testHashCode() {
		assertThat(forTest().hashCode(),is(-332554922));
	}

	@Test
	public void testGetschoolId() {
		assertThat(forTest().getschoolId(),is(1));
	}

	@Test
	public void testSetId() {
		School school = forTest();
		school.setId(2);
		assertThat(school.getschoolId(),is(2));
	}

	@Test
	public void testGetName() {
		assertThat(forTest().getName(),is("School"));
	}

	@Test
	public void testSetName() {
		School school = forTest();
		school.setName("PRD");
		assertThat(school.getName(),is("PRD"));
	}

	@Test
	public void testGetCountry() {
		assertThat(forTest().getCountry(),is("Russia"));
	}

	@Test
	public void testSetCountry() {
		School school = forTest();
		school.setCountry("GES");;
		assertThat(school.getCountry(),is("GES"));
	}

	@Test
	public void testGetIndex() {
		assertThat(forTest().getIndex(),is("123654"));
	}

	@Test
	public void testSetIndex() {
		School school = forTest();
		school.setIndex("121233");
		assertThat(school.getIndex(),is("121233"));
	}

	@Test
	public void testGetКlass() {
		Klass klass = new Klass("1Z");
		Klass klass1 = new Klass("2Z");
		Klass klass2 = new Klass("3Z");
		List<Klass> listкlass = new ArrayList<Klass>();
		listкlass.add(klass);
		listкlass.add(klass1);
		listкlass.add(klass2);
		assertThat(forTest().getКlass(),is(listкlass));
	}

	@Test
	public void testSetКlass() {
		Klass klass = new Klass("12");
		Klass klass1 = new Klass("23");
		Klass klass2 = new Klass("34Z");
		List<Klass> listкlass = new ArrayList<Klass>();
		listкlass.add(klass);
		listкlass.add(klass1);
		listкlass.add(klass2);
		School school = forTest();
		school.setКlass(listкlass);
		assertThat(school.getКlass(),is(listкlass));
	}

}
