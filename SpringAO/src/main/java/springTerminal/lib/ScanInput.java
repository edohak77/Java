package springTerminal.lib;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import springTerminal.interfaces.UserInput;

import java.io.File;
import java.util.Scanner;

@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ScanInput implements UserInput {

private Scanner scanner;
private String inputText;

@Override
    public String[] input() {
        String[]inputArray = null;
        scanner = new Scanner(System.in);
        inputText = scanner.nextLine();
        inputArray =inputText.split(" ");
        return inputArray;
    }

}
