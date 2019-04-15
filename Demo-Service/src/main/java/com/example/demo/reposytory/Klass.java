package com.example.demo.reposytory;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;



/**
 * Класс описывает школьный класс
 * @author admin
 *
 */
@Entity

class Klass{
	/**
	 * Первичный ключ школьного класса
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/**
	 * Номер класса
	 */
	@Pattern(regexp = "^[0-9]{1,2}[a-zA-z]$")
	private String number;
	/**
	 * Школа
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private School school; 
	/**
	 * Конструктор школьного класса
	 */
	public Klass() {
		
	}
	/**
	 * 	Конструктор школьного класса
	 * @param number номер
	 * @param school школа
	 */
	public Klass(@Pattern(regexp = "^[0-9]{1,2}[a-zA-z]$") String number) {
		super();
		this.number = number;
	}
	
	/**
     * Метод переопределяет equals
     */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Klass other = (Klass) obj;
		if (id != other.id)
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
	/**
	 * Метод возвращает - id школьного клсса 
	 * @return id школьного клсса
	 */
	public int getId() {
		return id;
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
    public School getSchool() {
		return school;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}
	/**
     * Метод устанавливает - id школьного клсса 
     * @param id школьного клсса 
     */
	public void setId(int id) {
		this.id = id;
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
    public void setSchool(School school) {
		this.school = school;
	}
	
}
