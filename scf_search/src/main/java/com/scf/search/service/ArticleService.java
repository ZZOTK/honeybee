package com.scf.search.service;

import com.scf.search.dao.ArticleDao;
import com.scf.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    public Page<Article> findByKey(String key,int page,int size){
        Pageable pageable = PageRequest.of(page - 1,size);
        return articleDao.findByTileOrContentLike(key,key,pageable);
    }


    public void save(Article article){
        articleDao.save(article);
    }
}
