/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.vigenere.cipher.controller;

import pl.polsl.vigenere.cipher.exception.EmptyStringException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import pl.polsl.vigenere.cipher.model.VigenereModel;
import pl.polsl.vigenere.cipher.view.VigenereView;

/**
 * @author Bartosz Dera
 */
public class VigenereController {
    
    /**
     * Object of VigenereModel
     */
    private final VigenereModel theModel;
    
    /**
     * Object of VigenereView
     */
    private final VigenereView theView;
    
//    private String[] args = null;
    /**
     * Constructor of VigenereController
     * @param theModel Object of VigenereModel
     * @param theView Object of VigenereView
     * @param args Array of String objects from command line
     */      
    public VigenereController(VigenereModel theModel, VigenereView theView, String[] args){
        this.theModel=theModel;
        this.theView=theView;
        
        if(args.length != 0){
            setParamFromCommandLine(args);
            theView.setTextToCode(theModel.getTextToCode());
            theView.setSecretLetter(theModel.getSecretLetter());
        }

        this.theView.addEncodeListener(evt -> {
            try{
            theModel.setTextToCode(theView.getTextToCode());
            theModel.setSecretLetter(theView.getSecretLetter());
            theModel.encodeMessage();
            }
            catch(EmptyStringException e){
                theView.displayErrorMessage(e.getMessage());
            }
            
            theView.setEncodedMessage(theModel.getEncodedMessage());
        });
    }
    
    /**
     * Method analyzing parameters and executed when given in command line.
     * @param args Command line
     */
    public void setParamFromCommandLine(String[] args){
        for (int i = 0; i < args.length; i++) {
            if(args[i].equalsIgnoreCase("-key")){
                try{
                    theModel.setSecretLetter(args[i+1]);
                }
                catch(EmptyStringException ex){
                    theView.displayErrorMessage(ex.getMessage());
                }
            }
            else if(args[i].equalsIgnoreCase("-message")){
                    String[] temp = Arrays.copyOfRange(args, i+1, args.length);
                    
                theModel.setTextToCode(readTextToCode(temp));
                }
        }
    }
    
     /**
     * Method reading whole textToCode string from command line
     * @param temp Array of Strings to be analyzed
     * @return textToCode
     */
    private String readTextToCode(String[] temp){
        int i = 0;
        String result = ""; //is initialization needed?
        while(i < temp.length){
            if(temp[i].charAt(0) == '-'){
                break;
            }
            result = result.concat(temp[i]+' ');
            i++;
        }
        
        return result;
    }
}
