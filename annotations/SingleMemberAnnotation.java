package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

//An annotation type declaration with single member
@Retention(RetentionPolicy.RUNTIME)
@interface SingleAnno{
    int value();   //This variable name must be "value"
}

public class SingleMemberAnnotation {

    @SingleAnno(100)  //no ()
    public static void myMeta() {
        SingleMemberAnnotation singleMemberAnnotation = new SingleMemberAnnotation();

        try {
            //Get the class object that represents this class
            Method m = singleMemberAnnotation.getClass().getMethod("myMeta");
            //Determine if annotation is present
            SingleAnno anno = m.getAnnotation(SingleAnno.class);
                System.out.println(anno.value());
        } catch (NoSuchMethodException e) {
            System.out.println("Method is not found");
        }
    }

    public static void main(String[] args) {
        myMeta();
    }
}

