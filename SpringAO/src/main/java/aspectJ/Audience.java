package aspectJ;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
public class Audience {
    public void turnOffCellphones(){
        System.out.println("All audiences turn off cellphones");
    }
    public void applaud(){
        System.out.println("Cap-cap-cap");
    }
    public void ogogo(){
        System.out.println("Boooooooooooo...");
    }

    public Audience() {
    }
    public void init(){
        System.out.println("Audience init...");
    }

    public void watchPlay(ProceedingJoinPoint joinPoint){
        try {

            System.out.println("The aoudiencies is taking theyr seats.");
            System.out.println("The audience is turning off their cellphones");
            long start = System.currentTimeMillis(); // Перед выступлением

            joinPoint.proceed();

            long end = System.currentTimeMillis(); // После выступления
            System.out.println("CLAP CLAP CLAP CLAP CLAP");
            System.out.println("The performance took " + (end - start)
                    + " milliseconds.");

        } catch (Throwable throwable) {
            System.out.println("Boo! We want our money back!");
        }

    }
}

