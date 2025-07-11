package NoGroupID;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        new App(sc1).run();
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
        sc1.close();
    }
}