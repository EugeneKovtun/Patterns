package behavioral.strategy;

import java.util.Arrays;

/**
 * Created by eugene on 08.08.17.
 */
public class StrategyApp {
    public static void main(String[] args) {
        StrategyClient strategyClient = new StrategyClient();
        int[] arr0 = {1, 5, 3, 1, 5, 3};
        strategyClient.setStrategy(new InsertIntoSort());
        strategyClient.executeStrategy(arr0);
        System.out.println(Arrays.toString(arr0));

        int[] arr1 = {1, 5, 3, 1, 5, 3};
        strategyClient.setStrategy(new AnySort());
        strategyClient.executeStrategy(arr1);
        System.out.println(Arrays.toString(arr1));


    }
}

interface Sorting {
    void sort(int[] array);
}

class StrategyClient {
    Sorting strategy;

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] array) {
        strategy.sort(array);
    }
}

class InsertIntoSort implements Sorting {
    @Override
    public void sort(int[] array) {
        int temp, j;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                temp = array[i + 1];
                array[i + 1] = array[i];
                j = i;
                while (j > 0 && temp < array[j - 1]) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = temp;
            }
        }
    }
}

class AnySort implements Sorting {
    @Override
    public void sort(int[] array) {
        Arrays.sort(array);
    }
}