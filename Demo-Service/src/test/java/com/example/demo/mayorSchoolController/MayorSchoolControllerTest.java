package com.example.demo.mayorSchoolController;

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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.mayorSchoolService.MayorSchoolService;
import com.example.demo.mayorSchoolService.SchoolDto;
import com.example.demo.restControllerAdvices.MyRestControllerAdvice;
import com.example.demo.schoolDirectorKlassService.KlassDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
class MayorSchoolControllerTest {
	/**
	 * Main entry point for server-side Spring MVC test support
	 */
	private MockMvc mockMvc;
     /**
     * лист школ
     */
	 private List<SchoolDto> listSchoolDto;
	 
     /**
     * Сервис школ
     */
	 @Mock
	 private MayorSchoolService mayorSchoolService;
     /**
     * Контроллер школ
     */
     @InjectMocks
     private MayorSchoolController mayorSchoolController; 
 	/**
      * Обработчик исключений службы загрузки
      */
 	@InjectMocks
 	private MyRestControllerAdvice myRestControllerAdvice;
 	/**
	 * Метод описывает конвертацию объекта в Json
	 * @param obj объект
	 * @return Json
	 */
	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	 @BeforeEach
	    void setMockOutput() {
		 mockMvc = MockMvcBuilders.standaloneSetup(mayorSchoolController).
				 setControllerAdvice(myRestControllerAdvice).build();
		 List<KlassDto> listklassDto = new ArrayList<>();
			KlassDto klassDto = new KlassDto(1, "4G", 1);
			listklassDto.add(klassDto);
			SchoolDto schoolDto = new SchoolDto();
			schoolDto.setId(1);
			schoolDto.setName("School");
			schoolDto.setCountry("Russia");
			schoolDto.setIndex("111111");
			schoolDto.setКlassDto(listklassDto);
			listSchoolDto = new ArrayList<>();
			listSchoolDto.add(schoolDto);  
    }
	@Test
	public void mayorSchoolServiceLoaded() {
		assertNotNull(mayorSchoolService);
	}
 	/**
	 * Поиск всех школ
	 * @throws Exception
	 */
	@Test
	public void testFindAll() throws Exception {
		when(mayorSchoolService.getAllSchool()).thenReturn(listSchoolDto);

	mockMvc.perform(MockMvcRequestBuilders.get("/school/all"))
	        .andExpect(MockMvcResultMatchers.status().isOk())
	        .andExpect(jsonPath("[0].index", is("111111")));
	}
	
    /**
     * Поиск всех школ - имитация ошибки
     * @throws Exception
     */
	@Test
	public void testFindException() throws Exception {
	List<SchoolDto> result = (List<SchoolDto>) mayorSchoolService.getAllSchool();
	when(mayorSchoolService.getAllSchool()).thenReturn(result);
	mockMvc.perform(MockMvcRequestBuilders.get("/school/all"))
			.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	
	/**
	 * Поиск всех школ по ИД
	 * @throws Exception
	 */
	@Test
	public void testGetSchoolById() throws Exception {
		when(mayorSchoolService.findById(1)).thenReturn(listSchoolDto);
		mockMvc.perform(MockMvcRequestBuilders.get("/school/id/1"))
		.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.index", is("111111")));
	}
	/**
	 * Поиск всех школ по ИД - имитация ошибки
	 * @throws Exception
	 */
	@Test
	public void testGetSchoolByIdNull() throws Exception {
		List<SchoolDto> result = (List<SchoolDto>) mayorSchoolService.getAllSchool();
		when(mayorSchoolService.findById(1)).thenReturn(result);
		mockMvc.perform(MockMvcRequestBuilders.get("/school/id/1"))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	/**
     * Поиск всех школ по Наименованию
     * @throws Exception
     */
	@Test
	public void testGetSchoolByName() throws Exception {
		when(mayorSchoolService.findByName("School")).thenReturn(listSchoolDto);

		mockMvc.perform(MockMvcRequestBuilders.get("/school/name/School"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(jsonPath("[0].index", is("111111")));	
	}
	/**
	 * Поиск всех школ по Наименованию - имитация ошибки
	 * @throws Exception
	 */
	@Test
	public void testGetSchoolByNameNull() throws Exception {
		List<SchoolDto> result = (List<SchoolDto>) mayorSchoolService.getAllSchool();
		when(mayorSchoolService.findByName("School")).thenReturn(result);
	mockMvc.perform(MockMvcRequestBuilders.get("/school/name/School"))
			.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	/**
	 * Поиск всех школ по Стране 
	 * @throws Exception
	 */
	@Test
	public void testGetSchoolByCountry() throws Exception {
		when(mayorSchoolService.findByCountry("Russia")).thenReturn(listSchoolDto);

		mockMvc.perform(MockMvcRequestBuilders.get("/school/country/Russia")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("[0].index", is("111111")));	
	}
	/**
	 * Поиск всех школ по Стране - имитация ошибки
	 * @throws Exception
	 */
	@Test
	public void testGetSchoolByCountryNull() throws Exception {
		List<SchoolDto> result = (List<SchoolDto>) mayorSchoolService.getAllSchool();
		when(mayorSchoolService.findByCountry("Russia")).thenReturn(result);
	mockMvc.perform(MockMvcRequestBuilders.get("/school/country/Russia"))
			.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	public void testGetSchoolByIndex() throws Exception {
		when(mayorSchoolService.findByIndex("111111")).thenReturn(listSchoolDto);

		mockMvc.perform(MockMvcRequestBuilders.get("/school/index/111111")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("[0].index", is("111111")));
	}
	/**
	 * Поиск всех школ по Индексу - имитация ошибки
	 * @throws Exception
	 */
	@Test
	public void testGetSchoolByIndexNull() throws Exception {
		List<SchoolDto> result = (List<SchoolDto>) mayorSchoolService.getAllSchool();
		when(mayorSchoolService.findByIndex("111111")).thenReturn(result);
	mockMvc.perform(MockMvcRequestBuilders.get("/school/index/111111"))
			.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	  /**
     * Сохранение школы
     * @throws Exception
     */
	@Test
	public void testSaveSchool() throws Exception {
		List<KlassDto> listKlassDto = new ArrayList<KlassDto>();
    	KlassDto klassDto1 = new KlassDto(0,"1A",1);
    	listKlassDto.add(klassDto1);
		mockMvc.perform(MockMvcRequestBuilders.post("/school").
				param("name", "School").
				param("country", "Russia").
				param("index", "111111").
				content(asJsonString(listKlassDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).
		andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	/**
	 * Удаление школы 
	 * @throws Exception
	 */
	@Test
	public void testDeleteSchool() throws Exception {
		when(mayorSchoolService.findById(1)).thenReturn(listSchoolDto);
		mockMvc.perform(MockMvcRequestBuilders.delete("/school/delet/1")).
		andExpect(MockMvcResultMatchers.status().isOk());
	}
	/**
	 * Удаление школы - имитация ошибки
	 * @throws Exception
	 */
	@Test
	public void testDeleteSchoolNull() throws Exception {
		List<SchoolDto> result = (List<SchoolDto>) mayorSchoolService.getAllSchool();
		when(mayorSchoolService.findById(1)).thenReturn(result);
		mockMvc.perform(MockMvcRequestBuilders.delete("/school/delet/1")).
		andExpect(MockMvcResultMatchers.status().isNotFound());
	}

}
