import article.Article;
import article.ArticleController;
import system.SystemController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner sc;
    ArticleController articleController;
    SystemController systemController;

    App(Scanner sc) {
        this.sc = sc;
        articleController = new ArticleController(sc);
        systemController = new SystemController();
    }

    public void run() {
        System.out.println("== 게시판 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine().trim();
            if (command.equals("종료")) {
                systemController.exit();
                break;
            } else if (command.equals("등록")) {
                articleController.write();
            } else if (command.equals("목록")) {
                articleController.list();
            } else if (command.startsWith("삭제")) {
                articleController.delete(command);
            } else if (command.startsWith("수정")) {
                articleController.modify(command);
            }
        }
    }
}