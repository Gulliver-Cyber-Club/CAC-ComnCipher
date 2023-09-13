import java.security.spec.KeySpec;
import java.util.Scanner;
import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.print.DocFlavor.CHAR_ARRAY;
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
        byte[] salt = FileImputStream("saltBytes.txt");
        Scanner.close();
        return salt;
    }
    public static void main(String[] args){
        char[] password = password();
        byte[] salt = salt();
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(password, salt, 65536, 256);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");
    }
}
