package test;

/**
 * Created by chen on 2017/12/1.
 */
public class Sample {

    public static void main(String[] args) {
        byte[] bytes = {0x01, 0x12, (byte) 0xDB, 0x12, 0x01, 0x00, 0x39, 0x33, 0x39, 0x34, 0x33, 0x30,
                        0x30, 0x31, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x37, 0x03};

        byte checkSum = 0;
        for (byte aByte : bytes) {
            checkSum += aByte;
        }
//        bytes[bytes.length - 1] = checkSum;
        System.out.println("checkSum = " + byteArray2HexString(new byte[]{checkSum}));
    }

    /**
     * byte[]数组转16进制字符串
     *
     * @param arr
     * @return
     */
    public static String byteArray2HexString(byte[] arr) {
        if (arr == null || arr.length == 0) {
            return "";
        }
        StringBuilder sbd = new StringBuilder();
        for (byte b : arr) {
            String tmp = Integer.toHexString(0xFF & b);
            if (tmp.length() < 2)
                tmp = "0" + tmp;
            sbd.append(tmp);
        }
        return sbd.toString();
    }

}
