import java.util.Arrays;

public class QuickSortDebug {

    public static void main(String[] args) {
        int[] arr = {8, 3, 7, 6, 1, 5, 4, 2};
        System.out.println("Before sorting: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("After sorting: " + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return; // 종료 조건

        int pivotIndex = partition(arr, lo, hi);
        System.out.println("Pivot placed at index " + pivotIndex + ": " + Arrays.toString(arr));

        quickSort(arr, lo, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, hi);
    }

    private static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];  // 피벗을 첫 번째 요소로 선택
        int i = lo, j = hi + 1;

        System.out.println("\nPartitioning (lo=" + lo + ", hi=" + hi + ", pivot=" + pivot + ")");
        System.out.println("Start: " + Arrays.toString(arr));

        while (true) {
            while (++i <= hi && arr[i] < pivot); // 왼쪽에서 큰 값 찾기
            while (--j >= lo && arr[j] > pivot); // 오른쪽에서 작은 값 찾기

            if (i >= j) break; // 포인터가 교차하면 종료

            swap(arr, i, j);
            System.out.println("Swapped: " + Arrays.toString(arr));
        }

        swap(arr, lo, j); // 피벗을 최종 위치로 이동
        System.out.println("Pivot swapped: " + Arrays.toString(arr));

        return j; // 피벗의 최종 위치 반환
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
