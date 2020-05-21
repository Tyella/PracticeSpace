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
     * ʹ���������ļ�
     *
     * @param source �ļ���Դ
     * @param dest   Ŀ���ļ�
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
     * ʹ��FileChannel�����ļ�
     *
     * @param source �ļ���Դ
     * @param dest   �ļ�Ŀ�ĵ�
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
     * ʹ��FileUtils�����ļ�
     *
     * @param source Դ�ļ�
     * @param dest   Ŀ���ļ�
     * @throws IOException IoException
     */
    public static void copyFileUsingApacheCommonsIO(File source, File dest) throws IOException {
        FileUtils.copyFile(source, dest);
    }

    /**
     * ʹ��Java�Դ��ķ��������ļ�
     *
     * @param source Դ�ļ�
     * @param dest   Ŀ���ļ�
     * @throws IOException IOException
     */
    public static void copyFileUsingJavaFiles(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath());
    }


}
