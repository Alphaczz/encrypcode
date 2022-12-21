
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class encrptedClassLoader extends ClassLoader {
   
    public Class<?> findClass(String className,byte[] key) throws Exception {
    Path file=Paths.get(className+".class");
    byte[] encryptedContent=Files.readAllBytes(file);
    Cipher decryption=Cipher.getInstance("AES");
    decryption.init(Cipher.DECRYPT_MODE,new SecretKeySpec(key,0,key.length,"AES"));
    byte[] content=decryption.doFinal(encryptedContent);
    

        return defineClass(className,content,0,content.length);
    }
}
