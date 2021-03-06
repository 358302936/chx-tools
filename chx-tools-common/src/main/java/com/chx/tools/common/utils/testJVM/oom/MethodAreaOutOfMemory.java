package com.chx.tools.common.utils.testJVM.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 方法区溢出
 * @VM args:-XX:PermSize=10M -XX:MaxPermSize=10M
 * @author chuhx
 * @version 2017年7月24日
 */
public class MethodAreaOutOfMemory {
	public static void main(String[] args) {
	       while(true){
	           Enhancer enhancer = new Enhancer();
	           enhancer.setSuperclass(TestCase.class);
	           enhancer.setUseCache(false);
	           enhancer.setCallback(new MethodInterceptor() {
	              @Override
	              public Object intercept(Object arg0, Method arg1, Object[] arg2,
	                     MethodProxy arg3) throws Throwable {
	                  return arg3.invokeSuper(arg0, arg2);
	              }
	           });
	           enhancer.create();
	       }
	    }
}
