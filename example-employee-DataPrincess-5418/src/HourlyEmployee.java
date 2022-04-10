// HourlyEmployee extends (inherits from) Employee
//    from Eric Roberts
//    David John
//    March 2021


public class HourlyEmployee extends Employee{

    // two class members for HourlyEmployee
    protected double hourlyRate;
    protected double hoursWorked;

    // hourly employee constructor
    public HourlyEmployee(String name, double hourlyRate){
        super(name);

        assert(hourlyRate >= 7.75 && hourlyRate <= 175.00):  "Error on hourlyRate";
        this.hourlyRate = hourlyRate;
        this.hoursWorked = 3.0;   // guarantee every employee at least 3 hours
    }

    // setter for hourlyRate
    public void sethourlyRate(double wage){
        assert(wage >= 7.75 && wage <= 175.00 ): "Illegal hourlyRate";
        this.hourlyRate = wage;
    }

    // setter for hoursWorked
    public void sethoursWorked(double hours){
        assert(hours>=0 && hours<=100): "Illegal number of hours";
        this.hoursWorked = Math.max(hours,this.hoursWorked); }

    // getPay() implementation required by abstract Employee getPay()
    public double getPay(){

        // over 40 hours
        if (this.hoursWorked>=40.0){
            return 40.0*this.hourlyRate + (this.hoursWorked-40.0)*this.hourlyRate*1.5;
        }

        return this.hourlyRate*this.hoursWorked;
    }

    // getClassification  implementation required by abstract
    public Classification getClassification(){ return Classification.Hourly; }
}
