package com.example.demo.services;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
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
class MayorSchoolServiceImplTest {
	/**
	 * Cервис школ
	 */
	@Autowired
	MayorSchoolService mayorSchoolService;
	/**
	 * Cервис классов
	 */
	@Autowired
	SchoolDirectorKlassService schoolDirectorKlassService;
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
		schoolDto = new SchoolDto();
		klassDto.setSchoolId(1);
		schoolDto.setId(1);
		schoolDto.setName("School");
		schoolDto.setCountry("Russia");
		schoolDto.setIndex("111222");
		List<KlassDto> listKlassDto = new ArrayList<KlassDto>();
		listKlassDto.add(klassDto);
		schoolDto.setКlassDto(listKlassDto);
		mayorSchoolService.saveSchool(schoolDto);
	}
	/**
	 * Метод описывает - подготовку репозиториев после тестировнием
	 */
	@AfterEach
	public void setUpAfterTest() {
		schoolDirectorKlassService.getAllKlass().forEach(klass ->schoolDirectorKlassService.deleteKlass(klass));
		mayorSchoolService.getAllSchool().forEach(school -> mayorSchoolService.deleteSchool(school));
	}

	/**
	 * Метод описывает - тест ошибки при удаление школы
	 */
	@Test
	public void testDeleteSchoolException() {
		SchoolDto schoolDto = null;
		assertThrows(IllegalArgumentException.class,() -> mayorSchoolService.deleteSchool(schoolDto));
	}
    /**
     * Метод описывает - тест поиск школы по стране
     */
	@Test
	void testFindByCountry() {
		assertEquals(mayorSchoolService.findByCountry("Russia").get(0).getCountry(), "Russia");
	}
	/**
	 * Метод описывает - тест ошибки при поискe школы по стране
	 */
	@Test
	void testFindByCountryException() {
		assertThrows(IllegalArgumentException.class,() -> mayorSchoolService.findByCountry(null));
	}
	/**
	 * Метод описывает - тест поиск школы по ID
	 */
	@Test
	void testFindById() {
		assertEquals(mayorSchoolService.findById(5).get(0).getCountry(), "Russia");
	}
    /**
     * Метод описывает - тест поиск школы по индексу
     */
	@Test
	void testFindByIndex() {
		assertEquals(mayorSchoolService.findByIndex("111222").get(0).getIndex(), "111222");
	}
    /**
     * Метод описывает - тест ошибки при поискe школы по индексу
     */
    @Test
	void testFindByIndexException() {
    	assertThrows(IllegalArgumentException.class,() -> mayorSchoolService.findByIndex(null));
	}
    /**
     * Метод описывает - тест поиск школы по наименованию
     */
    @Test
	void testFindByName() {
		assertEquals(mayorSchoolService.findByName("School").get(0).getName(),"School");
	}
    /**
     * Метод описывает - тест ошибки при поискe школы по наименованию
     */
    @Test
	void testFindByNameException() {
    	assertThrows(IllegalArgumentException.class,() -> mayorSchoolService.findByName(null));
	}
    /**
     * Метод описывает - тест поиск школ
     */
	@Test
	void testGetAllSchool() {
		assertEquals(mayorSchoolService.getAllSchool().get(0).getName(), "School");
	}
    /**
     *   Метод описывает - тест ошибку при сохранении школы
     */
    @Test
	void testSaveSchoolException() {
    	SchoolDto schoolDto = null;
    	assertThrows(IllegalArgumentException.class,() -> mayorSchoolService.saveSchool(schoolDto));
	}
    /**
     * Метод описывает - тест удаление школы
     */
	@Test
	public void testDeleteSchool() {
		assertEquals(mayorSchoolService.findById(11).size(), 0);
	}
}
