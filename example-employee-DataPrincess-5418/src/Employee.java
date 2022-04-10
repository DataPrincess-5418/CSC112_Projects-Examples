//  Employee (abtract) base class
//  from Eric Roberts
//
//   David John
//   March 2020

// Base Employee class.  Since it is abstract no Employee
// object can be instantiated.
public abstract class Employee {

    // enumeration for employee classifications
    public enum Classification {Hourly, Commissioned, Temporary};

    // Every employee must have a name
    protected String name;

    // (protected) Employee constructor
    protected Employee(String name){
        this.name = name;
    }

    // getter for the name
    protected String getName(){
        return this.name;
    }

    // abstract (required for each extended class)  getPay()
    public abstract double getPay();

    // abstract getClassification()
    public abstract Classification getClassification();


}
