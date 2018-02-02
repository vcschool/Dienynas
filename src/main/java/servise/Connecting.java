package servise;

import user.User;
import user.UserDATAcontrol;

import java.sql.Date;
import java.util.Scanner;



public class Connecting {

    private static String lastName;
    private static String firstName;
    private static String password;


    public void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert first name:");
        firstName = scanner.next();
        System.out.println("Ïnsert last name:");
        lastName = scanner.next();
        System.out.println("Insert password:");
        password = scanner.next();

        Admin admin = new Admin();

        String admFN = admin.getFirstName();
        String admLN = admin.getLastName();
        String admP = admin.getPassword();

        User user = findUser(firstName);

        if (admFN.equals(firstName) && admLN.equals(lastName) && admP.equals(password)) {


            launchAdmin();




        } else {

            if (firstName.equals(user.getFirstName()) && lastName.equals(user.getLastName()) && password.equals(user.getPassword())) {

                launchUers(user);

            }

            System.out.println("Wrong name or password");

        }



    }


    public User findUser(String username) {

        return UserDATAcontrol.connectUser(username);
    }

    private void launchUers(User user) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + user.getRole());

        user = findUser(firstName);

     while (true) {
         if (user.getRole().equals("student")) {

             System.out.println("Press function number:");
             System.out.println("1. See chosen courses");
             System.out.println("2. See all courses");
             System.out.println("3. Change password");
             System.out.println("4. Exit");

             int numb = scanner.nextInt();

             switch (numb) {
                 case 1:
                     System.out.println(user.getCourse());
                     break;
                 case 2:
                     System.out.println(UserDATAcontrol.findCourse());

                     break;
                 case 3:System.out.println("insert new password");
                     String pasw = scanner.next();
                     UserDATAcontrol.changePassword(pasw,user.getFirstName(),user.getLastName());
                     break;
                 case 4:
                     System.exit(1);
                     break;


             }
         } else if (user.getRole().equals("lecturer")) {

             System.out.println(user.getRole() + "lecturer.");

             System.out.println("1. See students");
             System.out.println("2. Change password");
             System.out.println("3. Exit");

             int numb = scanner.nextInt();


             switch (numb){

                 case 1:
                     System.out.println("insert course");
                     String course = scanner.next();
                     UserDATAcontrol.findStudents(course);
                     break;
                 case 2:
                     System.out.println("insert new password");
                     String pasw = scanner.next();
                     UserDATAcontrol.changePassword(pasw,user.getFirstName(),user.getLastName());
                     break;
                 case 3: System.exit(1);
                     break;


             }


         }

     }

    }


    private static void launchAdmin() {
        System.out.println("Welcome ADMIN");
        Scanner sc = new Scanner(System.in);
while(true){

        System.out.println("Insert task number");
        System.out.println("1.Insert user");
        System.out.println("2.Find user ");
        System.out.println("3.EXIT");

        int numb = sc.nextInt();

        switch (numb){

            case 1:System.out.println("first name");
        String firstName = sc.next();
        System.out.println("last name");
        String lastName = sc.next();

        //====== Galima padaryti random skaiciaus paskyrima SQL arba java su rand.nextInt(50)
//      System.out.println("personal number");
//        int personalNumber = sc.nextInt();
        System.out.println("role");
        String role = sc.next();
        System.out.println("password");
        String password = sc.next();
        System.out.println("course");
        String course = sc.next();

        User user = new User(firstName,lastName,password,course,role);

                DATAcontrol.insertUser(user);
                break;

            case 2: System.out.println("Find user");
                System.out.println("first name");
                String fN = sc.next();
                System.out.println("User:");

                DATAcontrol.getUser(fN);
                break;
//            case 3:
//                String title1;
//                Date startDate2;
//                System.out.println("Insert course title");
//                title1 = sc.next();
//                System.out.println("Insert Date (reik konvertinti inputa)");
//                startDate2 = null;
//
//                //nebaigtas, reikia pakoreguoti (neleidzia ivesti startDate)!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//
//                Course course1 = new Course(title1,startDate2,0);
//
//                courseControl();
//
//                break;
            case 3:
                System.exit(1);
                break;
            default:
                return;



        }
    }




    }



}
