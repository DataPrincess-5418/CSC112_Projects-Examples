//  Temporary employee class as an extension of HourlyEmployee
//
//  David John
//  March 2021

public class TempEmployee extends HourlyEmployee {

    // TempEmployee constructor
    public TempEmployee(String name, double hourlyrate){
        super(name,hourlyrate);
        this.sethoursWorked(0.00);  // temps don't have a guaranteed minimum
    }
    // setter for hoursWorked
    public void sethoursWorked(double hours){
        assert(hours >=0 && hours <= 50):  "Illegal hours for temp employee";
        this.hoursWorked = hours; }

    // getPay() implementation required by abstract Employee getPay()
    public double getPay(){

        // over 40 hours -- note higher overtime rate
        if (this.hoursWorked>=40.0){
            return 40.0*this.hourlyRate + (this.hoursWorked-40.0)*this.hourlyRate*1.8;
        }

        return this.hourlyRate*this.hoursWorked;
    }

    // getClassification  implementation required by abstract
    public Classification getClassification(){ return Classification.Temporary; }
}
