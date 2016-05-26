import java.util.Random;

/**
 * Created by jorge on 24-05-16.
 */
public class InstanceCreator {

    private int n = (int) Math.pow(2, 20);
    private int[] alphabetSize = {2, 4, 8, 16, 32, 64, 128, 256};

    private char[][] alphabet = new char[8][];

    public InstanceCreator() {

        for (int i = 0; i < this.alphabetSize.length; i++) {
            this.alphabet[i] = new char[this.alphabetSize[i]];
            for (int j = 0; j < this.alphabetSize[i]; j++) {
                this.alphabet[i][j] = (char) (j + 300);
            }
        }
    }

    public char[][] getAlphabet() {
        return this.alphabet;
    }

    public int[] getAlphabetSize() {
        return this.alphabetSize;
    }

    public String alphabetToString(int exp) {
        String string = "";
        for (char character : this.alphabet[exp - 1]) {
            string = string + character;
        }
        return string;
    }

    public String generateInstance(int exp) {
        int step = n / alphabetSize[exp - 1];
        Random random = new Random();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % step == 0) {
                stringBuilder.append(alphabet[exp - 1][i / step]);
            }
            else {
                stringBuilder.append(alphabet[exp - 1][random.nextInt(alphabetSize[exp - 1])]);
            }
        }
        String instance = stringBuilder.toString();
        return instance;
    }
}
