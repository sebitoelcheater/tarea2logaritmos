/**
 * Created by jorge on 21-05-16.
 */
public class WaveletTree implements WaveletNode {

    // Bit map for this tree's root
    private int[] bitMap;

    // Child references
    private WaveletNode leftChild;
    private WaveletNode rightChild;

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
        return this.bitMap;
    }

    public void setBitmap (int[] bitmap) {
        this.bitMap = bitmap;
    }

    public WaveletNode getLeftChild() {
        return this.leftChild;
    }

    public WaveletNode getRightChild() {
        return this.rightChild;
    }

    public void setLeftChild(WaveletTree leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(WaveletTree rightChild) {
        this.rightChild = rightChild;
    }

}
