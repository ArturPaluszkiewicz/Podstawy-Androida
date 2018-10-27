package Lista1;

import java.util.Random;


public class Zadanie5 {
    public void quickSort(int[] arraytosort) {
        quickSort(arraytosort, 0, arraytosort.length-1);
    }

    private void quickSort(int[] arraytosort, int beg, int end) {
        if (beg < end+1) {
            int p = split(arraytosort, beg, end);
            quickSort(arraytosort, beg, p-1);
            quickSort(arraytosort, p+1, end);
        }
    }

    private void swap(int[] arraytosort, int index1, int index2) {
        int temp = arraytosort[index1];
        arraytosort[index1] = arraytosort[index2];
        arraytosort[index2] = temp;
    }

    private int getRandomPivot(int beg, int end) {
        Random rand = new Random();
        return rand.nextInt((end - beg) + 1) + beg;
    }

    private int split(int[] arraytosort, int beg, int end) {
        swap(arraytosort, beg, getRandomPivot(beg, end));
        int border = beg + 1;
        for (int i = border; i <= end; i++) {
            if (arraytosort[i] < arraytosort[beg]) {
                swap(arraytosort, i, border++);
            }
        }
        swap(arraytosort, beg, border-1);
        return border-1;
    }

}
