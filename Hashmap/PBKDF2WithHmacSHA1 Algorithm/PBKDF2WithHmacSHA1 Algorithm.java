import java.security.*;  
import java.math.BigInteger;  
import java.security.MessageDigest;  
import java.nio.charset.StandardCharsets;  
import javax.crypto.spec.PBEKeySpec;   
import javax.crypto.SecretKeyFactory;  
import java.security.spec.InvalidKeySpecException;  
  
public class PBKDF2WithHmacSHA1   
{  
    // main method  
    public static void main(String argvs[]) throws NoSuchAlgorithmException, InvalidKeySpecException   
    {  
        // password to be hashed  
        String  orgPassword = "@JavaTpoint";  
          
        String createdSecuredPasswordHash = createStrongPasswordHash(orgPassword);  
        System.out.println(createdSecuredPasswordHash);  
    }  
      
  
    private static String createStrongPasswordHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException  
    {  
        // number of iteration used  
        int itr = 500;  
        char[] charArr = password.toCharArray();  
        byte[] saltArr = obtainSalt();  
           
        PBEKeySpec pbeSpec = new PBEKeySpec(charArr, saltArr, itr, 64 * 8);  
          
        // using PBKDF2WithHmacSHA1 for hashing  
        SecretKeyFactory secKeyFact = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");  
        byte[] hashArr = secKeyFact.generateSecret(pbeSpec).getEncoded();  
        return itr + ": " + intoHex(saltArr) + ":" + intoHex(hashArr);  
    }  
       
       
    // getting the salt   
    private static byte[] obtainSalt() throws NoSuchAlgorithmException  
    {  
        SecureRandom secRand = SecureRandom.getInstance("SHA1PRNG");  
        byte[] saltArr = new byte[16];  
        secRand.nextBytes(saltArr);  
        return saltArr;  
    }  
       
       
     // converting into hexadecimal  
    private static String intoHex(byte[] arr) throws NoSuchAlgorithmException  
    {  
        BigInteger bInt = new BigInteger(1, arr);  
        String hexStr = bInt.toString(16);  
        int paddingLen = (arr.length * 2) - hexStr.length();  
        if(paddingLen > 0)  
        {  
            return String.format("%0"  + paddingLen + "d", 0) + hexStr;  
        }  
        else  
        {  
            return hexStr;  
        }  
    }  
}  
