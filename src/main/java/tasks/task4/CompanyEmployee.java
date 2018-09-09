package tasks.task4;

import tasks.task2.Person;

import java.util.ArrayList;
import java.util.List;

public class CompanyEmployee implements StandartEmployee {


    public static final double[] PAY_GRADES = {15000, 20000, 30000, 40000, 55000, 70000, 80000, 100000, 300000, 500000};//Enum сделать
    private static final double TAX_RATE = 0.10;
    int payGrade;
    private Person person;
    private boolean paysTaxes;


    private List<StandartEmployee> directReports =new ArrayList<>();


    private List<StandartEmployee> managers = new ArrayList<>();

    public CompanyEmployee() {
    }

    public CompanyEmployee(Person person, boolean paysTaxes) {
        this.person = person;
        this.paysTaxes = paysTaxes;
    }

    public CompanyEmployee(Person person, boolean paysTaxes, int payGrade) {
        this.person = person;
        this.paysTaxes = paysTaxes;
        this.payGrade = payGrade;

    }

    public void setDirectReports(List<StandartEmployee> directReports) {
        this.directReports = directReports;
    }

    public void setManagers(List<StandartEmployee> managers) {
        this.managers = managers;
    }

    public void addManager(StandartEmployee manager) {
        managers.add(manager);

    }
    public void addManagers(List<StandartEmployee> newManagers)
    {
        newManagers.forEach(x->managers.add(x));
    }

    public void addDirectReport(StandartEmployee directReport) {
        directReports.add(directReport);
    }

    public void addDirectReports(List<StandartEmployee> newDirectReports)
    {
        newDirectReports.forEach(x->directReports.add(x));
    }

    public boolean isPaysTaxes() {
        return paysTaxes;
    }

    @Override
    public double getIncome() {

        if (paysTaxes)
            return PAY_GRADES[payGrade] * TAX_RATE;
        else return PAY_GRADES[payGrade];

    }

    @Override
    public List<StandartEmployee> getManagers() {

        return managers;
    }

    @Override
    public List<StandartEmployee> getDirectReports() {
        return directReports;
    }

    @Override
    public String toString() {
        return "CompanyEmployee{" +
                "payGrade=" + payGrade +
                ", person=" + person +
                ", paysTaxes=" + paysTaxes +
                '}';
    }


}
