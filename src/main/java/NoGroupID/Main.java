import java.util.Scanner;
// package NoGroupID;
public class Main {
    public static void main(String[] args) {
        /*
            종료
            ==게시판앱
            명령 종료
        */
        Scanner scanner = new Scanner(System.in);
        System.out.println("---게시글---");
        while(true){
            System.out.print("입력: ");
            String input = scanner.nextLine();
            if(input.equals("종료")){
                break;
            }
        }
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