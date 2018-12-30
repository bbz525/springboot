package com.tensqure.base.controller;

import com.tensqure.base.pojo.Label;
import com.tensqure.base.service.LabelService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/label")
    public class LabelController {
    @Autowired
    private LabelService labelService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return  new Result(true, StatusCode.OK,"查找成功",labelService.findAll());
    }
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable String id){

        return  new Result(true, StatusCode.OK,"查找成功",labelService.findById(id));
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result save(@RequestBody Label label){
        labelService.save(label);
        return  new Result(true, StatusCode.OK,"添加成功");
    }
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public Result deletebById(@PathVariable String id){
        labelService.deleteById(id);
        return  new Result(true, StatusCode.OK,"删除成功");
    }
    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable Integer id,@RequestBody Label label){
        labelService.update(label);
        return  new Result(true, StatusCode.OK,"修改成功");
    }

}