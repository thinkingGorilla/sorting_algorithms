package me.thinking_gorilla;

import java.util.function.BiPredicate;

import static me.thinking_gorilla.Utils.print;

public class InsertionSort {

    public static void ascendingSort(int[] array) {
        insertionSort(array, (current, key) -> current > key);
    }

    public static void descendingSort(int[] array) {
        insertionSort(array, (current, key) -> current < key);
    }

    // 정렬된 상태인 경우 while 조건문이 동작하지 않는다. 즉 배열 길이만큼 순회가 발생한다. → 시간 복잡도는 O(n)
    // 임의 정렬 상태인 경우 반드시 while 조건문이 동작한다.
    // 이때 while 조건문에서 배열 길이만큼 순회가 발생한다. → 시간 복잡도는 O(n²)
    public static void insertionSort(int[] array, BiPredicate<Integer, Integer> condition) {
        // 배열의 두 번째 요소부터 시작
        for (int i = 1; i < array.length; i++) {
            // array[j + 1] = array[j]이 수행되더라도 key가 변경되지 않도록
            // 별도의 로컬 변수에 저장한다.
            int key = array[i];
            int j = i - 1;

            // 순회 요소와 key를 비교하여 조건에 해당하면 요소를 오른쪽으로 이동
            while (j >= 0 && condition.test(array[j], key)) {
                array[j + 1] = array[j];
                j--;
            }

            // key를 적절한 위치에 삽입
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};

        print("삽입 정렬 전:", array);
        ascendingSort(array);
        // descendingSort(array);
        print("삽입 정렬 후:", array);
    }
}
