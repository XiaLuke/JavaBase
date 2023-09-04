package cn.xf;

public class InsertSort {
    /**
     * 插入排序
     *
     * @param arr
     * @return {@link int[]}
     */
    public static int[] insertionSort1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            int j = i - 1;
            for (; j >= 0 && arr[j] > cur; j--) {
                arr[j + 1] = arr[j];
            }
//            while (j >= 0 && arr[j] > cur) {
//                arr[j + 1] = arr[j];
//                j--;
//            }

            arr[j + 1] = cur;
        }
        return arr;
    }

    /**
     * 二分插入排序
     *
     * @param arr
     */
    public static int[] binaryInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            int left = 0, right = i - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] > cur) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
                arr[j + 1] = arr[j];
            }
            arr[left] = cur;
        }
        return arr;
    }

    /**
     * 希尔排序（缩小增量排序）
     *
     * @param arr 加勒比海盗
     */
    public static void shellSort(int[] arr) {
        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int cur = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > cur) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = cur;
            }
            gap /= 2;
        }
    }

    public static void main(String[] args) {
        int length = 10;
        int[] arr = GenerateArray.generate(length, 1000);
        GenerateArray.length = length;
        int[] ints = insertionSort1(arr);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
