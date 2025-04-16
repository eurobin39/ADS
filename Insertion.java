import java.util.Arrays;

public class Insertion {
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {  // 두 번째 요소부터 시작
            int key = arr[i];  // 현재 삽입할 값
            int j = i - 1;  // 정렬된 부분의 마지막 인덱스

            // 정렬된 부분에서 key보다 큰 값을 오른쪽으로 이동
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];  // 한 칸씩 오른쪽으로 이동
                j--;
            }
            arr[j + 1] = key;  // key를 올바른 위치에 삽입
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        System.out.println("정렬 전: " + Arrays.toString(arr));

        insertionSort(arr);

        System.out.println("정렬 후: " + Arrays.toString(arr));
    }
}
