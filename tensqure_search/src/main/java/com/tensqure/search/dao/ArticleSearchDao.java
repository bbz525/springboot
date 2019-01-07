package com.tensqure.search.dao;

import com.tensqure.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleSearchDao extends ElasticsearchRepository<Article,String> {

    /**
     * 检索
     * @param
     * @return
     */
    public Page<Article> findByTitleOrContentLike(String title, String
            content, Pageable pageable);
}
