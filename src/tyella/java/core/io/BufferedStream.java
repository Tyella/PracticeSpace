package tyella.java.core.io;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferedStream {

    public static void input(){
        InputStream inputStream=new BufferedInputStream(new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        });

    }
}
