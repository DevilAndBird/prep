package com.csair.cbs.util;

import com.csair.cbs.common.domain.CommonVar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        req.setCharacterEncoding(CommonVar.UTF8);
        resp.setContentType(CommonVar.CONTENTTYPE);
        if(req.getParameter("method")==null){
            //method不能为空
            return;
        }
        String methodName=req.getParameter("method");
        Class cla =this.getClass();
        try {
            Method method = cla.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            //取消Java的权限控制检查，就可以调用类的私有属性和方法
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
