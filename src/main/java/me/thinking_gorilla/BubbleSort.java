package me.thinking_gorilla;

import static me.thinking_gorilla.Utils.print;
import static me.thinking_gorilla.Utils.swap;

public class BubbleSort {

    // 버블 정렬 메소드
    public static void bubbleSort(int[] array) {
        int n = array.length;

        // 배열의 모든 요소에 대해 반복
        for (int i = 0; i < n - 1; i++) {
            // 각 패스마다 인접한 요소들을 비교하여 큰 값을 뒤로 보냄
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // 요소 교환
                    swap(array, j, j + 1);
                }
            }
        }
    }

    // 메인 메소드 (테스트용)
    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};

        print("버블 정렬 전:", array);
        bubbleSort(array);
        print("버블 정렬 후:", array);
    }
}