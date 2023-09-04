package cn.xf;

public class _1401 {
    public static boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
//        if (x_center >= x1 && x_center <= x2 && y_center >= y1 && y_center <= y2) {
//            return true; // 圆心在矩形内
//        }
//        int dx = Math.max(x_center - x2, x1 - x_center);
//        int dy = Math.max(y_center - y2, y1 - y_center);
//        return dx * dx + dy * dy <= radius * radius; // 计算圆心与矩形边界之间的最短距离
        // 将圆心坐标限制在矩形范围内
        int cx = Math.max(x1, Math.min(xCenter, x2));
        int cy = Math.max(y1, Math.min(yCenter, y2));
        // 求圆心到矩形边界的距离
        int dx = cx - xCenter;
        int dy = cy - yCenter;
        // 判断是否有重叠部分
        return dx * dx + dy * dy <= radius * radius;
    }

    public static void main(String[] args) {
        boolean b = checkOverlap(1, 0, 0, 1, -1, 3, 1);
        System.out.println(b);
    }
}
