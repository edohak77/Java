package instigate.terminal.interfaces;

import java.io.File;
import java.io.IOException;

public interface Comands {
    File cd(File file, String input) throws Exception;
    File ls(File file, String input) throws Exception;
    File pwd(File file);
    File mkdir(File file, String dirctoryName);
    File touch(File file,String fileName) throws Exception;
    File cat(File file, String filename) throws Exception;
    File echo(File file, String text);
    File inTextWrait(File file, String inText) throws Exception;
    File rm(File file, String filename) throws Exception;

}
