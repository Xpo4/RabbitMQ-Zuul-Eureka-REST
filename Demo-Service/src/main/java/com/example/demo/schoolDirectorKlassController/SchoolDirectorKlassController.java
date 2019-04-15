package com.example.demo.schoolDirectorKlassController;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.restControllerAdvices.exaption.CustomNotFoundExaption;
import com.example.demo.schoolDirectorKlassService.KlassDto;
import com.example.demo.schoolDirectorKlassService.SchoolDirectorKlassService;

/**
* Класс описывает контроллер школьных классов
* @author admin
*
*/
@RestController
@RequestMapping("/klass")
class SchoolDirectorKlassController {
	/**
	 * Сервис школьных классов
	 */
	@Autowired
	private SchoolDirectorKlassService schoolDirectorKlassService;
	/**
	 * Метод описывает получение всех данных из БД
   * @return 
	 * @return данные из БД
	 */
	
	@GetMapping("/all")
	public List<KlassDto> find()throws CustomNotFoundExaption{
		if (schoolDirectorKlassService.getAllKlass().size() == 0) {
			throw new CustomNotFoundExaption("Школьных классов в базе данных нету");
		}
		List<KlassDto> listKlassDto = schoolDirectorKlassService.getAllKlass();
		listKlassDto.forEach(klassDto -> {
			Link linkID = ControllerLinkBuilder.linkTo(SchoolDirectorKlassController.class).slash("id/" + klassDto.getklass_Id()).withSelfRel();
			Link linkNumber = ControllerLinkBuilder.linkTo(SchoolDirectorKlassController.class).slash("number/" + klassDto.getNumber()).withSelfRel();
			Link linkDelete= ControllerLinkBuilder.linkTo(SchoolDirectorKlassController.class).slash("delete/" + klassDto.getklass_Id()).withSelfRel();
			klassDto.add(linkID);
			klassDto.add(linkNumber);
			klassDto.add(linkDelete);
		});
		return listKlassDto;
	}
	/**
	 * Поиск школьного класса по ID
	 * @param id ID
	 * @return школьный класс
	 */
	@GetMapping("id/{id}")
    public KlassDto getKlassById(@PathVariable int id)throws CustomNotFoundExaption{
		if (schoolDirectorKlassService.findById(id).size() == 0) {
			throw new CustomNotFoundExaption("В базе данных нет класса с ID: " + id);
		}
		KlassDto klassDto = schoolDirectorKlassService.findById(id).get(0);
			Link linkDelete = ControllerLinkBuilder.linkTo(SchoolDirectorKlassController.class).slash("delete/" + klassDto.getklass_Id()).withSelfRel();
			klassDto.add(linkDelete);		
        return klassDto;
	}
	/**
	 * Метод описывает поиск школьного класса по номеру
	 * @param number номер
	 * @return лист школьных классов 
	 */
	@GetMapping("number/{number}")
	public List<KlassDto> getKlassByNumber(@PathVariable String number)throws CustomNotFoundExaption {
		if (schoolDirectorKlassService.findByNumber(number).size() == 0) {
			throw new CustomNotFoundExaption("В базе данных нет классов с Номером: " + number);
		}
		List<KlassDto> listKlassDto = schoolDirectorKlassService.findByNumber(number);
		listKlassDto.forEach(klassDto -> {
			Link linkID = ControllerLinkBuilder.linkTo(SchoolDirectorKlassController.class).slash("id/" + klassDto.getklass_Id()).withSelfRel();
			klassDto.add(linkID);
		});
		return listKlassDto;
	}
	/**
	 * Метод описывает сохранение школьного класса
	 * @param number номер класса
	 * @param id ID школы
	 * @return уведомление о создании школьного класса
	 */
	@PostMapping
	public ResponseEntity<String> saveKlass(@RequestParam String number,@RequestParam int id)throws CustomNotFoundExaption{
		if ((schoolDirectorKlassService.SchoolFindById(id).size() == 0)) {
			throw new CustomNotFoundExaption("Создание класса не возможно.В базе данных нет школы с ID: " + id);
		}
		KlassDto klassDto = new KlassDto(0, number, id);
		schoolDirectorKlassService.saveKlass(klassDto);
		return ResponseEntity.status(HttpStatus.OK).body(klassDto + " Класс сохранен!");
	}
	/**
	 * Метод описывает удаление школьного класса
	 * @param id
	 * @return уведомление о удалении школьного класса
	 */
	@DeleteMapping("delet/{id}")
	public ResponseEntity<String> deleteKlass(@PathVariable int id)throws CustomNotFoundExaption{
		if (schoolDirectorKlassService.findById(id).size() == 0) {
			throw new CustomNotFoundExaption("Удаление класса не возможно.В базе данных нет класса с ID: " + id);
		}
		KlassDto klassDto = schoolDirectorKlassService.findById(id).get(0);
		klassDto.setId(id);
		schoolDirectorKlassService.deleteKlass(klassDto);
        return ResponseEntity.status(HttpStatus.OK).body(klassDto + " Класс удален!");
	}
}