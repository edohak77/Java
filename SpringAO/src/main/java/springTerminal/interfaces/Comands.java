package springTerminal.interfaces;

import java.io.File;

public interface Comands {
    File cd(File file, String input) throws Exception;
    File ls(File file, String input) throws Exception;
    File pwd(File file);
    File mkdir(File file, String dirctoryName);
    File touch(File file,String fileName) throws Exception;
    File cat(File file, String filename) throws Exception;

}
