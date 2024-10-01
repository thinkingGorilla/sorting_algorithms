package me.thinking_gorilla;

import static me.thinking_gorilla.Utils.print;

public class InsertionSort {

    // 삽입 정렬 메소드
    public static void insertionSort(int[] array) {
        int n = array.length;

        // 배열의 두 번째 요소부터 시작
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            // key보다 큰 값을 만나면 해당 값을 오른쪽으로 이동
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            // key를 적절한 위치에 삽입
            array[j + 1] = key;
        }
    }

    // 메인 메소드 (테스트용)
    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};

        print("삽입 정렬 전:", array);
        insertionSort(array);
        print("삽입 정렬 후:", array);
    }
}
