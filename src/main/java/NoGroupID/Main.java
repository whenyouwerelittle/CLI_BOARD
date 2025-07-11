package NoGroupID;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---게시판 앱---");
        System.out.println("명령)등록");

        while(true){
            System.out.print("제목 :");
            String input = scanner.nextLine();
            if(input.equals("제목1")){
                break;
            }
        }

        while(true){
            System.out.print("내용 :");
            String input2 = scanner.nextLine();
            if(input2.equals("내용1")){
                break;
            }
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