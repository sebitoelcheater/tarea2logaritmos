import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sebito on 26-05-16.
 */
public class MyUtilsTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetCharacters() throws Exception {
        String myString1 = "alabar_a_la_alabarda";
        char[] expected1 = {'_', 'a', 'b', 'd', 'l', 'r'};

        assertArrayEquals(expected1, MyUtils.getCharacters(myString1));

        String myString2 = "";
        char[] expected2 = {};

        assertArrayEquals(expected2, MyUtils.getCharacters(myString2));

        String myString3 = "anita lava la tina";
        char[] expected3 = {' ', 'a', 'i', 'l', 'n', 't', 'v'};

        assertArrayEquals(expected3, MyUtils.getCharacters(myString3));

        String myString4 = "Jorgé lava la tina";
        char[] expected4 = {' ', 'J', 'a', 'g', 'i', 'l', 'n', 'o', 'r', 't', 'v', 'é'};

        assertArrayEquals(expected4, MyUtils.getCharacters(myString4));
    }
}