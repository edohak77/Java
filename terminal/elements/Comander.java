package instigate.terminal.elements;

import instigate.terminal.interfaces.Comands;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Comander implements Comands {
    @Override
    public File cd(File file, String input) throws Exception {
        if (input.equals("..")){
            File newFile1 = new File(file.getParent());
            return newFile1;
        }
        File newFile = null;
        String comandtext = input;

        if (input.indexOf('/') != -1) {
            String tempText = input.replaceAll("/", "");
            comandtext = tempText;
            newFile = new File("/" + comandtext);

        }else {

            newFile = new File(file.getAbsolutePath() + "/" + input);
        }
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
            File newFile = null;
            String comandtext = input;
            if (input.indexOf('/') != -1) {
                String tempText = input.replaceAll("/","");
                comandtext = tempText;
                newFile = new File("/" + comandtext);

            }else {
                newFile = new  File(file.getAbsolutePath() + "/" + comandtext);
            }
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
        System.out.println();
        return file;
    }

    @Override
    public File echo(File file, String text) {
        String replaseText = text.replaceAll("\"","");
        String[]splitText = replaseText.split(" ");
        for (int i = 1; i < splitText.length; i++) {
            System.out.print(splitText[i] + " ");
        }
        System.out.println();
        return file;
    }

    @Override
    public File inTextWrait(File file, String inText) throws Exception {
//        System.out.println("inTextWrite");
        boolean append = isAppend(inText);
        List<String> matchesList = new ArrayList<>();
        String filename = "";
//        String[] textSplit = inText.split(" ");
        String regex = "[^\\s\"']+|\"([^\"]*)\"|'([^']*)'";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inText);

        while (matcher.find()){
            matchesList.add(matcher.group());
        }
        String addedText = matchingText(matchesList);
        if (addedText.equals("ls")) addedText = lsWriter(file);
        if (addedText.equals(">") || addedText.equals(">>")) addedText ="";
        filename = matchesList.get(matchesList.size()-1);

        File newFile = new File( file.getAbsolutePath() + "/" + filename);

        writeText(newFile, addedText, append);

        return file;
    }

    @Override
    public File rm(File file, String filename) throws Exception {
//        System.out.println(filename);
        File dir = new File(file.getAbsolutePath() + "/" + filename);
       if(dir.delete()){
            System.out.println(filename + " deleted");
        }else System.out.println("No such faile!!!");
//

        return file;
    }

    private void writeText(File file,String text, boolean append){
//        System.out.println("writeText");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file,append);
            fileWriter.write(text);
            fileWriter.flush();
            System.out.println("file is create:");
        } catch (IOException e) {
            System.out.println("file is not create.");
        }
    }

    private boolean isAppend(String text){
//        System.out.println("isAppend");
        if (text.indexOf(">>") !=-1) return true;
        return false;
    }

    private String matchingText(List<String> textList) throws Exception {
        String out = "";
        String comand = textList.get(0);

        switch (comand){
            case "echo":
                out = textList.get(1).replaceAll("\"","");
                return out;
            case "ls":
                out = "ls";
                return out;
            default:
                System.out.println(comand + " " + out);
//                throw new Exception();
                return out;
        }
    }

    private String lsWriter(File file) {
        String out = "";
        String[]files = file.list();

        for (String s : files) {
            out = out + s + "\n";
        }

        return out;
    }
}
