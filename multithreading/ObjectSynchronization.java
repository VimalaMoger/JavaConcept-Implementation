package multithreading;

public class ObjectSynchronization {

    synchronized void call(String str){
        System.out.println("[" + str);
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        ObjectSynchronization obj = new ObjectSynchronization();
        ThreadClass t = new ThreadClass(obj, "call ");
        ThreadClass tt = new ThreadClass(obj, "my ");
        ThreadClass ttt = new ThreadClass(obj, "method");
        try{
            t.t.join();
            tt.t.join();
            ttt.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted " +e);
        }
        System.out.println("Main thread exiting ..");
    }
}


class ThreadClass implements Runnable{
    String str;
    ObjectSynchronization obj;
    Thread t;

    ThreadClass(ObjectSynchronization obj, String str){
        this.str = str;
        this.obj = obj;
        t = new Thread(this);
        t.start();
    }
    @Override
    public void run() {
        synchronized (obj) {
            obj.call(str);
        }
    }

}
