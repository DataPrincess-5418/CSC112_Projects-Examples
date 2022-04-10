// Simple program to illustrate and tests ideas related to
// inheritance.
//
// David John
// March 2021


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        // create some employees
        HourlyEmployee Joe = new HourlyEmployee("Joe", 21.25);
        CommissionedEmployee Sue = new CommissionedEmployee("Sue", 75000, 0.055);
        Employee Mary = new HourlyEmployee("Mary", 18.79);
        TempEmployee David = new TempEmployee("David", 17.50);
        CommissionedEmployee Amanda = new CommissionedEmployee("Amanda",90300, 0.045);
        CommissionedEmployee nana = new CommissionedEmployee("nana", 23500.0, 0.231);
        Employee Java = new Employee("Hello", 234);

        ArrayList<Employee> company = new ArrayList<Employee>();
        company.add(Joe);
        company.add(Sue);
        company.add(Mary);
        company.add(David);
        company.add(Amanda);

        // get and set hours for hourly and temporary employees
        for (Employee XXX : company){

            if (XXX.getClassification() == Employee.Classification.Hourly ){
                System.out.printf("Enter hours for hourly employee -- %s : ",XXX.getName());
                double hours = keyboard.nextDouble();
                ((HourlyEmployee)XXX).sethoursWorked(hours);
            }
            else if (XXX.getClassification() == Employee.Classification.Temporary ){
                System.out.printf("Enter hours for temporary employee -- %s : ",XXX.getName());
                double hours = keyboard.nextDouble();
                ((TempEmployee) XXX).sethoursWorked(hours);
            }
            else if (XXX.getClassification() == Employee.Classification.Commissioned )  {
                System.out.printf("Enter sales for commissioned employee -- %s : ",XXX.getName());
                double sales = keyboard.nextDouble();
                ((CommissionedEmployee) XXX).setsalesVolume(sales);
            }
        }

        System.out.println("\n\n");

        // pay them all
        for (Employee XXX : company){
            System.out.printf("%8s %,10.2f%20s%n", XXX.getName(), XXX.getPay(), XXX.getClassification());
        }



    }
}
