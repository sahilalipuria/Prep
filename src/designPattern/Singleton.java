package designPattern;

/**
 * @author salipuri
 *
 *
One of the key challenges faced by junior developers is the way to keep Singleton class as Singleton i.e. the way to prevent multiple instances of Singleton class.

Double checked locking of Singleton is a way to make sure that only one instance of Singleton class is created through an application life cycle.

In double-checked locking, code checks for an existing instance of Singleton class twice with and without locking to make sure that only one instance of singleton gets created.

The above code will create multiple instances of Singleton class if called by more than one thread in parallel(known as multithreading).
The primary solution to the current problem will be to make getInstance() method synchronized.
Though it’s thread-safe and solves the issue of multiple instances, it isn’t very efficient. You need to bear cost of synchronization every time you call this method, while synchronization is only needed on first class, when Singleton instance is created.
This brings us to double checked locking pattern, where only a critical section of code is locked.

Why is it called Double Checked Locking?

It is called double-checked locking because there are two checks for instance == null, one without locking and other with locking (inside synchronized) block.
 *
 */

public class Singleton {

    private static volatile Singleton instance;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }

        return instance;
    }

    public static synchronized Singleton getInstance2(){
        if(instance == null){
            instance = new Singleton();
        }

        return instance;
    }

    public static Singleton getInstance3(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null)
                    instance = new Singleton();
            }
        }

        return instance;
    }
    public static void main(String[] args) {
        Singleton instance1 = getInstance();
        System.out.println(instance1.toString());
        Singleton instance2 = getInstance();
        System.out.println(instance2.toString());
        Singleton instance3 = getInstance2();
        System.out.println(instance1.toString());
        Singleton instance4 = getInstance2();
        System.out.println(instance2.toString());
        Singleton instance5 = getInstance3();
        System.out.println(instance1.toString());
        Singleton instance6 = getInstance3();
        System.out.println(instance2.toString());
    }
}
