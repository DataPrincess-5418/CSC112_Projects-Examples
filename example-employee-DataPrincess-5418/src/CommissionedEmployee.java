public class CommissionedEmployee extends Employee {

    private double baseSalary;
    private double commissionRate;
    private double salesVolume;

    public CommissionedEmployee(String name, double baseSalary, double commissionRate){
        super(name);

        assert(baseSalary>=0) :  "Illegal baseSalary";
        this.baseSalary = baseSalary;
        this.setcommissionRate(commissionRate);
    }

    public void setcommissionRate(double rate){
        assert(rate>=0.01 && rate <= .25): "Illegal commission rate";
        this.commissionRate = rate;
    }

    public void setsalesVolume(double volume){
        assert(volume>=0): "Illegal sales amount";
        this.salesVolume = volume;
    }

    // required getPay() -- weekly
    public double getPay(){
        return this.baseSalary/52.0 + this.commissionRate*this.salesVolume;
    }

    // required getClassification()
    public Classification getClassification(){ return Classification.Commissioned; }
}
