package cn.xf;

/**
 *  美丽下标对的数目
 *
 * 给你一个下标从 0 开始的整数数组 nums 。如果下标对 i、j 满足 0 ≤ i < j < nums.length ，如果nums[i] 的 第一个数字 和 nums[j] 的 最后一个数字 互质 ，
 * 则认为 nums[i] 和 nums[j] 是一组 美丽下标对 。
 * 返回 nums 中 美丽下标对 的总数目。
 * 对于两个整数 x 和 y ，如果不存在大于 1 的整数可以整除它们，则认为 x 和 y 互质 。换而言之，如果 gcd(x, y) == 1 ，则认为 x 和 y 互质，
 * 其中 gcd(x, y) 是 x 和 k 最大公因数 。
 *
 * @author XF
 * @date 2023/06/28
 */
public class _2748 {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public int countBeautifulPairs(int[] nums) {
        int ans = 0;
        // 创建一个长度为10的数组cnt用于统计数字1到9的出现次数
        var cnt = new int[10];
        for (int x : nums) {
            for (int y = 1; y < 10; y++)
                // 遍历1到9，检查cnt数组中任意数字y的出现次数是否大于0，并且x的个位数与y的最大公约数是否为1
                if (cnt[y] > 0 && gcd(x % 10, y) == 1)
                    ans += cnt[y]; // 如果满足条件，则累加cnt[y]到答案中
            while (x >= 10) x /= 10; // 对x进行除以10的操作，直到x小于10，即获取x的最高位
            cnt[x]++; // 统计x的最高位（个位）的出现次数
        }
        return ans; // 返回美丽对数量的答案
    }

    public static void main(String[] args) {
        int[] nums =  new int[]{2,5,1,4};
    }
}
