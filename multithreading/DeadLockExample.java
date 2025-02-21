package multithreading;

public class DeadLockExample implements Runnable{

    A a = new A();
    B b = new B();
    DeadLockExample(){
        Thread.currentThread().setName(" Main Thread");
        Thread t = new Thread(this, "racingThread ");
        t.start();
        a.foo(b);   ///get lock on A
    }
    @Override
    public void run() {
        b.bar(a);       //get lock on B
    }

    public static void main(String[] args) {
        new DeadLockExample();
    }
}

class A{
    synchronized void foo(B b){
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered A.foo");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("A is interrupted ");
        }

        System.out.println(name + "trying to call B's last() ");
        b.last();
    }
    synchronized void last(){
        System.out.println("Inside A's last() ");
    }
}

class B{
    synchronized void bar(A a){
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered B.bar");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("B is interrupted ");
        }

        System.out.println(name + "trying to call A's last() ");
        a.last();
    }
    synchronized void last(){
        System.out.println("Inside B's last() ");
    }
}