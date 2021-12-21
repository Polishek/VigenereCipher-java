/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.vigenereCipher;

import pl.polsl.vigenereCipher.view.VigenereView;
import pl.polsl.vigenereCipher.model.VigenereModel;
import pl.polsl.vigenereCipher.controller.VigenereController;

/**
 * @author Bartosz Dera
 * @version 2.0
 */
public class VigenereCipher {
    public static void main(String[] args){
        
        VigenereModel theModel = new VigenereModel();
        VigenereView theView = new VigenereView();

        VigenereController theController = new VigenereController(theModel, theView, args);
        
        theView.setVisible(true);
    }
    
}
