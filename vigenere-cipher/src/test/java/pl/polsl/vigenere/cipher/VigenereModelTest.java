package pl.polsl.vigenere.cipher;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class VigenereModelTest {

    private VigenereModel theModel;

    /**
     * Method initializing VigenereModel before each class.
     */
    @BeforeEach
    public void setUp() {
        theModel = new VigenereModel("a", "This is test string");
    }

    /**
     * Method testing shiftRight method from VigenereModel.
     */
    @Test
    public void shiftRightTest() {
        assertEquals("", theModel.shiftRight(""), "shiftRight method wrongly executes with empty string parameter!");
        assertEquals("Thi si stes tstrin", theModel.shiftRight("This is test string"), "shiftRight method wrongly executes with correct parameter!");
        assertEquals("Thi si stes tstrin", theModel.shiftRight(" This is test string"), "shiftRight has problems with space in front of the string!");
        assertEquals("Thi si stes tstrin", theModel.shiftRight("This is test string "), "shiftRight has problems with space after the string!");
    }

    /**
     * Method testing secretLetter method from VigenereModel.
     */
    @Test
    public void setSecretLetterTest() {
        try {
            theModel.setSecretLetter("nba");
        } catch (EmptyStringException ex) {
            fail("Exception thrown!");
        }
        assertEquals("n", theModel.getSecretLetter());

        try {
            theModel.setSecretLetter("_nba");
        } catch (EmptyStringException ex) {
            fail("Exception thrown!");
        }
        assertEquals("n", theModel.getSecretLetter());
    }

    /**
     * Method testing encodeMessage methode from VigenereModel.
     */
    @Test
    public void encodeMessageTest() {           //very complicated to test
        try{
            theModel.encodeMessage();
        }
        catch(EmptyStringException ex){
            fail("Exception error in encodeMessageText!");
        }

        assertEquals("TAPA AA LXWL LLKZVT", theModel.getEncodedMessage());
    }
}
