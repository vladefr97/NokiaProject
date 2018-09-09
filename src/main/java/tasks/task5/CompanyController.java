package tasks.task5;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tasks.task2.Person;
import tasks.task4.CompanyEmployee;
import tasks.task4.CompanyHirerachy;

import java.util.Arrays;
import java.util.List;

@RestController
public class CompanyController {
    private static CompanyHirerachy company;

    public static void main(String[] args) {

    }

    @RequestMapping("/employee")
    public List<CompanyEmployee> getAllEmployee(){
        company = new CompanyHirerachy();

        CompanyEmployee Igor = new CompanyEmployee(new Person(22, true, "Igor"), true);
        CompanyEmployee John = new CompanyEmployee(new Person(22, true, "John"), true);
        CompanyEmployee Ivan = new CompanyEmployee(new Person(22, true, "Ivan"), true);
        CompanyEmployee Petr = new CompanyEmployee(new Person(22, true, "Petr"), true);
        CompanyEmployee Vasia = new CompanyEmployee(new Person(44, true, "Vasia"), true);

        company.addEmployees(Arrays.asList(Igor,John,Ivan,Petr,Vasia));


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


        return company.getCompanyEmployees();

    }
}
