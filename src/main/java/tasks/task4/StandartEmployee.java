package tasks.task4;

import java.util.List;

public interface StandartEmployee {
    double getIncome();

    String getName();

    List<Integer> getManagersIDs();

    List<Integer> getDirectReportsIDs();
}
