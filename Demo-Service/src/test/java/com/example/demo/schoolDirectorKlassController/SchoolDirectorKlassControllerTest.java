package com.example.demo.schoolDirectorKlassController;



import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.mayorSchoolService.SchoolDto;
import com.example.demo.restControllerAdvices.MyRestControllerAdvice;
import com.example.demo.restControllerAdvices.exaption.CustomNotFoundExaption;
import com.example.demo.schoolDirectorKlassService.KlassDto;
import com.example.demo.schoolDirectorKlassService.SchoolDirectorKlassService;

@ExtendWith(MockitoExtension.class)
class SchoolDirectorKlassControllerTest {
	/**
	 * Main entry point for server-side Spring MVC test support
	 */
	private MockMvc mockMvc;
    /**
     * Лист классов
     */
	private ArrayList<KlassDto> listklass;
	/**
	 * Сервис школьных классов
	 */
	@Mock
	private SchoolDirectorKlassService schoolDirectorKlassService;
	 /**
     * Контроллер школьных классов
     */
	@InjectMocks
	private SchoolDirectorKlassController schoolDirectorKlassController;
	/**
     * Обработчик исключений службы загрузки
     */
	@InjectMocks
	private MyRestControllerAdvice myRestControllerAdvice;
	/**
     * Предустановки до начала тестирования
     */
	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(schoolDirectorKlassController)
				.setControllerAdvice(myRestControllerAdvice).build();
		listklass = new ArrayList<KlassDto>();
		KlassDto klassDto = new KlassDto(1,"4D", 1);
		listklass.add(klassDto);
	}
    /**
     * Проверка сервиса школьных классов
     */
	@Test
	public void testKlassServiceImplLoaded() {
		assertNotNull(schoolDirectorKlassService);
	}
	 /**
     * Поиск всех школьных классов
     * @throws Exception
     */
	@Test
	public void testFind() throws Exception {

		when(schoolDirectorKlassService.getAllKlass()).thenReturn(listklass);

		mockMvc.perform(MockMvcRequestBuilders.get("/klass/all"))
		        .andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("[0].number", is("4D")));;
	}
    /**
     * Поиск всех школьных классов - имитация ошибки
     * @throws Exception
     */
	@Test
	public void testFindExeption() throws Exception {
		List<KlassDto> result = (List<KlassDto>) schoolDirectorKlassService.getAllKlass();
		when(schoolDirectorKlassService.getAllKlass()).thenReturn(result);
		mockMvc.perform(MockMvcRequestBuilders.get("/klass/all"))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	/**
     * Поиск школьных классов по ИД 
     * @throws Exception
     */
	@Test
	public void testGetKlassById() throws Exception {
		when(schoolDirectorKlassService.findById(1)).thenReturn(listklass);
		mockMvc.perform(MockMvcRequestBuilders.get("/klass/id/1")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.number", is("4D")));
	}
    /**
     * Поиск школьных классов по ИД  - имитация ошибки
     * @throws Exception
     */
	@Test
	public void testGetKlassByIdExeption() throws Exception {
		when(schoolDirectorKlassService.findById(1)).thenThrow(new CustomNotFoundExaption("Всё пропало!"));
		mockMvc.perform(MockMvcRequestBuilders.get("/klass/id/1"))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
    /**
     * Поиск школьных классов по ИД  - имитация null
     * @throws Exception
     */
	@Test
	public void testGetKlassByIdNull() throws Exception {
		List<KlassDto> result = (List<KlassDto>) schoolDirectorKlassService.getAllKlass();
		when(schoolDirectorKlassService.findById(1)).thenReturn(result);
		mockMvc.perform(MockMvcRequestBuilders.get("/klass/id/1"))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	/**
     * Поиск школьных классов по Номеру
     * @throws Exception
     */
	@Test
	public void testGetKlassByNumber() throws Exception {
		when(schoolDirectorKlassService.findByNumber("4D")).thenReturn(listklass);

		mockMvc.perform(MockMvcRequestBuilders.get("/klass/number/4D")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("[0].number", is("4D")));
	}
    /**
     * Поиск школьных классов по Номеру - имитация ошибки
     * @throws Exception
     */
	@Test
	public void testGetKlassByNumberException() throws Exception {
		List<KlassDto> result = (List<KlassDto>) schoolDirectorKlassService.getAllKlass();
		when(schoolDirectorKlassService.findByNumber("4D")).thenReturn(result);
		mockMvc.perform(MockMvcRequestBuilders.get("/klass/number/4D"))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	/**
	 * Поиск сохранения школьного клсса
	 * @throws Exception
	 */
	@Test
	public void testSaveKlass() throws Exception {
		List<SchoolDto> listSchool = new ArrayList<SchoolDto>();
		SchoolDto schoolDto = new SchoolDto();
		schoolDto.setId(1);
		listSchool.add(schoolDto);
		when(schoolDirectorKlassService.SchoolFindById(1)).thenReturn(listSchool);
		mockMvc.perform(MockMvcRequestBuilders.post("/klass").param("number", "4K").param("id", "1")).
				andExpect(MockMvcResultMatchers.status().isOk());
	}
	/**
	 * Удаление школьного клсса - имитация ошибки
	 * @throws Exception
	 */
	@Test
	public void testSaveKlassException() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.post("/klass").param("number", "4K").param("id", "1")).
		andExpect(MockMvcResultMatchers.status().isNotFound());
	}
    /**
     * Удаление школьного класса 
     * @throws Exception
     */
	@Test
	public void testDeleteKlass() throws Exception {
		when(schoolDirectorKlassService.findById(1)).thenReturn(listklass);
		mockMvc.perform(MockMvcRequestBuilders.delete("/klass/delet/1")).
		andExpect(MockMvcResultMatchers.status().isOk());
	}
	/**
     * Удаление школьного класса - имитация ошибки
     * @throws Exception
     */
	@Test
	public void testDeleteKlassException() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/klass/delet/1")).
		andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	
	/**
     * Удаление школьного класса - имитация ошибки
     * @throws Exception
     */
	@Test
	public void testDeleteKlassExceptionAdvice() throws Exception {
		when(schoolDirectorKlassService.findById(1)).thenThrow(new IllegalArgumentException());
		mockMvc.perform(MockMvcRequestBuilders.delete("/klass/delet/1")).
		andExpect(MockMvcResultMatchers.status().isInternalServerError());
	}


}
