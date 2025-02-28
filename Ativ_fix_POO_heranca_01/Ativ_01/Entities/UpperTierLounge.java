package Ativ_fix_POO_heranca_01.Ativ_01.Entities;

public class UpperTierLounge extends VIP {
    private double loungeTierAdditional;
    
    public UpperTierLounge() {
        super();
    }
    
    public UpperTierLounge(double price, double VIP_Additional, double loungeTierAdditional) {
        super(price, VIP_Additional);
        this.loungeTierAdditional = loungeTierAdditional;
    }
    
    public void setLoungeTierAdditional(double loungeTierAdditional) {
        this.loungeTierAdditional = loungeTierAdditional;
    }
    
    public double getLoungeTierAdditional() {
        return loungeTierAdditional;
    }
    
    @Override
    public void showPrice() {
        double price = getPrice();
        double VIP_Additional = getVIP_Additional();
        double loungeTierAdditional = getLoungeTierAdditional();
        double total = price + VIP_Additional + loungeTierAdditional;
        System.out.println("Ticket price: R$ " + String.format("%.2f", price));
        System.out.println("VIP additional: R$ " + String.format("%.2f", VIP_Additional));
        System.out.println("Lounge tier additional: R$ " + String.format("%.2f", loungeTierAdditional));
        System.out.println("Total: R$ " + String.format("%.2f", total));
    }
}