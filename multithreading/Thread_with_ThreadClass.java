package multithreading;

public class Thread_with_ThreadClass extends Thread{
    Thread_with_ThreadClass(){
        super("Child Thread ");
        System.out.println("Child thread "+ this);
        start();
    }
    //entry point for the second thread
    public void run(){
        try{
            for(int i=5; i>0; i--){
                System.out.println("Child thread "+i);
                Thread.sleep(500);
            }
        }catch (InterruptedException e) {
            System.out.println(" Child interrupted ");
        }
        System.out.println("Child is exiting ");
    }

    public static void main(String[] args) {
        new Thread_with_ThreadClass();
        try{
            for(int i=5; i>0; i--){
                System.out.println("Main thread "+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread is interrupted "+Thread.currentThread());
        }
        System.out.println("Main thread exiting "+Thread.currentThread());
    }
}
