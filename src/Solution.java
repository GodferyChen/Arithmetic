import java.util.*;

/**
 * Created by chen on 2017/1/21.
 */
public class Solution {

    public static void main(String[] args) {
//        int [] result = twoSumBetter(new int[]{2,7,11,15},9);
//        System.out.println("result[0] = "+result[0]+",result[1]="+result[1]);
//        System.out.println("汉明距离 " + hammingDistance2(1, 4));
        System.out.println("value = " + findMaxConsecutiveOnesBetter(new int[]{1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1}));
    }

    /**
     * Max Consecutive Ones
     * 给定一个二进制数组，计算数组中出现的最大连续1的个数。
     *
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (count > res) res = count;
                count = 0;
            } else {
                count++;
            }
            if (i == nums.length - 1 && count != 0 && count > res) {
                res = count;
            }
        }
        return res;
    }

    /**
     * 更优解：
     * 如果说当前位为0，那么连续1就结束了，最大的就是前面积累的maxHere，
     * 如果当前位是1，那么在当前积累的maxHere基础上加一
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnesBetter(int[] nums) {
        int max = 0;
        int maxHere = 0;
        for (int i : nums) {
            max = Math.max(max, maxHere = i == 0 ? 0 : maxHere + 1);
        }
        return max;
    }

    /**
     * Fizz Buzz
     *
     * @param n
     * @return
     */
    public static List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }

    /**
     * Number Complement
     *
     * @param num
     * @return
     */
    public static int findComplement(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution.
     * example:
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * @param nums   : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     * numbers=[2, 7, 11, 15],  target=9
     * return [1, 2]
     */
    public static int[] twoSumBetter(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                int[] result = {map.get(nums[i]), i};
                return result;
            }
            map.put(target - nums[i], i);
        }
        return new int[]{};
    }

    /**
     * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
     * Given two integers x and y, calculate the Hamming distance.
     * 根据异或的性质（相同为0，不同为1）来解题，把1的情况累加起来就是答案
     *
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (((x & (1 << i)) ^ (y & (1 << i))) > 0) {
                System.out.println("输出 i = " + i);
                res++;
            }
        }
        return res;
    }

    /**
     * 解题思路：将两个数异或起来，遍历异或结果的每一位，统计为1的个数
     *
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance2(int x, int y) {
        int res = 0;
        int exc = x ^ y;
        for (int i = 0; i < 32; i++) {
            res += (exc >> i) & 1;
        }
        return res;
    }

    /**
     * 解题思路：上个方法中有遍历每一位并不高效，可以进一部优化，已知一个数num，num&(num-1)可以快速移除最右边的bit1,
     * 一直循环到num为0，总的循环数就是num中bit1的个数
     *
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance3(int x, int y) {
        int res = 0;
        int exc = x ^ y;
        while (exc > 0) {
            res++;
            exc &= (exc - 1);
        }
        return res;
    }

    /**
     * 递归的写法，非常的简洁，递归终止的条件是当两个数异或为0时，表明此时两个数完全相同，我们返回0，
     * 否则我们返回异或和对2取余加上对x/2和y/2调用递归的结果。异或和对2取余相当于检查最低位是否相同，
     * 而对x/2和y/2调用递归相当于将x和y分别向右移动一位，这样每一位都可以比较到，也能得到正确结果
     *
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance4(int x, int y) {
        if ((x ^ y) == 0) return 0;
        return (x ^ y) % 2 + hammingDistance4(x / 2, y / 2);
    }

}
