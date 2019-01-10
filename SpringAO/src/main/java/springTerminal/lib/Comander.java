package springTerminal.lib;

import org.springframework.stereotype.Component;
import springTerminal.interfaces.Comands;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
public class Comander implements Comands {
    @Override
    public File cd(File file, String input) throws Exception {
        if (input.equals("..")){
            File newFile1 = new File(file.getParent());
            return newFile1;
        }
        File newFile = new File(file.getAbsolutePath() + "/" + input);
        if (newFile.isDirectory()){
            return newFile;
        }
        System.out.println("> No such file or directory!");
        throw new Exception();
//        return file;
    }

    @Override
    public File ls(File file, String input) throws Exception {
        if (input == ""){
            String[]files = file.list();
            for (String s: files) {
                System.out.println(s);
            }

        }else {
            File newFile = new  File(file.getAbsolutePath() + "/" + input);
            if (newFile.isDirectory()){
                String[] list = newFile.list();
                for (String t:list) {
                    System.out.println(t);
                }
            }else {
                System.out.println("> \'" + input + "\' is not a directory!");
                throw new Exception();
            }
        }

        return file;
    }

    @Override
    public File pwd(File file) {
        System.out.println(file.getAbsolutePath());
        return file;
    }

    @Override
    public File mkdir(File file, String dirctoryName) {
        File dir = new File(file.getAbsolutePath() + "/" + dirctoryName);
        if (dir.exists()){
            System.out.println("> Directory on this name exist");
        }
        boolean created = dir.mkdir();
        if (created) System.out.println("> \'" + dirctoryName + "\' directory is created!");
        else System.out.println("> directory don`t create..");
        return file;
    }

    @Override
    public File touch(File file, String fileName) throws Exception {
        File dir = new File(file.getAbsolutePath() + "/" + fileName);
        if (dir.exists()){
            System.out.println("> File on this name exist");
            throw new Exception();
        }
        boolean created = dir.createNewFile();
        if (created) System.out.println("> \'" + fileName + "\' file is created!");
        else System.out.println("> file don`t create..");

        return file;
    }

    @Override
    public File cat(File file, String filename) throws Exception {
        try {
            FileReader fileReader = new FileReader(file.getAbsolutePath() + "/" + filename);
            int c;
            while((c=fileReader.read())!=-1){
                System.out.print((char)c);
            }
        } catch (IOException e) {
            System.out.println("> Not such file...");
            throw new Exception();
        }

        return file;
    }

}
