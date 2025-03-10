import java.util.Arrays;

/*
 * 퀵 정렬 (Quick Sort)
 * - 피벗을 기준으로 작은 값과 큰 값을 나누는 방식으로 정렬
 * - 평균 O(n log n), 최악 O(n²) (이미 정렬된 경우 최악 발생 가능)
 * - 제자리 정렬 (In-Place)이며, 불안정 정렬 (Unstable Sort)
 */
public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; // 첫 번째 요소를 피벗으로 선택
        int i = low;
        int j = high;

        while (i < j) {
            while (i < j && arr[j] >= pivot) j--;
            while (i < j && arr[i] <= pivot) i++;
            if (i < j) swap(arr, i, j);
        }

        swap(arr, low, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr)); // [1, 2, 5, 5, 6, 9]
    }
}
