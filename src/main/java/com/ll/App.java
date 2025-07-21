package com.ll;

import com.ll.article.ArticleController;
import com.ll.db.DBConnection;
import com.ll.system.SystemController;

public class App {
    ArticleController articleController;
    SystemController systemController;
    String loginId = new String();
    // public String loginId = new String(); // login 후 id 값 저장

    App() {
        DBConnection.DB_NAME = "testdb";
        DBConnection.DB_PORT = 3306;
        DBConnection.DB_USER = "root";
        DBConnection.DB_PASSWORD = "mys&Xph43K09";

        Container.getDBConnection().connect();

        articleController = new ArticleController();
        systemController = new SystemController();
    }

    public void run() {
        System.out.println("== Board ==");
        System.out.println("input exit : Close bbs");
        System.out.println("input list : Print out articles.");
        System.out.println("input logIn : log in before CUD BBS");
        System.out.println("input del?id=ID_NUM : Delete an articles with id");
        System.out.println("input new : Add an article.");
        System.out.println("input modify?id=ID_NUM : Edit an articles with id");

        while (true) {
            System.out.print("command) ");
            String command = Container.getSc().nextLine().trim();

            // 커맨드에 입력한 내용을 actionCode, idx로 분류해서 필드로 저장
            Request request = new Request(command);

            if (request.getActionCode().equals("exit")) {
                /*
                if(loginId.isEmpty() == false) {
                    System.out.println(loginId+"__");
                }
                */
                systemController.exit();
                break;
            } else if (request.getActionCode().equals("new")) {
                articleController.write();
            } else if (request.getActionCode().equals("list")) {
                articleController.list();
            } else if (request.getActionCode().startsWith("del")) {
                articleController.delete(request);
            } else if (request.getActionCode().startsWith("modify")) {
                articleController.modify(request);
            } else if (request.getActionCode().startsWith("logIn")){
                // System.out.println("you are in log in process.");
                String loginId = articleController.logIn();
            }
        }

    }
}