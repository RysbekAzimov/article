package com.example.test_academy.service;

import com.example.test_academy.entity.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    List<Article> getAllArticles();
    Optional<Article> getArticleById(Long id);
    Article createArticle(Article article);
    Optional<Article> updateArticle(Long id, Article updatedArticle);
    boolean deleteArticle(Long id);
}
