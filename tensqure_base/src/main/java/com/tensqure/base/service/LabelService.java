package com.tensqure.base.service;

import com.tensqure.base.dao.LabelDao;
import com.tensqure.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;

@Service
@Transactional
public class LabelService {
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    public List<Label> findAll(){
        return labelDao.findAll();
    }
    public Label findById(String id){
        return labelDao.findById(id).get();
    }
    public void save(Label label){
        redisTemplate.opsForValue().set("label_"+label.getId(),"13oop");
        label.setId(idWorker.nextId()+"");
        labelDao.save(label);
    }
    public void update(Label label){
        labelDao.save(label);
    }
    public void deleteById(String id){
        labelDao.deleteById(id);
    }
}
