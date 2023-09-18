import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Scanner;
import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
class Encrypt{
    public static  char[] password(){
        System.out.println("enter password");
        Scanner scanner = new Scanner(System.in);
        char[] password = scanner.next().toCharArray();
        scanner.close();
        return password;
    }
    public static byte[] salt(){
        try (FileInputStream FileInputStream = new FileInputStream("saltBytes.txt")) {
            byte[] salt = FileInputStream.readAllBytes();
            return salt;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException{
        char[] password = password();
        byte[] salt = salt();
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(password, salt, 65536, 256);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");
    }
}
