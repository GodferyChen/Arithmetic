package sample;

import java.util.*;

/**
 * Created by chen on 2016/1/2.
 */
public class Sample {

    public static int count = 1;
    public static int lastTime = 0;

    public static void main(String[] args) throws Exception {

//        getMaxValue();
        long startTime = System.currentTimeMillis();
        long result = getFibonacciData(50);
        long endTime = System.currentTimeMillis();
        System.out.println("fibonacci = " + result+",time = " + (endTime - startTime));
    }

    /**
     * 编写一个能将给定非负整数列表中的数字排列成最大数字的函数。
     */
    public static void getMaxValue() {
        int[] values = {50, 2, 1, 9};
        List<HashMap<String,Integer>> list = new ArrayList<>();
        for (int value : values) {
            HashMap<String, Integer> map = new HashMap<>();
            map.put("key_value", value);
            map.put("key_number", getMaxNumber(value));
            list.add(map);
        }
        System.out.println("sample.sample.getMaxValue = " + list.toString());
        for (int i = 0; i < list.size(); i++) {
            HashMap<String, Integer> max = list.get(i);
            int n = i;
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(j).get("key_number") > max.get("key_number")){
                    max = list.get(j);
                    n = j;
                    System.out.println("j = " + max.toString());
                }
            }
            System.out.println("j = " + max.toString());
//            list.get(n).put("key_value",list.get(i).get("key_value"));
//            list.get(n).put("key_number",list.get(i).get("key_number"));
            list.get(i).put("key_value",max.get("key_value"));
            list.get(i).put("key_number",max.get("key_number"));
            System.out.println("list.get(n) = " + list.get(n).toString());
            System.out.println("list.get(i) = " + max.get("key_number"));
        }

        System.out.println("sample.sample.getMaxValue = " + list.toString());
    }

    public static int getMaxNumber(int number) {
        if (number >= 10) {
            number = number / 10;
            return getMaxNumber(number);
        } else {
            return number;
        }
    }

    public static long getFibonacciData(int num) throws Exception {
        if(num == 0){
            return 0;
        }else if(num == 1 || num == 2){
            return 1;
        }else if(num > 2){
            long result = getFibonacciData(num - 1) + getFibonacciData(num - 2);
            if(result < 0){
                throw new Exception("result is too large!");
            }else {
                return result;
            }
        }else {
            throw new Exception("please enter num >= 0");
        }
    }

    /**
     * 编写一个交错合并列表元素的函数。
     */
    public static void merge() {
        String[] strFir = {"a", "B", "C", "D", "E"};
        String[] strSec = {"1", "2", "3", "4", "5", "6"};
        List<String> list = new ArrayList<>();
        int minlen = strFir.length < strSec.length ? strFir.length : strSec.length;
        for (int i = 0; i < minlen; i++) {
            list.add(strFir[i]);
            list.add(strSec[i]);
        }
        if (strFir.length < strSec.length) {
            list.addAll(Arrays.asList(strSec).subList(minlen, strSec.length));
        } else if (strFir.length > strSec.length) {
            list.addAll(Arrays.asList(strFir).subList(minlen, strFir.length));
        }
    }

    public static void countSum() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int sum = 0;
        /**for方法**/
//        for (int number : numbers) {
//            sum += number;
//        }
        /**while方法**/
//        int i = 0;
//        while (true){
//            sum += numbers[i];
//            i++;
//            if(i == numbers.length){
//                break;
//            }
//        }
        sum = sum(0, sum, numbers);
    }

    /**
     * 递归方法
     *
     * @param index
     * @param sum
     * @param numbers
     * @return
     */
    public static int sum(int index, int sum, int[] numbers) {
        if (index < numbers.length) {
            return sum(index + 1, sum, numbers) + numbers[index];
        } else {
            return sum;
        }

    }

    public static void otherMethod() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 10. 写个程序打印出接下来的20个闰年。
     */
    public static void printLeapYear() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        for (int i = year; i >= 0; i--) {
            if (i % 400 == 0 || (i % 4 == 0 && i % 100 != 0)) {
                for (int j = 0; j < 20; j++) {
                    i += 4;
                    System.out.print(i + "\t");
                }
                return;
            }
        }
    }

    /**
     * 9. 写一个竞猜游戏，用户必须猜一个秘密的数字，在每次猜完后程序会告诉用户他猜的数是太大了还是太小了，
     * 直到猜测正确，最后打印出猜测的次数。如果用户连续猜测同一个数字则只算一次。
     */
    public static void testNumGame() {
        System.out.println("这是一个竞猜游戏，猜0到100内的一个数字！");
        int num = (int) (Math.random() * 100);
        method(num, false);
    }

    public static void method(int num, boolean bool) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入您猜的数字：");
        String test = input.nextLine();
        int guess = Integer.parseInt(test);
        if (lastTime != guess && bool) {
            count++;
        }
        lastTime = guess;
        if (lastTime > num) {
            System.out.println("数字太大了！");
            method(num, true);
        } else if (lastTime < num) {
            System.out.println("数字太小了！");
            method(num, true);
        } else {
            System.out.println("恭喜了猜对了！答案就是：" + num + ",您一共猜了" + count + "次");
        }
    }

    /**
     * 8. 写程序打印所有的素数。
     */
    public static void getPrimeNums() {
        int maxNum = 65538;
        int[] primeNums = new int[maxNum / 2 + 1];
        int sqrtRoot;
        int cursor = 0;
        boolean isPrime;
        for (int i = 2; i <= maxNum; i++) {
            sqrtRoot = (int) Math.sqrt(i); //取平方根
            isPrime = true;
            for (int j = 0; j < cursor; j++) {
                if (primeNums[j] > sqrtRoot)
                    break;
                if (i % primeNums[j] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNums[cursor++] = i;
            }
        }
        int[] result = new int[cursor];
        System.arraycopy(primeNums, 0, result, 0, cursor);

        System.out.println("共" + primeNums.length + "个素数");
        for (int i = 0; i < primeNums.length; i++) {
            System.out.print(primeNums[i] + "\t");
        }
    }

    /**
     * 7. 写程序打印出12×12乘法表。
     */
    public static void getMultiplicationTable() {
        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " * " + j + " = " + i * j + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 6. 写个程序，要求用户输入一个数n，并概率性的选择是计算1到n的和还是计算1到n的乘积。
     *
     * @param num
     */
    public static void countSumOrProduct(int num) {
        int method = Math.random() > 0.5 ? 1 : 0;
        System.out.println("method = " + method);
        int result = 1;
        for (int i = 1; i <= num; i++) {
            if (method == 0) {//求和
                result += i;
            } else {//乘积
                result *= i;
            }
        }
        System.out.println("result = " + result);
    }

    /**
     * 5. 修改上个程序，使得求和的数只包含3或5的倍数，例如n=17，则求和的数为：3, 5, 6, 9, 10, 12, 15。
     * 4. 写程序输入一个数n并打印出从1到n的和。
     *
     * @param num
     */
    public static void countSum(int num) {
        int sum = 0;
        for (int i = 0; i <= num; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
                System.out.println("i = " + i);
            }
        }
        System.out.println("sum = [" + sum + "]");
    }

    /**
     * 3. 修改上一个程序，使得仅可以与Alice和Bob这两个用户用其姓名与之打招呼。
     * 2. 写程序输入用户的姓名并用该姓名和他打招呼。
     */
    public static void sayHello() {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入您的姓名：");
        String name = input.next();
        if (name.equals("Alice") || name.equals("Bob")) {
            System.out.println("Hello " + name + " !");
        } else {
            System.out.println("我不认识你!");
            sayHello();
        }
    }

    /**
     * 1.写程序将” Hello World”打印到屏幕。
     */
    public static void print() {
        System.out.println("HelloWorld!");
    }

}
