package Ativ_fix_DS_polimorfismo_01.Ativ_04.Entities;

public class CardPayment extends Payment {
    public CardPayment() {
    }

    @Override
    public void pay() {
        System.out.println("Card payment approved!");
    }
}
