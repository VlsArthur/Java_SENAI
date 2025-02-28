package Ativ_fix_POO_heranca_01.Ativ_01.Entities;

public class Ticket {
    private double price;
    
    public Ticket() {
        
    }
    
    public Ticket(double price) {
        this.price = price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void showPrice() {
        double price = getPrice();
        System.out.println("Ticket price: R$ " + String.format("%.2f.", price));
    }
}