import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;

class Encrypt{
  IvParameterSpec ivParameterSpec;
  String salt;   

    
    public void encrypt (String p, String s, String plaintext) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException {
        String password = p;
        salt =s;
        String plainText = plaintext;
        ivParameterSpec = AESUtil.generateIv();
        SecretKey key = AESUtil.getKeyFromPassword(password,salt);
        String cipherText = AESUtil.encryptPasswordBased(plainText, key, ivParameterSpec);
      System.out.print(cipherText);
    }
      public void decrypt(String password, String s, String cipherText) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException{
        String salt = s;
        SecretKey key = AESUtil.getKeyFromPassword(password,salt);
        String decryptedCipherText = AESUtil.decryptPasswordBased(
          cipherText, key, ivParameterSpec);
          System.out.print(decryptedCipherText);
    }

  }