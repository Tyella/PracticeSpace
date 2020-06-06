package tyella.java.core.nio;

public class TimeServer {

    public static void main(String[] args) {

        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(8081);

        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
