package bankmanagementsytem;

import java.sql.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Conn {
    Connection c;
    Statement s;

    // 16-character secret key (AES-128)
    private static final String SECRET_KEY = "1234567890abcdef";

    private String decrypt(String encryptedText) throws Exception {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decoded = Base64.getDecoder().decode(encryptedText);
        byte[] decrypted = cipher.doFinal(decoded);
        return new String(decrypted);
    }

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Encrypted "root" and "yourpassword" (example)
            String encryptedUser = "OlCVQ+Ik+3KlL5wgnVj51Q==";     // encrypted "root"
            String encryptedPass = "GFScEk+5hgADrWH4DDnQ2g==";     // encrypted "password"

            String username = decrypt(encryptedUser);
            String password = decrypt(encryptedPass);

            // Secure SSL connection (optional, if your DB supports it)
            String url = "jdbc:mysql://localhost:3306/bankmanagementsystem?useSSL=true&requireSSL=false";

            c = DriverManager.getConnection(url, username, password);
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
