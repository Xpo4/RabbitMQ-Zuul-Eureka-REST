package com.example.demo.schoolDirectorKlassService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mayorSchoolService.SchoolDto;
import com.example.demo.reposytory.AccesAdapter;

/**
 * Класс описывает сервис школьных классов и его бизнес-логику
 * @author admin
 *
 */
@Service
@Transactional
class SchoolDirectorKlassServiceImpl implements SchoolDirectorKlassService {
	/**
	 * Адаптер доступа к репозиторию
	 */
	@Autowired
	private AccesAdapter accesAdapter;
	/**
	 * Метод описывает удаление школьного класса
	 * @param klassDto класс
	 * @throws IllegalArgumentException klass = null
	 */
	@Override
	public void deleteKlass(KlassDto klassDto) throws IllegalArgumentException {
		if(klassDto == null) throw new IllegalArgumentException ("Требуется указать класс");
		accesAdapter.klassDelete(klassDto);
	}
	/**
	 * Метод описывает поиск по id
	 * @param id
	 * @return лист классов
	 */
	@Override
	public List<KlassDto> findById(int id) {
		return accesAdapter.klassFindById(id);
	}
	/**
	 * Метод описывает поиск по номеру класса в репозитории
	 * @param number номер школы
	 * @return лист классов
	 * @throws IllegalArgumentException number = null
	 */
	@Override
	public List<KlassDto> findByNumber(String number) throws IllegalArgumentException {
		if(number == null) throw new IllegalArgumentException ("Требуется указать номер");
		return accesAdapter.klassFindByNumber(number);
	}
	/**
	 * Меиод описывает поиск всех классов
	 * @return лист классов
	 */
	@Override
	public List<KlassDto> getAllKlass() {
		return accesAdapter.klassFindAll();
	}
	/**
	 * Метод описывает добавление школьнго класса
	 * @param klass класс
	 * @return лист классов 
	 * @throw IllegalArgumentException klass = null
	 * @throw IllegalArgumentException номер = "4А"
	 */
	@Override
	public void saveKlass(KlassDto klassDto) throws IllegalArgumentException {
		if(klassDto == null) throw new IllegalArgumentException ("Требуется указать класс");
		String string = klassDto.getNumber();
		if(string=="4I") throw new IllegalArgumentException ("Класс 4А недоступен для создания");
		accesAdapter.klassSave(klassDto);	
	}
	/**
	 * Метод описывает поиск школ по ID
	 * @param id
	 * @return лист школ
	 */
	public List<SchoolDto> SchoolFindById(int id) {
		return accesAdapter.schoolFindById(id);
	}
	
}
