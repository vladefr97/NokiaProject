package tasks.task2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PersonsManage {

    public static void main(String[] args) {
        PersonsManage manage = new PersonsManage();

        System.out.println(manage.getWithoutFifthPersonsList(Person.getRandomPersonsList(10)));
    }


    public PersonsManage() {

    }


    public  Map<Integer, List<Person>> getListOfPersonForEachAge(List<Person> personsList) {//this function returns map in which key - person's age, value - list of persons with this age

        Map<Integer, List<Person>> personByAge = personsList.stream().collect(
                Collectors.groupingBy(Person::getAge)
        );

        return personByAge;
    }

    public void printEachPersonByAge(Map<Integer, List<Person>> personByAge) {//printing persons grouping by age

        for (Map.Entry<Integer, List<Person>> item : personByAge.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue().size());
            for (Person person : item.getValue())
                System.out.println(person);
        }
    }


    public  List<Person> getWithoutFifthPersonsList(List<Person> personsList) {//this function returns list of persons in which every fifth element is removed

        System.out.println("-----------Изначальный----------");
        personsList.forEach(x -> System.out.println(x));

        List<Person> list2 = IntStream.range(0, personsList.size())
                .filter(n -> n % 5 == 0)
                .mapToObj(personsList::get)
                .collect(Collectors.toList());


        personsList = personsList.stream().filter(x -> !list2.contains(x)).collect(Collectors.toList());
        System.out.println("---------Конечный--------------");
        personsList.forEach(x -> System.out.println(x));

        return personsList;


    }

}
