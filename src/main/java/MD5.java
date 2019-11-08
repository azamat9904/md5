
import java.io.*;
import org.apache.commons.codec.digest.DigestUtils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    private final static String fileName = "C:\\Users\\azamatnamialy\\Desktop\\md5\\src\\main\\input.txt";
    private static String fileInformation = "";
    private static String hashText = "";
    public static void main(String[] args) {

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while(reader.ready())  fileInformation += reader.readLine() + "\n";
            int index = fileInformation.lastIndexOf("\n");
            fileInformation = fileInformation.substring(0,index);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(fileInformation.getBytes());
            BigInteger numbers = new BigInteger(1,messageDigest);
            hashText = numbers.toString(16);
            while (hashText.length() < 32)  hashText = "0" + hashText;
            System.out.println(hashText);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }
}
