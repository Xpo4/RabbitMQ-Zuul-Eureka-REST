package com.example.demo.reposytory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mayorSchoolService.SchoolDto;
import com.example.demo.schoolDirectorKlassService.KlassDto;

;
/**
 * Класс описывает адаптер доступа к репозиторию
 * @author admin
 *
 */
@Service
class AccesAdapteImpl implements AccesAdapter  {
	/**
	 * Репозиторий школ
	 */
	@Autowired
	private MayorSchoolReposytory schoolRepository;
	/**
	 * Репозиторий школьных классов 
	 */
	@Autowired
	private SchoolDirectorKlassReposytory klassRepository;
	/**
	 * Метод описывает конвертацию SchoolDto в School
	 * @param schoolDto 
	 * @return School
	 */
	private School converterSchoolDtoToSchool(SchoolDto schoolDto) {	
	School school = new School(schoolDto.getName(),
				schoolDto.getCountry(),
				schoolDto.getIndex(),
				schoolDto.getКlassDto().stream().map(klassDto -> new Klass(
						klassDto.getNumber())).collect(Collectors.toList()));
	school.getКlass().forEach(klass -> klass.setSchool(school));
		return school;		
	}
	/**
	 * Метод описывает конертацию листа классов School в лист классов SchoolDto
	 * @param listSchool листа классов School
	 * @return лист классов SchoolDto
	 */
	private List<SchoolDto> converterListSchoolToListSchoolDto(List<School> listSchool) {	
		if(listSchool == null) {
			return new ArrayList<SchoolDto>();
		}
		return listSchool.stream().map(school -> new SchoolDto(
						 school.getschoolId(),
						 school.getName(),
						 school.getCountry(),
						 school.getIndex(),
						 school.getКlass().stream().map(klass -> new KlassDto(
								klass.getId(),
								klass.getNumber(),
								school.getschoolId())).
						 collect(Collectors.toList()))).collect(Collectors.toList());
	}
	/**
	 * Метод описывает - конвертацию KlassDto в Klass
	 * @param klassDto
	 * @return Klass
	 */
	private Klass converterKlassDtoToKlass(KlassDto klassDto) {
		Klass klass = new Klass(klassDto.getNumber());
		klass.setSchool(schoolRepository.findById(klassDto.getSchoolId()).get(0));
		klass.setId(klassDto.getklass_Id());
		return klass;	
	}
	/**
	 * Метод описывает - конвертацию листа классов Klass в лист классов KlassDto
	 * @param listKlass листа классов Klass
	 * @return лист классов KlassDto
	 */
	private List<KlassDto> converterListKlassToListKlassDto(List<Klass> listKlass) {
		if(listKlass == null) {
			return new ArrayList<KlassDto>();
		}
	return listKlass.stream().map(klass -> new KlassDto(
			klass.getId(),
			klass.getNumber(),
			klass.getSchool().getschoolId()))
	.collect(Collectors.toList());
	}
	/**
	 * Метод описывает поиск по ID класса в репозитории
	 * @param id ID класса
	 * @return лист классов
	 */
	public List<KlassDto> klassFindById(int id) {
		return converterListKlassToListKlassDto(klassRepository.findById(id));
	}
	/**
	 * Метод описывает поиск по номеру класса в репозитории
	 * @param number номер школы
	 * @return лист классов
	 */
	public List<KlassDto> klassFindByNumber(String number) {
		return converterListKlassToListKlassDto(klassRepository.findByNumber(number));
	}
	/**
	 * Метод описывает сохранение школьного класса
	 * @param klassDto
	 */
	public void klassSave (KlassDto klassDto) {
		klassRepository.save(converterKlassDtoToKlass(klassDto));
	}
	/**
	 * Метод описывает удаление школьного класса
	 * @param klassDto
	 */
	public void klassDelete (KlassDto klassDto) {
//		System.out.println(klassDto.getklass_Id());
//		klassRepository.deleteById(klassDto.getklass_Id());
		klassRepository.delete(klassRepository.findById(klassDto.getklass_Id()).get(0));
	}
	/**
	 * Метод описывает вывод всех классов
	 * @return лист классов
	 */
	public List<KlassDto> klassFindAll () {
		return converterListKlassToListKlassDto((klassRepository.findAll()));	
	}
/////////////////////////////////////////////////////////////////////////////////	
/////////////////////////////////////////////////////////////////////////////////		
/////////////////////////////////////////////////////////////////////////////////
	/**
	 * Метод описывает поиск по стране в репозитории
	 * @param country страна
	 * @return лист школ
	 */
	public List<SchoolDto> schoolFindByCountry(String country) {
		return converterListSchoolToListSchoolDto(schoolRepository.findByCountry(country));
	}
	/**
	 * Метод описывает поиск по ID класса в репозитории
	 * @param id ID класса
	 * @return лист классов
	 */
	public List<SchoolDto> schoolFindById(int id) {
		return converterListSchoolToListSchoolDto((schoolRepository.findById(id)));
	}
	/**
	 * Метод описывает поиск по индексу в репозитории
	 * @param index индекс
	 * @return лист стран
	 */
	public List<SchoolDto> schoolFindByIndex(String index) {
		return converterListSchoolToListSchoolDto(schoolRepository.findByIndex(index));
	}
	/**
	 * Метод описывает поиск по наименованию в репозитории
	 * @param name наименование школы
	 * @return лист школ
	 */
	public List<SchoolDto> schoolFindByName(String name) {
		return converterListSchoolToListSchoolDto(schoolRepository.findByName(name));
	}
	/**
	 * Метод описывает сохранение школы
	 * @param klassDto
	 */
	public void schoolSave (SchoolDto schoolDto) {
		schoolRepository.save(converterSchoolDtoToSchool(schoolDto));
	}
	/**
	 * Метод описывает удаление школы
	 * @param schoolDto
	 */
	public void schoolDelete (SchoolDto schoolDto) {
		schoolRepository.deleteById(schoolDto.getSchoolId());
	}
	/**
	 * Метод описывает вывод всех школ
	 * @return 
	 * @return лист классов
	 */
	public List<SchoolDto> schoolFindAll () {
		return converterListSchoolToListSchoolDto(schoolRepository.findAll());	
	}
}