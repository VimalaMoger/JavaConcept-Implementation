package enumerations;

import java.util.Random;

enum DaysOfWeek{
    Sunday("Reading"), Monday, Tuesday("Music"), Wednesday("Learn"), Thursday("Walking"), Friday("Shopping"), Saturday("Fun");

    private String toDo;
    DaysOfWeek(String str) {
        this.toDo = str;
    }

    DaysOfWeek(){
        this.toDo = "Fitness Exercise";
    }
    String getToDo(){
        return toDo;
    }
}

public class EnumDemo {
    public static void main(String args[]){
        DaysOfWeek day;
        day = DaysOfWeek.Monday;

        //Output an enum value
        System.out.println("Value of day: "+day);

        day = DaysOfWeek.Thursday;

        //Compare two enum values
        if(day == DaysOfWeek.Thursday)
            System.out.println(day +" == Thursday ");

        //Use an enum to control a switch statement
        switch (day){
            case Monday:
                System.out.println("It's Monday");
            case Thursday:
                System.out.println("It is Thursday ");
        }

        //Using values()
        for(DaysOfWeek daysOfWeek: DaysOfWeek.values()){
            System.out.println(daysOfWeek +" ends with "+daysOfWeek.getToDo());
        }

        //using ordinal()
        day = DaysOfWeek.Sunday;
        DaysOfWeek secondDay = DaysOfWeek.Monday;
        if(day.compareTo(secondDay) < 0)   //check the index of the constant
            System.out.println(day + " comes before "+ secondDay);
        if(secondDay.compareTo(day) > 0)
            System.out.println(secondDay + " comes after "+ day);

        Question.answer();

    }
}

enum Answer{
    NO, YES, MAYBE, LATER, SOON, NEVER
}
class Question {
    Random random = new Random();

    //get the answer
    Answer ask(){
        int prob = random.nextInt(100);
        if(prob < 15)
            return Answer.MAYBE;
        else if (prob < 30)
            return Answer.NO;
        else if (prob < 60)
            return Answer.YES;
        else if (prob < 75)
            return Answer.LATER;
        else if(prob < 98)
            return Answer.SOON;
        else
            return Answer.NEVER;
        }

        //compare the result with enum constants
        static void answer(){
            Answer answer = new Question().ask();
            switch (answer){
                case NO:
                    System.out.println("NO");break;
                case YES:
                    System.out.println("Yes");break;
                case MAYBE:
                    System.out.println("Maybe");break;
                case LATER:
                    System.out.println("Later");break;
                case SOON:
                    System.out.println("Soon");break;
                case NEVER:
                    System.out.println("Never");break;
            }
        }
    }

