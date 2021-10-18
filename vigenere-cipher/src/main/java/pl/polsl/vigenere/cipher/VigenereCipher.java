/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.vigenere.cipher;

/**
 *
 * @author Bartosz Dera
 */
public class VigenereCipher {
    public static void main(String[] args){
        VigenereModel test = new VigenereModel("h", "siema");
        test.encodeMessage();
    }
    
}
