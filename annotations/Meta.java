package annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

//An annotation type declaration
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    String str();
    int val();
}
//another annotation with description
@Retention(RetentionPolicy.RUNTIME)
@interface Description{
    String description();
}

@Description(description = "Annotation test class")
@MyAnnotation(str = "New Annotation", val = 100)
public class Meta {

    @Description(description = "Annotation class method")
    @MyAnnotation(str = "New Annotation", val = 100)
    public static void myMeta(String str, int i){

        Meta obj = new Meta();
        //Obtain the annotation for this method and display the values of the members
        try{
            //Get the class object that represents this class
            Class c = obj.getClass();
            //Now, get a Method object that represents this method
            Method m = c.getMethod("myMeta", String.class, int.class);
            //Next, get the annotation for this class
            MyAnnotation annotation = m.getAnnotation(MyAnnotation.class);
            //Finally, display the values
            System.out.println(annotation.str() +" "+ annotation.val());

            //get all annotations on mehtod level
            Annotation[] annotations = m.getAnnotations();
            for(Annotation a : annotations)
                System.out.println(a);
        }catch (NoSuchMethodException e){
            System.out.println("Method is not found");
        }
    }

    public static void main(String[] args) {
        myMeta("test",12);
    }
}
