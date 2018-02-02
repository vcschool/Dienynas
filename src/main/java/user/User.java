package user;

public class User {


   private static String firstName;
   private static String lastName;
   private String role;
   private static String password;
   private String course;

   public User(String firstName, String lastName, String password, String course,String role) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.password = password;
      this.course = course;
      this.role = role;

   }

   public String getCourse() {
      return course;
   }

   public static String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public static String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }


   public String getRole() {
      return role;
   }

   public void setRole(String role) {
      this.role = role;
   }

   public static String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }
}
