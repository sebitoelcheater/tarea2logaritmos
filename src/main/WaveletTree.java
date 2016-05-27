package main;

import java.util.ArrayList;

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
        for (int i = 0; i <= index; i++) {
            if (bitmap[i] == b)
                counter++;
        }
        return counter;
    }

    public int rank(char b, int index) {
        int tag = getTag(alphabet, b);
        if(tag == 0){
            return leftChild.rank(0, );
        }
        int counter = 0;

        for (int i = 0; i <= index; i++) {
            if (bitmap[i] == b)
                counter++;
        }
        return counter;
    }

    /*
Finalmente queremos implementar la operación range[x,y](S, i, j), que cuenta la cantidad de elementos con valores entre x e y entre las posiciones i y j. Para ellos, usaremos la siguiente estrategia recursiva
1. Si [x, y] es disjunto al subrango que representa vraíz, entonces la respuesta es 0.
2. Si [x, y] contiene al subrango que representa vraíz, entonces la respuesta es j − i + 1.
3. Si [x,y] intersecta pero no contiene al subrango representado por vraíz, entonces la respuesta es la suma de las consultas a ambos hijos.
*/
    // Range function
    public int range(char x, char y, int i, int j) {
        int indexX = this.alphabet.toString().indexOf(x);
        int indexY = this.alphabet.toString().lastIndexOf(y);

        if ((i > j)) {
            return 0;
        }
        else if () {
            return j - i + 1;
        }
        else { }
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
