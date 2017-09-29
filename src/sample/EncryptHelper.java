package sample;

/**
 * Created by chen on 2017/6/13.
 */
public class EncryptHelper {

    public static void main(String[] args) {
        pin();
    }

    public static byte[] pin() {
        byte[] pinData = new byte[]{0x06, 0x12, 0x34, 0x56, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF};
        byte[] panData = new byte[]{0x00, 0x00, 0x67, (byte) 0x89, 0x01, 0x23, 0x45, 0x67};
        byte[] res = new byte[8];
        for (int i = 0; i < pinData.length; i++) {
            res[i] = (byte) (pinData[i] ^ panData[i]);
        }
        System.out.println(byteArray2HexString(res));
        return res;
    }

    public static String byteArray2HexString(byte[] var0) {
        if(var0 != null && var0.length != 0) {
            StringBuilder var1 = new StringBuilder();
            byte[] var2 = var0;
            int var3 = var0.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                byte var5 = var2[var4];
                String var6 = Integer.toHexString(255 & var5);
                if(var6.length() < 2) {
                    var6 = "0" + var6;
                }

                var1.append(var6);
            }

            return var1.toString();
        } else {
            return "";
        }
    }

}
