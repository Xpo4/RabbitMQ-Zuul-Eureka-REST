package com.example.demo.mayorSchoolService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.reposytory.AccesAdapter;



/**
 * Класс описывает сервис школ и его бизнес-логику
 * @author admin
 *
 */
@org.springframework.stereotype.Service
@Transactional
class MayorSchoolServiceImpl implements MayorSchoolService {
	/**
	 * Адаптер доступа к репозиторию
	 */
	@Autowired
	private AccesAdapter accesAdapter;
	/**
	 * Метод описывает удаление школы
	 * @param school школа
	 * @throws IllegalArgumentException school = null
	 */
	@Override
	public void deleteSchool(SchoolDto schoolDto) throws IllegalArgumentException {
			if(schoolDto == null) throw new IllegalArgumentException ("Требуется указать школу");
			accesAdapter.schoolDelete(schoolDto);	
	}
	/**
	 * Метод описывает поиск по стране в репозитории
	 * @param country страна
	 * @return лист школ
	 * @throws IllegalArgumentException country = null
	 */
	@Override
	public List<SchoolDto> findByCountry(String country) throws IllegalArgumentException {
		if(country == null) throw new IllegalArgumentException ("Требуется указать страну");
		return accesAdapter.schoolFindByCountry(country);
	}
	/**
	 * Метод описывает поиск школы по ID в репозитории
	 * @param id ID
	 * @return школа
	 */
	@Override
	public List<SchoolDto> findById(int id) {
		return accesAdapter.schoolFindById(id);
	}
	/**
	 * Метод описывает поиск по индексу в репозитории
	 * @param index индекс
	 * @return лист школ 
	 * @throws IllegalArgumentException index = null
	 */
	@Override
	public List<SchoolDto> findByIndex(String index) throws IllegalArgumentException {
		if(index == null) throw new IllegalArgumentException ("Требуется указать индекс");
		return accesAdapter.schoolFindByIndex(index);
	}
	/**
	 * Метод описывает поиск по наименованию школы в репозитории
	 * @param name наименование школы
	 * @return лист школ
	 * @throws IllegalArgumentException name = null
	 */
	@Override
	public List<SchoolDto> findByName(String name) throws IllegalArgumentException {
		if(name == null) throw new IllegalArgumentException ("Требуется указать наименование");
		return accesAdapter.schoolFindByName(name);
	}
	/**
	 * Метод описывает поиск всех школ
	 * @return лист школ
	 */
	@Override
	public List<SchoolDto> getAllSchool() {
		return accesAdapter.schoolFindAll();
	}
    /**
     * Метод описывает сохранение школы
     */
	@Override
	public void saveSchool(SchoolDto schoolDto) throws IllegalArgumentException {
		if(schoolDto == null) throw new IllegalArgumentException ("Требуется указать школу");
		accesAdapter.schoolSave(schoolDto);	
	}
}