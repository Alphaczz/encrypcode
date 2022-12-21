import java.io.*;
import java.nio.file.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
public class encryptCls {
    public static void main(String[] args) throws Exception{
        Path file=Paths.get("hello.class");
        byte[] content=Files.readAllBytes(file);
        Cipher encryption =Cipher.getInstance("AES");
        byte[] key={76,110,22,-34,12,-43,23,-23,-45,29,112,12,34,23,-98,76};
        encryption.init(Cipher.ENCRYPT_MODE,new SecretKeySpec(key,0,key.length,"AES"));
        byte[] encrytedContent=encryption.doFinal(content);
        FileOutputStream out =new FileOutputStream("hello.class");
        out.write(encrytedContent);
        out.close();
    }
}
