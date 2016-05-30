package main;

import java.util.Random;

/**
 * Created by jorge on 24-05-16.
 */
public class Main {
    public static void main(String[] args) {
        InstanceCreator instanceCreator = new InstanceCreator();

        String[] stringInstances = new String[8];
        WaveletNode[] treeInstances = new WaveletTree[8];
        long[] sumRank = new long[8];
        long[] sumRange = new long[8];

        int n = (int) Math.pow(2, 20);
        int m = 10 * n;

        for (int k = 0; k < 8; k++) {
            stringInstances[k] = instanceCreator.generateInstance(k + 1);
            treeInstances[k] = WaveletTree.toWaveletTree(stringInstances[k]);

            for (int l = 0; l < m; l++) {
                Random random = new Random();
                int size = instanceCreator.getAlphabetSize()[k];

                char c = instanceCreator.alphabetToString(k + 1).charAt(random.nextInt(size));
                int i = random.nextInt(size);
                int j = random.nextInt(size);
                char x = instanceCreator.alphabetToString(k + 1).charAt(random.nextInt(size));
                char y = instanceCreator.alphabetToString(k + 1).charAt(random.nextInt(size));

                long startRank = System.nanoTime();
                treeInstances[k].rank(c, i);
                sumRank[k] += System.nanoTime() - startRank;

                long startRange = System.nanoTime();
                treeInstances[k].range(x, y, i, j);
                sumRange[k] += System.nanoTime() - startRange;
            }

            long avgRank = sumRank[k]/m;
            long avgRange = sumRange[k]/m;
            System.out.println("Rank average time when alphabet size = 2^" + String.valueOf(k + 1) + ": " + String.valueOf(avgRank) + "ns.");
            System.out.println("Range average time when alphabet size = 2^" + String.valueOf(k + 1) + ": " + String.valueOf(avgRange) + "ns.");
        }
    }
}
