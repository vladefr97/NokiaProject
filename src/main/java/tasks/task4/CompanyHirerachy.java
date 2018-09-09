package tasks.task4;

import tasks.task2.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CompanyHirerachy implements StandartHierarchy {


    List<CompanyEmployee> companyEmployees;

    public List<CompanyEmployee> getCompanyEmployees() {
        return companyEmployees;
    }


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

        company.addEmploye(
                John,
                Arrays.asList(
                        Ivan,
                        Petr
                ),
                Arrays.asList(
                        Igor
                )
        );

        company.addEmploye(Vasia,
                null,
                Arrays.asList(Igor)
        );
      /*  company.addEmploye(
                new CompanyEmployee(Person.getRandomPerson(), true, 5),
                Arrays.asList(
                        new CompanyEmployee(Person.getRandomPerson(), true, 2),
                        new CompanyEmployee(Person.getRandomPerson(), true, 2)
                ),
                Arrays.asList(
                        new CompanyEmployee(Person.getRandomPerson(), false, 9)
                )
        );*/


        System.out.println(company);
        company.deleteEmploye(John);

    }

    @Override
    public String toString() {
        return "CompanyHirerachy{" +
                "companyEmployees=" + companyEmployees +
                '}';
    }


    @Override
    public void addEmploye(StandartEmployee newEmployee, List<StandartEmployee> directReports, List<StandartEmployee> managers) {

        if (directReports != null) {
            ((CompanyEmployee) newEmployee).setDirectReports(directReports);
            directReports.forEach(x -> ((CompanyEmployee) x).addManager(newEmployee));
            directReports.stream().filter(x -> !companyEmployees.contains(x)).forEach(x -> companyEmployees.add((CompanyEmployee) x));
        }

        if (managers != null) {
            ((CompanyEmployee) newEmployee).setManagers(managers);
            managers.forEach(x -> ((CompanyEmployee) x).addDirectReport(newEmployee));
            managers.stream().filter(x -> !companyEmployees.contains(x)).forEach(x -> companyEmployees.add((CompanyEmployee) x));
        }
        companyEmployees.add((CompanyEmployee) newEmployee);


    }

    @Override
    public Boolean deleteEmploye(StandartEmployee firedEmployee) {
        if (!companyEmployees.contains(firedEmployee)) return false;

        if (firedEmployee.getManagers().isEmpty() && !firedEmployee.getDirectReports().isEmpty()) {//The director of company or person without managers and direct reports is fired
            if (firedEmployee.getDirectReports() == null) {
                companyEmployees.remove(firedEmployee);
            } else {
                //uncheked--------------------------------------------------------------------
                //--------------------------------------------------------
                //new director is employee with the least count of direct reports
                CompanyEmployee newDirector = (CompanyEmployee) firedEmployee.getDirectReports()
                        .stream()
                        .filter(x -> x.getDirectReports() != null)
                        .min((x1, x2) -> x1.getDirectReports().size() > x2.getDirectReports().size() ? 1 : -1)
                        .get();


                if (firedEmployee.getDirectReports().size() != 1 && !firedEmployee.getDirectReports().isEmpty()) {
                    firedEmployee.getDirectReports().remove(newDirector);
                    newDirector.setDirectReports(firedEmployee.getDirectReports());
                    newDirector.setManagers(null);
                    firedEmployee.getDirectReports().forEach(x -> ((CompanyEmployee) x).setManagers(Arrays.asList(newDirector)));
                } else
                    newDirector.setManagers(null);


            }

        } else if (firedEmployee.getManagers().size() == 1 && !firedEmployee.getDirectReports().isEmpty()) {
            firedEmployee.getManagers().forEach(x -> x.getDirectReports().remove(firedEmployee));
            firedEmployee.getManagers().forEach(x -> ((CompanyEmployee) x).addDirectReports(firedEmployee.getDirectReports()));
            firedEmployee.getDirectReports().forEach(x -> ((CompanyEmployee) x).setManagers(firedEmployee.getManagers()));

        } else if (firedEmployee.getManagers().size() > 1 && !firedEmployee.getDirectReports().isEmpty()) {

            firedEmployee.getManagers().forEach(x -> x.getDirectReports().remove(firedEmployee));
            ((CompanyEmployee)firedEmployee.getManagers().get(0)).addDirectReports(firedEmployee.getDirectReports());
            firedEmployee.getDirectReports().forEach(x->((CompanyEmployee)x).addManager(firedEmployee.getManagers().get(0)));
            firedEmployee.getDirectReports().forEach(x->x.getManagers().remove(firedEmployee));

        }else if(firedEmployee.getDirectReports().isEmpty())
        {
            firedEmployee.getManagers().forEach(x->x.getDirectReports().remove(firedEmployee));

        }
        companyEmployees.remove(firedEmployee);
        return true;
    }

    @Override
    public void promoteEmploye(StandartEmployee downgradedEmployee) {



    }


    @Override
    public void downgradeEmployee(StandartEmployee downgradedEmployee) {

    }


    public StandartEmployee getEmploye() {

        return null;
    }
}
