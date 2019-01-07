package com.tensqure.search.service;

import com.tensqure.search.dao.ArticleSearchDao;
import com.tensqure.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ArticleSearchService {


    @Autowired
    private ArticleSearchDao articleSearchDao;
    /**
     * 增加文章
     * @param article
     */
    public void add(Article article){
        articleSearchDao.save(article);
    }

    public Page<Article> findByTitleLike(String keywords, int page, int size)
    {
        PageRequest pageRequest = PageRequest.of(1, size);
        return
                articleSearchDao.findByTitleOrContentLike(keywords,keywords,
                        pageRequest);
    }
}
