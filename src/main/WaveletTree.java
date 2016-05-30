package main;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jorge on 21-05-16.
 */
public class WaveletTree implements WaveletNode {

    // Bit map for this tree's root
    private int[] bitmap;

    private char[] alphabet;

    // Child references
    private WaveletNode leftChild;
    private WaveletNode rightChild;

    // Constructor
    private WaveletTree(){}

    // Rank function
    public int rank(int b, int index) {
        int counter = 0;
        index = Math.min(bitmap.length-1, index);
        for (int i = 0; i <= index; i++) {
            if (bitmap[i] == b)
                counter++;
        }
        return counter;
    }

    public int rank(char b, int index) {
        int tag = getTag(alphabet, b);
        int rank = rank(tag, index);
        if(tag == 0)
            return leftChild.rank(b, rank-1);
        else
            return rightChild.rank(b, rank-1);
    }


    // Range function
    public int range(char x, char y, int i, int j) {
        // exception handling
        j = Math.min(j, bitmap.length);
        if(y < x || j <= i || i >= bitmap.length || y < alphabet[0] || x > alphabet[alphabet.length-1])
            return 0;
        else if (x <= alphabet[0] && y >= alphabet[alphabet.length-1])
            return j - i;
        else if (x <= alphabet[0] && y < alphabet[alphabet.length-1] || x > alphabet[0] || y >= alphabet[alphabet.length-1]) {
            if (j == bitmap.length)
                return getLeftChild().range(x, y, rank(0, i)-1, rank(0, j)) + getRightChild().range(x, y, rank(1, i)-1, rank(1, j));
            else {
                return getLeftChild().range(x, y, rank(0, i) - 1, rank(0, j) - 1) + getRightChild().range(x, y, rank(1, i) - 1, rank(1, j) - 1);
            }
        } else
            return 0;
    }


    // Getters and setters
    public int[] getBitmap() {
        return this.bitmap;
    }

    public void setBitmap (int[] bitmap) {
        this.bitmap = bitmap;
    }

    public WaveletNode getLeftChild() {
        return this.leftChild;
    }

    public WaveletNode getRightChild() {
        return this.rightChild;
    }

    public void setLeftChild(WaveletNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(WaveletNode rightChild) {
        this.rightChild = rightChild;
    }

    public char[] getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public static WaveletNode toWaveletTree(String s){
        char[] chars = MyUtils.getCharacters(s);

        if(chars.length == 1) {
            WaveletLeaf waveletLeaf = new WaveletLeaf();
            waveletLeaf.setSymbol(chars[0]);
            waveletLeaf.setLength(s.length());
            return waveletLeaf;
        } else if(chars.length > 1) {
            WaveletTree waveletTree = new WaveletTree();
            StringBuilder sbLeft = new StringBuilder();
            StringBuilder sbRight = new StringBuilder();
            ArrayList<Integer> bitmap = new ArrayList<Integer>();


            char currentChar;
            for (int i = 0; i < s.length(); i++){
                currentChar = s.charAt(i);
                if(getTag(chars, currentChar) == 0) {
                    sbLeft.append(currentChar);
                    bitmap.add(0);
                } else {
                    sbRight.append(currentChar);
                    bitmap.add(1);
                }
            }

            waveletTree.bitmap = new int[bitmap.size()];
            waveletTree.alphabet = chars;
            for(int i = 0; i < bitmap.size(); i++) waveletTree.bitmap[i] = bitmap.get(i);
            waveletTree.setLeftChild(toWaveletTree(sbLeft.toString()));
            waveletTree.setRightChild(toWaveletTree(sbRight.toString()));

            return waveletTree;
        } else {
            return null;
        }
    }

    public static int getTag(char[] chars, char myChar){
        if((new String(chars).indexOf(myChar)+1) <= (1+chars.length)/2)
            return 0;
        else
            return 1;
    }

//    public char sub(int index){
//        if(this.bitmap[index] == 0){
//
//        }
//    }

}
