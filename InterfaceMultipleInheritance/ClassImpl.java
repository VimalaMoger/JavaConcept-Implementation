package InterfaceMultipleInheritance;

public class ClassImpl implements InterfaceTwo, InterfaceOne{
    @Override
    public void show() {
        System.out.println("Show One called");
    }

    @Override
    public void print() {
        System.out.println("Show two called");
    }
}

interface InterfaceOne {
    void show();
}

interface InterfaceTwo {
    void print();
}
