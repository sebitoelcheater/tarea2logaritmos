/**
 * Created by sebito on 26-05-16.
 */
public class WaveletLeaf implements WaveletNode {

    private char symbol;

    @Override
    public int rank(int b, int[] bitMap, int index) {
        return 0;
    }

    public void setSymbol(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
