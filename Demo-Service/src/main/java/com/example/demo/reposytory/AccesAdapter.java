package com.example.demo.reposytory;

import java.util.List;

import com.example.demo.mayorSchoolService.SchoolDto;
import com.example.demo.schoolDirectorKlassService.KlassDto;



/**
 * Класс описывает адаптер доступа к репозиторию
 * @author admin
 *
 */

public interface AccesAdapter {
	/**
	 * Метод описывает поиск по ID класса в репозитории
	 * @param id ID класса
	 * @return лист классов
	 */
	public List<KlassDto> klassFindById(int id);
	/**
	 * Метод описывает поиск по номеру класса в репозитории
	 * @param number номер школы
	 * @return лист классов
	 */
	public List<KlassDto> klassFindByNumber(String number);
	/**
	 * Метод описывает сохранение школьного класса
	 * @param klassDto
	 */
	public void klassSave (KlassDto klassDto);
	/**
	 * Метод описывает удаление школьного класса
	 * @param klassDto
	 */
	public void klassDelete (KlassDto klassDto);
	/**
	 * Метод описывает вывод всех классов
	 * @return лист классов
	 */
	public List<KlassDto> klassFindAll ();
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////	
	/**
	 * Метод описывает поиск по стране в репозитории
	 * @param country страна
	 * @return лист школ
	 */
	public List<SchoolDto> schoolFindByCountry(String country);
	/**
	 * Метод описывает поиск по ID класса в репозитории
	 * @param id ID класса
	 * @return лист классов
	 */
	public List<SchoolDto> schoolFindById(int id);
	/**
	 * Метод описывает поиск по индексу в репозитории
	 * @param index индекс
	 * @return лист стран
	 */
	public List<SchoolDto> schoolFindByIndex(String index);
	/**
	 * Метод описывает поиск по наименованию в репозитории
	 * @param name наименование школы
	 * @return лист школ
	 */
	public List<SchoolDto> schoolFindByName(String name);
	/**
	 * Метод описывает сохранение школы
	 * @param klassDto
	 */
	public void schoolSave (SchoolDto schoolDto);
	/**
	 * Метод описывает удаление школы
	 * @param schoolDto
	 */
	public void schoolDelete (SchoolDto schoolDto);
	/**
	 * Метод описывает вывод всех школ
	 * @return лист классов
	 */
	public List<SchoolDto> schoolFindAll ();
}