package cn.xf;

public class ConsolidationInterval {
    public static int[][] merge(int[][] intervals) {
        int i = intervals[1][1];
        System.out.println(i);
        return intervals;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {2,6},{8,10},{15,18}};
        int[][] merge = merge(intervals);

    }
}
