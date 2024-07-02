package ex8;

public class QuickSort implements Sortable{
    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length-1);
    }

    private void quickSort(int[] array, int a, int b) {
        if (a < b) {
            int i = partition(array, a, b);
            quickSort(array, a, i-1);
            quickSort(array, i+1, b);
        }
    }

    private int partition(int[] array, int a, int b) {
        int x = array[a];
        while (a < b) {
            while (array[a] < x) {
                a++;
            }
            while (array[b] > x) {
                b--;
            }
            swap(array, a, b);
        }
        return a;
    }


    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


}
