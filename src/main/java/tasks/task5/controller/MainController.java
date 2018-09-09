package tasks.task5.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tasks.task2.Person;
import tasks.task4.CompanyEmployee;
import tasks.task4.CompanyHirerachy;

import java.util.Arrays;
import java.util.Map;

@Controller
public class MainController {
    static CompanyHirerachy company;

    static {
        company = new CompanyHirerachy();

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

    }

    // внедряем значение из application.properties
  //  @Value("${welcome.message:test}")
    private String message = "Hello World";

    // Обычно я использую интерфейс Model, но в целом разницы нет,
    // т.к. используется реализация LinkedHashMap(Key, Val)
    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "index";
    }
    @RequestMapping("/employees/{id}")
    public String getEmployee(@PathVariable int id, Map<String,Object> model) {
        CompanyEmployee employee = company.getEmployeeByID(id);

        model.put("id",id);
        model.put("name",employee.getName());
        model.put("paysTaxes",employee.isPaysTaxes());
        model.put("directReportsIDs",employee.getDirectReportsIDs());
        model.put("managersIDs",employee.getManagersIDs());

        return "employee";

    }

    @RequestMapping("/all")
    public String allEmployees(Map<String, Object> model)
    {
        model.put("allEmployees",company.getCompanyEmployees());
        model.put("employee",company.getEmployeeByID(2));
        model.put("name",company.getEmployeeByID(2).getName());
        model.put("directReports",company.getEmployeeByID(2).getDirectReportsIDs());
        return "employeesList";
    }

    /*@RequestMapping("/employees/{id}")
    public String getEmployee(@PathVariable String id) {

        return "sdd";
    }*/
}