import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        int[] array = {5, 6, 3, 2, 5, 1, 4, 9};
        quickSort(array, 0, array.length - 1);
        for(int number : array){
            System.out.print(number + "\t");
        }
        System.out.println();
        test();
    }

    static int[] quickSort(int[] array, int low, int high){

        if (array.length == 0)
            return array;

        if (low >= high)
            return array;

        int middle = low + (high - low) / 2;
        int stand = array[middle];


        int i = low, j = high;
        while (i <= j) {
            while (array[i] < stand) {
                i++;
            }

            while (array[j] > stand) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }


        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
        return array;
    }


    static void test(){
        int[][] array = {{5, 6, 3, 2, 5, 1, 4, 9}, {5, 1, 5, 1, 3, 1, 1, 8, 4 ,1}, {6, 4, 6, 6, 6, 8, 6, 6}};
        int[][] result = {{1, 2, 3, 4, 5, 5, 6, 9}, {1, 1, 1, 1, 1, 3, 4, 5, 5, 8}, {4, 6, 6, 6, 6, 6, 6, 8}};

        for(int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]) + " must be sorted to " + Arrays.toString(result[i]));
            if (Arrays.equals(quickSort(array[i], 0, array[i].length - 1), result[i])) {
                System.out.println("Test # " + (i + 1) + " is passed!");
            } else {
                System.out.println("Test # " + (i + 1) + " is failed!");
                System.out.println("Result is " + Arrays.toString(quickSort(array[i], 0, array[i].length - 1)));
            }
        }
    }
}


