/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.vigenere.cipher;

/**
 *
 * @author Bartosz Dera
 */
public class VigenereModel {
    private String encodedMessage;
    private String key;    
    private String secretLetter;
    private String textToCode;
    
    /**
     * Constructor of VigenereModel
     * @param secretLetter Letter given by user to be first in the encoded message
     * @param textToCode String to be encoded
     */
    public VigenereModel(String secretLetter, String textToCode){
        this.secretLetter=secretLetter.toUpperCase();
        this.textToCode=textToCode.toUpperCase();
    }
    
    /**
     * Method for creating key used to encode message.
     */
    private void createKey(){
        key = secretLetter + removeLastChar(textToCode);
    }
    
    /**
     * Method responsible for encoding given message
     */
    public void encodeMessage(){  //does it have to be public?
        char[] charEncodedMessage = new char[textToCode.length()];
        
        char[][] cipherTable=new char[26][26];
        createCipherTable(cipherTable);
        
         for(int i = 0; i < textToCode.length(); i++) {
            charEncodedMessage[i] = cipherTable[textToCode.charAt(i)][key.charAt(i)]; // ERROR: not sure why, maybe char[]=char[][] ? or indexes of cipherTable
        }
        
        //encodedMessage = charEncodedMessage.toString();
        System.out.println(encodedMessage);
    }
    
    /**
     * Get the atribute encodedMessage
     * @return Encoded message
     */
    public String getEncodedMessage(){
        return encodedMessage;
    }
    
    /** 
     * Method to remove last character from given String
     * @param s String to have last character removed
     * @return substring os String without last character
     */
    private String removeLastChar(String s){  
        return s.substring(0, s.length() - 1);  
    }
    
    /**
     * Initialize cipherTable with uppercase letters
     * @param cipherTable Table to bo initialized
     */
    private void createCipherTable(char[][] cipherTable){
        int temp;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                cipherTable[i][j]=(char)(65 + ((i+j)%26));
            }
        }
    }
}