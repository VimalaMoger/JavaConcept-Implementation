package HackerRank;

public class SingletonPattern {
    private static SingletonPattern instance = null;
    public String str;

    private SingletonPattern(){}

    public static SingletonPattern getInstance(){
        if(instance == null)
           instance = new SingletonPattern();
        return instance;
    }

    public static void main(String[] args) {
        SingletonPattern pattern = SingletonPattern.getInstance();
        pattern.str = "Hello world ";
        SingletonPattern pattern1 = SingletonPattern.getInstance();
        pattern1.str = "I am Singleton";

        System.out.println(pattern.str);   //will store latest update made to the pattern
        System.out.println(pattern1.str);

        System.out.println(pattern1.hashCode());
        System.out.println(pattern.hashCode());
    }
}
