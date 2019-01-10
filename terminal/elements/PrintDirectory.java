package instigate.terminal.elements;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class PrintDirectory {
    private String userName;
    private String hostname;
    private String directory = "";
    private String tilda = "~";

    public void initUSerHostName(){
        userName = System.getProperty("user.name");
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            System.out.println("Uncnou host");
        }
    }

    public PrintDirectory() {
        initUSerHostName();
    }

    public void setDirectory(File file) {
        String path = "";
        String[] pathSplit = file.getAbsolutePath().split("/");

        if (pathSplit.length == 0) {
            tilda = "/";
        }else if (pathSplit.length <=2 && pathSplit.length > 0) {
            tilda = "/" + pathSplit[pathSplit.length-1];
        }else tilda = "~";
        if (pathSplit.length > 2){
            for (int i = 3; i < pathSplit.length; i++) {
                path = new String(path + "/" + pathSplit[i]);
            }
        }

        this.directory = path;
    }

    public void printMainDirectory(){

        System.out.print(userName + "@" + hostname + ":" + tilda + directory + "$ ");
    }

    public String getMainDirectory(){
        return new String(userName + "@" + hostname + ":~" + directory + "$ ");
    }
}
