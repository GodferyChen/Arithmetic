package sample;

import java.util.*;

/**
 * Created by chen on 2017/1/21.
 */
public class Solution {

    public static int ledIndex = 0;

    public static void main(String[] args) {
        System.out.println(fibonacci(47));
    }

    /* 字符串置换
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String A, String B) {
        byte[] aBytes = A.getBytes();
        byte[] bBytes = B.getBytes();
        if (aBytes.length != bBytes.length) {
            return false;
        }
        Arrays.sort(aBytes);
        Arrays.sort(bBytes);
        boolean result = true;
        for (int i = 0; i < aBytes.length; i++) {
            if (aBytes[i] != bBytes[i]) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static int fibonacci(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            int c = 0, a = 1, b = 1;
            for (int i = 3; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }

    /**
     * @param head a ListNode
     * @param val  an integer
     * @return a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode result = head;
        while (head.next != null) {
            if (head.next.val == val) {
                if (head.next.next != null) {
                    head.next = head.next.next;
                } else {
                    head.next = null;
                    break;
                }
            } else {
                head = head.next;
            }
        }
        if (head.val == val) {
            return result.next;
        }
        return result;
    }

    /**
     * 选择排序
     *
     * @param A an integer array
     * @return void
     */
    public void sortIntegers(int[] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序
     *
     * @param A an integer array
     * @return void
     */
    public void sortIntegers1(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = 0; j < A.length - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 插入排序
     *
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[j] > A[i]) {
                    int temp = A[j];
                    A[j] = A[i];
                    A[i] = temp;
                }
            }
        }
    }

    /**
     * @param root the root of binary tree
     * @return the max ndoe
     */
    private TreeNode max = new TreeNode(Integer.MIN_VALUE);

    public TreeNode maxNode(TreeNode root) {
        if (root == null) {
            return root;
        }
        max = max.val > root.val ? max : root;
        maxNode(root.left);
        maxNode(root.right);
        return max;
    }

    public String convertToBase7(int num) {
        if (num < 0) return "-" + convertToBase7(-num);
        if (num < 7) return String.valueOf(num);
        return convertToBase7(num / 7) + (num % 7);
    }

    /**
     * Contains Duplicate
     * 解题思路：将每个数设置进map,然后跟数组比对长度
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, num);
        return !(map.size() == nums.length);
    }

    /**
     * 感觉这个效率高一点
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }

    /**
     * Longest Palindrome （最长回文子串）
     *
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        return 0;
    }

    /**
     * Majority Element
     * 解题思路：由于所求的数在数组中有多半，所以只要排序后取中间的数即可
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * Valid Anagram
     * 解题思路：先判断长度是否一致，再排序后进行匹配
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        char[] charListS = s.toCharArray();
        char[] charListT = t.toCharArray();
        Arrays.sort(charListS);
        Arrays.sort(charListT);
        for (int i = 0; i < charListS.length; i++) {
            if (charListS[i] != charListT[i]) return false;
        }
        return true;
    }

    /**
     * Same Tree
     * 树的解题大多都可以用递归
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * Excel Sheet Column Number
     * 26进制转十进制
     *
     * @param s
     * @return
     */
    public static int titleToNumber(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + s.charAt(i) - 'A' + 1;
        }
        return res;
    }

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Delete Node in a Linked List
     * 解题思路：先把当前节点的值用下一个节点的值覆盖了，然后删除下一个节点即可
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * First Unique Character in a String
     *
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.lastIndexOf(s.charAt(i)) == s.indexOf(s.charAt(i))) return i;
        }
        return -1;
    }

    /**
     * Best Time to Buy and Sell Stock II （贪心法）
     * 解题思路：计算每个两个数的差值，大于0则相加，最后得出的就是最大的利润
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) profit += diff;
        }
        return profit;
    }

    /**
     * Submission Details
     * 解题思路：利用递归
     *
     * @param root
     * @return
     */
    public static int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    public static int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        //是否是叶子节点
        if (root.left == null && root.right == null && isLeft) return root.val;
        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }

    /**
     * Intersection of Two Arrays
     * 利用HashMap或者HashSet解题
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int aNums1 : nums1) {
            for (int aNums2 : nums2) {
                if (aNums1 == aNums2) {
                    map.put(aNums1, aNums2);
                }
            }
        }
        int[] res = new int[map.size()];
        Iterator iterator = map.entrySet().iterator();
        for (int i = 0; i < map.size(); i++) {
            Map.Entry entry = (Map.Entry) iterator.next();
            res[i] = (int) entry.getValue();
        }
        return res;
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        HashSet<Integer> hash = new HashSet<>();
        for (int aNums1 : nums1) {
            hash.add(aNums1);
        }
        HashSet<Integer> resHash = new HashSet<>();
        for (int aNums2 : nums2) {
            if (hash.contains(aNums2) && !resHash.contains(aNums2)) {
                resHash.add(aNums2);
            }
        }
        int[] res = new int[resHash.size()];
        int index = 0;
        for (int num : resHash) {
            res[index++] = num;
        }
        return res;
    }

    /**
     * Ransom Note
     * 解题思路：只要判断ransomNote字符是不是全部在magazines中即可
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for (int i = 0; i < magazine.length(); i++) cnt[magazine.charAt(i) - 'a']++;
        for (int i = 0; i < ransomNote.length(); i++) if (--cnt[ransomNote.charAt(i) - 'a'] < 0) return false;
        return true;
    }

    /**
     * Minimum Moves to Equal Array Elements
     * 解题思路：n为nums的数组长度，m为答案，x为最后全相等时的值
     * sum(nums)+m(n-1)=xn
     * min(nums)+m=x
     * --》m=sum-min*n
     *
     * @param nums
     * @return
     */
    public static int minMoves(int[] nums) {
        if (nums == null) return 0;
        int min = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        return sum - min * nums.length;
    }

    /**
     * Assign Cookies
     * 解题思路：尽量给每个人能接受的最小的蛋糕就好，直接排序后，两个数组从头开始就
     *
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                res++;
            } else {
                j++;
            }
        }
        return res;
    }

    /**
     * Move Zeroes
     * 解题思路：将非0数字都尽可能向前排，将剩余的都置0
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos] = nums[i];
                pos++;
            }
        }
        for (; pos < nums.length; pos++) {
            nums[pos] = 0;
        }
    }

    /**
     * Invert Binary Tree
     * 翻转二叉树，是树的基本操作之一,用递归行数更少，非递归用while语句即可
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    /**
     * Add Digits
     *
     * @param num
     * @return
     */
    public static int addDigits(int num) {
        return num / 10 == 0 ? num : addDigits(num / 10 + num % 10);
    }

    /**
     * 此解题是找规律得出的，每9个一循环，所有大于9的数的树根都是对9取余
     *
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
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[]{};
    }

    /**
     * Two Sum II - Input array is sorted
     * 返回index[]
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(numbers[i]) != null) {
                int[] res = new int[2];
                res[0] = i < map.get(numbers[i]) ? (i + 1) : map.get(numbers[i]);
                res[1] = i < map.get(numbers[i]) ? map.get(numbers[i]) : (i + 1);
                return res;
            }
            map.put(target - numbers[i], i + 1);
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
