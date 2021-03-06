package com.jiahanglee.babyship.controller;

import com.jiahanglee.babyship.entity.RolePlus;
import com.jiahanglee.babyship.entity.rbac_jpa.Role;
import com.jiahanglee.babyship.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @author jiahanglee
 * @version 0.0.1
 * @date 2018/9/18 11:02
 * @description //TODO
 */
@RestController
@CrossOrigin
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/addRole")
    public int addRole(RolePlus rolePlus) {
        System.out.println(rolePlus.toString());
        Role role = new Role();
        role.setName(rolePlus.getName());
        role.setDescription(rolePlus.getDescription());
        return roleService.addRole(role,rolePlus.getEditor());
    }

    @GetMapping(value = "/deleteRole")
    public int deleteRole(@RequestParam(name = "id", required = false) Integer id) {
        return roleService.deleteRole(id);
    }
    @PostMapping(value = "/updateRole")
    public void updateRole(RolePlus rolePlus) {
        System.out.println(rolePlus.toString());
        Role role = new Role();
        role.setId(rolePlus.getId());
        role.setName(rolePlus.getName());
        role.setDescription(rolePlus.getDescription());
        roleService.update(role,rolePlus.getEditor());
    }

    @GetMapping(value = "/allRole")
    public Object allRole(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize
    ) {
        return roleService.findAllRole(pageNum, pageSize);
    }
    @GetMapping(value = "/allRoles")
    public Object allRoles(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize
    ) {
        return roleService.findAllRole(pageNum, 100);
    }

}
