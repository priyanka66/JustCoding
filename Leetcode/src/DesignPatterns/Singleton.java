package DesignPatterns;

import java.io.*;
import java.lang.reflect.Constructor;
import java.security.Signature;

public class Singleton implements Serializable, Cloneable{

    private static Singleton instance = null;
    private Singleton() {
/* to avoid reflection errors
        if (instance != null) {
            throw new RuntimeException("Cannot create instance");
     }
*/        System.out.println("Creating Singleton");
    };

    public static Singleton getInstance() {
        if (instance == null) instance = new Singleton();
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private Object readResolve() throws ObjectStreamException {
        System.out.println(" read resolve");

        return instance;
    }
}

class TestClass {
    public static void main(String[] args) throws Exception{
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        print("s1",s1);
        print("s2", s2);

        //Reflection
        Class clazz = Class.forName("DesignPatterns.Singleton");
        Constructor<Singleton> ctor = clazz.getDeclaredConstructor();
        ctor.setAccessible(true);
        Singleton s3 = ctor.newInstance();
        print("Reflection s3", s3);


        //Serialization
        ObjectOutputStream  oos = new ObjectOutputStream(new FileOutputStream("/tmp/s1.ser"));
        oos.writeObject(s2);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/tmp/s1.ser"));
        Singleton s4 = (Singleton) ois.readObject();
        print("Serialisation s4" , s4);

        // Cloneable
        Singleton s5 = (Singleton)s2.clone();
        print("Clone - s5", s5);

        //

    }

    static void print(String name, Singleton object) {
        System.out.println(name + " " + " " + object.hashCode());
    }
}
