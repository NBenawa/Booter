package org.example.booter.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.example.booter.entity.Guest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LoggerHelper {

    @After("execution(* org.example.booter.api.controller.GuestApiController.addGuest(..))")
    public void writeLog(JoinPoint joinPoint) {
        Guest guest = Guest.convertToGuest(joinPoint.getArgs()[0].toString());
        LoggerWriter.writeLog(guest,"New Guest Created!", LocalDateTime.now());
    }
}
