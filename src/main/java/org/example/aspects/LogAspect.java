package org.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    @Before("execution(* org.example.controllers.StudentController.*())")
    public void logMethod(JoinPoint joinPoint){
        System.out.println("Details: " + joinPoint.getSignature().getName());
    }
}
