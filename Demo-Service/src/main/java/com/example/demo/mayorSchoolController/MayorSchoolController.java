package com.example.demo.mayorSchoolController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mayorSchoolService.MayorSchoolService;
import com.example.demo.mayorSchoolService.SchoolDto;
import com.example.demo.restControllerAdvices.exaption.CustomNotFoundExaption;
import com.example.demo.schoolDirectorKlassService.KlassDto;


/**
 * Класс описывает контроллер школ
 * @author admin
 *
 */
@RestController
@RequestMapping("/school")
class MayorSchoolController {
	/**
	 * Сервис школ
	 */
	@Autowired
	private MayorSchoolService mayorSchoolService;
	/**
	 * Метод описывает получение всех данных из БД
	 * @return данные из БД
	 */
	@GetMapping("/all")
	public List<SchoolDto> findAll()throws CustomNotFoundExaption{
		if (mayorSchoolService.getAllSchool().size() == 0) {
			throw new CustomNotFoundExaption("Школ в базе данных нету");
		}
		List<SchoolDto> listSchoolDto = mayorSchoolService.getAllSchool();
		listSchoolDto.forEach(schoolDto -> {
			Link linkCountrySearch = ControllerLinkBuilder.linkTo(MayorSchoolController.class).slash("country/" + schoolDto.getCountry()).withSelfRel();
			Link linkId = ControllerLinkBuilder.linkTo(MayorSchoolController.class).slash("id/" + schoolDto.getSchoolId()).withSelfRel();
			Link linkName = ControllerLinkBuilder.linkTo(MayorSchoolController.class).slash("name/" + schoolDto.getName()).withSelfRel();
			Link linkIndex = ControllerLinkBuilder.linkTo(MayorSchoolController.class).slash("index/" + schoolDto.getIndex()).withSelfRel();
			schoolDto.add(linkCountrySearch);
			schoolDto.add(linkId);
			schoolDto.add(linkName);
			schoolDto.add(linkIndex);
		 });
		return listSchoolDto;
	}
	/**
	 * Метод описывает поиск школ по стране
	 * @param country страна
	 * @return лист стран
	 */
	@GetMapping("country/{country}")
    public List<SchoolDto> getSchoolByCountry(@PathVariable String country)throws CustomNotFoundExaption{
		if (mayorSchoolService.findByCountry(country).size() == 0) {
			throw new CustomNotFoundExaption("В базе данных нет школ со Страной: " + country);
		}
		List<SchoolDto> listSchoolDto = mayorSchoolService.findByCountry(country);
		listSchoolDto.forEach(schoolDto -> {
			Link linkId = ControllerLinkBuilder.linkTo(MayorSchoolController.class).slash("id/" + schoolDto.getSchoolId()).withSelfRel();
			Link linkName = ControllerLinkBuilder.linkTo(MayorSchoolController.class).slash("name/" + schoolDto.getName()).withSelfRel();
			Link linkIndex = ControllerLinkBuilder.linkTo(MayorSchoolController.class).slash("index/" + schoolDto.getIndex()).withSelfRel();
			schoolDto.add(linkId);
			schoolDto.add(linkName);
			schoolDto.add(linkIndex);
		 });
		return listSchoolDto;
		
    }
	/**
	 * Метод описывает поиск школы по ID
	 * @param id ID
	 * @return школа
	 */
	@GetMapping("id/{id}")
    public SchoolDto getSchoolById(@PathVariable int id)throws CustomNotFoundExaption{
		if (mayorSchoolService.findById(id).size() == 0) {
			throw new CustomNotFoundExaption("В базе данных нет школы с ID: " + id);
		}
		SchoolDto schoolDto = mayorSchoolService.findById(id).get(0);
		Link linkDeleteID = ControllerLinkBuilder.linkTo(MayorSchoolController.class).slash("delet/" + schoolDto.getSchoolId()).withSelfRel();
		schoolDto.add(linkDeleteID);
        return schoolDto;
    }
	/**
	 * Метод описывает поиск школ по индексу
	 * @param index индекс
	 * @return лист стран
	 */
	@GetMapping("index/{index}")
    public List<SchoolDto> getSchoolByIndex(@PathVariable String index)throws CustomNotFoundExaption{
		if (mayorSchoolService.findByIndex(index).size() == 0) {
			throw new CustomNotFoundExaption("В базе данных нет школ с Индексом: " + index);
		}
		List<SchoolDto> listSchoolDto = mayorSchoolService.findByIndex(index);
		listSchoolDto.forEach(schoolDto -> {
			Link linkCountrySearch = ControllerLinkBuilder.linkTo(MayorSchoolController.class).slash("country/" + schoolDto.getCountry()).withSelfRel();
			Link linkId = ControllerLinkBuilder.linkTo(MayorSchoolController.class).slash("id/" + schoolDto.getSchoolId()).withSelfRel();
			Link linkName = ControllerLinkBuilder.linkTo(MayorSchoolController.class).slash("name/" + schoolDto.getName()).withSelfRel();
			schoolDto.add(linkCountrySearch);
			schoolDto.add(linkId);
			schoolDto.add(linkName);
		 });
		return listSchoolDto;
    }
	/**
	 * Метод описывает поиск школ по ноименованию
	 * @param name ноименование
	 * @return школы
	 */
	@GetMapping("name/{name}")
    public List<SchoolDto> getSchoolByName(@PathVariable String name)throws CustomNotFoundExaption{
		if (mayorSchoolService.findByName(name).size() == 0) {
			throw new CustomNotFoundExaption("В базе данных нет школ с Наименованием: " + name);
		}
		List<SchoolDto> listSchoolDto = mayorSchoolService.findByName(name);
		listSchoolDto.forEach(schoolDto -> {
			Link linkCountrySearch = ControllerLinkBuilder.linkTo(MayorSchoolController.class).slash("country/" + schoolDto.getCountry()).withSelfRel();
			Link linkId = ControllerLinkBuilder.linkTo(MayorSchoolController.class).slash("id/" + schoolDto.getSchoolId()).withSelfRel();
			Link linkIndex = ControllerLinkBuilder.linkTo(MayorSchoolController.class).slash("index/" + schoolDto.getIndex()).withSelfRel();
			schoolDto.add(linkCountrySearch);
			schoolDto.add(linkId);
			schoolDto.add(linkIndex);
		 });
		return listSchoolDto;
	}
	/**
	 * Метод описывает создание школы
	 * @param name наименование
	 * @param country страна 
	 * @param index индекс
	 * @return уведомление о создании школы
	 */
	@PostMapping
	@ResponseBody
	public ResponseEntity<String> saveSchool(@RequestParam String name,
			@RequestParam String country,
			@RequestParam String index,
			@RequestBody List<KlassDto> listKlassDto) throws CustomNotFoundExaption {
		SchoolDto schoolDto = new SchoolDto(0, name,country,index,listKlassDto);
		schoolDto.setКlassDto(listKlassDto);
		mayorSchoolService.saveSchool(schoolDto);
		return ResponseEntity.status(HttpStatus.OK).body(
				new SchoolDto(0, name,country,index,listKlassDto) + " Сохранение успешно!");
	}
	/**
	 * Метод описывает удаление школы по ID
	 * @param id ID
	 * @return уведомление о удалении школы
	 */
	@DeleteMapping("delet/{id}")
	public ResponseEntity<String> deleteSchool(@PathVariable int id)throws CustomNotFoundExaption {
		if (mayorSchoolService.findById(id).size() == 0) {
			throw new CustomNotFoundExaption("В базе данных нету школы с ID: " + id);
		}
		mayorSchoolService.deleteSchool(mayorSchoolService.findById(id).get(0));
       return ResponseEntity.status(HttpStatus.OK).body(" Удаление успешно!");
	}

}
