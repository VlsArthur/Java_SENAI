package Ativ_fix_POO_heranca_01.Ativ_01.Entities;

public class VIP extends Ticket {
    private double VIP_Additional;
    
    public VIP() {
        super();
    }
    
    public VIP(double price, double VIP_Additional) {
        super(price);
        this.VIP_Additional = VIP_Additional;
    }
    
    public void setVIP_Additional(double VIP_Additional) {
        this.VIP_Additional = VIP_Additional;
    }
    
    public double getVIP_Additional() {
        return VIP_Additional;
    }
    
    @Override
    public void showPrice() {
        double price = getPrice();
        double VIP_Additional = getVIP_Additional();
        double total = price + VIP_Additional;
        System.out.println("Ticket price: R$ " + String.format("%.2f", price));
        System.out.println("VIP additional: R$ " + String.format("%.2f", VIP_Additional));
        System.out.println("Total: R$ " + String.format("%.2f", total));
    }
}