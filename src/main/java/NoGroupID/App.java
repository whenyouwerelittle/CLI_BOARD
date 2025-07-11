package NoGroupID;
import java.util.Scanner;
public class App {
    Scanner sc1;
    App(Scanner sc1){
        this.sc1 = sc1;
    }

    public void run(){
        int lastId =1;
        System.out.println("---게시판 앱---");

        while(true){
            System.out.println("명령)등록");
            String message = sc1.nextLine();

            if(message.equals("종료")){
                break;
            }else if(message.equals("등록")){
                System.out.print("제목 :");
                String title = sc1.nextLine().trim();

                System.out.print("내용 :");
                String contents = sc1.nextLine().trim();
                System.out.printf("%d번 게시물이 등록되었습니다.\r", lastId);
                lastId++;
            }

        }
    }
}
