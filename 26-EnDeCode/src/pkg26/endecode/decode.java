/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg26.endecode;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;
/**
 *
 * @author asus
 */
public class decode {
    public static void main(String[] args) {
            try {
            // Đọc file chứa private key
            FileInputStream fis = new FileInputStream("D:\\Java\\26-EnDeCode\\File\\priKey.bin");
            byte[] b = new byte[fis.available()];
            fis.read(b);
            fis.close();

            // Tạo private key
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            PrivateKey priKey = factory.generatePrivate(spec);

            // Giải mã dữ liệu
            Cipher c = Cipher.getInstance("RSA");
            c.init(Cipher.DECRYPT_MODE, priKey);
            byte decryptOut[] = c.doFinal(Base64.decode("PonpLy0NpR9+S7o399KZYTWqKTGcoCOzOtLnfdduTXUiQwMfhPAbn8TxtmcDwb/VGiPv3tlRhIWqUvbsIttSdT9F+IZWLvBn2TZrTADgfLJ38L9unWNKXQF/Z5ZS+PWLC+jmMBGPLsc2vYtaGAbCDTGNYzxWBZEKNHYuoONsuizmV7kayfOpt6dsJm/7TrTeogQCUnuC5X/raTY+c0AheeGnkpwmx0N/gyY9YPiztj4PcIwPChHHtsJ437iy/OxgMBZpC1zH5FORDLUtVI6vjKE5Sezj+MVumObs684YRBE+N7RfobE3PWBIkNVhOo+3sArI8QfTzkgAyUuCUZaGSg=="));
            System.out.println("Dữ liệu sau khi giải mã: " + new String(decryptOut));
       } catch (Exception ex) {
        ex.printStackTrace();
       }
    }
}
