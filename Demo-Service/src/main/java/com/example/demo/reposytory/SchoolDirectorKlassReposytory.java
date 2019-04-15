package com.example.demo.reposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Интерфейс описывает репозиторий школьных классов
 * @author admin
 *
 */
interface SchoolDirectorKlassReposytory extends JpaRepository<Klass, Integer>{
	/**
	 * Метод описывает поиск по ID класса в репозитории
	 * @param id ID класса
	 * @return лист классов
	 */
	List<Klass> findById(int id);
	/**
	 * Метод описывает поиск по номеру класса в репозитории
	 * @param number номер школы
	 * @return лист классов
	 */
	List<Klass> findByNumber(String number);
	/**
	 * Метод описывает поиск по школе в репозитории
	 * @param school школа
	 * @return лист классов
	 */
	List<Klass> findBySchool (School school);
	
}
