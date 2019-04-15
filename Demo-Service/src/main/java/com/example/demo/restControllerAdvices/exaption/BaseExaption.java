package com.example.demo.restControllerAdvices.exaption;

/**
 * Класс описывает шаблон для ошибок 
 * @author Костя
 *
 */
abstract class BaseExaption extends RuntimeException {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
    /**
     * Код ошибки
     */
 	private int codeExaption;
	/**
	 * Сообщение ошибки
	 */
	private String string;
    /**
     * Конструктор
     * @param string сообщение ошибки
     */
	public BaseExaption(String string) {
		super();
	}
	/**
	 * Метод возвращает - код ошибки 
	 * @return код ошибки 
	 */
	public int getCodeExaption() {
		return codeExaption;
	}
    /**
	 * Метод возвращает - сообщение ошибки
	 * @return сообщение ошибки
	 */
	public String getString() {
		return string;
	}
	/**
     * Метод устанавливает - код ошибки 
     * @param string код ошибки 
     */
	public void setCodeExaption(int codeExaption) {
		this.codeExaption = codeExaption;
	}
	/**
     * Метод устанавливает - сообщение ошибки
     * @param string сообщение ошибки
     */
	public void setString(String string) {
		this.string = string;
	}
	
}
