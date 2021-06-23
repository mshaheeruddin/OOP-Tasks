import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeTask {
    public static void main(String[] args) {
        ArrayList<Employee> emp = new ArrayList();
        Scanner in = new Scanner(System.in);
        int ch = 0;
        System.out.println("Press 1 for Salaried Employee");
        System.out.println("Press 2 for Hourly Employee");
        System.out.println("Press 3 for Commission Employee");
        System.out.println("Press 4 for BasePlusCommission Employee");
        System.out.println("Press 5 to display");
        do{

            ch = in.nextInt();
            switch(ch)
            {
                case 1:
                    emp.add(new SEmployee("John","Smith","111-11-111",800));
                 break;
                case 2:
                    emp.add(new HEmployee("Karen","Price","222-22-222",16.75,40));
                    break;
                case 3:
                    emp.add(new CEmployee("Sue","Jones","333-33-333",10000,0.06));
                    break;
                case 4:
                    emp.add(new BCEmployee("Bob","Lewis","444-44-444",5000,0.04,300));

            }
        }while(ch != 5);
        for(int i = 0; i<emp.size(); i++){
            System.out.println(emp.get(i).toString());

        }
    }
}




abstract class Employee {
        private String firstName;
        private String lastName;
        private String SSN;

        public Employee(String Fname, String Lname, String SSN) {
            this.firstName = Fname;
            this.lastName = Lname;
            this.SSN = SSN;
        }

        public abstract double earnings();

        public void setFname(String Fname) {
            this.firstName = Fname;
        }

        public String getFName() {
            return this.firstName;
        }

        public void setLname(String Lname) {
            this.lastName = Lname;
        }

        public String getLName() {
            return this.lastName;
        }

        public String getSSN() {
            return this.SSN;
        }

        public void setSSN(String SSN) {
            this.SSN = SSN;
        }

        @Override
        public String toString() {
            return "Employee name: " + this.firstName +" "+ this.lastName+ "\n" + "social security number: " + this.SSN;
        }


    }

    class SEmployee extends Employee {
        private double weeklysalary;

        public SEmployee(String Fname, String Lname, String SSN,double weeklysalary) {
            super(Fname, Lname, SSN);
            this.weeklysalary=weeklysalary;
        }

        @Override
        public double earnings() {
            return weeklysalary;
        }

        @Override
        public String toString() {
            return "weekly " + super.toString() +
                    "\n" + "Weekly salary: " +"$"+ this.weeklysalary +"\n" +"earned :" + "$"+ earnings();
        }
    }

    class HEmployee extends Employee {
        public double wage;
        public double hours;

        public HEmployee(String fname, String lname, String SSN, double wage, double hoursWorked) {
            super(fname, lname, SSN);
            this.wage = wage;
            this.hours = hoursWorked;
        }

        public double getWage() {
            return wage;
        }

        public void setWage(double wage) {
            this.wage = wage;
        }

        public double getHours() {
            return hours;
        }

        public void setHours(double hours) {
            this.hours = hours;
        }

        @Override
        public double earnings() {
            if (hours <= 40) {
                return wage * hours;
            } else return 40 * wage + (hours - 40) * wage * 1.5;
        }

        public String toString() {
            return "hourly " + super.toString() + "\n" + "hourly wage: " +"$"+ wage +";" + " hours worked: " + hours+"\n"+"$"+earnings();
        }


    }

    class CEmployee extends Employee {
        private double grossSales;
        private double commisionRate;
        private double newbasesalary;

        public CEmployee(String fname, String lname, String ssn, double gS, double cR) {
            super(fname, lname, ssn);
            this.commisionRate = cR;
            this.grossSales = gS;
        }

        public double getGrossSales() {
            return grossSales;
        }

        public void setGrossSales(double gs) {
            this.grossSales = gs;
        }

        public void setCommissionRate(double commisionRate) {
            this.commisionRate = commisionRate;
        }

        public double getCommisionRate() {
            return commisionRate;
        }

        @Override
        public double earnings() {
            return commisionRate * grossSales;
        }

        @Override
        public String toString() {
            return "commission " + super.toString() + "\n" + "gross sales: " + "$" +grossSales + ";" + " commission rate: " + "$" +commisionRate +
                    "\n" + "earned:" +"$"+ earnings();
        }
    }

    class BCEmployee extends CEmployee {
        private double baseSalary;

        public BCEmployee(String fname, String lname, String SSN, double gS, double cR, double bS) {
            super(fname, lname, SSN, gS, cR);
            this.baseSalary = bS;
        }

        public double getBaseSalary() {
            return baseSalary;
        }

        public void setBaseSalary(double bS) {
            this.baseSalary = bS;
        }

        @Override
        public double earnings() {
            return (getCommisionRate() * getGrossSales()) + (baseSalary*0.10+baseSalary);
        }

        public double getAwardtenP() {
          return baseSalary*0.10+baseSalary;

        }

        public String toString() {
            return "base-salaried commission " + super.toString()  + ";" + " base salary: " +
                    "$"+baseSalary  +"\n"+ "new base salary with 10% increase is: " +"$"+ getAwardtenP() ;
        }

    }

