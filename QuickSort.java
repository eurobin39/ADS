import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) { // 최소 두 개 이상의 요소가 있을 때만 수행
            int pivotIndex = partition(arr, low, high); // 피벗 정렬 후 인덱스 반환
            quickSort(arr, low, pivotIndex - 1);  // 왼쪽 부분 정렬
            quickSort(arr, pivotIndex + 1, high); // 오른쪽 부분 정렬
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 피벗을 배열의 마지막 요소로 선택
        int i = low - 1; // 작은 값의 위치를 찾는 인덱스

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) { // 피벗보다 작은 값이면 왼쪽으로 이동
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high); // 피벗을 최종 위치로 이동
        return i + 1; // 피벗의 최종 위치 반환
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("정렬 전: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("정렬 후: " + Arrays.toString(arr));
    }
}
