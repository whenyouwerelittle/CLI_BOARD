package com.ll.article;

import com.ll.Container;
import com.ll.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArticleController {
    ArticleService articleService;
    // public String loginId = new String();
    public ArticleController() {
        articleService = new ArticleService();
    }

    public void write() {
        System.out.print("Title : ");
        String subject = Container.getSc().nextLine().trim();
        System.out.print("Content : ");
        String content = Container.getSc().nextLine().trim();
        System.out.print("ID : ");
        String userID = Container.getSc().nextLine().trim();
        System.out.print("Password : ");
        String userPassword = Container.getSc().nextLine().trim();

        int id = articleService.create(subject, content, userID, userPassword);
        // int id = articleService.create(subject, content);
        if(id!=0) {
            System.out.printf("%d번 게시글이 등록되었습니다.\n", id);
        }else{
            System.out.printf("Please double check your ID/Password.");
        }
    }

    public void list() {
        List<Article> articleList = articleService.findAll();
        System.out.println("SN \t||\t Type \t||\t Title \t||\t Content");
        System.out.println("--------------------------------------------");
        String contentType;//print out admin's notice first
        for (int i = articleList.size() - 1; i >= 0; i--) {
            Article article = articleList.get(i);
            if(article.getContentType()==1){
                contentType = new String("Article");
            }else{
                contentType = new String("Noti");
            }
            System.out.printf("%d \t|| "+contentType+" \t|| %s \t|| %s\n", article.getId(), article.getSubject(), article.getContent());
        }
    }

    public String logIn() {
        // List<Article> articleList = articleService.findAll();
        System.out.print("id : ");
        String userId = Container.getSc().nextLine().trim();
        System.out.print("password : ");
        String userPassword = Container.getSc().nextLine().trim();

        List<Article> articleList = new ArrayList<>();
        List<Map<String, Object>> rows = Container.getDBConnection().selectRows("select * from member where userId='"+userId+"' and password='"+userPassword+"'");
        boolean result = rows.isEmpty();
        System.out.println(result);
        if(result){
            System.out.println("check out your id and password");
            // this.logIn(); // 다음 기회에
            return null;
        }else{
            System.out.println("log in successful");
            return userId;

        }
/*
        System.out.println("번호 / 구분 / 제목 / 내용");
        System.out.println("----------------------");
        for (int i = articleList.size() - 1; i >= 0; i--) {
            Article article = articleList.get(i);
            System.out.printf("%d / %s / %s\n", article.getId(), article.getSubject(), article.getContent());
        }
        */
    }

    public void delete(Request request) {
        int id = _getIntParam(request.getParams("id"));
        if (id == -1) {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        Article article = articleService.findById(id);

        if (article == null) {
            System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
        } else {
            /*id, pasword 점검 */
            System.out.print("id : ");
            String userId = Container.getSc().nextLine().trim();
            System.out.print("password : ");
            String userPassword = Container.getSc().nextLine().trim();
            articleService.remove(article, userId, userPassword);
            // articleService.remove(article);
            // System.out.printf("%d번 게시물이 삭제되었습니다.\n", id);
        }
    }

    public void modify(Request request) {
        int id = _getIntParam(request.getParams("id"));

        if (id == -1) {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        Article article = articleService.findById(id);

        if (article == null) {
            System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
        } else {
            System.out.printf("제목(기존) : %s\n", article.getSubject());
            System.out.print("제목 : ");
            String modifySubject = Container.getSc().nextLine();

            System.out.printf("내용(기존) : %s\n", article.getContent());
            System.out.print("내용 : ");
            String modifyContent = Container.getSc().nextLine();

            /*id password 확인*/
            System.out.print("id : ");
            String userId = Container.getSc().nextLine().trim();
            System.out.print("password : ");
            String userPassword = Container.getSc().nextLine().trim();

            // articleService.modify(Article article, String modifySubject, String modifyContent);
            articleService.modify(article, modifySubject, modifyContent, userId, userPassword);

            // System.out.printf("%d번 게시물이 수정되었습니다.\n", id);
        }
    }

    private int _getIntParam(String id) {
        int defaultValue = -1;

        try {
            return Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}