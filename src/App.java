import java.util.Scanner;
import java.lang.Math;

public class App {
    public static void main(String args[]) {
        menu();        
    }

    private static double readDouble(Scanner egb, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = egb.nextLine();  // Ganze Zeile lesen
            try {
                return Double.parseDouble(input);  // Versuchen zu parsen
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    public static double addition(double a, double b) {
        return(a + b);
    }
    public static double subtraction(double a, double b) {
        return(a - b);
    }
    public static double multiplication(double a, double b) {
        return(a * b);
    }
    public static double division(double a, double b) {
        return(a / b);
    }
    public static double sinus(double x) {
        return(Math.sin(x));
    }
    public static double baseExp(double x, double y) {
        return(Math.pow(x, y));
    }
    public static int gcd(int a, int b) {
        if (b != 0) {
            return gcd(b, a % b);
        } else {
            return a;
        }
    }
    public static long fibonnaci(int n) {
        if (n <= 1) {
            return(n);
        }
        return(fibonnaci(n - 1) + fibonnaci(n - 2));
    }

    private static void menu() {
        int userEgb = 0;
        try(Scanner egb = new Scanner(System.in)) {
            do {
                System.out.printf("CALCULATOR - please select:\n" + //
                            "0: end program\n" + //
                            "1: add\n" + //
                            "2: subtract\n" + //
                            "3: multiply\n" + //
                            "4: divide\n" + //
                            "5: sin(x)\n" + //
                            "6: x^y\n" + //
                            "7: gcd()\n" + //
                            "8: fibonacci(n)\n");
                if (!egb.hasNextInt()) {
                    System.out.println("Error! No valid menu entry. Exiting...");
                    egb.nextLine();
                    userEgb = 0;
                    continue;
                } else {
                    userEgb = egb.nextInt();
                    egb.nextLine();

                    switch(userEgb) {
                        case 0:
                        System.out.println("Exiting...");
                        break;
                        case 1:
                        System.out.println("Addidtion selected.");
                        double augend = readDouble(egb, "Enter first number: ");
                        double addend = readDouble(egb, "Enter second number: ");
                        System.out.println(augend + " + " + addend + " = " + addition(augend, addend));
                        break;
                        case 2:
                        System.out.println("Subtraction selected.");
                        double minuend = readDouble(egb, "Enter first number: ");
                        double subtrahend = readDouble(egb, "Enter second number: ");
                        System.out.println(minuend + " - " + subtrahend + " = " + subtraction(minuend, subtrahend));
                        break;
                        case 3:
                        System.out.println("Multiplication selected.");
                        double multiplier = readDouble(egb, "Enter first number: ");
                        double multiplicand = readDouble(egb, "Enter second number: ");
                        System.out.println(multiplier + " * " + multiplicand + " = " + multiplication(multiplier, multiplicand));
                        break;
                        case 4:
                        System.out.println("Division selected.");
                        double numerator = readDouble(egb, "Enter first number: ");
                        double denominator = readDouble(egb, "Enter second number: ");
                        if (denominator == 0) {
                            System.out.println("Can't divide by 0!");
                        } else {
                            System.out.println(numerator + " / " + denominator + " = " + division(numerator, denominator));
                        }
                        break;
                        case 5:
                        System.out.println("sin(x) (radians) selected.");
                        double innerX = readDouble(egb, "Enter value for x: ");
                        System.out.println("sin(" + innerX + ") = " + sinus(innerX));
                        
                        break;
                        case 6:
                        System.out.println("x^y selected.");
                        double baseX = readDouble(egb, "Enter value for x: ");
                        double exponentY = readDouble(egb, "Enter value for exponent y: ");
                        System.out.println(baseX + "^" + exponentY + " = " + baseExp(baseX, exponentY));
                        break;
                        case 7:
                        System.out.println("Greatest common divisor selected.");
                        double numeratorGcd = readDouble(egb, "Enter first number (numbers after the point/comma are ignored): ");
                        double denominatorGcd = readDouble(egb, "Enter second number (numbers after the point/comma are ignored): ");
                        System.out.println("Gcd of " + (int)numeratorGcd + " and " + (int)denominatorGcd + " is: " + gcd((int)numeratorGcd, (int)denominatorGcd));
                        break;
                        case 8:
                        System.out.println("nth fibonnaci number calculator selected.");
                        double nFib = readDouble(egb, "enter value for n (numbers after the point/comma are ignored, only accurate till the 92nd number and for numbers > 40 it may take significant time to calculate): ");
                        System.out.println((int)nFib + ". fibonnaci number: " + fibonnaci((int)nFib));
                        break;
                        default:
                        System.out.println("Input error! Enter a number corresponding to a menu item!");
                    }
                }
            } while (userEgb != 0);
        }
    } // Muss Static sein, weil Main static ist und ich sonst nicht auf andere Static-Methoden oder Variablen zugreifen kann ohne weitere Objekte erzeugen zu müssen
}       // Sonst müsste ich erst ein Objekt der Klasse App erzeugen, um drauf zugreifen zu können, wenn es nicht static wäre.