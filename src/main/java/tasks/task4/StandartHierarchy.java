package tasks.task4;



public interface StandartHierarchy {

    void addEmployee(StandartEmployee newEmployee);

    Boolean deleteEmployee(StandartEmployee firedEmployee);

    void promoteEmployee(StandartEmployee downgradedEmployee);


    void downgradeEmployee(StandartEmployee downgradedEmployee);
}
