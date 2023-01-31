/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author naol
 */
public class EmailTakenException extends Exception {
	public EmailTakenException() {
		super("Email already taken, try to login");
	}
}
