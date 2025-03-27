package Ativ_fix_DS_polimorfismo_01.Ativ_04.Application;

import Ativ_fix_DS_polimorfismo_01.Ativ_04.Entities.Payment;
import Ativ_fix_DS_polimorfismo_01.Ativ_04.Entities.CardPayment;
import Ativ_fix_DS_polimorfismo_01.Ativ_04.Entities.CashPayment;

public class Main {
    public static void main(String[] args) {
        Payment[] payments = {new CardPayment(), new CashPayment()};

        for (Payment payment : payments) {
            payment.pay();
        }
    }
}
