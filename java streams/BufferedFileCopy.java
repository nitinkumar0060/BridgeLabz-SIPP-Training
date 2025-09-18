import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        File source = new File("largefile.dat");
        File dest1 = new File("copy_unbuffered.dat");
        File dest2 = new File("copy_buffered.dat");

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest1)) {
            long start = System.nanoTime();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            long end = System.nanoTime();
            System.out.println("Unbuffered time: " + (end - start) / 1_000_000 + " ms");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest2))) {
            long start = System.nanoTime();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            long end = System.nanoTime();
            System.out.println("Buffered time: " + (end - start) / 1_000_000 + " ms");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
