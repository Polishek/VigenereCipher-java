/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.vigenere.cipher;

/**
 *
 * @author Bartosz Dera
 */
public class EmptyStringException extends Exception{
    
    public EmptyStringException(){
    }
    
    public EmptyStringException(String message){
        super(message);
    }
}
