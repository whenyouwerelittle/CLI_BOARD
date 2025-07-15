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

            // 커맨드에 입력한 내용을 actionCode, idx로 분류해서 필드로 저장
            Request request = new Request(command);

            if (request.getActionCode().equals("종료")) {
                systemController.exit();
                break;
            } else if (request.getActionCode().equals("등록")) {
                articleController.write();
            } else if (request.getActionCode().equals("목록")) {
                articleController.list();
            } else if (request.getActionCode().startsWith("삭제")) {
                articleController.delete(request);
            } else if (request.getActionCode().startsWith("수정")) {
                articleController.modify(request);
            }
        }
    }
}
/*package com.ll;

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

            // 커맨드에 입력한 내용을 actionCode, idx로 분류해서 필드로 저장
            Request request = new Request(command);

            if (request.getActionCode().equals("종료")) {
                systemController.exit();
                break;
            } else if (request.getActionCode().equals("등록")) {
                articleController.write();
            } else if (request.getActionCode().equals("목록")) {
                articleController.list();
            } else if (request.getActionCode().startsWith("삭제")) {
                articleController.delete(request.getIdx());
            } else if (request.getActionCode().startsWith("수정")) {
                articleController.modify(request.getIdx());
            }
        }
    }
}*/
/*
package com.ll.article;

import com.ll.Container;

import java.util.ArrayList;
import java.util.List;

public class ArticleController {
    List<Article> articleList = new ArrayList<>();
    int lastId = 1;

    public void write() {
        System.out.print("제목 : ");
        String subject = Container.getSc().nextLine().trim();
        System.out.print("내용 : ");
        String content = Container.getSc().nextLine().trim();

        Article article  = new Article(lastId, subject, content);
        articleList.add(article);

        System.out.printf("%d번 게시글이 등록되었습니다.\n", lastId);
        lastId++;
    }

    public void list() {
        System.out.println("번호 / 제목 / 내용");
        System.out.println("----------------------");

        for (int i = articleList.size() - 1; i >= 0; i--) {
            Article article = articleList.get(i);
            System.out.printf("%d / %s / %s\n", article.getId(), article.getSubject(), article.getContent());
        }
    }

    public void delete(int idx) {
        Article article = _getFindById(idx);

        if (article == null) {
            System.out.printf("%d번 게시물은 존재하지 않습니다.\n", idx);
        }
        else {
            articleList.remove(article);
            System.out.printf("%d번 게시물이 삭제되었습니다.\n", idx);
        }
    }

    public void modify(int idx) {
        Article article = _getFindById(idx);

        if (article == null) {
            System.out.printf("%d번 게시물은 존재하지 않습니다.\n", idx);
        }
        else {
            System.out.printf("제목(기존) : %s\n", article.getSubject());
            System.out.print("제목 : ");
            String modifySubject = Container.getSc().nextLine();
            article.setSubject(modifySubject);

            System.out.printf("내용(기존) : %s\n", article.getContent());
            System.out.print("내용 : ");
            String modifyContent = Container.getSc().nextLine();
            article.setContent(modifyContent);

            System.out.printf("%d번 게시물이 수정되었습니다.\n", idx);
        }
    }

    private Article _getFindById(int id) {
        for ( Article item : articleList ) {
            if ( item.getId() == id ) {
                return item;
            }
        }
        return null;
    }
}


*/
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

