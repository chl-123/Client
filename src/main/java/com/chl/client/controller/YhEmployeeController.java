package com.chl.client.controller;

import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.chl.client.dao.YhEmployeeMapper;
import com.chl.client.dao.YhRoleMapper;
import com.chl.client.dao.YhRootMapper;
import com.chl.client.entity.YhEmployee;
import com.chl.client.entity.YhRole;
import com.chl.client.util.ListenerDemo;
import com.chl.client.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/yhemp")
public class YhEmployeeController {
	@Autowired
	YhEmployeeMapper yhempDao;
	@Autowired
	YhRoleMapper roleDao;
	@Autowired
	YhRootMapper rootDao;

	
    //登录
	@RequestMapping("/logi")
	public String login(HttpServletRequest request, YhEmployee data , ModelMap model) {
    	if(data.getEmpname()!=null) {
    		data.setPassword(MD5.encrypt(data.getPassword()));
    		YhEmployee all = yhempDao.login(data);
    		if(all!=null) {			
    			//取职位
    			YhRole relo=roleDao.selectByPrimaryKey(all.getRoleid());
    			//登录人
    			request.getSession().setAttribute("name",data.getEmpname());
                request.getSession().setAttribute("relo",relo.getRolename());
               
                //取登录人权限
                List rights =yhempDao.rights(all.getEmpname());
                request.getSession().setAttribute("rights",rights); 
                ListenerDemo demo=new ListenerDemo();
                request.getSession().setAttribute("num",demo.getOnlineNum()); 
                return "index";        
    		}else {
    			return "login";	
    		}
    	}else {
    		return "login";
    	}  					
	}
	
	
	 //注销用户
	@RequestMapping(value = "/logout")
   public String logout(HttpServletRequest request){
  	   request.getSession().invalidate();
  	   return "login";
  }
	
	//注册用户
	@RequestMapping(value = "/reg")
	public String reg(HttpServletRequest request,YhEmployee data) {		
		String again=(String)request.getParameter("again");
		if(data.getPassword().length()>0){
		    if(again.equals(data.getPassword())){
				data.setPassword(MD5.encrypt(data.getPassword()));
				data.setRoleid(4);
				YhEmployee all = yhempDao.reg(data.getEmpname());
				if(all!=null) {
					return "reg";
				}else {
				    yhempDao.insert(data);
					return "login";
				}				
			}
		}
		return "reg";
	}

}
