package main;

/**
 * Created by sebito on 26-05-16.
 */
public class WaveletLeaf implements WaveletNode {

    private char symbol;

    private int length;

    public void setSymbol(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int lenght) {
        this.length = lenght;
    }

    @Override
    public int rank(int i, int index) {
        return Math.min(index+1, length);
    }

    @Override
    public int rank(char c, int index) {
        return 0;
    }
}
