/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.vigenere.cipher;

/**
 *
 * @author Bartosz Dera
 */
public class VigenereController {
    
    private VigenereModel theModel;
    
    private VigenereView theView;
    
    private String[] args;
    
    public VigenereController(VigenereModel theModel, VigenereView theView, String[] args){
        this.theModel=theModel;
        this.theView=theView;
        this.args=args;
    }
}
