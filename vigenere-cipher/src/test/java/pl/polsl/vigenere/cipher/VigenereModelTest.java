package pl.polsl.vigenere.cipher;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class VigenereModelTest {

    private VigenereModel theModel;

    @BeforeEach
    public void setUp() {
        theModel = new VigenereModel();
    }

    @Test
    public void shiftRightTest() {
        assertEquals("", theModel.shiftRight(""), "shiftRight method wrongly executes with empty string parameter!");
        assertEquals("ab", theModel.shiftRight("abc"), "shiftRight method wrongly executes with correct parameter!");
        assertEquals("Thi si stes tstrin", theModel.shiftRight("This is test string"));
        assertEquals("Thi si stes tstrin", theModel.shiftRight(" This is test string"));    //TODO: Method wrongly ecxecutes when there is space as a first character.
        assertEquals("Thi si stes tstrin", theModel.shiftRight("This is test string "));
    }

    @Test
    public void setSecretLetterTest() {
        try {
            theModel.setSecretLetter("nba");
        } catch (EmptyStringException ex) {
            fail("Exception thrown!");
        }
        assertEquals("n", theModel.getSecretLetter(), "cos sie popsulo");

        try {
            theModel.setSecretLetter("_nba");
        } catch (EmptyStringException ex) {
            fail("Exception thrown!");
        }
        assertEquals("n", theModel.getSecretLetter(), "cos sie popsulo");
    }

    @Test
    public void encodeMessageTest() {

    }

}
