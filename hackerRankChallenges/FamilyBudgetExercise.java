package hackerRankChallenges;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.*;

/* Custom annotations with reflection concept, class access and modify attributes @ runtime */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface FamilyBudget {
    String userRole() default "GUEST";
    int budgetLimit();
}
public class FamilyBudgetExercise {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        while(testCases-- > 0){
            String role = scan.next();
            int spend = scan.nextInt();
            try{
                Class annotatedClass = FamilyMember.class;
                Method[] methods = annotatedClass.getMethods();
                for(Method method : methods){
                    if(method.isAnnotationPresent(FamilyBudget.class)){
                        FamilyBudget family = method.getAnnotation(FamilyBudget.class);
                        String userRole = family.userRole();
                        int budgetLimit = family.budgetLimit();
                        if(userRole.equals(role)){
                            if(spend <= budgetLimit){
                                method.invoke(FamilyMember.class.newInstance(), budgetLimit, spend);
                            }else
                                System.out.println("Budget Limit Over");
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class FamilyMember {
    @FamilyBudget(userRole = "SENIOR", budgetLimit = 100)
    public void seniorMember(int budget, int moneySpend) {
        System.out.println("Senior Member");
        System.out.println("Spend: " + moneySpend);
        System.out.println("Budget Left: " + (budget - moneySpend));
    }

    @FamilyBudget(userRole = "JUNIOR", budgetLimit = 50)
    public void juniorUser(int budget, int moneySpend) {
        System.out.println("Junior Member");
        System.out.println("Spend: " + moneySpend);
        System.out.println("Budget Left: " + (budget - moneySpend));
    }
}

