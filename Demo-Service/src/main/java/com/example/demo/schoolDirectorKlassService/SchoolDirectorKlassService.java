package com.example.demo.schoolDirectorKlassService;

import java.util.List;

import com.example.demo.mayorSchoolService.SchoolDto;

/**
 * Интерфейс описывает сервис школьных классов
 * @author admin
 *
 */
public interface SchoolDirectorKlassService {
	/**
	 * Метод описывает удаление школьного класса
	 * @param klass класс
	 * @throws IllegalArgumentException klass = null
	 */
	void deleteKlass(KlassDto klassDto) throws IllegalArgumentException;
	/**
	 * Метод описывает поиск  класса по id
	 * @return лист классов
	 */
	List<KlassDto> findById(int id);
	/**
	 * Метод описывает поиск по номеру класса в репозитории
	 * @param number номер школы
	 * @return лист классов
	 * @throws IllegalArgumentException number = null
	 */
	List<KlassDto> findByNumber(String number) throws IllegalArgumentException;
	/**
	 * Метод описывает поиск всех классов
	 * @return лист классов
	 */
	List<KlassDto> getAllKlass();
	/**
	 * Метод описывает добавление школьнго класса
	 * @param klass класс
	 * @throws IllegalArgumentException klass = null
	 */
	void saveKlass(KlassDto klassDto) throws IllegalArgumentException;
	
	List<SchoolDto> SchoolFindById(int id);
}
