package com.example.demo.mayorSchoolService;

import java.util.List;

/**
 * Интерфейс описывает сервис школ
 * @author admin
 *
 */
public interface MayorSchoolService {
	/**
	 * Метод описывает удаление школы
	 * @param кlass
	 * @return
	 * @throws IllegalArgumentException
	 */
	void deleteSchool(SchoolDto schoolDto) throws IllegalArgumentException;
	/**
	 * Метод описывает поиск по стране в репозитории
	 * @param country страна
	 * @return лист школ
	 * @throws IllegalArgumentException country = null
	 */
	List<SchoolDto> findByCountry(String country) throws IllegalArgumentException;
	/**
	 * Метод описывает поиск  школы по id
	 * @return лист школ
	 */
	List<SchoolDto> findById(int id);
	/**
	 * Метод описывает поиск по индексу в репозитории
	 * @param index индекс
	 * @return лист школ 
	 * @throws IllegalArgumentException index = null
	 */
	List<SchoolDto> findByIndex(String index) throws IllegalArgumentException;
	/**
	 * Метод описывает поиск по наименованию школы в репозитории
	 * @param name наименование школы
	 * @return лист школ
	 * @throws IllegalArgumentException name = null
	 */
	List<SchoolDto> findByName(String name) throws IllegalArgumentException;
	/**
	 * Метод описывает поиск всех школ
	 * @return лист школ
	 */
	List<SchoolDto> getAllSchool();
	/**
	 * Метод описывает добавление школы
	 * @param school школа
	 * @throws IllegalArgumentException school = null
	 */
	void saveSchool(SchoolDto schoolDto) throws IllegalArgumentException;
}
