package com.kravchuk.SpringSecurityPractice.profiling;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class AspectProfiling {
    private static final Logger logger = Logger.getLogger(AspectProfiling.class);

    @Pointcut("@annotation(ApiLog)\")")
    public void setLogger() {
    }


    @Before("setLogger()")
    public void logMainStart(JoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().getName();

        String className = joinPoint.getSignature().getDeclaringType().getName();

        logger.log(Level.INFO, "Название класса: " + className + " название метода: "
                + methodName + " этот метод только что завершил свою работу");


    }

    @After("setLogger()")
    public void logAppTimeLive(JoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().getName();

        String className = joinPoint.getSignature().getDeclaringType().getName();

        logger.log(Level.INFO, "Название класса: " + className + " название метода: "
                + methodName + " этот метод только что завершил свою работу");

    }

    @AfterThrowing(pointcut = "@annotation(ThrowException)",
            throwing = "error")
    public void logException(JoinPoint joinPoint, Exception error) {

        String methodName = joinPoint.getSignature().getName();

        String className = joinPoint.getSignature().getDeclaringType().getName();

        logger.log(Level.INFO, "Название класса: " + className + " название метода: "
                + methodName + " этот метод только что выбросил исключение" + error);

    }
}
