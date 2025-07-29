package com.algos.sort;

public class Practice {
    static int arr[] = {1, 5, 7, 9, 4, 9, 0, 30, 6};

    public static void main(String[] args) {
        Practice p = new Practice();
        // adjacent els
        p.bbSort();
        System.out.println(' ');

        // shifting
        p.insSort();
        System.out.println(' ');

        // true minimum
        p.selSort();
        System.out.println(' ');

        // pi and recursive sort
        p.quickSort(arr, 0, arr.length - 1);

    }

    // Trick: Compare adjacent elements
    void bbSort() {
        for (int i = 0; i < arr.length; i++) {
            boolean flg = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flg = true;
                }
            }

            if (!flg)
                break;

        }

        // display
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k]);
        }
    }

    // compare to all elements left to current element
    void insSort() {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while (j > 0 && arr[i] < arr[j]) {
                arr[j + 1] = arr[j]; // shift all els
                j--;
            }

            arr[j + 1] = arr[i]; // assign el to correct index

        }

        // display
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k]);
        }
    }

    // compare to all elements right to current element
    void selSort() {
        for (int i = 0; i < arr.length; i++) {
            int temp_min_idx = i;
            int true_min_idx = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    true_min_idx = j;
                }
            }

            int temp = arr[temp_min_idx];
            arr[temp_min_idx] = arr[true_min_idx];
            arr[true_min_idx] = temp;
        }

        // display
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k]);
        }
    }

    void quickSort(int[] arr, int begin, int end) {
        while (begin < end) {
            int pi = partition(arr, begin, end);

            quickSort(arr, begin, pi - 1);
            quickSort(arr, pi + 1, end);
        }
    }

    private int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = begin - 1;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        return i + 1;
    }
}
