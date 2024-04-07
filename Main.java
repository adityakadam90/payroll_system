import java.util.ArrayList;

abstract class Employee {
    private String name;
    private int id;
    public Employee(String name,int id) {
        this.name = name;
        this.id = id;

    }
    public String getName(){
        return name;
    }
    public int getid(){
        return id;
    }

    public abstract double cal_salary();
    @Override
    public String toString(){
        return "Employee [ name = "+name+" , id = "+id+" , salary = "+cal_salary()+" ]";
    }
}
class FullTimeEmployee extends Employee {
    private double monthlySalary;
    public FullTimeEmployee(String name,int id,double monthlySalary) {
        super(name,id);
        this.monthlySalary = monthlySalary;
    }
    @Override
    public double cal_salary(){
        return monthlySalary;
    }
}
class PartTimeemployee extends Employee {
    private double haurlyRate;
    private int hourWorked;
    public PartTimeemployee(String name,int id,int hourWorked,double hourRate ) {
        super(name,id);
        this.haurlyRate = hourRate;
        this.hourWorked = hourWorked;
    }
    @Override
    public double cal_salary(){
        return haurlyRate * hourWorked;
    }
}

class payRollSystem {
    private ArrayList<Employee> emplist;
    public payRollSystem(){
        emplist = new ArrayList<>();
    }

    public void addEmp(Employee employee){
        emplist.add(employee);
    }
    public void removeEmp(int id){
        Employee emptoremove = null;
        for(Employee emp : emplist) {
            if(emp.getid() == id) {
                emptoremove = emp;
                break;
            }
        }
        if(emptoremove != null){
            emplist.remove(emptoremove);
        }
    }
    public void displayEmployee(){
        for(Employee emp:emplist) {
            System.out.println(emp);
        }
    }
}
public class Main {
    public static void main(String[] args) {
            payRollSystem payRollSystem = new payRollSystem();
            FullTimeEmployee emp1 = new FullTimeEmployee("aditya",1,9000.0);
            PartTimeemployee emp2 = new PartTimeemployee("sanket",2,2,1000.0);

            payRollSystem.addEmp(emp1);
            payRollSystem.addEmp(emp2);
            payRollSystem.displayEmployee();
    }
}