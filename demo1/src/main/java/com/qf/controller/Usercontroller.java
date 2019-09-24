package com.qf.controller;

import com.qf.entity.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author L
 * @date 2019/9/1614:16
 */
@Controller
public class Usercontroller {


    private UserService userService;

    @RequestMapping("/index.jsp")
    @ResponseBody
    public String Login(User user, HttpServletRequest request){
        User user1 = userService.Login(user);
        if (user1 != null){
            HttpSession session = request.getSession();
            session.setAttribute("user",user1);
            return "success";
        } else {
            return "error";
        }
    }
    @RequestMapping("/exitUser")
    private String exitUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.getAttribute("user");
        session.removeAttribute("user");
        session.invalidate();
        return "index";

    }
}
