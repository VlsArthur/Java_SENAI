package Ativ_fix_DS_polimorfismo_01.Ativ_04.Entities;

public class CashPayment extends Payment {
    public CashPayment() {
    }

    @Override
    public void pay() {
        System.out.println("Cash payment received!");
    }
}
