package me.thinking_gorilla;

public class QuickSort {

    // 메인 정렬 메소드
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // 피벗을 기준으로 배열을 나누고 피벗의 인덱스를 가져옴
            int pivotIndex = partition(array, low, high);

            // 피벗 왼쪽 부분 정렬
            quickSort(array, low, pivotIndex - 1);
            // 피벗 오른쪽 부분 정렬
            quickSort(array, pivotIndex + 1, high);
        }
    }

    // 배열을 분할하는 메소드
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // 피벗을 배열의 마지막 요소로 선택
        int i = low - 1; // 작은 요소들의 마지막 인덱스

        for (int j = low; j < high; j++) {
            // 현재 요소가 피벗보다 작거나 같다면
            if (array[j] <= pivot) {
                i++;
                // 요소 교환
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // 피벗을 적절한 위치로 이동
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1; // 피벗의 위치 반환
    }

    // 메인 메소드 (테스트용)
    public static void main(String[] args) {
        int[] array = { 10, 80, 30, 90, 40, 50, 70 };
        System.out.println("정렬 전:");
        for (int value : array) {
            System.out.print(value + " ");
        }

        quickSort(array, 0, array.length - 1);

        System.out.println("\n정렬 후:");
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
