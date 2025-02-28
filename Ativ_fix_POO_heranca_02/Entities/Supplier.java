package Ativ_fix_POO_heranca_02.Entities;

public class Supplier extends Person {
    private float debtValue;
    private float CreditValue;

    public Supplier() {
        super();
    }

    public Supplier(String name, String phone, float debtValue, float creditValue) {
        super(name, phone);
        this.debtValue = debtValue;
        CreditValue = creditValue;
    }

    public Supplier(String name, String address, String phone, float debtValue, float creditValue) {
        super(name, address, phone);
        this.debtValue = debtValue;
        CreditValue = creditValue;
    }

    public float getDebtValue() {
        return debtValue;
    }

    public void setDebtValue(float debtValue) {
        this.debtValue = debtValue;
    }

    public float getCreditValue() {
        return CreditValue;
    }

    public void setCreditValue(float creditValue) {
        CreditValue = creditValue;
    }

    public void balance() {
        float balance = getCreditValue() - getDebtValue();
        System.out.println("Balance: R$ " + String.format("%.2f", balance));
    }

}
