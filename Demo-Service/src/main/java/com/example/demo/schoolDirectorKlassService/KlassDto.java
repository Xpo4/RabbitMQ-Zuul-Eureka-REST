package com.example.demo.schoolDirectorKlassService;


import javax.validation.constraints.Pattern;

import org.springframework.hateoas.ResourceSupport;





/**
 * Класс описывает школьный класс
 * @author admin
 *
 */
public class KlassDto extends ResourceSupport {
	/**
	 * Первичный ключ школьного класса
	 */
	private int klass_Id;
	/**
	 * Номер класса
	 */
	@Pattern(regexp = "^[0-9]{1,2}[a-zA-z]$")
	private String number;
	/**
	 * Школа
	 */
	private int schoolId; 
	/**
	 * Конструктор школьного класса
	 */
	public KlassDto() {
		
	}
	/**
	 * 	Конструктор школьного класса
	 * @param number номер
	 * @param schoolId Id школы
	 */
	public KlassDto(int klass_Id, @Pattern(regexp = "^[0-9]{1,2}[a-zA-z]$") String number, int schoolId) {
		super();
		this.klass_Id = klass_Id;
		this.number = number;
		this.schoolId = schoolId;
	}
	/**
	 * Метод возвращает - id школьного клсса 
	 * @return id школьного клсса
	 */
	public int getklass_Id() {
		return klass_Id;
	}
    /**
     * Метод возвращает - номер школьного класса
     * @return номер школьного класса
     */
	public String getNumber() {
		return number;
	}
    /**
	 * Метод возвращает - школу
	 * @return школу
	 */
    public int getSchoolId() {
		return schoolId;
	}
	/**
     * Метод устанавливает - id школьного клсса 
     * @param id школьного клсса 
     */
	public void setId(int klass_Id) {
		this.klass_Id = klass_Id;
	}
    
	/**
     * Метод устанавливает - номер школьного класса 
     * @param number  номер школьного класса
     */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
     * Метод устанавливает - школу
     * @param schol школу
     */
    public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
    	
}
