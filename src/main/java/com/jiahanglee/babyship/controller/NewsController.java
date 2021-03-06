package com.jiahanglee.babyship.controller;

import com.jiahanglee.babyship.entity.News;
import com.jiahanglee.babyship.service.NewsService;
import com.jiahanglee.babyship.service.TeacherService;
import com.jiahanglee.babyship.theone.SystemParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


@Controller
@CrossOrigin
@RestController
@Api(value="新闻", tags="新闻tag")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @Autowired
    SystemParams systemParams;
    @PostMapping("/addNews")
    public int addUser(News user) {
        return newsService.addTeacher(user);
    }

    @GetMapping(value = "/allNews")
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize
    ) {
        return newsService.findAllTeacher(pageNum, pageSize);
    }
    @GetMapping(value = "/selectNewsById")
    @ApiOperation(value="获取新闻列表value", notes="获取新闻列表notes")
    public Object selectNewsById(@ApiParam(value = "新闻id")
            @RequestParam( name = "id", required = false, defaultValue = "1")
                    int id
    ) {
        return newsService.selectTeachersById(id);
    }

    @GetMapping(value = "/deleteNews")
    public int deleteTeacher(@RequestParam(name = "id",required = false) Integer id){
          return newsService.deleteTeacher(id);
    }

    @PostMapping(value = "/updateNews")
    public void update(News teacher){
         newsService.update(teacher);
    }




}
