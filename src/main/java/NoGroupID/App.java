package NoGroupID;
import java.util.Scanner;
public class App {
    Scanner sc1;
    App(Scanner sc1){
        this.sc1 = sc1;
    }
    public void run(){
        int lastId =1;
        System.out.println("---Command line board---");
        System.out.println("Prompt : write");

        while(true){
            String message = sc1.nextLine();
            if(message.equals("end")){
                break;
            }else if(message.equals("write")){
                System.out.print("Title :");
                String title = sc1.nextLine().trim();
                System.out.print("Contents :");
                String contents = sc1.nextLine().trim();
                System.out.printf("%d message is added in the board.\r", lastId);
                lastId++;
            }

        }
    }
}
