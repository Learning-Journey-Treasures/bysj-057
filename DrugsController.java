package com.health.controller;

import cn.hutool.json.JSONObject;
import com.health.dao.entity.Drugs;
import com.health.dao.vo.DrugsVO;
import com.health.dao.vo.SellVO;
import com.health.service.IDrugsService;
import com.health.util.TableResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/drugs")
@Slf4j
public class DrugsController {


    @Autowired
    private IDrugsService drugsService;


    /**
     * 新增药品信息
     **/
    @PostMapping("/insert")
    public Boolean insert(@RequestBody Drugs drugs){
        return drugsService.insert(drugs);
    }


    /**
     * 编辑药品信息
     **/
    @PostMapping("/update/info")
    public Boolean update(@RequestBody Drugs drugs){
        return drugsService.update(drugs);
    }
    
    /**
     * 删除药品信息
     **/
    @GetMapping("/delete/info")
    public void deleteInfo(@RequestParam Integer id){
        drugsService.delete(id);
    }

    /**
     * 获取药品信息列表
     **/
    @GetMapping("/page")
    public TableResponse<List<DrugsVO>> page(@RequestParam Integer page, @RequestParam Integer limit,
                                             @RequestParam(required = false) String name,
                                             @RequestParam(required = false) Integer drugCategoryId){
        return drugsService.page(page, limit,name,drugCategoryId);
    }


    @GetMapping("/list")
    public List<Drugs> getList(){
        return drugsService.getList();
    }


    @GetMapping("/stat")
    public Map<String,Object> getStat(){
        return drugsService.stat();
    }

    /**
     * 获取药品利润列表
     **/
    @GetMapping("/profit/page")
    public TableResponse<List<SellVO>> profitPage(@RequestParam Integer page, @RequestParam Integer limit,
                                                  @RequestParam(required = false) String code){
        return drugsService.profitPage(page, limit,code);
    }

    @PostMapping("/upload/img")
    public JSONObject uploadLicFile(@RequestParam("file") MultipartFile file) {
        return drugsService.uploadImg(file);
    }


}
