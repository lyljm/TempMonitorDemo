package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SyncFailedException;

import static java.lang.Thread.sleep;

public class GetInfo {
    public static String exe;
    public static int time;
    public GetInfo(){
    }
    public static BufferedReader getInfo(){
        Process process=null;
            try {
                process=Runtime.getRuntime().exec(exe);
            } catch (IOException e) {
                //test
//                try {
//                    sleep(time);
//                } catch (InterruptedException ex) {
//                  ex.printStackTrace();
//                }
                e.printStackTrace();
                System.out.println("脚本执行错误");
                System.exit(1);
                }
        process.getInputStream();
        //int status=-1;
        try {
            //status=
            process.waitFor();
        } catch (InterruptedException e) {
            System.out.println("Faild to call shell command");
        }
        BufferedReader reader=new BufferedReader(new InputStreamReader(process.getInputStream()));
        return reader;
    }

}
