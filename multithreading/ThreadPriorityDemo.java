package multithreading;

public class ThreadPriorityDemo implements Runnable{
    int click = 0;
    Thread t;
    private volatile boolean running = true;

    ThreadPriorityDemo(int p){
        t = new Thread(this);
        System.out.println("Child thread name "+ t);
        t.setPriority(p);
        t.start();
    }

    @Override
    public void run() {
        while (running){
            click++;
        }
    }

    public void stop(){
        running = false;
    }

    public void resume(){
        running = true;
        //t.start();
    }
    public static void main(String[] args) {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        ThreadPriorityDemo highPriorityThread = new ThreadPriorityDemo(Thread.NORM_PRIORITY+2);
        ThreadPriorityDemo lowPriorityThread = new ThreadPriorityDemo(Thread.NORM_PRIORITY-2);

      /*  try{
            //wait for other child threads to end
            Thread.sleep(10000);
        }catch (InterruptedException e){
            System.out.println("Main thread interrupted " +Thread.currentThread());
        }
        System.out.println("Main thread exiting .."+Thread.currentThread());*/

        highPriorityThread.stop();
        lowPriorityThread.stop();

        //wait for child thread to finish
        try{
            highPriorityThread.t.join();
            lowPriorityThread.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted "+Thread.currentThread());
        }

        System.out.println("High priority thread ran "+ highPriorityThread.click +"..is currently set to "+ highPriorityThread.t.getPriority());
        System.out.println("Low priority thread ran "+ lowPriorityThread.click +"..is currently set to "+ lowPriorityThread.t.getPriority());
        System.out.println("Main thread is currently set to "+ Thread.currentThread().getPriority());
    }
}

