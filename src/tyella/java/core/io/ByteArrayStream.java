package tyella.java.core.io;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayStream {

    public static void byteArrayInputStream() throws IOException {
        byte[] buffer = {71, 69, 69, 75, 83};
        ByteArrayInputStream bais = null;
        try {
            bais = new ByteArrayInputStream(buffer);

            int number = bais.available();
            System.out.println("Use of available() method:" + number);

            // read()
            System.out.println("Char:" + (char) bais.read());
            System.out.println("Char:" + (char) bais.read());
            System.out.println("Char:" + (char) bais.read());

            // mark()
            bais.mark(0);

            bais.skip(1);
            System.out.println("mark() method comes to play");
            System.out.println("skip() method comes to play");
            System.out.println("Char:" + (char) bais.read());

            if (bais.markSupported()) {
                bais.reset();
                System.out.println("reset() invoked");
                System.out.println("Char:" + (char) bais.read());
                System.out.println("Char:" + (char) bais.read());
            } else {
                System.out.println("reset() method not supported.");
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            if (bais != null) {
                bais.close();
            }
        }
    }

    public static void byteArrayOutputStream() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = {'J', 'A', 'V', 'A'};
        for (byte b : buffer) {
            baos.write(b);
        }

        // size()
        int size = baos.size();
        System.out.println("use of size():" + size);

        String str = baos.toString();
        System.out.println("use of toString():" + str);

        String str1 = baos.toString("UTF-8");
        System.out.println("use of toString(String charSetName):" + str1);

        // reset
        baos.reset();
        System.out.println("use of reset()");

        String str2 = baos.toString();
        System.out.println("use of toString():" + str2);

        // close
        baos.close();
    }
}
