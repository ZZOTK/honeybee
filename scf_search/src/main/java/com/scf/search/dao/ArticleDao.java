package com.scf.search.dao;

import com.scf.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleDao extends ElasticsearchRepository<Article,String> {

    public Page<Article> findByTileOrContentLike(String title, String content, Pageable pageable);
}
