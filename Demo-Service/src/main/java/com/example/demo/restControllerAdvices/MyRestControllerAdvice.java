package com.example.demo.restControllerAdvices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.restControllerAdvices.exaption.CustomNotFoundExaption;

/**
 * Класс описывает обработку исключений службы загрузки
 * @author Костя
 *
 */
@RestControllerAdvice
public class MyRestControllerAdvice {
	/**
	 * Метод описывает ответ на ошибку MyNotFoundExaption
	 * @param ex ошибка
	 * @return ответ
	 */
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(CustomNotFoundExaption.class)
	public ResponseMsg handleIllegalArgumentException(CustomNotFoundExaption ex) {
		ResponseMsg responseMsg = new ResponseMsg(ex.getString());
		responseMsg.setExeptionNumber(ex.getCodeExaption());
		return responseMsg;
	}
	/**
	 * Метод описывает ответ на неопределенную ошибку сервера
	 * @param ex ошибка
	 * @return ответ
	 */
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public String handleNotFoundException(Exception ex) {	
		return "Ошибка сервера. Обратитесь к оператору.";
	}
}
