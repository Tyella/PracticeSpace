package test.tyella.java.core.io;

import java.io.File;
import org.junit.Test;
import tyella.java.core.io.CopyFile;

/**
 * CopyFile Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>5ÔÂ 11, 2020</pre>
 */
public class CopyFileTest {

    File sourceFile = new File("D:\\RIS3.3.7\\3.3.7-Snapshot1.vmem");
    File streamDestFile = new File("D:\\PracticeSpace\\fileTest\\3.3.7-Snapshot-Stream.vmem");
    File channelDestFile = new File("D:\\PracticeSpace\\fileTest\\3.3.7-Snapshot-channel.vmem");
    File apacheDestFile = new File("D:\\PracticeSpace\\fileTest\\3.3.7-Snapshot-apache.vmem");
    File filesDestFile = new File("D:\\PracticeSpace\\fileTest\\3.3.7-Snapshot-files.vmem");

    /**
     * Method: copyFileUsingStream(File source, File dest)
     */
    @Test
    public void testCopyFileUsingStream() throws Exception {
        long start = System.nanoTime();
        CopyFile.copyFileUsingStream(sourceFile, streamDestFile);
        System.out.println("Time taken by file stream using:" + (System.nanoTime() - start) / 1000);
    }

    /**
     * Method: copyFileUsingChannel(File source, File dest)
     */
    @Test
    public void testCopyFileUsingChannel() throws Exception {
        long start = System.nanoTime();
        CopyFile.copyFileUsingChannel(sourceFile, channelDestFile);
        System.out.println("Time taken by file channel using:" + (System.nanoTime() - start) / 1000);
    }

    /**
     * Method: copyFileUsingApacheCommonsIO(File source, File dest)
     */
    @Test
    public void testCopyFileUsingApacheCommonsIO() throws Exception {
        long start = System.nanoTime();
        CopyFile.copyFileUsingApacheCommonsIO(sourceFile, apacheDestFile);
        System.out.println("Time taken by apache using:" + (System.nanoTime() - start) / 1000);
    }

    /**
     * Method: copyFileUsingJavaFiles(File source, File dest)
     */
    @Test
    public void testCopyFileUsingJavaFiles() throws Exception {
        long start = System.nanoTime();
        CopyFile.copyFileUsingJavaFiles(sourceFile, filesDestFile);
        System.out.println("Time taken by files using:" + (System.nanoTime() - start) / 1000);
    }

}
