package tasks.task4;

import tasks.task2.Person;

import java.util.ArrayList;
import java.util.List;

public class CompanyEmployee implements StandartEmployee {


    public static final double[] PAY_GRADES = {15000, 20000, 30000, 40000, 55000, 70000, 80000, 100000, 300000, 500000};//Enum сделать
    private static final double TAX_RATE = 0.10;
    int payGrade;
    private int id;
    private String name;
    private Person person;
    private boolean paysTaxes;
    private List<Integer> directReportsIDs = new ArrayList<>();
    private List<Integer> managersIDs = new ArrayList<>();


    public CompanyEmployee() {
    }

    public CompanyEmployee(Person person, boolean paysTaxes) {
        this.person = person;
        name=person.getName();
        this.paysTaxes = paysTaxes;
    }

    public CompanyEmployee(Person person, boolean paysTaxes, int payGrade) {
        this.person = person;
        name = person.getName();
        this.paysTaxes = paysTaxes;
        this.payGrade = payGrade;

    }

    public Person getPerson() {
        return person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void removeDirectReport(int employeeID) {
        int n = directReportsIDs.size();
        for (int i = 0; i < n; i++) {
            if (directReportsIDs.get(i) == employeeID) {
                if (directReportsIDs.size() == 1) {
                    directReportsIDs = null;
                    directReportsIDs = new ArrayList<>();

                } else
                    directReportsIDs.remove(i);
                return;
            }
        }
    }

    public void removeManger(int employeeID) {
        int n = managersIDs.size();
        for (int i = 0; i < n; i++) {
            if (managersIDs.get(i) == employeeID) {
                if (managersIDs.size() == 1) {
                    managersIDs = null;
                    managersIDs = new ArrayList<>();
                } else
                    managersIDs.remove(i);
                return;
            }
        }
    }

    public void setDirectReportsIDs(List<Integer> directReportsIDs) {
        this.directReportsIDs = directReportsIDs;
    }

    public void setManagersIDs(List<Integer> managersIDs) {
        this.managersIDs = managersIDs;
    }


    public void addManager(Integer managerID) {
        managersIDs.add(managerID);

    }

    public void addManagers(List<Integer> newManagersIDs) {
        // newManagersIDs.forEach(x-> managersIDs.add(x));
        managersIDs.addAll(newManagersIDs);
    }

    public void addDirectReport(Integer directReportID) {
        this.directReportsIDs.add(directReportID);
    }

    public void addDirectReports(List<Integer> newDirectReportsIDs) {
        // newDirectReportsIDs.forEach(x-> directReportsIDs.add(x));
        this.directReportsIDs.addAll(newDirectReportsIDs);
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
    public String getName() {
        return person.getName();
    }

    @Override
    public List<Integer> getManagersIDs() {
        return managersIDs;
    }

    @Override
    public List<Integer> getDirectReportsIDs() {
        return directReportsIDs;
    }


    @Override
    public String toString() {
        return "CompanyEmployee{" +
                "payGrade=" + payGrade +
                ", id=" + id +
                ", person=" + person +
                ", paysTaxes=" + paysTaxes +
                ", directReportsIDs=" + directReportsIDs +
                ", managersIDs=" + managersIDs +
                '}';
    }
}
