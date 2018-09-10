package tasks.task4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tasks.task2.Person;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CompanyHirerachyTest {

    CompanyHirerachy company;

    CompanyEmployee Igor;
    CompanyEmployee John;
    CompanyEmployee Ivan;
    CompanyEmployee Petr;
    CompanyEmployee Vasia;

    @Before
    public void setUp() throws Exception {
        company = new CompanyHirerachy();

        Igor = new CompanyEmployee(new Person(22, true, "Igor"), true);
        John = new CompanyEmployee(new Person(22, true, "John"), true);
        Ivan = new CompanyEmployee(new Person(22, true, "Ivan"), true);
        Petr = new CompanyEmployee(new Person(22, true, "Petr"), true);
        Vasia = new CompanyEmployee(new Person(44, true, "Vasia"), true);

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

    @After
    public void tearDown() throws Exception {
        company = null;
        Ivan = null;
        John = null;
        Igor = null;
        Petr = null;
        Vasia = null;
    }

    @Test
    public void getCompanyEmployees() {

        List<CompanyEmployee> expectedList = Arrays.asList(Igor, John, Ivan, Petr, Vasia);

        assertEquals(expectedList, company.getCompanyEmployees());
    }

    @Test
    public void assignEmployees() {
    }

    @Test
    public void companyContainsEmployeeWithID() {

        assertEquals(true, company.companyContainsEmployeeWithID(Igor.getId()));
        company.deleteEmployee(Igor);
        assertEquals(false, company.companyContainsEmployeeWithID(Igor.getId()));

    }

    @Test
    public void getEmployeeByID() {

        int i = Igor.getId();

        assertEquals(Igor, company.getEmployeeByID(i));
    }

    @Test
    public void addEmployees() {
    }

    @Test
    public void addEmployee() {
    }

    @Test
    public void deleteEmployee() {

        assertEquals(true, company.companyContainsEmployeeWithID(Vasia.getId()));
        company.deleteEmployee(Vasia);
        assertEquals(false, company.companyContainsEmployeeWithID(Vasia.getId()));

    }

    @Test
    public void promoteEmployee() {
    }

    @Test
    public void downgradeEmployee() {
    }
}