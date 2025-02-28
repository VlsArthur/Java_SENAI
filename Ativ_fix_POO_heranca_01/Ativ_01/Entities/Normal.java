package Ativ_fix_POO_heranca_01.Ativ_01.Entities;

public class Normal extends Ticket {
    
    public Normal() {
        super();
    }
    
    public Normal (double price) {
        super(price);
    }
    
    public void showType() {
        System.out.println("Ticket type: Normal");
    }
}