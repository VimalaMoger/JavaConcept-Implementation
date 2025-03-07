package hackerRankChallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Coveriant Return type overriden in subclasses */
public class CoveriantReturnExercise {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String s = br.readLine().trim();
        Region region = null;
        switch (s){
            case "WestBengal":
                region = new WestBengal();
                break;
            case "AndraPradesh":
                region = new AndraPradesh();
                break;
        }
        Flower flower = region.yourNationalFlower();
        System.out.println(flower.whatsYourName());
    }
}

class Flower{
    String whatsYourName(){
        return "";
    }
}

class Jasmine extends Flower{
    @Override
    String whatsYourName(){
        return "Jasmine";
    }
}
class Lily extends Flower{
    @Override
    String whatsYourName(){
        return "Lily";
    }
}
class Region{
    Flower yourNationalFlower(){
        return new Flower();
    }
}
class WestBengal extends Region{
    @Override
    Jasmine yourNationalFlower(){
        return new Jasmine();
    }
}
class AndraPradesh extends Region{
    @Override
    Lily yourNationalFlower(){
        return new Lily();
    }
}