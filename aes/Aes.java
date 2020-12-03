import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;
import java.io.UnsupportedEncodingException;

public class Aes {
    private static String ivParameter = "0123456789abcdef"; //向量参数
    private static final String KEY_MD5 = "MD5";
    private static MessageDigest md5Digest;
    static {
        try {
            md5Digest = MessageDigest.getInstance(KEY_MD5);
                        
        } catch (NoSuchAlgorithmException e) {

                
        }
        
    }

    public static SecretKeySpec strKey2SecretKey(String key) throws UnsupportedEncodingException {
        byte[] bytes = key.getBytes("utf-8");
        //SecretKeySpec secretKey = new SecretKeySpec(bytes, "AES");
        SecretKeySpec secretKey = new SecretKeySpec(md5Digest.digest(bytes), "AES");
        return secretKey;
    }

    public static String encrypt(String content, String key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        byte[] bytes = encryptAES(content.getBytes("utf-8"), strKey2SecretKey(key));
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static byte[] encryptAES(byte[] content, SecretKeySpec secretKey)throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException, UnsupportedEncodingException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes("utf-8"));
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        return cipher.doFinal(content);
    }

    public static String decrypt(String content, String key)  throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        byte[] bytes = Base64.getDecoder().decode(content);
        byte[] data = decryptAES(bytes, strKey2SecretKey(key));
        return new String(data, "utf-8");
    }

    public static byte[] decryptAES(byte[] content, SecretKeySpec secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException, UnsupportedEncodingException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes("utf-8"));
        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        return cipher.doFinal(content);
    }

    public static void main(String[] args) {
        String content = "{\"uid\":2,\"exp\":\"2020-01-01 00:00:01\"}";
        System.out.println("raw data is: " + content);
        String key = "0123456789abcdef";
        System.out.println("key is: " + key);
        try {
            String result = encrypt(content, key);
            System.out.println("encrypt data is: " + result);
            String source = decrypt(result, key);
            System.out.println("decrypt data is: " + source);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
