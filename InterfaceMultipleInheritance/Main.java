package InterfaceMultipleInheritance;

public class Main {
    public static void main(String[] args) {
        InterfaceOne one = new ClassImpl();
        one.show();

        InterfaceTwo two = new ClassImpl();
        two.print();
    }
}
