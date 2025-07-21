package com.ll.article;

import java.util.List;

public class ArticleService {
    ArticleRepository articleRepository;

    public ArticleService() {
        articleRepository = new ArticleRepository();
    }

    public int create(String subject, String content, String userId, String userPassword) {
        return articleRepository.create(subject, content, userId, userPassword);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article findById(int id) {
        return articleRepository.findById(id);
    }
//articleService.remove(article, userId, userPassword);
    public void remove(Article article, String userId, String userPassword) {
        articleRepository.remove(article, userId, userPassword);
    }
// articleService.modify(article, modifySubject, modifyContent, userId, userPassword);
    public void modify(Article article, String modifySubject, String modifyContent, String userId, String userPassword) {
        articleRepository.modify(article, modifySubject, modifyContent,userId,userPassword );
    }
}