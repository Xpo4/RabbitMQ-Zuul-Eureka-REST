package com.example.demo.mayorSchoolService;



import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Pattern;

import org.springframework.hateoas.ResourceSupport;

import com.example.demo.schoolDirectorKlassService.KlassDto;



/**
 * Класс описывает школу
 * @author admin
 *
 */
public class SchoolDto extends ResourceSupport {
	/**
	 * ID школы 
	 */
	private int schoolId;
	/**
	 * Наименование школы
	 */
	@Pattern(regexp = "^[a-zA-z]{1,32}$")
	private String name;
	/**
	 * Страна
	 */
	@Pattern(regexp = "^[a-zA-z]{1,32}$")
	private String country;
	/**
	 * Индекс
	 */
	@Pattern(regexp = "^[0-9]{1,6}$")
	private String index;
	/**
	 * Классы
	 */
	private List<KlassDto> кlassDto = new ArrayList<KlassDto>();
	/**
	 * Конструктор школы
	 */
	public SchoolDto() {
		
	}

	public SchoolDto(int schoolId, @Pattern(regexp = "^[a-zA-z]{1,32}$") String name,@Pattern(regexp = "^[a-zA-z]{1,32}$") String country, @Pattern(regexp = "^[0-9]{1,6}$") String index,List<KlassDto> кlassDto) {
		super();
		this.schoolId = schoolId;
		this.name = name;
		this.country = country;
		this.index = index;
		this.кlassDto = кlassDto;
	}


	/**
     * Метод возвращает - класс
     * @return класс
     */ 
	public List<KlassDto> getКlassDto() {
		return кlassDto;
	}
    /**
     * Метод возвращает -  страну
     * @return страна
     */
	public String getCountry() {
		return country;
	}
    /**
     * Метод возвращает - индекс
     * @return индекс
     */
	public String getIndex() {
		return index;
	}
    /**
     * Метод возвращает - наименование школы 
     * @return наименование школы 
     */
	public String getName() {
		return name;
	}
    /**
     * Метод возвращает - id школы
     * @return id школы
     */
	public int getSchoolId() {
		return schoolId;
	}
    /**
     * Метод устанавливает - класс
     * @param кlass класс
     */
	public void setКlassDto(List<KlassDto> кlassDto) {
		this.кlassDto = кlassDto;
	}
    /**
     * Метод устанавливает - страну
     * @param country страна
     */
	public void setCountry(String country) {
		this.country = country;
	}
    /**
     * Метод устанавливает - id школы
     * @param id школы
     */
	public void setId(int schoolId) {
		this.schoolId = schoolId;
	}
    /**
     * Метод устанавливает - индекс
     * @param index индекс
     */
	public void setIndex(String index) {
		this.index = index;
	}
    /**
     * Метод устанавливает - наименование школы 
     * @param name наименование школы 
     */
	public void setName(String name) {
		this.name = name;
	}
}