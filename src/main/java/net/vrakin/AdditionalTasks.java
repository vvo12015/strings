package net.vrakin;

public class AdditionalTasks {

    public static String printNumber(int number){
        return DigitalStringGenerator.generateMoney(number);
    }

    public static String repeatCounter(String string){
        int counter = 1;

        while (counter <= string.length()){
            String forEquals = string.substring(0, counter).repeat(string.length()/counter);
            if (string.equals(forEquals)){
                return string.substring(0, counter);
            }
            counter++;
        }

        return "Wrong enter";
    }
}
