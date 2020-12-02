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
import java.io.UnsupportedEncodingException;

public class Aes {
    private static String ivParameter = "0123456789abcdef"; //向量参数

    public static SecretKeySpec strKey2SecretKey(String key) {
        byte[] bytes = key.getBytes();
        SecretKeySpec secretKey = new SecretKeySpec(bytes, "AES");
        return secretKey;
    }

    public static String encrypt(String content, String key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        byte[] bytes = encryptAES(content.getBytes("utf-8"), strKey2SecretKey(key));
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static byte[] encryptAES(byte[] content, SecretKeySpec secretKey)throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        return cipher.doFinal(content);
    }

    public static String decrypt(String content, String key)  throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        byte[] bytes = Base64.getDecoder().decode(content);
        byte[] data = decryptAES(bytes, strKey2SecretKey(key));
        return new String(data, "utf-8");
    }

    public static byte[] decryptAES(byte[] content, SecretKeySpec secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        return cipher.doFinal(content);
    }

    public static void main(String[] args) {
        String content = "{\"uid\":2,\"exp\":\"2020-01-01 00:00:00\"}";
        System.out.println("明文数据：" + content);
        String key = "0123456789abcdef";
        System.out.println("key is:" + key);
        try {
            String result = encrypt(content, key);
            System.out.println("encrypt data is:" + result);
            String source = decrypt(result, key);
            System.out.println("decrypt data is:" + source);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
