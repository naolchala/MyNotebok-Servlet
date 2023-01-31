/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

public class IncorrectPasswordException extends Exception {
	public IncorrectPasswordException() {
		super("Incorrect Password, try again!");
	}
}
