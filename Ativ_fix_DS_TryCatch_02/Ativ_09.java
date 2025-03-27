package Ativ_fix_DS_TryCatch_02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ativ_09 {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Type a Celsius temperature: ");
            Double temperature = sc.nextDouble();
            if (temperature<-273.5) throw new InvalidTemperatureException();
            Double fahrenheitTemperature = temperature * 1.8 + 32;
            System.out.println("Temperature in Fahrenheit: " + fahrenheitTemperature + "°F");
        } catch (InvalidTemperatureException e) {
            System.out.println("Invalid temperature inserted.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
        }

    }

    static class InvalidTemperatureException extends Exception {
        public InvalidTemperatureException() {
        }
    }
}
