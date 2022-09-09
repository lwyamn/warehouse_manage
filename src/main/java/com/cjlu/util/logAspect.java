package com.cjlu.util;

import com.cjlu.config.logAnnotation;
import com.cjlu.mapper.logMapper;
import com.cjlu.pojo.log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
@EnableAsync
public class logAspect {
    @Autowired
    private logMapper logMapper; //日志 mapper
    @Autowired
    private RedisUtil redisUtil;

    private String requestPath = null ; // 请求地址
    private long startTimeMillis = 0; // 开始时间
    private long endTimeMillis = 0; // 结束时间
    private String user = null; // 操作人
    private HttpServletRequest request = null;//请求

    /**
     * 注解的位置
     */
    @Pointcut("@annotation(com.cjlu.config.logAnnotation)")
    public void logPointCut() {}

    /**
     * @param joinPoint
     * @Description 前置通知  方法调用前触发   记录开始时间,从session中获取操作人
     */
    @Before(value="logPointCut()")
    public void before(JoinPoint joinPoint){
        startTimeMillis = System.currentTimeMillis();
    }
    /**
     * @param joinPoint
     * @Description 获取入参方法参数
     * @return
     */
    public Map<String, Object> getNameAndValue(JoinPoint joinPoint) {
        Map<String, Object> param = new HashMap<>();
        Object[] paramValues = joinPoint.getArgs();
        String[] paramNames = ((CodeSignature)joinPoint.getSignature()).getParameterNames();
        for (int i = 0; i < paramNames.length; i++) {
            if(paramValues[i] instanceof Integer || paramValues[i] instanceof String) {
                param.put(paramNames[i], paramValues[i]);
            }
        }
        return param;
    }
    /**
     * @param joinPoint
     * @Description 后置通知    方法调用后触发   记录结束时间 ,操作人 ,入参等
     */
    @After(value="logPointCut()")
    public void after(JoinPoint joinPoint) {
        request = getHttpServletRequest();
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class<?> targetClass = null;
        try {
            targetClass = Class.forName(targetName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method[] methods = targetClass.getMethods();
        String action;
        String methodDesc;
        String systemType;
        String actionType;
        String ip;
        Class<?>[] clazzs;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                clazzs = method.getParameterTypes();
                if (clazzs!=null&&clazzs.length == arguments.length
                        &&method.getAnnotation(logAnnotation.class)!=null) {
                    request = getHttpServletRequest();
                    requestPath=request.getServletPath();
                    String token = request.getHeader("token");
                    user = (String) redisUtil.get(token);
                    action = method.getAnnotation(logAnnotation.class).action();
                    methodDesc = method.getAnnotation(logAnnotation.class).methodDesc();
                    systemType = method.getAnnotation(logAnnotation.class).systemType();
                    actionType = method.getAnnotation(logAnnotation.class).actionType();
                    ip = ipUtils.getClientIpAddress(request);
                    endTimeMillis = System.currentTimeMillis();
                    log log=new log(user, requestPath,
                            (endTimeMillis-startTimeMillis)+"ms",
                            getNameAndValue(joinPoint).toString(), action, methodDesc,systemType,actionType,ip);
                    logMapper.addLog(log);
                }
            }
        }
    }
    /**
     * @Description: 获取request
     */
    public HttpServletRequest getHttpServletRequest(){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes)ra;
        HttpServletRequest request = sra.getRequest();
        return request;
    }
    /**
     * @param joinPoint
     * @return 环绕通知
     * @throws Throwable
     */
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        return null;
    }
    /**
     * @param joinPoint
     * @Description 异常通知
     */
    public void throwing(JoinPoint joinPoint) {
        System.out.println("异常通知");
    }
}
