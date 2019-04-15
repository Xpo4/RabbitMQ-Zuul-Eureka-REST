package com.example.demo.restControllerAdvices.exaption;

/**
 * Класс описывает ошибку генерируемую сервером при отсутсвие запрашиваемой информации 
 * @author Костя
 *
 */
public class CustomNotFoundExaption extends BaseExaption {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
    /**
     * Конструктор
     * @param string
     */
	public CustomNotFoundExaption(String string) {
		super(string);
		this.setCodeExaption(1);
		this.setString(string);
	}

	
}
