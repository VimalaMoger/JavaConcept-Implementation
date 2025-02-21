package multithreading;

public class MultithreadsInExample implements Runnable {
    String name;
    Thread t;
    MultithreadsInExample(String name){
        this.name = name;
        t =  new Thread(this, name);
        System.out.println("Child thread name "+ t);
        t.start();
    }

    @Override
    public void run() {
        try{
            for(int i=5; i>0; i--){
                System.out.println(name+"- Child thread "+i +"............."+Thread.currentThread());
                Thread.sleep(500);
            }
        }catch (InterruptedException e) {
            System.out.println(name+"- interrupted "+ Thread.currentThread());
        }
        System.out.println(name +"- is exiting ");
    }

    public static void main(String[] args) {
        MultithreadsInExample one = new MultithreadsInExample("One");
        MultithreadsInExample two = new MultithreadsInExample("Two");
        MultithreadsInExample three = new MultithreadsInExample("Three");

        System.out.println("Thread one is alive "+ one.t.isAlive());
        System.out.println("Thread two is alive "+ two.t.isAlive());
        System.out.println("Thread three is alive "+ three.t.isAlive());

        try{
            System.out.println("Wait for threads to finish.. ");
            one.t.join();
            two.t.join();
            three.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted "+Thread.currentThread());
        }

        System.out.println("Thread one is alive "+ one.t.isAlive());
        System.out.println("Thread two is alive "+ two.t.isAlive());
        System.out.println("Thread three is alive "+ three.t.isAlive());

        System.out.println("Main thread exiting .."+Thread.currentThread());

       /* try{
            //wait for other child threads to end
            Thread.sleep(10000);
        }catch (InterruptedException e){
            System.out.println("Main thread interrupted " +Thread.currentThread());
        }
        System.out.println("Main thread exiting .."+Thread.currentThread());*/

    }
}
