package multithreading;

public class SuspendResumeExample implements Runnable{
    String name;
    Thread t;
    boolean running;

    SuspendResumeExample(String name){
        this.name = name;
        t = new Thread(this, name);
        System.out.println("New thread "+t);
        System.out.println();
        t.start();
    }

    public void suspendThread(){
        running = true;
    }

    synchronized void resumeThread(){
        running = false;
        notify();
    }

    @Override
    public void run() {
            try {
                for (int i = 5; i > 0; i--) {
                    System.out.println(name + "- this thread in run state: " + i);
                    Thread.sleep(200);
                    synchronized (this) {
                        while (running) {
                            wait();
                        }
                    }
                }
            }catch (InterruptedException e) {
                System.out.println(name + " interrupted");
            }
            System.out.println(name + " exiting ");
    }

    public static void main(String[] args) {
        SuspendResumeExample t1 = new SuspendResumeExample("One ");
        SuspendResumeExample t2 = new SuspendResumeExample("Two ");

        try{
            Thread.sleep(1000);

            t1.suspendThread();
            System.out.println("t1 supended.. "+t1.running);

            Thread.sleep(1000);
            t1.resumeThread();

            Thread.sleep(1000);

            t2.suspendThread();
            System.out.println("t2 suspended.. "+t2.running);

            Thread.sleep(1000);
            t2.resumeThread();

        }catch (InterruptedException e){
            System.out.println(" Main thread got interrupted");
        }

        //wait other thread to finish
        try{
            t1.t.join();
            t2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted "+Thread.currentThread());
        }
    }
}

