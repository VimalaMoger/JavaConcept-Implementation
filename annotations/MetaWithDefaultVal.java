package annotations;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

//An annotation type declaration
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno{
    String str() default "Testing";
}
public class MetaWithDefaultVal {

    @MyAnno//() removed, no error - annotated as Marker annotation
    public static void myMeta(){

        MetaWithDefaultVal obj = new MetaWithDefaultVal();
        //Obtain the annotation for this method and display the values of the members
        try{
            //Get the class object that represents this class
            Class c = obj.getClass();
            //Now, get a Method object that represents this method
            Method m = c.getMethod("myMeta");
            //Next, get the annotation for this class
            MyAnno annotation = m.getAnnotation(MyAnno.class);
            //Finally, display the values
            System.out.println(annotation.str());

        }catch (NoSuchMethodException e){
            System.out.println("Method is not found");
        }
    }

    public static void main(String[] args) {
        myMeta();
    }
}
