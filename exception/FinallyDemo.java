package exception;

public class FinallyDemo {
    //throw an exception out of method
    static void ProcA(){
        try{
            System.out.println("Inside procA ");
            throw new RuntimeException("demo ");
        }finally {
            System.out.println("proc A finally ");
        }
    }

    static void ProcB(){
        try{
            System.out.println("Inside Proc B");
            return;    //return from within try block
        }finally{
            System.out.println("Proc B finally");
        }
    }

    //execute a try block normally
    static void ProcC(){
        try{
            System.out.println("Inside Proc C");
        }finally{
            System.out.println("Proc C finally ");
        }
    }

    public static void main(String[] args) {
        try{
            ProcA();
        }catch(Exception e){
            System.out.println(" Exception caught "+ e);
        }
        ProcB();
       ProcC();
    }
}
