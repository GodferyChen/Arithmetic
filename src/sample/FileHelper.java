package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by chen on 2017/6/14.
 */
public class FileHelper {

    public static void main(String[] args) {
        File file = new File("D://File/file.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
                PrintStream ps = new PrintStream(file);
                ps.println("哈哈哈哈哈");
                ps.append("呵呵呵呵呵");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            PrintStream ps = null;
            try {
                ps = new PrintStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ps.println("嘿嘿哈哈哈哈哈");
        }
    }

}
