package multithreading;

public class Thread_With_Runnable implements  Runnable{
    Thread t;

    Thread_With_Runnable(){
        t = new Thread(this, "Runnable Thread");
        System.out.println("Child Thread "+ t);
        t.start();
    }

    //entry point for the second thread
    @Override
    public void run() {
        try{
            for(int i=5; i>0; i--){
                System.out.println("Child thread "+ i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Child thread is interrupted "+Thread.currentThread());
        }
        System.out.println("Child thread exiting "+Thread.currentThread());

    }

    public static void main(String[] args) {
        new Thread_With_Runnable();
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
