import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.*;
import java.util.Scanner;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;

class Encrypt{
  IvParameterSpec ivParameterSpec;
  String password;
  String salt;   

    
    public  String encrypt () throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException {
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
      public String decrypt(String cipherText) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException{

        SecretKey key = AESUtil.getKeyFromPassword(password,salt);
        String decryptedCipherText = AESUtil.decryptPasswordBased(
          cipherText, key, ivParameterSpec);
          return decryptedCipherText;
    }
  }