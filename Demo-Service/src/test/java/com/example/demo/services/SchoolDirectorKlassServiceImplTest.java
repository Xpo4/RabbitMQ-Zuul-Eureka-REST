package com.example.demo.services;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.demo.mayorSchoolService.MayorSchoolService;
import com.example.demo.mayorSchoolService.SchoolDto;
import com.example.demo.schoolDirectorKlassService.KlassDto;
import com.example.demo.schoolDirectorKlassService.SchoolDirectorKlassService;

@DirtiesContext
@SpringBootTest
class SchoolDirectorKlassServiceImplTest {
	/**
	 * Cервис классов
	 */
	@Autowired
	SchoolDirectorKlassService schoolDirectorKlassService;
	/**
	 * Cервис школ
	 */
	@Autowired
	MayorSchoolService mayorSchoolService;
	/**
	 * Класс
	 */
	KlassDto klassDto;
	/**
	 * Школа
	 */
	SchoolDto schoolDto;
	/**
	 * Метод описывает - подготовку репозиториев перед тестировнием
	 */
	@BeforeEach
	public void setUpBeforeTest() {
		klassDto = new KlassDto();
		klassDto.setId(1);
		klassDto.setNumber("4F");
		klassDto.setSchoolId(1);
		schoolDto = new SchoolDto();
		schoolDto.setId(1);
		schoolDto.setName("School");
		schoolDto.setCountry("Russia");
		schoolDto.setIndex("111222");
		List<KlassDto> listKlassDto = new ArrayList<KlassDto>();
		listKlassDto.add(klassDto);
		schoolDto.setКlassDto(listKlassDto);
		KlassDto klassDto1 = new KlassDto();
		klassDto1.setId(2);
		klassDto1.setNumber("5F");
		klassDto1.setSchoolId(1);
		mayorSchoolService.saveSchool(schoolDto);
		schoolDirectorKlassService.saveKlass(klassDto1);
	}
	/**
     * Метод описывает - тест поиск класса по iD
     */
	@Test
	void testFindById() {
		assertThat(schoolDirectorKlassService.findById(2).get(0).getklass_Id(),is(2));
	}
	/**
	 * Метод описывает - тест поиск класса по наименованию
	 */
	@Test
	void testFindByNumber() {
		assertEquals(schoolDirectorKlassService.findByNumber("4F").get(0).getNumber(), "4F");
	}
	/**
	 * Метод описывает - тест ошибки при поиске класса по наименованию
	 */
	@Test
	void testFindByNumberException() {
		assertThrows(IllegalArgumentException.class,() -> schoolDirectorKlassService.findByNumber(null));
	}
    /**
     * Метод описывает - тест поиск классов
     */
	@Test
	void testGetAllKlass() {
		assertEquals(schoolDirectorKlassService.getAllKlass().get(0).getNumber(), "5F");
	}
	/**
	 * Метод описывает - тест ошибки при сохранение класса
	 */
	@Test
	void testSaveKlassException() {
		KlassDto klassDto = null;
		assertThrows(IllegalArgumentException.class,() -> schoolDirectorKlassService.saveKlass(klassDto));
	}
	/**
	 * Метод описывает - тест ошибки при сохранение класса
	 */
	@Test
	void testSaveKlassException2() {
		KlassDto klassDto = new KlassDto();
		klassDto.setNumber("4I");
		assertThrows(IllegalArgumentException.class,() -> schoolDirectorKlassService.saveKlass(klassDto));
	}
	/**
	 * Метод описывает - тест поиск школы по ID
	 */
	@Test
	void testSchoolFindById() {
		assertEquals(schoolDirectorKlassService.SchoolFindById(1).get(0).getCountry(), "Russia");
	}
	/**
	 * Метод описывает - тест ошибки при удаление класса
	 */
	@Test
	void testDeleteKlassException() {
		KlassDto klassDto = null;
		assertThrows(IllegalArgumentException.class,() -> schoolDirectorKlassService.deleteKlass(klassDto));
  }
	/**
	 * Метод описывает - тест удаления школы
	 */
	@Test
	void testDeleteKlass() {
		schoolDirectorKlassService.deleteKlass(klassDto);
		assertEquals(schoolDirectorKlassService.findById(1).size(), 0);
  }
}
