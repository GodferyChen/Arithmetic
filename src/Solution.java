import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chen on 2017/1/21.
 */
public class Solution {

    public static void main(String[] args) {
//        int [] result = twoSumBetter(new int[]{2,7,11,15},9);
//        System.out.println("result[0] = "+result[0]+",result[1]="+result[1]);
//        System.out.println("汉明距离 " + hammingDistance2(1, 4));
        System.out.println("value = " + addDigits(49));
    }

    /**
     * Invert Binary Tree
     * 翻转二叉树，是树的基本操作之一,用递归行数更少，非递归用while语句即可
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    /**
     * Add Digits
     * @param num
     * @return
     */
    public static int addDigits(int num) {
        return num / 10 == 0 ? num : addDigits(num / 10 + num % 10);
    }

    /**
     * 此解题是找规律得出的，每9个一循环，所有大于9的数的树根都是对9取余
     * @param num
     * @return
     */
    public static int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }

    /**
     * Find the Difference
     * 解题思路：根据异或的特性：相同为0，不同为1，所有的字母进行异或操作，得出的结果就是多的那个字母
     *
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference(String s, String t) {
        char res = 0;
        for (char item : s.toCharArray()) {
            res ^= item;
        }
        for (char item : t.toCharArray()) {
            res ^= item;
        }
        return res;
    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Maximum Depth of Binary Tree
     * 求二叉树的深度
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? (left + 1) : (right + 1);
    }

    /**
     * 解题思路：x^y 执行加法，不考虑进位
     * (x&y)<<1 //进位操作
     *
     * @param a
     * @param b
     * @return
     */
    public static int getSum(int a, int b) {
        return b == 0 ? a : getSum((a ^ b), (a & b) << 1);
    }

    /**
     * 取补码
     *
     * @param a
     * @return
     */
    public static int negative(int a) {
        return getSum(~a, 1);
    }

    /**
     * 用位运算实现相减
     *
     * @param a
     * @param b
     * @return
     */
    public static int sub(int a, int b) {
        return getSum(a, negative(b));
    }

    /**
     * 解题思路一致，改用迭代
     *
     * @param a
     * @param b
     * @return
     */
    public static int getSum2(int a, int b) {
        while (b > 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    /**
     * Construct the rectangle
     * 解题思路：记area的平方根为sqrt
     * 从int(sqrt) 向 1 递减枚举宽度W，若area % W == 0，则L = area / W
     *
     * @param area
     * @return
     */
    public static int[] constructRectangle(int area) {
        int[] res = new int[2];
        int sqrt = (int) Math.sqrt(area);
        for (int i = sqrt; i >= 1; i--) {
            if (area % i == 0) {
                res[0] = area / i;
                res[1] = i;
                break;
            }
        }
        return res;
    }

    /**
     * Single Number
     * 解题思路：取异或，相同为0，不同为1
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    /**
     * Find All Numbers Disappeared in an Array
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> resArray = new ArrayList<>();
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i] - 1] = nums[i];
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] < 0) resArray.add(i + 1);
        }
        return resArray;
    }

    /**
     * 解题思路：将其本应该在的位置设置为负值，最后遍历，为正的即为缺失值
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbersBetter(int[] nums) {
        List<Integer> resArray = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = Math.abs(nums[i]) - 1;
            if (nums[temp] > 0) nums[temp] = -nums[temp];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) resArray.add(i + 1);
        }
        return resArray;
    }

    /**
     * Nim Game
     * if ((n - 1) % 4 == 0 || (n - 2) % 4 == 0 || (n - 3) % 4== 0) return true;
     * else return false;
     * 进一步整理
     * return (n - 1) % 4 == 0 || (n - 2) % 4 == 0 || (n - 3) % 4 == 0;
     *
     * @param n
     * @return
     */
    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    /**
     * Island Perimeter
     * 解题思路：每个格子周长为4，两个格子相邻时周长-2
     *
     * @param grid
     * @return
     */
    public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    if (i > 0 && grid[i - 1][j] == 1) perimeter -= 2;
                    if (j > 0 && grid[i][j - 1] == 1) perimeter -= 2;
                }
            }
        }
        return perimeter;
    }

    /**
     * Reverse String
     * Write a function that takes a string as input and returns the string reversed.
     *
     * @param s
     * @return
     */
    public static String reverseString(String s) {
        char[] args = s.toCharArray();
        char[] content = new char[args.length];
        for (int i = 0; i < args.length; i++) {
            content[i] = args[args.length - i - 1];
        }
        return String.valueOf(content);
    }

    /**
     * 直接使用StringBuffer类的reverse()方法
     *
     * @param s
     * @return
     */
    public static String reverseString2(String s) {
        return new StringBuffer(s).reverse().toString();
    }

    /**
     * 异或预算满足交换律
     * 时间复杂度仅为方法1的一半
     *
     * @param s
     * @return
     */
    public static String reverseString3(String s) {
        char[] c = s.toCharArray();
        int start = 0;
        int end = c.length - 1;
        while (start < end) {
            c[start] = (char) (c[start] ^ c[end]);
            c[end] = (char) (c[start] ^ c[end]);
            c[start] = (char) (c[start] ^ c[end]);
            start++;
            end--;
        }
        return String.valueOf(c);
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
     *
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
