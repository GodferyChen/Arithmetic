package sample;

import java.security.MessageDigest;

/**
 * Created by chen on 2017/4/28.
 */
public class MyMD5 {

    static char[] hex = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

    public static void main(String[] args) {
//        try {
//            MessageDigest md5 = MessageDigest.getInstance("MD5");
//            md5.update("a".getBytes());
//            System.out.println("md5(a)="+byte2str(md5.digest()));
//            md5.update("a".getBytes());
//            md5.update("bc".getBytes());
//            System.out.println("md5(abc)="+byte2str(md5.digest()));
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
        System.out.println("pass(123456) = "+getMD5("123456"));
    }

    private static String byte2str(byte[] bytes){
        int len = bytes.length;
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < len; i++) {
            byte byte0 = bytes[i];
            result.append(hex[byte0 >>> 4 & 0xf]);
            result.append(hex[byte0 & 0xf]);
        }
        return result.toString();
    }

    public static String getMD5(String pwd) {
        //将字符串转换为字节数组
        byte[] toChapter = pwd.getBytes();
        //md5str用来保存字节数组转换成的十六进制数
        StringBuffer md5str = new StringBuffer();
        try{
            //得到一个实现特定摘要算法的消息摘要对象
            MessageDigest md5 = MessageDigest.getInstance( "MD5" );
            //将字节数组toChapter添加到待计算MD5值的字节序列中
            md5.update(toChapter);
            //计算字节序列的MD5值，返回16个字节的字节数组，保存到toChapterDigest
            byte[] toChapterDigest = md5.digest();
            System.out.println("MyMD5.getMD5 " + toChapterDigest.length);

            //每个8位的二进制字节用十六进制表示的话，需要两个字符，每个十六进制字符对应四位二进制位
            //故16个字节(128bit)转换后，变为了32个字符的字符串，将它们添加到md5str中

            int digital;
            for (int i = 0; i <toChapterDigest.length; i++) {
                digital =toChapterDigest[i];
                //这里字节类型赋值给int类型，会按符号位扩展的
                //如果字节的最高位是1，扩展为int时它的高位(9-32位)都会变为1
                if(digital < 0) {
                    //将8位字节之前的高位全变为0
                    digital += 256;
                }
                if(digital < 16){
                    md5str.append("0");
                }
                //经过判断之后的操作，能保证digtal转换为十六进制字符的时候只得到两位
                md5str.append(Integer.toHexString(digital));
            }
        }catch( Exception e ) {
            e.printStackTrace();
        }
        //返回十六进制字符串
        return md5str.toString();
    }

}
