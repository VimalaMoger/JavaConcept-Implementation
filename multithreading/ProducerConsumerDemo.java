package multithreading;

public class ProducerConsumerDemo {

    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
        System.out.println("Press Cntl + c to stop");
    }
}

class Q{
    int n;
    boolean valueSet = false;

    synchronized int get(){
        if(!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(this + "Interrupted");
            }
        }
        System.out.println("Value is retrieved ");
        valueSet = false;
        notify();

        return n;
    }
    synchronized void put(int n){
        if(valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(this + "Interrupted");
            }
        }
        valueSet = true;
        notify();
        this.n = n;
        System.out.println("Value is added "+n);
    }
}

class Producer implements Runnable{
    Q q;
    Producer(Q q){
        this.q = q;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        int i = 0;
        while(true)
            q.put(i++);
    }
}

class Consumer implements Runnable{
    Q q;
    Consumer(Q q){
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        int i = 0;
        while(true)
            q.get();
    }
}
