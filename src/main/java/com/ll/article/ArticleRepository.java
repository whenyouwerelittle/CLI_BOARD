package com.ll.article;

import com.ll.Container;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArticleRepository {
    int lastId = 1;
    // private Connection connection; 다음 기회에


    public int create(String title, String content, String userId, String userPassowrd) {
        List<Article> memberList = new ArrayList<>();
        List<Map<String, Object>> rows = Container.getDBConnection().selectRows("select userType from member where userId='"+userId+"' and password='"+userPassowrd+"'"); // notice type : 0, general article type :1
        if(rows.isEmpty()){
            // System.out.println("Please check your id/password again");
            return 0;
        }else{
            Object userTypeObj = rows.get(0).get("userType");
            int userType = Integer.parseInt(userTypeObj.toString());

            // userType : 1 -> contentType : 1, userType 0 -> contentType : 0(관리자)
            // title, content, memberId, contentType
            String sql = String.format("insert into article set title='%s', content='%s', memberId='%s', contentType=%s", title, content, userId, userType);
            int id = Container.getDBConnection().insert(sql);
            return id;
        }
    }



    public List<Article> findAll() {
        List<Article> articleList = new ArrayList<>();
        List<Map<String, Object>> rows = Container.getDBConnection().selectRows("select * from article order by contentType desc"); // notice type : 0, general article type :1
        for ( Map<String, Object> row : rows ) {
            Article article = new Article(row);
            articleList.add(article);
        }

        return articleList;
    }

    public Article findById(int id) {
        List<Article> articleList = this.findAll();

        for (Article item : articleList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void remove(Article article, String userId, String userPassword) {
        List<Article> memberList = new ArrayList<>();
        List<Map<String, Object>> rows = Container.getDBConnection().selectRows("select * from member where userId='"+userId+"' and password='"+userPassword+"'"); // notice type : 0, general article type :1

        if(rows.size() != 1){
            System.out.println("Please check your id/password again");
        }else{
            String sql = String.format("DELETE FROM article where id ='%d'", article.getId());
            Container.getDBConnection().delete(sql);
            System.out.printf("No. %d article is deleted.\n", article.getId());
        }

    }

    public void modify(Article article, String modifySubject, String modifyContent, String userId, String password) {
        List<Article> memberList = new ArrayList<>();
/*
        //다음기회에        
        String sql = "select * from member where userId=? and password=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, userId);
        pstmt.setString(2, password);   

*/
        //List<Map<String, Object>> rows = Container.getDBConnection().selectRows(pstmt.toString());
        List<Map<String, Object>> rows = Container.getDBConnection().selectRows("select * from member where userId='"+userId+"' and password='"+password+"'"); // notice type : 0, general article type :1
        
        if(rows.isEmpty()==true){
            // return null;
            System.out.println("Please check your id/password again");
        }else{
            String sql = String.format("update article set title='%s', content='%s' where id ='%d'", modifySubject, modifyContent, article.getId());
            Container.getDBConnection().update(sql);
            System.out.printf("No. %d article is updated.\n", article.getId());
        }
        // String sql = String.format("update article set subject='%s', content='%s' where id = %d", modifySubject, modifyContent, article.getId());
        // Container.getDBConnection().update(sql);
    }
}