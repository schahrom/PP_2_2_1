package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      User user2 = new User("Roman", "Kasimov", "romankasimov@gmail.com");
      Car car = new Car("Model S", 12);
      user2.setCar(car);
      User user1 = new User("Dmitry" ,"Tudvasev", "tudvdim@gmail.com");
      Car car1 = new Car("Model T", 234);
      user1.setCar(car1);

      userService.add(user2);
      userService.add(user1);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car  = " + user.getCar());
         System.out.println();
      }


      System.out.println("______________________________________________");


      List<User> users1 = userService.getUserByCar("Model S", 12);
      List<User> userList = userService.getUserByCar("Model T", 234);

      List<User> resList = new ArrayList<>();
      resList.addAll(userList);
      resList.addAll(users1);
      for (User dataUser : resList) {
         System.out.println("Id = " + dataUser.getId());
         System.out.println("First Name = " + dataUser.getFirstName());
         System.out.println("Last Name = " + dataUser.getLastName());
         System.out.println("Email = " + dataUser.getEmail());
         System.out.println("Car  = " + dataUser.getCar());
         System.out.println();
      }

      context.close();
   }
}
