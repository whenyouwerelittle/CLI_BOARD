package com.ll;

import com.ll.article.ArticleController;
import com.ll.system.SystemController;

public class App {
    ArticleController articleController;
    SystemController systemController;

    App() {
        articleController = new ArticleController();
        systemController = new SystemController();
    }

    public void run() {
        System.out.println("== 게시판 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = Container.getSc().nextLine().trim();

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


/*
package com.ll;
import com.ll.article.ArticleController;
import com.ll.system.SystemController;
import java.util.Scanner;

public class App {
    // Scanner sc;
    ArticleController articleController;    // CRUD
    SystemController systemController;      // exit

    App(Scanner sc) {   // App Constructor method
        this.sc = sc;   // From Main class
        articleController = new ArticleController(sc);  // CRUD 객체 생성
        systemController = new SystemController();      // Exit 객체 생성
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
}*/
