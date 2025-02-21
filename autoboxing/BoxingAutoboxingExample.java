package autoboxing;
public class BoxingAutoboxingExample {

    static int autoConversion(Integer v){
        return v;           //java 5 feature - autoboxing available
    }

    static void IntegerToInt(Integer obj){
        switch (obj){               //obj is automatically unboxed- java 5 - any wrapper type can be
            case 1:{                    //used in any expression like while/do while/if
                System.out.println("one");
                break;
            }
            case 2:{
                System.out.println("two");
                break;
            }
            default:
                System.out.println("error");
        }
    }

    public static void main(String[] args) {
        //Integer obj = new Integer(100); //deprecated
        Integer obj = 1000;   //autobox to wrapper type
        int i = obj;        //auto-unboxing

        i = obj.intValue();   //returns int value
        System.out.println(autoConversion(obj));

        int num = autoConversion(obj);  //method call
        ++num;
        System.out.println("num "+num);

        Integer obj2 = num + (obj/3);           //int to wrapper type
        System.out.println("obj2- auto-boxed after the expression evaluation "+ obj2);

        IntegerToInt(2);  //method call

        //using byteValue()
        int j = obj.byteValue();
        System.out.println("Truncated j value after narrowing primitive conversion "+j);
    }
}
