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
    
    private VigenereModel theModel;
    
    private VigenereView theView;
    
    private String[] args = null;
            
    public VigenereController(VigenereModel theModel, VigenereView theView, String[] args){
        this.theModel=theModel;
        this.theView=theView;
        
        if(args.length != 0){
            this.args=args;
            theModel.setParamFromCommandLine(args);
        }
        
        // Can I insert method to manage args array, that will send it to proper attributes on VigenereModel?
        this.theView.addEncodeListener(new EncodeListener());
    }
    
    class EncodeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            theModel.setTextToCode(theView.getTextToCode());
            theModel.setSecretLetter(theView.getSecretLetter());
            
            theModel.encodeMessage();
            theView.setEncodedMessage(theModel.getEncodedMessage());
        }
    }
    
    
}
