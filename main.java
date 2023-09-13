import java.security.spec.KeySpec;
import java.util.Scanner;
import javax.crypto.*;
import javax.crypto.spec.*;
class Encrypt{
  
 public static void main(String[] args){
 System.out.println("enter password");
 Scanner scanner = new Scanner(System.in);
String password = scanner.nextLine();
scanner.close();
System.out.println("enter salt");
 Scanner Scanner = new Scanner(System.in);
String salt = Scanner.nextLine();
Scanner.close();
SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
KeySpec spec = new PBEKeySpec(password, salt, 65536, 256);
SecretKey tmp = factory.generateSecret(spec);
SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");
}
}
