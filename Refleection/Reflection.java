import java.beans.Expression;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflecion {
    public static void main(String[] args) throws Exception {
        String path = "java.lang." + args[0];
        Class c = Class.forName(path);
        Method[] m = c.getDeclaredMethods();
        System.out.println("Methods in " + args[0]);
        for (Method m1 : m) {
            System.out.println(m1.getName());
        }
        Field[] feild = c.getDeclaredFields();
        System.out.println("Fields of " + args[0]);
        for (Field f : feild) {
            System.out.println(f.getName());
        }
    }

}
