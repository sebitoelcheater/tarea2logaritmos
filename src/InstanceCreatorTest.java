import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jorge on 24-05-16.
 */
public class InstanceCreatorTest {

    InstanceCreator instanceCreator;
    String instance_2;
    String instance_4;
    String instance_8;
    String instance_16;
    String instance_32;
    String instance_64;
    String instance_128;
    String instance_256;

    @Before
    public void setUp() throws Exception {
        instanceCreator = new InstanceCreator();
        instance_2 = instanceCreator.generateInstance(1);
        instance_4 = instanceCreator.generateInstance(2);
        instance_8 = instanceCreator.generateInstance(3);
        instance_16 = instanceCreator.generateInstance(4);
        instance_32 = instanceCreator.generateInstance(5);
        instance_64 = instanceCreator.generateInstance(6);
        instance_128 = instanceCreator.generateInstance(7);
        instance_256 = instanceCreator.generateInstance(8);
    }

    @Test
    public void testGetAlphabet() {
        //assertTrue(instanceCreator.getAlphabet()[0].equals("Ĭĭ"));
        //assertTrue(instanceCreator.getAlphabet()[3].equals("ĬĭĮįİıĲĳĴĵĶķĸĹĺĻ"));
        //assertTrue(instanceCreator.getAlphabet()[7].equals("ĬĭĮįİıĲĳĴĵĶķĸĹĺĻļĽľĿŀŁłŃńŅņŇňŉŊŋŌōŎŏŐőŒœŔŕŖŗŘřŚśŜŝŞşŠšŢţŤťŦŧŨũŪūŬŭŮůŰűŲųŴŵŶŷŸŹźŻżŽžſƀƁƂƃƄƅƆƇƈƉƊƋƌƍƎƏƐƑƒƓƔƕƖƗƘƙƚƛƜƝƞƟƠơƢƣƤƥƦƧƨƩƪƫƬƭƮƯưƱƲƳƴƵƶƷƸƹƺƻƼƽƾƿǀǁǂǃǄǅǆǇǈǉǊǋǌǍǎǏǐǑǒǓǔǕǖǗǘǙǚǛǜǝǞǟǠǡǢǣǤǥǦǧǨǩǪǫǬǭǮǯǰǱǲǳǴǵǶǷǸǹǺǻǼǽǾǿȀȁȂȃȄȅȆȇȈȉȊȋȌȍȎȏȐȑȒȓȔȕȖȗȘșȚțȜȝȞȟȠȡȢȣȤȥȦȧȨȩȪȫ"));
    }
}