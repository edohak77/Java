package instigate.terminal.elements;
import com.sun.deploy.util.StringUtils;

import java.io.File;

public class ComandMatcher {
    private static Comander comander;
    private static File newFile;

    public static File matches(File file, String inputingText) throws Exception {
        String[]textes = inputingText.split(" ");
        String comandtext = null;
        newFile = file;
        if (textes.length > 1) {
            comandtext = textes[1];
        }
        if (!isComand(textes[0])) throw new Exception();
        comander = new Comander();
        if (textes[0].equals("echo") && inputingText.indexOf('>') == -1){
            newFile = comander.echo(newFile,inputingText);
        }else if (inputingText.indexOf('>') != -1){
            newFile = comander.inTextWrait(newFile, inputingText);
        }else {
            newFile = matchesStandart(newFile, textes[0], comandtext);
        }
        return newFile;
    }

    private static File matchesStandart(File file, String comand, String comandtext) throws Exception {
        comander = new Comander();
        newFile = file;
        if (comandtext == null) comandtext ="";
        switch (comand) {
            case "pwd":
               newFile = comander.pwd(file);
                return newFile;
            case "ls":
                newFile = comander.ls(file, comandtext);
                return newFile;
            case "cd":
                newFile = comander.cd(file,comandtext);
                return newFile;
            case "mkdir":
                newFile = comander.mkdir(file, comandtext);
                return newFile;
            case "touch":
                newFile = comander.touch(file, comandtext);
                return newFile;
            case "cat":
                newFile = comander.cat(file, comandtext);
                return newFile;
            case "echo":
                newFile = comander.echo(file, comandtext);
                return newFile;
            case "rm":
                newFile = comander.rm(file,comandtext);
            default:
//                System.out.println("switch exp");
                return newFile;
        }
//        System.out.println("switchic heto");
    }

    private static boolean isComand(String comand){
        String[]comands = {"cd", "pwd", "exit", "ls", "mkdir", "cat", "touch", "echo", "rm" };

        for (String c : comands) {
            if (comand.equals(c)) return true;
        }

        return false;
    }

}
