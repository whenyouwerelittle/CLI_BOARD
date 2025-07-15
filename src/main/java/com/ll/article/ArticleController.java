package com.ll.article;

import com.ll.Container;
import com.ll.Request;

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

    public void delete(Request request) {
        int id = _getIntParam(request.getParams("id"));

        if ( id == -1 ) {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        Article article = _getFindById(id);

        if (article == null) {
            System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
        }
        else {
            articleList.remove(article);
            System.out.printf("%d번 게시물이 삭제되었습니다.\n", id);
        }
    }

    public void modify(Request request) {
        int id = _getIntParam(request.getParams("id"));

        if ( id == -1 ) {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        Article article = _getFindById(id);

        if (article == null) {
            System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
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

            System.out.printf("%d번 게시물이 수정되었습니다.\n", id);
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

    private int _getIntParam(String id) {
        int defaultValue = -1;

        try {
            return Integer.parseInt(id);
        } catch(NumberFormatException e) {
            return defaultValue;
        }
    }
}
/*package com.ll.article;

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

    public void delete(String command) {
        String[] commandList = command.split("\\?", 2);
        String[] paramsStr = commandList[1].split("=", 2);

        String value =  paramsStr[1];
        int idx = Integer.parseInt(value);

        Article article = _getFindById(idx);

        if (article == null) {
            System.out.printf("%d번 게시물은 존재하지 않습니다.\n", idx);
        }
        else {
            articleList.remove(article);
            System.out.printf("%d번 게시물이 삭제되었습니다.\n", idx);
        }
    }

    public void modify(String command) {
        String[] commandList = command.split("\\?", 2);
        String[] paramsStr = commandList[1].split("=", 2);

        String value =  paramsStr[1];
        int idx = Integer.parseInt(value);

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
package com.ll.article;
import com.ll.Container;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArticleController {
    // Scanner sc;
    List<Article> articleList = new ArrayList<>(); //최초 선언
    int lastId = 1;

    public ArticleController() {
        // this.sc = sc;
    }

    public void write() {
        System.out.print("제목 : ");
        String subject = Container.getSc().nextLine().trim();
        System.out.print("내용 : ");
        String content = Container.getSc().nextLine().trim();

        Article article  = new Article(lastId, subject, content);
        articleList.add(article);

        System.out.printf("%d번 게시글이 등록되었습니다.\n", lastId);
        // System.out.println(articleList.getFirst());     // printout article.Article@548c4f57
        System.out.println(articleList.get(0));     // printout article.Article@548c4f57
        //System.out.println(articleList.get(0).getClass()); // class article.Article
        lastId++;
        // System.out.println(articleList.); article.Article@548c4f57
    }

    public void list() {
        System.out.println("번호 / 제목 / 내용");
        System.out.println("----------------------");

        for (int i = articleList.size() - 1; i >= 0; i--) {
            Article article = articleList.get(i);
            System.out.printf("%d / %s / %s\n", article.getId(), article.getSubject(), article.getContent());
        }
    }

    public void delete(String command) {
        String[] commandList = command.split("\\?", 2);
        String[] paramsStr = commandList[1].split("=", 2);

        String value =  paramsStr[1];
        int idx = Integer.parseInt(value);

        Article article = _getFindById(idx);

        if (article == null) {
            System.out.printf("%d번 게시물은 존재하지 않습니다.\n", idx);
        }
        else {
            articleList.remove(article);
            System.out.printf("%d번 게시물이 삭제되었습니다.\n", idx);
        }
    }

    public void modify(String command) {
        String[] commandList = command.split("\\?", 2);
        String[] paramsStr = commandList[1].split("=", 2);

        String value =  paramsStr[1];
        int idx = Integer.parseInt(value);

        Article article = _getFindById(idx);

        if (article == null) {
            System.out.printf("%d번 게시물은 존재하지 않습니다.\n", idx);
        }
        else {
            System.out.printf("제목(기존) : %s\n", article.getSubject());
            System.out.print("제목 : ");
            String modifySubject = sc.nextLine();
            article.setSubject(modifySubject);

            System.out.printf("내용(기존) : %s\n", article.getContent());
            System.out.print("내용 : ");
            String modifyContent = sc.nextLine();
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
}*/

