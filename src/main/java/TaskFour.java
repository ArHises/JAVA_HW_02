import java.util.Scanner;

public class TaskFour {
    public static void main(String[] args) {
//        4) К калькулятору из предыдущего ДЗ добавить логирование.

        calcOptions();
    }

    private static void CalcInterface() {
        System.out.println("1. +");
        System.out.println("2. -");
        System.out.println("3. *");
        System.out.println("4. \\");
        System.out.println("5. Exit");

    }

    private static void calcOptions() {
        Scanner iScanner = new Scanner(System.in);
        CalcInterface();
        String task = iScanner.nextLine();
        while (!task.equals("5")) {
            if (task.equals("1")) {
                plus();
            } else if (task.equals("2")) {
                minus();
            } else if (task.equals("3")) {
                multiply();
            } else if (task.equals("4")) {
                divide();
            } else {
                System.out.println("Try again");
                CalcInterface();
            }
            CalcInterface();
            task = iScanner.nextLine();
        }
    }

    public static void plus(){
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int one = Integer.parseInt(iScanner.nextLine());
        int two = Integer.parseInt(iScanner.nextLine());
        System.out.println(one + " + " + two + " = " + (one+two));
    }
    public static void minus(){
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int one = Integer.parseInt(iScanner.nextLine());
        int two = Integer.parseInt(iScanner.nextLine());
        System.out.println(one + " - " + two + " = " + (one-two));
    }
    public static void multiply(){
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int one = Integer.parseInt(iScanner.nextLine());
        int two = Integer.parseInt(iScanner.nextLine());
        System.out.println(one + " * " + two + " = " + (one * two));
    }
    public static void divide(){
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        double one = Double.parseDouble(iScanner.nextLine());
        double two = Double.parseDouble(iScanner.nextLine());
        System.out.println(one + " / " + two + " = " + (one/two));
    }
}
