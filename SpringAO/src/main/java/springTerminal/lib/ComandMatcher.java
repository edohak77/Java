package springTerminal.lib;

import java.io.File;

public class ComandMatcher {
    private static Comander comander;
    private static File newFile;

    public static File matches(File file, String comand, String comandtext) throws Exception {
        if (!isComand(comand)) throw new Exception();
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
            default:
//                System.out.println("switch exp");
                return newFile;
        }
//        System.out.println("switchic heto");
    }

    private static boolean isComand(String comand){
        String[]comands = {"cd", "pwd", "exit", "ls", "mkdir", "cat", "touch" };

        for (String c : comands) {
            if (comand.equals(c)) return true;
        }

        return false;
    }
}
