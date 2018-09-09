package tasks.task5.controller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompanyApplication {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        SpringApplication.run(CompanyApplication.class, args);

    }
}
