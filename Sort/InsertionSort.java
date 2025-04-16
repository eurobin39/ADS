import java.util.Arrays;

/*
 * 삽입 정렬 (Insertion Sort)
 * - 이미 정렬된 부분을 유지하면서 새로운 원소를 적절한 위치에 삽입
 * - 최선의 경우 O(n) (이미 정렬된 경우), 최악의 경우 O(n²)
 * - 작은 크기의 데이터에 유리하고, 안정 정렬 (Stable Sort)
 */
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // key보다 큰 값들은 오른쪽으로 이동
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key; // 적절한 위치에 key 삽입
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr)); // [1, 2, 5, 5, 6, 9]
    }
}
