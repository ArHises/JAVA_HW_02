import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TaskFour {
//
    public static void main(String[] args) {
//        4) К калькулятору из предыдущего ДЗ добавить логирование.

        Logger log = Logger.getLogger(TaskFour.class.getName());
        ConsoleHandler ch = new ConsoleHandler();
        SimpleFormatter sFormat = new SimpleFormatter();
        ch.setFormatter(sFormat);
        log.addHandler(ch);
        calcOptions(log);

    }

    private static void CalcInterface() {
        System.out.println("1. +");
        System.out.println("2. -");
        System.out.println("3. *");
        System.out.println("4. \\");
        System.out.println("5. Exit");

    }

    private static void calcOptions(Logger log) {
        Scanner iScanner = new Scanner(System.in);
        CalcInterface();
        String task = iScanner.nextLine();
        while (!task.equals("5")) {
            if (task.equals("1")) {
                plus(log);
            } else if (task.equals("2")) {
                minus(log);
            } else if (task.equals("3")) {
                multiply(log);
            } else if (task.equals("4")) {
                divide(log);
            } else {
                System.out.println("Try again");
                CalcInterface();
            }
            CalcInterface();
            task = iScanner.nextLine();
        }
    }

    public static void plus(Logger log){
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int one = Integer.parseInt(iScanner.nextLine());
        int two = Integer.parseInt(iScanner.nextLine());
        log.info(one + " + " + two + " = " + (one+two));
        System.out.println(one + " + " + two + " = " + (one+two));
    }
    public static void minus(Logger log){
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int one = Integer.parseInt(iScanner.nextLine());
        int two = Integer.parseInt(iScanner.nextLine());
        log.info(one + " - " + two + " = " + (one-two));
        System.out.println(one + " - " + two + " = " + (one-two));
    }
    public static void multiply(Logger log){
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int one = Integer.parseInt(iScanner.nextLine());
        int two = Integer.parseInt(iScanner.nextLine());
        log.info(one + " * " + two + " = " + (one * two));
        System.out.println(one + " * " + two + " = " + (one * two));
    }
    public static void divide(Logger log){
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        double one = Double.parseDouble(iScanner.nextLine());
        double two = Double.parseDouble(iScanner.nextLine());
        log.info(one + " / " + two + " = " + (one/two));
        System.out.println(one + " / " + two + " = " + (one/two));
    }
}
