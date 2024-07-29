package net.vrakin;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello strings" );
        boolean notExited = true;
        try(Scanner sc = new Scanner(System.in)) {
            while (notExited){
                System.out.println("Enter number task. Basic task (1-3), additional task (4-5) or 0 to exit: ");
                int task = sc.nextInt();
                String string = "";

                switch (task){
                    case 0 -> notExited = false;
                    case 1 -> System.out.printf("\". The number of \"b\" characters in string: %s%n", BasicTasks.countB(string));
                    case 2 -> System.out.printf("\"the longest word entered: %s%n", BasicTasks.longestWord(string));
                    case 3 -> BasicTasks.piPrint();
                    case 4 -> System.out.println(AdditionalTasks.printNumber(sc.nextInt()));
                    case 5 -> {
                        sc.nextLine();
                        System.out.println(AdditionalTasks.repeatCounter(sc.nextLine()));
                    }
                    default -> {
                        System.out.println("Invalid task");
                        notExited = false;
                    }
                }
            }
        }
    }
}
