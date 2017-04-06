package sport.tc.com.encryptutil;

import java.security.MessageDigest;

/**
 * Created by punisher on 2017/3/2.
 */

public class MD5Encrypt {
    public static String md5(String string) {
        try {
            byte[] hash;
            try {
                hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
            } catch (Exception e) {
                throw new RuntimeException("Huh, MD5 should be supported?", e);
            }

            StringBuilder hex = new StringBuilder(hash.length * 2);
            for (byte b : hash) {
                if ((b & 0xFF) < 0x10) hex.append("0");
                hex.append(Integer.toHexString(b & 0xFF));
            }
            return hex.toString();
        } catch (Exception e) {
            System.out.println("Md5 parse failded");
            return string;
        }
    }
}
