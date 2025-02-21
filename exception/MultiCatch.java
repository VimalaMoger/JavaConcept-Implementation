package exception;

public class MultiCatch {
    public static void main(String[] args) {
        try{
            int a = args.length;   // 0
            System.out.println("a = "+ a);
            int b = 42/a;
            int c[] ={1};
            c[42] =  99;
        }catch (ArithmeticException e){
            System.out.println("Devide by zero "+ e);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array index out of bounds "+ e);
        }catch (Exception e){
            System.out.println("Handled by Exception class "+ e);
        }
    }
}
