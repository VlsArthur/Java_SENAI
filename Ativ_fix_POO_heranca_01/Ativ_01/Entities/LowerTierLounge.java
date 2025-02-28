package Ativ_fix_POO_heranca_01.Ativ_01.Entities;

public class LowerTierLounge extends VIP {
    private String location;
    
    public LowerTierLounge() {
        super();
    }
    
    public LowerTierLounge(double price, double VIP_Additional, String location) {
        super(price, VIP_Additional);
        this.location = location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void showLocation() {
        String location = getLocation();
        System.out.println("Lounge locadion: " + location);
    }
}