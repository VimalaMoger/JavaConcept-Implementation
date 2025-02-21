package exception;

public class CustomException extends Exception{
    private int detail;
    CustomException(int a){
        detail = a;
    }
    public String toString(){
        return "MyException[" + detail + "]";
    }

    public static void main(String[] args){
        try {
            ExceptionDemo.compute(11);
        } catch (CustomException e) {
            throw new RuntimeException(e);
        }
    }
}

class ExceptionDemo{
    static void compute(int a) throws CustomException {
        System.out.println("Called compute(" + a + ")");
        if (a > 10)
            throw new CustomException(a);
        System.out.println("Normal exit ");
    }
}


