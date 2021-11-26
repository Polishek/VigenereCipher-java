package pl.polsl.test;

import pl.polsl.vigenere.cipher.VigenereModel;

public class vigenereModelTests {
    private VigenereModel theModel;

    public void shiftRightTest() {
        assertEquals(theModel.shiftRight(""), "");
    }

}
