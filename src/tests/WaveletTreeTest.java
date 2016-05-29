package tests;

import main.WaveletLeaf;
import main.WaveletTree;
import org.junit.Assert;
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

        Assert.assertEquals(0, waveletTree.rank(0, 0));
        Assert.assertEquals(1, waveletTree.rank(0, 1));
        Assert.assertEquals(2, waveletTree.rank(0, 2));
        Assert.assertEquals(3, waveletTree.rank(0, 3));
        Assert.assertEquals(3, waveletTree.rank(0, 4));

        Assert.assertEquals(1, waveletTree.rank(1, 0));
        Assert.assertEquals(1, waveletTree.rank(1, 1));
        Assert.assertEquals(1, waveletTree.rank(1, 2));
        Assert.assertEquals(1, waveletTree.rank(1, 3));
        Assert.assertEquals(2, waveletTree.rank(1, 4));

        Assert.assertEquals(0, waveletTree.getLeftChild().rank(0, 0));
        Assert.assertEquals(1, waveletTree.getLeftChild().rank(0, 1));
        Assert.assertEquals(1, waveletTree.getLeftChild().rank(0, 2));

        Assert.assertEquals(1, waveletTree.getLeftChild().rank(1, 0));
        Assert.assertEquals(1, waveletTree.getLeftChild().rank(1, 1));
        Assert.assertEquals(2, waveletTree.getLeftChild().rank(1, 2));

        // char
        Assert.assertEquals(0, waveletTree.rank('m', 0));
        Assert.assertEquals(0, waveletTree.rank('m', 1));
        Assert.assertEquals(1, waveletTree.rank('m', 2));
        Assert.assertEquals(1, waveletTree.rank('m', 3));
        Assert.assertEquals(1, waveletTree.rank('m', 4));

        Assert.assertEquals(0, waveletTree.rank('o', 0));
        Assert.assertEquals(1, waveletTree.rank('o', 1));
        Assert.assertEquals(1, waveletTree.rank('o', 2));
        Assert.assertEquals(2, waveletTree.rank('o', 3));
        Assert.assertEquals(2, waveletTree.rank('o', 4));

        Assert.assertEquals(1, waveletTree.rank('s', 0));
        Assert.assertEquals(1, waveletTree.rank('s', 1));
        Assert.assertEquals(1, waveletTree.rank('s', 2));
        Assert.assertEquals(1, waveletTree.rank('s', 3));
        Assert.assertEquals(2, waveletTree.rank('s', 4));

    }

    @Test
    public void getTag() throws Exception {
        char[] chars1 = {'a', 'b', 'c'};

        Assert.assertEquals(0, WaveletTree.getTag(chars1, 'a'));
        Assert.assertEquals(0, WaveletTree.getTag(chars1, 'b'));
        Assert.assertEquals(1, WaveletTree.getTag(chars1, 'c'));

        char[] chars2 = {'a', 'b', 'c', 'd'};

        Assert.assertEquals(0, WaveletTree.getTag(chars2, 'a'));
        Assert.assertEquals(0, WaveletTree.getTag(chars2, 'b'));
        Assert.assertEquals(1, WaveletTree.getTag(chars2, 'c'));
        Assert.assertEquals(1, WaveletTree.getTag(chars2, 'd'));

        char[] chars3 = {'a', 'b', 'c', 'd', 'x', 'y', 'z'};

        Assert.assertEquals(0, WaveletTree.getTag(chars3, 'a'));
        Assert.assertEquals(0, WaveletTree.getTag(chars3, 'b'));
        Assert.assertEquals(0, WaveletTree.getTag(chars3, 'c'));
        Assert.assertEquals(0, WaveletTree.getTag(chars3, 'd'));
        Assert.assertEquals(1, WaveletTree.getTag(chars3, 'x'));
        Assert.assertEquals(1, WaveletTree.getTag(chars3, 'y'));
        Assert.assertEquals(1, WaveletTree.getTag(chars3, 'z'));

    }

    @Test
    public void toWaveletTree() throws Exception{
        WaveletTree waveletTree = (WaveletTree) WaveletTree.toWaveletTree("somos");

        Assert.assertEquals('m', ((WaveletLeaf) ((WaveletTree) waveletTree.getLeftChild()).getLeftChild()).getSymbol());
        Assert.assertEquals('o', ((WaveletLeaf) ((WaveletTree) waveletTree.getLeftChild()).getRightChild()).getSymbol());
        Assert.assertEquals('s', ((WaveletLeaf) waveletTree.getRightChild()).getSymbol());

        int[] expectedBitmap = {1,0,0,0,1};
        Assert.assertArrayEquals(expectedBitmap, waveletTree.getBitmap());

        int[] expectedBitmap1 = {1,0,1};
        Assert.assertArrayEquals(expectedBitmap1, ((WaveletTree) waveletTree.getLeftChild()).getBitmap());
    }

    @Test
    public void range() throws Exception{
        WaveletTree waveletTree1 = (WaveletTree) WaveletTree.toWaveletTree("somos o no somos");

        assertEquals(13, waveletTree1.range('a', 'z', 0, 16));
        assertEquals(7, waveletTree1.range('n', 'o', 0, 16));
        assertEquals(7, waveletTree1.range('n', 'o', 0, 16));
        assertEquals(6, waveletTree1.range('a', 'z', 3, 12));
        assertEquals(4, waveletTree1.range('n', 'o', 3, 12));

        WaveletTree waveletTree2 = (WaveletTree) WaveletTree.toWaveletTree("111121111211112111121111211112111121111");
        assertEquals(1, waveletTree2.range('2', '2', 4, 10));
        assertEquals(1, waveletTree2.range('2', '2', 9, 15));
        assertEquals(1, waveletTree2.range('2', '2', 14, 20));
        assertEquals(3, waveletTree2.range('2', '2', 4, 20));

    }

}