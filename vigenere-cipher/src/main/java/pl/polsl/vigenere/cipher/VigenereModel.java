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
    
    public VigenereModel(String secretLetter, String textToCode){
        this.secretLetter=secretLetter.toUpperCase();
        this.textToCode=textToCode.toUpperCase();
    }
    
    private void createKey(){
        key = secretLetter + removeLastChar(textToCode);
    }
    
    public void encodeMessage(){  //does it have to be public?
        char[] charEncodedMessage = new char[textToCode.length()];
        //char[] charTextToCode=textToCode.toCharArray();
        //char[] charKey=key.toCharArray();
        
        char[][] cipherTable=new char[26][26];
        createCipherTable(cipherTable);
        
         for(int i = 0; i < encodedMessage.length(); i++) {
            charEncodedMessage[i] = cipherTable[textToCode.charAt(i)][key.charAt(i)]; // looking for wanted 'encoded' character
        }
        
        encodedMessage = charEncodedMessage.toString();
        System.out.println(encodedMessage);
    }
    
    public String getEncodedMessage(){
        return encodedMessage;
    }
    
    /** 
     * Method to remove last character
     */
    private String removeLastChar(String s){  
        return s.substring(0, s.length() - 1);  
    }
    
    /**
     * Initialize cipherTable with uppercase letters
     * @param cipherTable table to bo initialized
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