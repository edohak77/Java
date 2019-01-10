package springTerminal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springTerminal.lib.ScanInput;

import java.io.File;

public class TerminalStart {
    private static File file ;

    public static void main(String[] args) {
        String username  = System.getProperty("user.name");
        file =  new File("/home" + "/" + username);
        ApplicationContext context = new ClassPathXmlApplicationContext("terminal_conmtext.xml");
        ScanInput scanInput = (ScanInput)context.getBean("scanInput");
        String[]inputText = {""};
        while (!inputText[0].equals("exit")){
            inputText = scanInput.input();
        }
    }
}
