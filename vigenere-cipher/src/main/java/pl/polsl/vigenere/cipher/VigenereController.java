/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.vigenere.cipher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Bartosz Dera
 */
public class VigenereController {
    
    private final VigenereModel theModel;
    
    private final VigenereView theView;
    
//    private String[] args = null;
            
    public VigenereController(VigenereModel theModel, VigenereView theView, String[] args){
        this.theModel=theModel;
        this.theView=theView;
        
        if(args.length != 0){
//            this.args=args;
            theModel.setParamFromCommandLine(args);
            theView.setTextToCode(theModel.getTextToCode());
            theView.setSecretLetter(theModel.getSecretLetter());
        }
        
        this.theView.addEncodeListener(new EncodeListener());
    }
    
    class EncodeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            try{
            theModel.setTextToCode(theView.getTextToCode());
            theModel.setSecretLetter(theView.getSecretLetter());          
            theModel.encodeMessage();
            }
            catch(EmptyStringException e){
                theView.displayErrorMessage("Wartosci wiadomosci oraz klucza nie moga byc puste!");
            }
            
            theView.setEncodedMessage(theModel.getEncodedMessage());
        }
    }
}
