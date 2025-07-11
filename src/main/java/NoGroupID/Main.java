package NoGroupID;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lastId =1;
        System.out.println("---게시판 앱---");


        while(true){
            System.out.println("명령)등록");
            String message = scanner.nextLine();

            if(message.equals("종료")){
                break;
            }else if(message.equals("등록")){
                System.out.print("제목 :");
                String title = scanner.nextLine().trim();

                System.out.print("내용 :");
                String contents = scanner.nextLine().trim();
                System.out.printf("%d번 게시물이 등록되었습니다.\r", lastId);

            }
            lastId++;
        }


        System.out.println("명령)종료");
        /*
        int sum = 0;
        String input;

        System.out.println("글을 입력하세요 (종료하려면 0 입력):");

        while (true) {
            System.out.print("입력: ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase(0)) {
                break; // "exit" 입력 시 반복 종료
            }

            try {
                String message = Integer.parseInt(input);
                // sum += number;
            } catch (NumberFormatException e) {
                System.out.println("유효하지 않은 숫자입니다. 다시 입력해주세요.");
            }
        }

        System.out.println("총 합계: " + sum);*/
        scanner.close();
    }
}