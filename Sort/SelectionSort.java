import java.util.Arrays;

/*
 * 선택 정렬 (Selection Sort)
 * - 가장 작은 값을 찾아서 차례로 배치
 * - 최선, 최악, 평균 O(n²)
 * - 제자리 정렬 (In-Place)이며, 불안정 정렬 (Unstable Sort)
 */
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 최소값과 현재 위치를 교환
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr)); // [1, 2, 5, 5, 6, 9]
    }
}
