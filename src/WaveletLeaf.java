/**
 * Created by sebito on 26-05-16.
 */
public class WaveletLeaf implements WaveletNode {

    private char symbol;

    private int lenght;

    public void setSymbol(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    @Override
    public int rank(int i, int index) {
        return Math.min(index+1, lenght);
    }

    @Override
    public int rank(char c, int index) {
        return 0;
    }
}
