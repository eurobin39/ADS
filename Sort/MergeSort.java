import java.util.Arrays;

/*
 * 병합 정렬 (Merge Sort)
 * - 분할 정복 기법을 사용하여 배열을 반으로 나누고 합병하여 정렬
 * - 최선, 최악, 평균 O(n log n)
 * - 추가 메모리 공간 O(n) 필요, 안정 정렬 (Stable Sort)
 */
public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = Arrays.copyOfRange(arr, left, right + 1);
        Arrays.sort(temp);
        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr)); // [1, 2, 5, 5, 6, 9]
    }
}
