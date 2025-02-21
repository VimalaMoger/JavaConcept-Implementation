package exception;

public class NestedTry {
    public static void main(String[] args) {
        try{
            int a = args.length;   //0
            int b = 42/a;
            System.out.println("a "+ a);
            try{
                if(a==1)
                    a = a/(a-a);  //division by zero
                if(a == 2){
                    int c[] = {1};
                    c[42] = 99;
                }
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Array index out of bounds "+e);
            }
        }catch(ArithmeticException e){
            System.out.println("Arithmatic exception: Divide by zero "+e);
        }
    }
}
