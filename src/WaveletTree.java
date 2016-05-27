import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorge on 21-05-16.
 */
public class WaveletTree implements WaveletNode {

    // Bit map for this tree's root
    private int[] bitmap;

    // Child references
    private WaveletNode leftChild;
    private WaveletNode rightChild;

    // Constructor
    private WaveletTree(){

    }

    // Rank function
    public int rank(int b, int[] bitMap, int index) {
        int counter = 0;
        for (int i = 0; i <= index; i++) {
            if (bitMap[i] == b)
                counter++;
        }
        return counter;
    }

    public int rankSymbol(WaveletTree root, Character c, String sequence, int index) {
        //
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

    public static WaveletNode toWaveletTree(String s){
        char[] chars = MyUtils.getCharacters(s);

        if(chars.length == 1) {
            WaveletLeaf waveletLeaf = new WaveletLeaf();
            waveletLeaf.setSymbol(chars[0]);
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

}
