package tasks.task2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class PersonsManageTest {

    PersonsManage personsManager;

    @Before
    public void setUp() throws Exception {
        personsManager = new PersonsManage();
    }

    @After
    public void tearDown() throws Exception {
        personsManager = null;
    }

    @Test
    public void getListOfPersonForEachAge() {

        Map<Integer, List<Person>> resultMap = personsManager.getListOfPersonForEachAge(Arrays.asList(
                new Person(10, false, "Hillary"),
                new Person(25, true, "Vladimir"),
                new Person(10, false, "Angela")
                ));

        Map<Integer, List<Person>> expectedMap = new HashMap<>();
        expectedMap.put(25, Arrays.asList(new Person(25, true, "Vladimir")));
        expectedMap.put(10, Arrays.asList(
                new Person(10,false,"Hillary"),
                new Person(10,false,"Angela")
        ));


        boolean check = true;
        if (resultMap.entrySet().size() != expectedMap.entrySet().size())
            check = false;
        else {

            int size = Math.min(resultMap.entrySet().size(), expectedMap.entrySet().size());


            Iterator<Map.Entry<Integer, List<Person>>> resultIterator = resultMap.entrySet().iterator();
            Iterator<Map.Entry<Integer, List<Person>>> expectedIterator = expectedMap.entrySet().iterator();

            while (resultIterator.hasNext() && expectedIterator.hasNext()) {
                Map.Entry<Integer, List<Person>> tempExcp = expectedIterator.next();
                Map.Entry<Integer, List<Person>> tempRes = resultIterator.next();

                if (tempExcp.getValue().size() != tempRes.getValue().size() || tempExcp.getKey() != tempRes.getKey())
                    check = false;
            }

            if(resultIterator.hasNext()||expectedIterator.hasNext())
                check = false;

        }

        System.out.println("----------Expected-------");
        personsManager.printEachPersonByAge(expectedMap);
        System.out.println("----------Result---------");
        personsManager.printEachPersonByAge(resultMap);

        assertEquals(true, check);

    }

    @Test
    public void printEachPersonByAge() {


    }

    @Test
    public void getFifthPesronsList() {
        List<Person> originalPersonList = Arrays.asList(
                new Person(66, true, "Petr"),
                new Person(24, true, "Vladimir"),
                new Person(98, false, "Angela"),
                new Person(73, true, "Donald"),
                new Person(92, true, "Aleksey"),
                new Person(30, false, "Ksenia"),
                new Person(82, false, "Angela"),
                new Person(65, false, "Hillary"),
                new Person(69, true, "Aleksey"),
                new Person(10, true, "Elizabeth")
        );

        List<Person> expectedPersonList = Arrays.asList(
                new Person(24, true, "Vladimir"),
                new Person(98, false, "Angela"),
                new Person(73, true, "Donald"),
                new Person(92, true, "Aleksey"),
                new Person(82, false, "Angela"),
                new Person(65, false, "Hillary"),
                new Person(69, true, "Aleksey"),
                new Person(10, true, "Elizabeth")
        );

        List<Person> resultList = personsManager.getWithoutFifthPersonsList(originalPersonList);

        boolean check = true;

        if (expectedPersonList.size() != resultList.size())
            check = false;
        else {

            int size = Math.min(expectedPersonList.size(), resultList.size());
            for (int i = 0; i < size; i++)
                if (expectedPersonList.get(i).compareTo(resultList.get(i)) != 0)
                    check = false;

        }
        assertEquals(true, check);


    }
}