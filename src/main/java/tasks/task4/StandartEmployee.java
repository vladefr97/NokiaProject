package tasks.task4;

import java.util.List;

public interface StandartEmployee {
    double getIncome();

    List<StandartEmployee> getManagers();

    List<StandartEmployee> getDirectReports();
}
