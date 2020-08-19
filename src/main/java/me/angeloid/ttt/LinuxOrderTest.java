package me.angeloid.ttt;

import java.io.*;

/**
 * @author AngeloidYun
 * @date 2020/7/14
 */
public class LinuxOrderTest {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Process process = Runtime.getRuntime().exec("kill -9 40977");
                    PrintStream printStream = new PrintStream(process.getOutputStream());
                    String line = null;
                    BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));

                    while ((line = input.readLine()) != null) {

                        System.out.println(line);

                    }


                    input.close();
                    printStream.println();
                    printStream.flush();
                    printStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
