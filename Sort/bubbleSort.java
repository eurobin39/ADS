import java.util.Arrays;

/*
 * 버블 정렬 (Bubble Sort)
 * - 인접한 두 개의 원소를 비교하여 교환하는 방식으로 정렬
 * - 가장 큰 원소가 매 패스마다 끝으로 이동함
 * - 최악의 경우 O(n²), 최선의 경우 O(n) (이미 정렬된 경우)
 * - 제자리 정렬 (In-Place)이며, 안정 정렬 (Stable Sort)
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) { // 인접한 두 원소 비교 후 스왑
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // 스왑이 없으면 정렬 완료
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr)); // [1, 2, 5, 5, 6, 9]
    }
}
