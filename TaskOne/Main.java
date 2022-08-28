public class Main {
    public static void main(String[] args) {

        int[][] array = new int[10][10];

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                array[i][j] = rand();
            }
        }

        print(array);
        analysis(array);

    }
    static double x = 0.5;
    static int rand() {
        int a = 25173, b = 13849, m = 32768;

        x = (a * x + b) % m ;
        return (int) x % 100;
    }

    static void print(int[][] array){

        for (int[] ints : array) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }

    }

    static void analysis(int[][] array){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int average = 0;
        int counter = 0;

        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (min > array[i][j]) min = array[i][j];
                if (max < array[i][j]) max = array[i][j];
                average += array[i][j];
                counter += 1;
            }
        }

        average /= counter;

        System.out.println("Min value : " + min + "\n" +
                "Max value : " + max + "\n" +
                "Average value : " + average);

    }

}
