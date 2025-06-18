public class SeleccionSortDemo {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        System.out.println("Arreglo original:");
        imprimir(arr);
        selectionSort(arr);
        System.out.println("Arreglo ordenado con Selection Sort:");
        imprimir(arr);
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void imprimir(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}