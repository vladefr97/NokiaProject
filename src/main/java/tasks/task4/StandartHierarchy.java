package tasks.task4;

import tasks.task2.Person;

import java.util.List;

public interface StandartHierarchy {

    void addEmploye(
            StandartEmployee newEmployee,
            List<StandartEmployee> directReports,
            List<StandartEmployee> managers
    );

    Boolean deleteEmploye(StandartEmployee firedEmployee);

    void promoteEmploye(StandartEmployee downgradedEmployee);


    void downgradeEmployee(StandartEmployee downgradedEmployee);
}
