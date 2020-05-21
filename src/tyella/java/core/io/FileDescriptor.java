package tyella.java.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileDescriptor {

    public static void main(String[] args) throws FileNotFoundException {
        int i = 0;
        try {
            File file = new File("D:\\apidoc\\main.js");
            for (i = 0; i < 2000; i++) {
                InputStream inputStream = new FileInputStream(file);
                System.out.println("i = " + i);
                if (i % 1000 == 0) {
                    System.out.println("i/1000=" + i / 1000);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Exception,and i=" + i);
            throw e;
        }
    }
}
