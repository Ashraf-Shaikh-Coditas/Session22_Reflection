package Week5.Session22;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class CatPrivate
{
    private String color;

    private void show() {
        System.out.println("This cat has "+color+" color.");
    }
}
public class MainPrivateData {

    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        CatPrivate c = new CatPrivate();
        Class obj = c.getClass();
//        access fields of class and print details
        Field field1=obj.getDeclaredField("color");
        field1.setAccessible(true);
        field1.set(c, "frawn");
        System.out.println("The color of cat is :: "+field1.get(c));


        //modifier
        int modifier=field1.getModifiers();
        String mod= Modifier.toString(modifier);
        System.out.println("Modifier field is::"+mod);

        Method m1 = obj.getDeclaredMethod("show");
        m1.setAccessible(true);
        m1.invoke(c);

        int modifier2 = m1.getModifiers();
        String mod2 = Modifier.toString(modifier2);
        System.out.println("Modifier of method is::"+mod2);


    }

}

/*

The color of cat is :: frawn
Modifier field is::private

This cat has frawn color.
Modifier of method is::private

* */