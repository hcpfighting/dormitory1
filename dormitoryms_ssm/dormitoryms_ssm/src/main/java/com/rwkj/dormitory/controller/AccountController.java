package com.rwkj.dormitory.controller;

import com.rwkj.dormitory.service.AccountService;
import com.rwkj.dormitory.dto.AccountDto;
import com.rwkj.dormitory.form.AccountForm;
import com.rwkj.dormitory.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * 登录和退出
 */

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    //将表单参数封装为bean对象AccountFrom
    @PostMapping("/login")//表单post
    public ModelAndView login(AccountForm accountForm, HttpSession session){

        AccountDto accountDto = this.accountService.login(accountForm);
        ModelAndView modelAndView = new ModelAndView();
        switch (accountDto.getCode()){
            case -1://用户名错误
                modelAndView.setViewName("login");
                modelAndView.addObject("usernameError", "用户名不存在");
                break;
            case -2://密码错误
                modelAndView.setViewName("login");
                modelAndView.addObject("passwordError", "密码错误");
                break;
            case 0://登录成功
                switch (accountForm.getType()){
                    case "systemAdmin":
                        modelAndView.setViewName("systemadmin");
                        //登录成功，将登录信息用session返回
                        session.setAttribute("systemAdmin", accountDto.getAdmin());
                        break;
                    case "dormitoryAdmin":
                        modelAndView.setViewName("dormitoryadmin");
                        session.setAttribute("dormitoryAdmin", accountDto.getAdmin());
                        break;
                }
                break;
        }
        return modelAndView;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

}