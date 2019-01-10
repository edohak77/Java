package springTerminal.AOP;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import springTerminal.lib.ComandMatcher;
import springTerminal.lib.ScanInput;

@Component
@Aspect
public class ComadScantrue {
    @Pointcut("execution(* springTerminal.lib.ScanInput.input())")
    public void allMethods(){}


    @AfterReturning(pointcut = "allMethods()", returning = "inputText")
    public void isComand(String[] inputText) throws Exception {
        String comand = inputText[0];
        String comadtext ="";
        String[]comands  ={"cd", "ls", "mkdir", "touch", "pwd", "cat"};
        for (String s : comands ) {
            if (comand.equals(s)) {
//                ComandMatcher.matches();
                return;
            }
        }
        return;
    }
}
