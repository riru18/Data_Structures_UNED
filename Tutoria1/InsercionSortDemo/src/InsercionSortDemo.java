public class InsercionSortDemo {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        System.out.println("Arreglo original:");
        imprimir(arr);
        insertionSort(arr);
        System.out.println("Arreglo ordenado con Insertion Sort:");
        imprimir(arr);
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void imprimir(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}