package me.thinking_gorilla;

import static me.thinking_gorilla.Utils.print;

public class MergeSort {

    // 메인 정렬 메소드
    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return; // 배열 길이가 1 이하인 경우 정렬이 필요 없음
        }

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        // 배열을 왼쪽과 오른쪽으로 나누기
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        // 재귀적으로 왼쪽과 오른쪽을 정렬
        mergeSort(left);
        mergeSort(right);

        // 정렬된 두 부분 배열을 합병
        merge(array, left, right);
    }

    // 합병 메소드
    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // 두 배열을 비교하여 더 작은 값을 결과 배열에 넣기
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // 왼쪽 배열에 남은 요소 추가
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // 오른쪽 배열에 남은 요소 추가
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    // 메인 메소드 (테스트용)
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        print("병합 정렬 전:", array);
        mergeSort(array);
        print("병합 정렬 후:", array);
    }
}
