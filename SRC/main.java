import java.security.NoSuchAlgorithmException;
import java.security.spec.*;
import java.util.Scanner;
import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
class Encrypt{
     

    public static  char[] message(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter message");
        String messageAsString = scanner.nextLine();
        char[] message = messageAsString.toCharArray();
        scanner.close();
        return message;
        }
    public static byte[] password(){
        Scanner scannerb = new Scanner(System.in); 
        System.out.println("enter password");
        String passwordAsString = scannerb.nextLine();
        byte[] password = passwordAsString.getBytes(StandardCharsets.UTF_8);
        scannerb.close();
        return password;
        }
        
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException{
        char[] message = message();
        byte[] password = password();
        try {
             SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
         KeySpec spec = new PBEKeySpec(message, password, 65536, 256);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");
        System.out.println(secret);
    } catch (Exception e) {
    }
    }
}
