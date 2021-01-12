package com.aaron.springinaction.knights;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.io.PrintStream;

/**
 * 吟游诗人
 */
@Aspect //step2. 声明一个切面
public class Minstrel {
    private PrintStream stream;

    public Minstrel(PrintStream stream) {
        this.stream = stream;
    }

    @Pointcut("execution(* com.aaron.springinaction.knights.Knight.embarkOnQuest())")
    public void embarkOnQuest(){}

    /**
     * 探险之前调用
     */
    @Before("embarkOnQuest()")
    public void singBeforeQuest(){
        stream.println("Fa la la, the knight is so brave!");
    }

    /**
     * 探险之后调用
     */
    @After("embarkOnQuest()")
    public void singAfterQuest(){
        stream.println("Tee hee hee, the brave knight did embark on a quest!");
    }
}
