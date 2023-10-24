import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.*;
import java.util.Scanner;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;

class Encrypt{
  static IvParameterSpec ivParameterSpec;
  static String password;
  static String salt;   

    
    public static  String encrypt () throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter password");
        password = scanner.nextLine();
        System.out.println("enter salt");
        salt = scanner.nextLine();
        System.out.println("enter message");
        String plainText = scanner.nextLine();
        scanner.close();
        ivParameterSpec = AESUtil.generateIv();
        SecretKey key = AESUtil.getKeyFromPassword(password,salt);
        String cipherText = AESUtil.encryptPasswordBased(plainText, key, ivParameterSpec);
      return cipherText;
    }
      public static String decrypt(String cipherText) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException{

        SecretKey key = AESUtil.getKeyFromPassword(password,salt);
        String decryptedCipherText = AESUtil.decryptPasswordBased(
          cipherText, key, ivParameterSpec);
          return decryptedCipherText;
    }
    public static void main(String[] args) throws InvalidKeyException, InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException {
      String cipherText = encrypt();
      System.out.println(cipherText);
      String decodedText = decrypt(cipherText);
      System.out.println(decodedText);
    }


  }