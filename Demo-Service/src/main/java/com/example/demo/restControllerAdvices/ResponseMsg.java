package com.example.demo.restControllerAdvices;


/**
 * Класс описывает сообщение на ошибку генерируемое обработчиком ошибок службы загрузки
 * @author Костя
 *
 */
class ResponseMsg {
	private String message;
 /**
  * Номер ошибки
  */
	private int ExeptionNumber;
	/**
	 * Конструктор
	 * @param msg сообщение
	 */
	public ResponseMsg(String msg){
		this.message = msg;
	}
	/**
	 * Метод возвращает - номер ошибки
	 * @return номер ошибки
	 */
	public int getExeptionNumber() {
		return ExeptionNumber;
	}
	/**
	 * Метод возвращает - сообщение
	 * @return сообщение
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * Метод устанавливает - номер ошибки
	 * @param exeptionNumber номер ошибки
	 */
	public void setExeptionNumber(int exeptionNumber) {
		ExeptionNumber = exeptionNumber;
	}
}
