package me.thinking_gorilla;

import java.util.function.BiPredicate;

import static me.thinking_gorilla.Utils.print;
import static me.thinking_gorilla.Utils.swap;

public class BubbleSort {

    public static void ascendingSort(int[] array) {
        bubbleSort(array, (current, key) -> current > key);
    }

    public static void descendingSort(int[] array) {
        bubbleSort(array, (current, key) -> current < key);
    }

    // 버블 정렬 또한 선택 정렬과 마찬가지로 졍렬 상태와는 무관하게 배열에서 한 요소를 뽑고 나머지 요소들과 비교를 수행한다.
    // 따라서 시간 복잡도는 O(n²)
    public static void bubbleSort(int[] array, BiPredicate<Integer, Integer> condition) {
        boolean sorted = false; // 조기종료 유도 변수
        // 배열의 모든 요소에 대해 반복
        // `-1`을 하는 이유는 버블 정렬은 2칸짜리 윈도우가 움직이면서 비교하는 것이므로
        // 버블 정렬에서 발생하는 비교횟수는 배열의 크기에서 하나를 뺸 것이기 때문이다.
        for (int i = 0; i < array.length - 1 && !sorted; i++) {
            sorted = true;
            // `-i`의 의미는 이전 패스에서 완료된 정렬 요소 개수
            // `-1`의 의미는 이번 패스에서 버블 비교할 횟수
            // 각 패스마다 인접한 요소들을 비교하여 큰 값을 뒤로 보냄
            for (int j = 0; j < array.length - i - 1; j++) {
                if (condition.test(array[j], array[j + 1])) {
                    // 요소 교환
                    swap(array, j, j + 1);
                    sorted = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};

        print("버블 정렬 전:", array);
        ascendingSort(array);
        // descendingSort(array);
        print("버블 정렬 후:", array);
    }
}
