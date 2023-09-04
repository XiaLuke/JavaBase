package cn.xf;

public class SelectSort {
    private static int arrLength;

    /**
     * 选择排序方案1
     * 依次比较每个数据，记录最小值的下标，一轮比较结束后，将最小数与当前循环次数位置的数据进行交换
     *
     * @param arr
     * @return {@link int[]}
     */
    public static int[] selectSort1(int[] arr) {
        int arrLength = arr.length;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int temp = arr[i];
            for (int j = i + 1; j < arrLength; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    /**
     * 选择排序
     * 在每一轮比较后，找到最小值的位置，如果最小值下标与开始时记录的数据一致，则不进行数据交换
     *
     * @param arr
     * @return {@link int[]}
     */
    public static int[] selectSort2(int[] arr) {
        for (int i = 0; i < arrLength - 1; i++) {
            int temp = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < temp) {
                    minIndex = j;
                }
            }
            // 发生过交换
            if (minIndex != i) {
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }

    public static void selectionSort3(int[] arr, int start) {
        int n = arr.length;
        if (start < n - 1) {
            int minIndex = start;
            for (int j = start + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != start) {
                int temp = arr[start];
                arr[start] = arr[minIndex];
                arr[minIndex] = temp;
            }
            selectionSort3(arr, start + 1);
        }
    }

    public static void main(String[] args) {
        int length = 10;
        int[] nums = GenerateArray.generate(length, 1000);
        arrLength = length;
        for (int i : selectSort2(nums)) {
            System.out.println(i);
        }
    }
}
