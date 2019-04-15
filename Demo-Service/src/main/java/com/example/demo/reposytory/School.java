package com.example.demo.reposytory;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;
/**
 * Класс описывает школу
 * @author admin
 *
 */
@Entity
class School {
	/**
	 * ID школы 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@OneToMany( fetch = FetchType.EAGER, mappedBy = "school",orphanRemoval=true, cascade=CascadeType.ALL)
	private List<Klass> кlass = new ArrayList<Klass>();
	/**
	 * Конструктор школы
	 */
	public School() {
		
	}
	
    public School(@Pattern(regexp = "^[a-zA-z]{1,32}$") String name, @Pattern(regexp = "^[a-zA-z]{1,32}$") String country, @Pattern(regexp = "^[0-9]{1,6}$") String index,List<Klass> кlass) {
		super();
		this.name = name;
		this.country = country;
		this.index = index;
		this.кlass = кlass;
	}
    
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		School other = (School) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (schoolId != other.schoolId)
			return false;
		return true;
	}
    /**
     * Метод возвращает - класс
     * @return класс
     */ 
	public List<Klass> getКlass() {
		return кlass;
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
	public int getschoolId() {
		return schoolId;
	}
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + schoolId;
		return result;
	}
    /**
     * Метод устанавливает - класс
     * @param кlass класс
     */
	public void setКlass(List<Klass> кlass) {
		this.кlass = кlass;
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
