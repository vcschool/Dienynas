import servise.Connecting;
import servise.DATAcontrol;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome MVIS");
        System.out.println("+++ INSERT YOUR NAME AND PASWORD +++");

        DATAcontrol.creatDB();

        Connecting connect = new Connecting();

       while (true){connect.login();}

    }
}
