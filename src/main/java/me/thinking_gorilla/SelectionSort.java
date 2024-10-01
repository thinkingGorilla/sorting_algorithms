package me.thinking_gorilla;

public class SelectionSort {

    // 선택 정렬 메소드
    public static void selectionSort(int[] array) {
        int n = array.length;

        // 배열의 모든 요소에 대해 반복
        for (int i = 0; i < n - 1; i++) {
            // i부터 n까지의 배열 중에서 최소값을 찾음
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j; // 최소값의 인덱스를 업데이트
                }
            }

            // 최소값을 현재 위치로 교환
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    // 메인 메소드 (테스트용)
    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};
        System.out.println("선택 정렬 전:");
        for (int value : array) {
            System.out.print(value + " ");
        }

        // 선택 정렬 실행
        selectionSort(array);

        System.out.println("\n선택 정렬 후:");
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
