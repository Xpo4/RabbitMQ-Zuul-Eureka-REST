package com.example.demo.reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Интерфейс описывает репозиторий для школ
 * @author admin
 *
 */
interface MayorSchoolReposytory extends JpaRepository<School, Integer> {
	/**
	 * Метод описывает поиск по стране в репозитории
	 * @param country страна
	 * @return лист школ
	 */
	List<School> findByCountry(String country);
	/**
	 * Метод описывает поиск по ID класса в репозитории
	 * @param id ID класса
	 * @return лист классов
	 */
	List<School> findById(int id);
	/**
	 * Метод описывает поиск по индексу в репозитории
	 * @param index индекс
	 * @return лист стран
	 */
	List<School> findByIndex(String index);
	/**
	 * Метод описывает поиск по наименованию в репозитории
	 * @param name наименование школы
	 * @return лист школ
	 */
	List<School> findByName(String name);
}
