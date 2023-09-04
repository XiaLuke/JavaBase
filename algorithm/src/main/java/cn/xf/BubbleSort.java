package cn.xf;

public class BubbleSort {
    /**
     * 方式1
     *
     * @param nums 数列
     * @return {@link int[]}
     */
    public static int[] bubbleSort1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * 冒泡排序
     * 标记在一轮比较汇总中，如果没有需要交换的数据，说明数组已经有序，可以减少排序循环的次数
     * 冒泡排序最优解
     *
     * @param arr
     * @return {@link int[]}
     */
    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            System.out.println(arr[i]);
            System.out.println(n - i - 1);
            if (!flag) {
                break;
            }
        }
        return arr;
    }

    /**
     * 双向冒泡排序
     *
     * @param arr
     * @return {@link int[]}
     */
    public static int[] bubbleSort2(int[] arr) {
        int low = 0;
        int high = arr.length - 1; //设置变量的初始值
        int tmp, j;
        while (low < high) {
            for (j = low; j < high; ++j) //正向冒泡,找到最大者
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            --high;                 //修改high值, 前移一位
            for (j = high; j > low; --j) //反向冒泡,找到最小者
                if (arr[j] < arr[j - 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            ++low;                  //修改low值,后移一位
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = GenerateArray.generate(10, 1000);
        for (int item : nums) {
            System.out.println(item);
        }
        int[] ints = bubbleSort2(nums);
        for (int anInt : ints) {
            System.out.println("排序后：" + anInt);
        }
    }

}
