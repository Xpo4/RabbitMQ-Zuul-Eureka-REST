package com.example.demo.reposytory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

import com.example.demo.schoolDirectorKlassService.KlassDto;

public class KlassDtoTest {
	
	KlassDto klassDto = new KlassDto(1,"4Z",1);

	@Test
	public void testGetklass_Id() {
		assertThat(klassDto.getklass_Id(),is(1));
	}

	@Test
	public void testSetId() {
	    klassDto.setId(5);;
		assertThat(klassDto.getklass_Id(),is(5));
	}

	@Test
	public void testGetNumber() {
		assertThat(klassDto.getNumber(),is("4Z"));
	}

	@Test
	public void testSetNumber() {
		klassDto.setNumber("4F");
		assertThat(klassDto.getNumber(),is("4F"));
	}

	@Test
	public void testGetSchoolId() {
		assertThat(klassDto.getSchoolId(),is(1));
	}

	@Test
	public void testSetSchoolId() {
		klassDto.setSchoolId(2);
		assertThat(klassDto.getSchoolId(),is(2));
	}

}
