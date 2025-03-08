package Ativ_DS_EAD_01.Exemplo_02.Entities;

public class Calc {
    public static class Finantial {
        public static double calcSimpleInterest(double principal, double interestRate, int time) {
            return (principal * interestRate * time) / 100;
        }

        public static double convertCurrency(double value, double exchangeRate) {
            return value * exchangeRate;
        }
    }
}
