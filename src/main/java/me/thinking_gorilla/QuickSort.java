package me.thinking_gorilla;

import static me.thinking_gorilla.Utils.print;
import static me.thinking_gorilla.Utils.swap;

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
        int i = low; // 작은 요소들의 마지막 인덱스

        for (int j = low; j < high; j++) {
            // 현재 요소가 피벗보다 작거나 같다면
            if (array[j] < pivot) {
                // 요소 교환
                swap(array, i++, j);
            }
        }

        // 피벗을 적절한 위치로 이동
        swap(array, i, high);

        return i; // 피벗의 위치 반환
    }

    // 피벗을 기준으로 배열을 나누는 메서드
    /*
    private static int partition(int[] arr, int left, int right) {
        // 첫 번째 요소를 피벗으로 선택
        int pivot = arr[left];
        // 피벗보다 큰 값을 찾는 포인터
        int low = left + 1;
        // 피벗보다 작은 값을 찾는 포인터
        int high = right;

        while (low < high) {
            // 내부 while 루프: 피벗보다 큰 값을 찾는다.
            while (low <= right && arr[low] < pivot) {
                low++;
            }
            // 내부 while 루프: 피벗보다 작은 값을 찾는다.
            while (high >= left && arr[high] > pivot) {
                high--;
            }

            // low와 high가 교차하지 않은 경우, 값을 교환한다.
            if (low < high) {
                swap(arr, low, high);
            }
        }

        // 피벗을 제자리에 놓기 위해 교환
        // 피벗은 left 인덱스의 요소이므로 left 요소와 high 요소의 값을 교환한다.
        swap(arr, left, high);
        return high; // 피벗의 최종 위치 반환
    }
    */

    // 메인 메소드 (테스트용)
    public static void main(String[] args) {
        int[] array = {10, 80, 30, 90, 40, 50, 70};

        print("퀵 정렬 전:", array);
        quickSort(array, 0, array.length - 1);
        print("퀵 정렬 후:", array);
    }
}
