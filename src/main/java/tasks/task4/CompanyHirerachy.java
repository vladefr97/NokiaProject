package tasks.task4;

import tasks.task2.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompanyHirerachy implements StandartHierarchy {


    List<CompanyEmployee> companyEmployees;
    private static int IDCounter = 0;


    public CompanyHirerachy() {
        companyEmployees = new ArrayList<>();
    }

    public CompanyHirerachy(List<CompanyEmployee> companyEmployees) {
        this.companyEmployees = companyEmployees;
    }

    public static void main(String[] args) {
        CompanyHirerachy company = new CompanyHirerachy();

        CompanyEmployee Igor = new CompanyEmployee(new Person(22, true, "Igor"), true);
        CompanyEmployee John = new CompanyEmployee(new Person(22, true, "John"), true);
        CompanyEmployee Ivan = new CompanyEmployee(new Person(22, true, "Ivan"), true);
        CompanyEmployee Petr = new CompanyEmployee(new Person(22, true, "Petr"), true);
        CompanyEmployee Vasia = new CompanyEmployee(new Person(44, true, "Vasia"), true);

        company.addEmployees(Arrays.asList(Igor, John, Ivan, Petr, Vasia));


        company.assignEmployees(
                John,
                Arrays.asList(
                        Ivan.getId(),
                        Petr.getId()
                ),
                Arrays.asList(
                        Igor.getId()
                )
        );

        company.assignEmployees(Vasia,
                null,
                Arrays.asList(Igor.getId())
        );


        System.out.println(company);
         company.deleteEmployee(John);
         company.deleteEmployee(Igor);

    }

    public List<CompanyEmployee> getCompanyEmployees() {
        return companyEmployees;
    }

    private static int getNewEmployeeID() {
        return ++IDCounter;

    }

    @Override
    public String toString() {
        return "CompanyHirerachy{" +
                "companyEmployees=" + companyEmployees +
                '}';
    }

    public void assignEmployees(CompanyEmployee newEmployee, List<Integer> directReportsIDs, List<Integer> managersIDs) {

        if (directReportsIDs != null) {
            newEmployee.setDirectReportsIDs(directReportsIDs);

            directReportsIDs
                    .stream()
                    .filter(this::companyContainsEmployeeWithID)
                    .forEach(x -> getEmployeeByID(x)
                            .addManager(newEmployee.getId())
                    );
        }
        if (managersIDs != null) {
            newEmployee.setManagersIDs(managersIDs);
            managersIDs
                    .stream()
                    .filter(this::companyContainsEmployeeWithID)
                    .forEach(x -> getEmployeeByID(x)
                            .addDirectReport(newEmployee.getId()));

        }


       /* if (directReports != null) {
            ((CompanyEmployee) newEmployee).setDirectReportsIDs(directReports);
            directReports.forEach(x -> ((CompanyEmployee) x).addManager(newEmployee));
            directReports.stream().filter(x -> !companyEmployees.contains(x)).forEach(x -> companyEmployees.add((CompanyEmployee) x));
        }

        if (managers != null) {
            ((CompanyEmployee) newEmployee).setManagersIDs(managers);
            managers.forEach(x -> ((CompanyEmployee) x).addDirectReport(newEmployee));
            managers.stream().filter(x -> !companyEmployees.contains(x)).forEach(x -> companyEmployees.add((CompanyEmployee) x));
        }
        companyEmployees.add((CompanyEmployee) newEmployee);*/


    }

    public boolean companyContainsEmployeeWithID(int id) {
        for (CompanyEmployee employee : companyEmployees) {
            if (employee.getId() == id)
                return true;
        }
        return false;
    }

    public CompanyEmployee getEmployeeByID(int id) {

        for (CompanyEmployee employee : companyEmployees) {
            if (employee.getId() == id)
                return employee;
        }
        return null;
    }

    public void addEmployees(List<CompanyEmployee> newCompanyEmployees) {
        newCompanyEmployees.forEach(x -> x.setId(getNewEmployeeID()));
        companyEmployees.addAll(newCompanyEmployees);
    }

    @Override
    public void addEmployee(StandartEmployee newEmployee) {

        ((CompanyEmployee) newEmployee).setId(getNewEmployeeID());
        if(!companyEmployees.contains(newEmployee))
        companyEmployees.add((CompanyEmployee) newEmployee);
    }

    @Override
    public Boolean deleteEmployee(StandartEmployee firedEmployee) {

        if (!companyEmployees.contains(firedEmployee))
            return false;

        int managersCount = firedEmployee.getManagersIDs().size();
        int directReportsCount = firedEmployee.getDirectReportsIDs().size();
        if (managersCount == 0 && directReportsCount != 0)//deleting top manager
        {
            Integer newDirectorID = firedEmployee.getDirectReportsIDs()
                    .stream()
                    .findFirst()
                    .get();
            ((CompanyEmployee)firedEmployee).removeDirectReport(newDirectorID);
            CompanyEmployee newDirector = getEmployeeByID(newDirectorID);
            newDirector.removeManger(((CompanyEmployee) firedEmployee).getId());
            newDirector.addDirectReports(firedEmployee.getDirectReportsIDs());

            firedEmployee.getDirectReportsIDs()
                    .stream()
                    .filter(x->getEmployeeByID(x)!=null)
                    .forEach(
                            x->getEmployeeByID(x)
                                    .removeManger(((CompanyEmployee) firedEmployee).getId())
                    );
            firedEmployee.getDirectReportsIDs()
                    .stream()
                    .filter(x->getEmployeeByID(x)!=null)
                    .forEach(
                            x->getEmployeeByID(x).addManager(newDirectorID)
                    );

        } else if (managersCount != 0 && directReportsCount != 0)//deleting middle manager
        {
            CompanyEmployee newManager = getEmployeeByID(firedEmployee.getManagersIDs().stream().findFirst().get());

            newManager.removeDirectReport(((CompanyEmployee) firedEmployee).getId());

            newManager
                    .getDirectReportsIDs()
                    .addAll(firedEmployee.getDirectReportsIDs());

            firedEmployee.getDirectReportsIDs().forEach(
                    x -> getEmployeeByID(x).removeManger(((CompanyEmployee) firedEmployee).getId())
            );

            firedEmployee
                    .getDirectReportsIDs()
                    .forEach(
                            x -> getEmployeeByID(x).getManagersIDs().add(newManager.getId())
                    );


        } else if (managersCount != 0 && directReportsCount == 0) {//deleting lower employee

            firedEmployee.getManagersIDs()
                    .forEach(
                            x->getEmployeeByID(x)
                                    .removeDirectReport(((CompanyEmployee)firedEmployee).getId())
                    );
        }


       /* if (!companyEmployees.contains(firedEmployee)) return false;

        if (firedEmployee.getManagersIDs().isEmpty() && !firedEmployee.getDirectReportsIDs().isEmpty()) {//The director of company or person without managers and direct reports is fired
            if (firedEmployee.getDirectReportsIDs() == null) {
                companyEmployees.remove(firedEmployee);
            } else {
                //uncheked--------------------------------------------------------------------
                //--------------------------------------------------------
                //new director is employee with the least count of direct reports
                CompanyEmployee newDirector = (CompanyEmployee) firedEmployee.getDirectReportsIDs()
                        .stream()
                      //  .filter(x -> x.getDirectReportsIDs() != null)
                        .min((x1, x2) -> x1.getDirectReports().size() > x2.getDirectReports().size() ? 1 : -1)
                        .get();


                if (firedEmployee.getDirectReports().size() != 1 && !firedEmployee.getDirectReports().isEmpty()) {
                    firedEmployee.getDirectReports().remove(newDirector);
                    newDirector.setDirectReportsIDs(firedEmployee.getDirectReports());
                    newDirector.setManagersIDs(null);
                    firedEmployee.getDirectReports().forEach(x -> ((CompanyEmployee) x).setManagersIDs(Arrays.asList(newDirector)));
                } else
                    newDirector.setManagersIDs(null);


            }

        } else if (firedEmployee.getManagers().size() == 1 && !firedEmployee.getDirectReports().isEmpty()) {
            firedEmployee.getManagers().forEach(x -> x.getDirectReports().remove(firedEmployee));
            firedEmployee.getManagers().forEach(x -> ((CompanyEmployee) x).addDirectReports(firedEmployee.getDirectReports()));
            firedEmployee.getDirectReports().forEach(x -> ((CompanyEmployee) x).setManagersIDs(firedEmployee.getManagers()));

        } else if (firedEmployee.getManagers().size() > 1 && !firedEmployee.getDirectReports().isEmpty()) {

            firedEmployee.getManagers().forEach(x -> x.getDirectReports().remove(firedEmployee));
            ((CompanyEmployee)firedEmployee.getManagers().get(0)).addDirectReports(firedEmployee.getDirectReports());
            firedEmployee.getDirectReports().forEach(x->((CompanyEmployee)x).addManager(firedEmployee.getManagers().get(0)));
            firedEmployee.getDirectReports().forEach(x->x.getManagers().remove(firedEmployee));

        }else if(firedEmployee.getDirectReports().isEmpty())
        {
            firedEmployee.getManagers().forEach(x->x.getDirectReports().remove(firedEmployee));

        }*/


        companyEmployees.remove(firedEmployee);
        return true;
    }

    @Override
    public void promoteEmployee(StandartEmployee downgradedEmployee) {


    }


    @Override
    public void downgradeEmployee(StandartEmployee downgradedEmployee) {

    }


}
