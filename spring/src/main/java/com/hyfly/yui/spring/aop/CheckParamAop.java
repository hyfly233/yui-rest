package com.hyfly.yui.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CheckParamAop {
    @Pointcut("@annotation(com.hyfly.yui.spring.annotation.CheckParam)")
    public void checkParamPointcut() {
    }

    @Around("checkParamPointcut()")
    public Object doCheckParam(ProceedingJoinPoint pjp) throws Throwable {
        try {
            System.out.println("doCheckParam");
            Object[] args = pjp.getArgs();
            for (Object arg : args) {
                if (arg == null) {
                    throw new RuntimeException("参数不能为空");
                }
            }
            return pjp.proceed();
        } finally {
            System.out.println("doCheckParam finally");
        }
    }
}
