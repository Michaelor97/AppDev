package com.example.springprojectmain.repository;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AOPRepo {
    @Before("execution(* com.example.springprojectmain.daos.PetRepository.findAll(..))")
    public void beforeFindAll(JoinPoint joinPoint) {
        log.info("{} executing {} with arguments {}", joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), joinPoint.getArgs());
    }
    @After(value = "execution(* findAll(..))")
    public void afterFindAll(JoinPoint joinPoint) {
        log.info("Done with {}", joinPoint.getSignature().getName());
    }
}