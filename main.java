import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Scanner;
import java.lang.Object;
import javax.xml.bind.DatatypeConverter;
class Encrypt{
  
    public static void main(String[] args){
        System.out.println("enter memsecret");
        Scanner scanner = new Scanner(System.in);
String password = scanner.nextLine();
scanner.close();

MessageDigest digest = null;
digest = MessageDigest.getInstance("SHA-256");
byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
String encoded = DatatypeConverter.printHexBinary(hash);        
System.out.println(encoded.toLowerCase());
    }

}
