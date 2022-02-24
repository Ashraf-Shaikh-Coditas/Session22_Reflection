package Week5.Session22;

import java.lang.reflect.*;

class Shape {
    void area() {
        System.out.println("This is Shape's area() .");
    }
}

class Rectangle extends Shape {
    int length,breadth;
    double area;

    public Rectangle() {
        System.out.println("Default Constructor");
    }

    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    void area(int length, int breadth) {
        System.out.println("This is Rectangle's area() .");
        area = length*breadth;
        System.out.println(" Area of Rectangle is "+area);
    }

    private void show() {
        System.out.println("This is a Rectangle .");
    }
}
public class ReflectionDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Rectangle r = new Rectangle();
        Class c_rObj = r.getClass();

        String name = c_rObj.getName();
        System.out.println("Class Name :: "+name);

        name = c_rObj.getCanonicalName();
        System.out.println("Cannonical Name :: "+name);

        name = c_rObj.getTypeName();
        System.out.println("Type  name :: "+name);

        name = c_rObj.getSimpleName();
        System.out.println("Simple  name :: "+name);

        name =c_rObj.getPackageName();
        System.out.println("Package name :: "+name);

        int modifier = c_rObj.getModifiers();
        String mod = Modifier.toString(modifier);
        System.out.println("Int modifier :: "+modifier);
        System.out.println("String modifier :: "+mod);

        Class superclass = c_rObj.getSuperclass();
        System.out.println("Superclass :: "+superclass);

        Constructor[] arrC = c_rObj.getDeclaredConstructors();
        for(Constructor c : arrC) {
            System.out.println("Name of Constructor is :: "+c.getName());
            System.out.println("Declaring class Name is :: "+c.getDeclaringClass());
            int modifier1 = c.getModifiers();
            String mod1 = Modifier.toString(modifier1);
            System.out.println("Modifier for constructor is :: "+mod1);
            System.out.println("Number of parameters is :: "+c.getParameterCount());
            System.out.println();
        }

        Constructor[] arrC1 = c_rObj.getConstructors();
        for(Constructor c : arrC1) {
            System.out.println("Name of Constructor is :: "+c.getName());
            System.out.println("Declaring class Name is :: "+c.getDeclaringClass());
            int modifier1 = c.getModifiers();
            String mod1 = Modifier.toString(modifier1);
            System.out.println("Modifier for constructor is :: "+mod1);
            System.out.println("Number of parameters is :: "+c.getParameterCount());
            System.out.println();
        }

        Method[] arrM = c_rObj.getDeclaredMethods();
        for(Method m : arrM) {
            System.out.println("Name of Method is :: "+m.getName());
            System.out.println("Declaring class Name is :: "+m.getDeclaringClass());
            int modifier1 = m.getModifiers();
            String mod1 = Modifier.toString(modifier1);
            System.out.println("Modifier for method is :: "+mod1);
            System.out.println("Number of parameters is :: "+m.getParameterCount());
            System.out.println();
        }

        System.out.println("..............METHOD INVOCATION ..................");
        Method m1 = c_rObj.getDeclaredMethod("area",int.class,int.class);
        m1.invoke(r,2,4);

        Field[] arrF = c_rObj.getDeclaredFields();
        for(Field f : arrF) {
            System.out.println("Name of field is :: "+f.getName());
            int modF = f.getModifiers();
            String modf = Modifier.toString(modF);
            System.out.println("Modifier of field is :: "+modf);
            System.out.println();
        }

        Field f1 = c_rObj.getDeclaredField("length");
        f1.set(r,4);
        System.out.println("Field value set by us :: "+f1.get(r));





    }
}

/*
Default Constructor
Class Name :: Week5.Session22.Rectangle
Cannonical Name :: Week5.Session22.Rectangle
Type  name :: Week5.Session22.Rectangle
Simple  name :: Rectangle

Package name :: Week5.Session22

Int modifier :: 0
String modifier ::

Superclass :: class Week5.Session22.Shape

Name of Constructor is :: Week5.Session22.Rectangle
Declaring class Name is :: class Week5.Session22.Rectangle
Modifier for constructor is :: public
Number of parameters is :: 0

Name of Constructor is :: Week5.Session22.Rectangle
Declaring class Name is :: class Week5.Session22.Rectangle
Modifier for constructor is :: public
Number of parameters is :: 2

Name of Constructor is :: Week5.Session22.Rectangle
Declaring class Name is :: class Week5.Session22.Rectangle
Modifier for constructor is :: public
Number of parameters is :: 0

Name of Constructor is :: Week5.Session22.Rectangle
Declaring class Name is :: class Week5.Session22.Rectangle
Modifier for constructor is :: public
Number of parameters is :: 2

Name of Method is :: show
Declaring class Name is :: class Week5.Session22.Rectangle
Modifier for method is :: private
Number of parameters is :: 0

Name of Method is :: area
Declaring class Name is :: class Week5.Session22.Rectangle
Modifier for method is ::
Number of parameters is :: 2

..............METHOD INVOCATION ..................
This is Rectangle's area() .
Area of Rectangle is 8.0

Name of field is :: length
Modifier of field is ::

Name of field is :: breadth
Modifier of field is ::

Name of field is :: area
Modifier of field is ::

Field value set by us :: 4


* */