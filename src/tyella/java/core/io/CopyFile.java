package tyella.java.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import org.apache.commons.io.FileUtils;


public class CopyFile {

    private static final int BUFFER_SIZE = 4096;

    /**
     * 使用流拷贝文件
     *
     * @param source 文件来源
     * @param dest   目的文件
     * @throws IOException IoException
     */
    public static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[BUFFER_SIZE];
            int length = 0;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found,file path is:" + source.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                os.close();
            }
            if (is != null) {
                is.close();
            }
        }
    }

    /**
     * 使用FileChannel拷贝文件
     *
     * @param source 文件来源
     * @param dest   文件目的地
     * @throws IOException IoException
     */
    public static void copyFileUsingChannel(File source, File dest) throws IOException {
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destChannel = new FileOutputStream(dest).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        } finally {
            if (destChannel != null) {
                destChannel.close();
            }
            if (sourceChannel != null) {
                sourceChannel.close();
            }
        }
    }

    /**
     * 使用FileUtils拷贝文件
     *
     * @param source 源文件
     * @param dest   目的文件
     * @throws IOException IoException
     */
    public static void copyFileUsingApacheCommonsIO(File source, File dest) throws IOException {
        FileUtils.copyFile(source, dest);
    }

    /**
     * 使用Java自带的方法拷贝文件
     *
     * @param source 源文件
     * @param dest   目的文件
     * @throws IOException IOException
     */
    public static void copyFileUsingJavaFiles(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath());
    }


}
