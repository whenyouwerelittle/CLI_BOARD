package com.ll.article;

import java.util.List;

public class ArticleService {

    ArticleRepository articleRepository;

    public ArticleService() {
        articleRepository = new ArticleRepository();
    }

    public int create(String subject, String content) {
        return articleRepository.create(subject, content);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article getFindById(int id) {
        return articleRepository.getFindById(id);
    }

    public void remove(Article article) {
        articleRepository.remove(article);
    }

    public void modify(Article article, String modifySubject, String modifyContent) {
        articleRepository.modify(article, modifySubject, modifyContent);
    }
}
/*
package com.ll.article;
import java.util.ArrayList;
import java.util.List;

public class ArticleService {
    List<Article> articleList = new ArrayList<>();
    int lastId = 1;

    public int create(String subject, String content) {
        Article article  = new Article(lastId, subject, content);
        articleList.add(article);

        lastId++;

        return article.getId();
    }

    public List<Article> findAll() {
        return articleList;
    }

    public Article getFindById(int id) {
        for ( Article item : articleList ) {
            if ( item.getId() == id ) {
                return item;
            }
        }
        return null;
    }

    public void remove(Article article) {
        articleList.remove(article);
    }

    public void modify(Article article, String modifySubject, String modifyContent) {
        article.setSubject(modifySubject);
        article.setContent(modifyContent);
    }
}*/
