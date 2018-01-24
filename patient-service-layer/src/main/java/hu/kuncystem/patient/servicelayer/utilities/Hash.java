package hu.kuncystem.patient.servicelayer.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * This class contains some security methods.
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. dec. 28.
 * 
 * @version 1.0
 */
public class Hash {
    /**
     * Create md5 hash string from normal string.<br />
     * <b>source:</b>
     * https://www.avajava.com/tutorials/lessons/how-do-i-generate-an-md5-digest-for-a-string.html
     * 
     * @param text
     *            A string which we want to convert
     * 
     * @return It will return md5 string for success otherwise it will return
     *         null.
     */
    public static final String MD5(String text) {

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(text.getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static final String BCrypt(String text){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(text);
    }
}
