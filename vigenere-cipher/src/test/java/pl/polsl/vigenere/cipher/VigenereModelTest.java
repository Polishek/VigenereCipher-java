package pl.polsl.vigenere.cipher;

import java.util.stream.Stream;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pl.polsl.vigenere.cipher.exception.EmptyStringException;
import pl.polsl.vigenere.cipher.model.VigenereModel;


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
     * @param expectedValue String object with expected value of test result.
     * @param inputValue String object of parameter to tested method.
     */
    @ParameterizedTest
    @MethodSource
    public void shiftRightTest(String expectedValue, String inputValue) {
        assertEquals(expectedValue, theModel.shiftRight(inputValue), "shiftRight method wrongly executes with empty string parameter!");
        assertEquals("Thi si stes tstrin", theModel.shiftRight("This is test string"), "shiftRight method wrongly executes with correct parameter!");
        assertEquals("Thi si stes tstrin", theModel.shiftRight(" This is test string"), "shiftRight has problems with space in front of the string!");
        assertEquals("Thi si stes tstrin", theModel.shiftRight("This is test string "), "shiftRight has problems with space after the string!");
    }

    /**
     * Method testing secretLetter method from VigenereModel.
     */
    @ParameterizedTest
    @ValueSource(strings = {"nba", "_nba", " nba", "\" 5n5 " })
    public void setSecretLetterTest(String strings) {
        try {
            theModel.setSecretLetter(strings);
        } catch (EmptyStringException ex) {
            fail("Exception thrown!");
        }
        assertEquals("n", theModel.getSecretLetter());
    }

    /**
     * Method testing encodeMessage methode from VigenereModel.
     */
    @ParameterizedTest
    @ValueSource(strings = {"TAPA AA LXWL LLKZVT"})
    public void encodeMessageTest(String testString) {           //very complicated to test
        try{
            theModel.encodeMessage();
        }
        catch(EmptyStringException ex){
            fail("Exception error in encodeMessageText!");
        }

        assertEquals(testString, theModel.getEncodedMessage());
    }
    
    public static Stream<Arguments> shiftRightTest()
    {
        return Stream.of(Arguments.of("", ""), Arguments.of("Thi si stes tstrin", "This is test string"));
    }
}
