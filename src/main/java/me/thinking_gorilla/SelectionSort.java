package me.thinking_gorilla;

import java.util.function.BiPredicate;

import static me.thinking_gorilla.Utils.print;
import static me.thinking_gorilla.Utils.swap;

public class SelectionSort {

    public static void ascendingSort(int[] array) {
        selectionSort(array, (current, extreme) -> current < extreme);
    }

    public static void descendingSort(int[] array) {
        selectionSort(array, (current, extreme) -> current > extreme);
    }

    // 배열이 정렬된 상태든 아니든 간에 무조건 비교 요소를 한 개 뽑고 배열에 있는 나머지 요소와 비교한다.
    // 따라서 시간 복잡도는 O(n²)
    private static void selectionSort(int[] array, BiPredicate<Integer, Integer> condition) {
        for (int i = 0; i < array.length - 1; i++) {

            int extremeIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (condition.test(array[j], array[extremeIndex])) {
                    extremeIndex = j;
                }
            }

            swap(array, extremeIndex, i);
        }
    }

    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};

        print("선택 정렬 전:", array);
        ascendingSort(array);
        // descendingSort(array);
        print("선택 정렬 후:", array);
    }
}
