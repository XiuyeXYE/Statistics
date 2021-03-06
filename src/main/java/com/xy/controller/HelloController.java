package com.xy.controller;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiuye.util.log.LogUtil;

@Controller
public class HelloController {
	
	@SuppressWarnings("Duplicates")
    @RequestMapping("/")
    public String home(HttpServletRequest request, Model model) {

		LogUtil.log("=======================");
		LogUtil.log("This page is home page!");
		LogUtil.log("=======================");
        String name = "World";

        Subject subject = SecurityUtils.getSubject();

        PrincipalCollection principalCollection = subject.getPrincipals();

        if (principalCollection != null && !principalCollection.isEmpty()) {
            Collection<Map> principalMaps = subject.getPrincipals().byType(Map.class);
            if (CollectionUtils.isEmpty(principalMaps)) {
                name = subject.getPrincipal().toString();
            }
            else {
                name = (String) principalMaps.iterator().next().get("username");
            }
        }

        model.addAttribute("name", name);
        LogUtil.log("=======================");
        LogUtil.log("Home page OK!");
        LogUtil.log("=======================");
        return "hello";
    }
}
