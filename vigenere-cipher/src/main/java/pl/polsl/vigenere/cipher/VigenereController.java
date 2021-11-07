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
//            this.args=args;
            theModel.setParamFromCommandLine(args);      //Why did it work before pull request?
            theView.setTextToCode(theModel.getTextToCode());
            theView.setSecretLetter(theModel.getSecretLetter());
        }
        
        //this.theView.addEncodeListener(new EncodeListener());        
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
    
//    /**
//     * Class implementing EncodeListener object
//     */
//    class EncodeListener implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent evt){
//           try{
//            theModel.setTextToCode(theView.getTextToCode());
//            theModel.setSecretLetter(theView.getSecretLetter());          
//            theModel.encodeMessage();
//            }
//            catch(EmptyStringException e){
//                theView.displayErrorMessage(e.getMessage());
//            }
//            
//            theView.setEncodedMessage(theModel.getEncodedMessage());
//        }
//    }
}
