import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jorge on 24-05-16.
 */
public class InstanceCreatorTest {

    InstanceCreator instanceCreator;
    String[] instances = new String[8];

    @Before
    public void setUp() throws Exception {
        instanceCreator = new InstanceCreator();
        instances[0] = instanceCreator.generateInstance(1);
        instances[1] = instanceCreator.generateInstance(2);
        instances[2] = instanceCreator.generateInstance(3);
        instances[3] = instanceCreator.generateInstance(4);
        instances[4] = instanceCreator.generateInstance(5);
        instances[5] = instanceCreator.generateInstance(6);
        instances[6] = instanceCreator.generateInstance(7);
        instances[7] = instanceCreator.generateInstance(8);
    }

    @Test
    public void testAlphabetToString() {
        assertTrue(instanceCreator.alphabetToString(1).equals("Ĭĭ"));
        assertTrue(instanceCreator.alphabetToString(4).equals("ĬĭĮįİıĲĳĴĵĶķĸĹĺĻ"));
        assertTrue(instanceCreator.alphabetToString(8).equals("ĬĭĮįİıĲĳĴĵĶķĸĹĺĻļĽľĿŀŁłŃńŅņŇňŉŊŋŌōŎŏŐőŒœŔŕŖŗŘřŚśŜŝŞşŠšŢţŤťŦŧŨũŪūŬŭŮůŰűŲųŴŵŶŷŸŹźŻżŽžſƀƁƂƃƄƅƆƇƈƉƊƋƌƍƎƏƐƑƒƓƔƕƖƗƘƙƚƛƜƝƞƟƠơƢƣƤƥƦƧƨƩƪƫƬƭƮƯưƱƲƳƴƵƶƷƸƹƺƻƼƽƾƿǀǁǂǃǄǅǆǇǈǉǊǋǌǍǎǏǐǑǒǓǔǕǖǗǘǙǚǛǜǝǞǟǠǡǢǣǤǥǦǧǨǩǪǫǬǭǮǯǰǱǲǳǴǵǶǷǸǹǺǻǼǽǾǿȀȁȂȃȄȅȆȇȈȉȊȋȌȍȎȏȐȑȒȓȔȕȖȗȘșȚțȜȝȞȟȠȡȢȣȤȥȦȧȨȩȪȫ"));
    }

    @Test
    public void testGenerateInstance() {
        for (int i = 0; i < 8; i++) {
            StringBuilder alphabet = new StringBuilder((int) Math.pow(2, i + 1));
            for (int j = 0; j < instances[i].length(); j++) {
                char c = instances[i].charAt(j);
                if (alphabet.indexOf(String.valueOf(c)) == -1)
                    alphabet.append(c);
            }
            assertFalse(alphabet.length() != (int) Math.pow(2, i + 1));
        }
    }
}