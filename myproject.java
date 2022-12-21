
import java.lang.reflect.Method;

public class myproject {
  public static void main(String[] args) throws Exception {
        byte[] key={76,110,22,-34,12,-43,23,-23,-45,29,112,12,34,23,-98,76};  
        encrptedClassLoader myClasLoader= new encrptedClassLoader();
 Class<?>dynamiClass=myClasLoader.findClass("hello", key);
Method m =dynamiClass.getMethod("main",String[].class);
 m.invoke(null,new Object[]{null});

}
}
