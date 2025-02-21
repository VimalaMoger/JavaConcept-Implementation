package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

//An annotation type declaration
@Retention(RetentionPolicy.RUNTIME)
@interface MyMarker{}

public class MarkerAnnotation {

    @MyMarker  //no ()
    public static void myMeta() {
        MarkerAnnotation markerAnnotation = new MarkerAnnotation();

        try {
            //Get the class object that represents this class
            Method m = markerAnnotation.getClass().getMethod("myMeta");
            //Determine if annotation is present
            if(m.isAnnotationPresent(MyMarker.class))
                System.out.println("MyMarker is present ");
        } catch (NoSuchMethodException e) {
            System.out.println("Method is not found");
        }
    }

    public static void main(String[] args) {
        myMeta();
    }
}
