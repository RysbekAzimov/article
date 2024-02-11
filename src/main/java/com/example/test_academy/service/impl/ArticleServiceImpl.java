package com.example.test_academy.service.impl;

import com.example.test_academy.entity.Article;
import com.example.test_academy.repository.ArticleRepository;
import com.example.test_academy.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }


    @Override
    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }


    @Override
    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Optional<Article> updateArticle(Long id, Article updatedArticle) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if (optionalArticle.isPresent()) {
            Article article = optionalArticle.get();
            article.setTag(updatedArticle.getTag());
            article.setDescription(updatedArticle.getDescription());
            articleRepository.save(article);
            return Optional.of(article);
        } else {

            return Optional.empty();
        }
    }
    @Override
    public boolean deleteArticle(Long id) {
        if (articleRepository.existsById(id)) {
            articleRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
