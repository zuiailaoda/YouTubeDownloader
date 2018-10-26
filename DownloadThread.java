package com.Lireoy;

import java.io.*;
import java.util.stream.Collectors;

public class DownloadThread extends Thread {

    private static String link;

    static void setLink(String newLink) {
        link = newLink;
    }

    @Override
    public void run() {
        try {
            Process process = new ProcessBuilder("C:\\yourlocation\\somewhere\\dl.bat", link).start();

            String line;

            while (true) {
                try {
                    line = new BufferedReader(new InputStreamReader(process.getInputStream())).lines().collect(Collectors.joining("\n"));
                    Controller.setConsoleTextArea(line);
                    System.out.println();
                } catch (NullPointerException e) {
                    System.out.println("valami kinullázódott a kurva anyját");
                }
            }

        } catch (IOException e) {
            System.out.println("valami elbaszódott");
        }

    }
}
