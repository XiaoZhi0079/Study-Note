import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection{
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException {

        System.out.println("-----------------打印类对象-----------------");
        Class c = Dog.class;
        System.out.println(c.getSimpleName());

        System.out.println("-----------------打印全部的public构造器对象-----------------");

        Constructor[] con=c.getConstructors();
        for(Constructor ct:con) {
            System.out.println(ct);
        }

        System.out.println("------------------打印全部构造器对象----------------");

        Constructor[] con1=c.getDeclaredConstructors();
        for(Constructor ct:con1) {
            System.out.println(ct);
        }

        System.out.println("------------------打印接收String类的构造器----------------");

        Constructor con2=c.getDeclaredConstructor(String.class);
        System.out.println(con2);

        System.out.println("-----------------打印接收String,int,String类的构造器-----------------");

        Constructor con3=c.getConstructor(String.class, int.class,String.class);
        System.out.println(con3);

        System.out.println("------------------打印所有成员变量----------------");

        Field[] f=c.getDeclaredFields();
        for(Field ff:f){
            System.out.println(ff);
        }

        System.out.println("----------------打印public的成员变量--weight------------------");

        Field f1=c.getField("weight");
        System.out.println(f1);

        System.out.println("------------------打印不接收参数的eat方法对象----------------");

        Method m=c.getDeclaredMethod("eat");
        System.out.println(m);

        System.out.println("----------------打印接受int参数的eat方法对象------------------");

        Method m1=c.getDeclaredMethod("eat", int.class);
        System.out.println(m1);

        System.out.println("--------------使用接受String参数的构造器进行构造----------------");

        con2.setAccessible(true);//打开暴力反射开关
        Dog dog=(Dog)con2.newInstance("中华田园犬欢欢");
        System.out.println(dog);

        System.out.println("--------------使用成员变量weight对象进行赋值----------------");

        f1.setAccessible(true);//打开暴力反射开关
        f1.set(dog, 100);
        System.out.println(dog);

        System.out.println("--------------使用成员变量weight对象进行取值----------------");

        System.out.println(f1.get(dog));

        System.out.println("--------------使用方法对象m1进行方法调用----------------");

        m1.setAccessible(true);
        System.out.println(m1.invoke(dog, 100));
    }
}
