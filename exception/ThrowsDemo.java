package exception;

public class ThrowsDemo {
    static void throwONe() throws IllegalAccessException {
        System.out.println("Inside throw one ");
        throw  new IllegalAccessException("demo ");
    }

    public static void main(String[] args) {
        try{
            throwONe();
        } catch (IllegalAccessException e) {
            System.out.println("Caught "+ e);
        }
    }
}
