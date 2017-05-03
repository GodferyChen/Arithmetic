package sample;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by chen on 2017/1/28.
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println((~2));
    }

    public static void tempValueWithData() {
        //原十六进制数组
        byte[] value = {(byte) 0x73, (byte) 0x0B};
        //转成二进制
        int source = Byte2Int(value[0]) * 256 + Byte2Int(value[1]);
        //反转
        int a = invert(source);
        //取反
        a^=0xffff;
        byte high1 = (byte) (a / 256);
        byte high2 = (byte) (a % 256);
        //两个byte换位,最好转成十进制
        int data = Byte2Int(high1) + Byte2Int(high2) * 256;
        System.out.println("解析出来的十进制数据：" + data);
        System.out.println("返回的体温值：" + String.format("%2.1f", (float) data / 100));
    }

    /**
     * 倒序
     *
     * @param source
     * @return
     */
    private static int invert(int source) {
        int result = 0, temp = 0;
        for (int i = 0; i < 16; i++) {
            temp = source & 0x01;
            source = source >> 1;
            result = result + temp;
            if (i != 15) result = result << 1;
        }
        return result;
    }

    private static void parseData() {
        String datas = Integer.toBinaryString(Byte2Int((byte) 0x0C) * 256 + Byte2Int((byte) 0x80));
        char[] bytes = datas.toCharArray();
        System.out.print("原二进制：" + bytes.length + ":");
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(bytes[i]);
        }
        System.out.println();
        ArrayList<Character> arrayList = new ArrayList<Character>();
        for (int i = 0; i < bytes.length; i++) {
            arrayList.add(bytes[i]);
        }
        ArrayList<Character> arrayList1 = new ArrayList<>();
        arrayList1.addAll(arrayList);
        Collections.reverse(arrayList);
        System.out.print("倒置数据：" + arrayList.size() + ":");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print((char) arrayList.get(i));
        }
        System.out.println();
        String s = "";
        for (int i = 0; i < arrayList1.size(); i++) {
            s += String.valueOf(arrayList.get(i));
        }
        String data = Integer.toBinaryString(~Integer.valueOf(s, 2)).substring(16, 32);
        System.out.println("取反数据：" + data);
        String lastData = data.substring(8, data.length()) + data.substring(0, 8);
        System.out.println("最终数据：" + lastData);
        int temp = Integer.valueOf(lastData, 2);
        System.out.println("转为十进制数据：" + String.format("%2.1f", (float) temp / 100));
    }

    public static int Byte2Int(byte b) {
        return (b >= 0 ? b : b + 256);
    }

}
