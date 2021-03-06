package com.scf.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.scf.article.pojo.Article;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ArticleDao extends JpaRepository<Article,String>,JpaSpecificationExecutor<Article>{

    //增删改需要加
    @Modifying
    @Query(value = "UPDATE tb_article SET state=1 WHERE id=?", nativeQuery = true)
	public void updateState(String id);

    @Modifying
    @Query(value = "UPDATE tb_article SET thumbup + 1 WHERE id = ?",nativeQuery = true)
    public void addThumbup(String id);

}
