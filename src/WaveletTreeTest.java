import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jorge on 24-05-16.
 */
public class WaveletTreeTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void rank() throws Exception {
        // int 0 and 1
        WaveletTree waveletTree = (WaveletTree) WaveletTree.toWaveletTree("somos");

        assertEquals(0, waveletTree.rank(0, 0));
        assertEquals(1, waveletTree.rank(0, 1));
        assertEquals(2, waveletTree.rank(0, 2));
        assertEquals(3, waveletTree.rank(0, 3));
        assertEquals(3, waveletTree.rank(0, 4));

        assertEquals(1, waveletTree.rank(1, 0));
        assertEquals(1, waveletTree.rank(1, 1));
        assertEquals(1, waveletTree.rank(1, 2));
        assertEquals(1, waveletTree.rank(1, 3));
        assertEquals(2, waveletTree.rank(1, 4));

        assertEquals(0, waveletTree.getLeftChild().rank(0, 0));
        assertEquals(1, waveletTree.getLeftChild().rank(0, 1));
        assertEquals(1, waveletTree.getLeftChild().rank(0, 2));

        assertEquals(1, waveletTree.getLeftChild().rank(1, 0));
        assertEquals(1, waveletTree.getLeftChild().rank(1, 1));
        assertEquals(2, waveletTree.getLeftChild().rank(1, 2));

    }

    @Test
    public void getTag() throws Exception {
        char[] chars1 = {'a', 'b', 'c'};

        assertEquals(0, WaveletTree.getTag(chars1, 'a'));
        assertEquals(0, WaveletTree.getTag(chars1, 'b'));
        assertEquals(1, WaveletTree.getTag(chars1, 'c'));

        char[] chars2 = {'a', 'b', 'c', 'd'};

        assertEquals(0, WaveletTree.getTag(chars2, 'a'));
        assertEquals(0, WaveletTree.getTag(chars2, 'b'));
        assertEquals(1, WaveletTree.getTag(chars2, 'c'));
        assertEquals(1, WaveletTree.getTag(chars2, 'd'));

        char[] chars3 = {'a', 'b', 'c', 'd', 'x', 'y', 'z'};

        assertEquals(0, WaveletTree.getTag(chars3, 'a'));
        assertEquals(0, WaveletTree.getTag(chars3, 'b'));
        assertEquals(0, WaveletTree.getTag(chars3, 'c'));
        assertEquals(0, WaveletTree.getTag(chars3, 'd'));
        assertEquals(1, WaveletTree.getTag(chars3, 'x'));
        assertEquals(1, WaveletTree.getTag(chars3, 'y'));
        assertEquals(1, WaveletTree.getTag(chars3, 'z'));

    }

    @Test
    public void toWaveletTree() throws Exception{
        WaveletTree waveletTree = (WaveletTree) WaveletTree.toWaveletTree("somos");

        assertEquals('m', ((WaveletLeaf) ((WaveletTree) waveletTree.getLeftChild()).getLeftChild()).getSymbol());
        assertEquals('o', ((WaveletLeaf) ((WaveletTree) waveletTree.getLeftChild()).getRightChild()).getSymbol());
        assertEquals('s', ((WaveletLeaf) waveletTree.getRightChild()).getSymbol());

        int[] expectedBitmap = {1,0,0,0,1};
        assertArrayEquals(expectedBitmap, waveletTree.getBitmap());

        int[] expectedBitmap1 = {1,0,1};
        assertArrayEquals(expectedBitmap1, ((WaveletTree) waveletTree.getLeftChild()).getBitmap());
    }

}