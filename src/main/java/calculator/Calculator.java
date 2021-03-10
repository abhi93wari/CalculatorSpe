package calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class.getName());

    public Calculator() {
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        int number1;
        double number,exponent;
        do {
            System.out.println("\n\n*************Calculator*************\n\n");
            System.out.println("Choose to perform operation\n");
            System.out.print("Press 1 to find factorial of a number\nPress 2 to find natural log of a number\n" +
                    "Press 3 to find value of number x raised to y\nPress 4 to find square root of a number\n" +
                    "Press any other key to exit\nEnter your choice: ");
            int choice;
            try{
                choice=scanner.nextInt();
            }
            catch(InputMismatchException error){
                logger.error("Invalid input, Entered input is not a number");
                return;
            }

            switch (choice) {
                case 1:
                    // factorial
                    try {
                        System.out.print("Enter the number : ");
                        number1 = scanner.nextInt();
                    } catch (InputMismatchException error) {
                        logger.error("Invalid input, Entered input is not a number");
                        return;
                    }
                    System.out.println("Factorial of the number is : " + calculator.factorial(number1));
                    break;
                case 2:
                    // Natural log
                    try {
                        System.out.print("Enter the number : ");
                        number = scanner.nextDouble();
                    } catch (InputMismatchException error) {
                        logger.error("Invalid input, Entered input is not a number");
                        return;
                    }
                    System.out.println("Natural log of the number is  : " + calculator.logarithm(number));
                    break;
                case 3:
                    // x raised to y
                    try {
                        System.out.print("Enter the base : ");
                        number = scanner.nextDouble();
                        System.out.print("Enter the exponent : ");
                        exponent = scanner.nextDouble();
                    } catch (InputMismatchException error) {
                        logger.error("Invalid input, Entered input is not a number");
                        return;
                    }
                    System.out.println("x raised to y is : " + calculator.power(number,exponent));
                    break;
                case 4:
                    //square root
                    try {
                        System.out.print("Enter the number : ");
                        number = scanner.nextDouble();
                    } catch (InputMismatchException error) {

                        logger.error("Invalid input, Entered input is not a number");
                        return;
                    }
                    System.out.println("Square root of given number is : " + calculator.Sqroot(number));
                    break;
                default:
                    System.out.println("Invalid choice,please enter correct choice.. ");
                    break;
            }
        } while (true);
    }



    public Double factorial(int number) {
        double result =0;
        int fact=1;
        try {
            logger.info("[FACTORIAL] - "  + number + "!");
            if (number < 0) {
                result = Double.NaN;
                throw new ArithmeticException("Domain Error");
            }
            else{
                for (int i = 1; i <= number; i++) {
                    fact = fact * i;
                }
                result=fact;
            }
        }
        catch(ArithmeticException error){
            logger.error("[EXCEPTION - FACTORIAL] - Cannot find FACTORIAL of negative number " + error.getLocalizedMessage());
        }
        finally{
            logger.info("[RESULT - FACTORIAL] - " + result);
        }
        return result;

    }

    public double logarithm(double number) {
        Double result =0.0;
        try {
            logger.info("[NATURAL LOG] - "  + "(" + number + ")");
            if (number <= 0) {
                result = Double.NaN;
                throw new ArithmeticException("Domain Error");
            }
            else{
                result = Math.log(number);
            }
        }
        catch(ArithmeticException error){
            logger.error("[EXCEPTION - NATURAL LOG] - Cannot find LOG of negative number or 0 " + error.getLocalizedMessage());
        }
        finally{
            logger.info("[RESULT - NATURAL LOG] - " + result);
        }
        return result;
    }

    public double power(double number1,double number2) {
        Double result =0.0;
        try {
            logger.info("[x raised to y] - " + number1 + " ^ " + number2 );
            result = Math.pow(number1,number2);
            if (result==Double.NaN) {

                throw new ArithmeticException("Not a number");
            }
        }
        catch(ArithmeticException error){
            logger.error("[EXCEPTION - POWER] - Cannot find POWER  " + error.getLocalizedMessage());
        }
        finally{
            logger.info("[RESULT - x raised to y] - " + result);
        }
        return result;
    }

    public double Sqroot(double number) {
        double result=0.0;
        try {
            logger.info("[SQUARE ROOT] - " + "sqrt( " + number + ")");
            if (number < 0) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN negative square root");
            }
            else{
                result = Math.sqrt(number);
            }
        }
        catch(ArithmeticException error){
            logger.error("[EXCEPTION - SQUARE ROOT] - Cannot find square root of negative number " + error.getLocalizedMessage());
        }
        finally{
            logger.info("[RESULT - SQUARE ROOT] - " + result);
        }
        return result;
    }

}
