package com.oscfurl;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Main {


    public static String getSourceCode(String path) throws IOException {
        String source="Not found";
        URL url=new URL(path);
        URLConnection connection=url.openConnection();
        InputStream inStream=connection.getInputStream();
        int i;
        StringBuilder sb=new StringBuilder();
        while((i=inStream.read())!=-1){
            sb.append((char)i);
        }
        source=sb.toString();
        System.out.println("Access Granted to url");
        return source;
    }
    public static void launchSourceCode() throws IOException, InterruptedException {
        Runtime rTime = Runtime.getRuntime();
        String url = "L:\\programming\\Local\\ObtainSourceCode-Java\\sourceCode.html";
        String browser = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe ";
        Process pc = rTime.exec(browser + url);
        pc.waitFor();
        System.out.println("Opening Source code in browser");
    }

    public static void saveToFile(String sourceCode) throws IOException {
        RandomAccessFile file=new RandomAccessFile("L:\\programming\\Local\\ObtainSourceCode-Java\\sourceCode.html","rw");
        file.writeBytes(sourceCode);
        System.out.println("Source code downloaded");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input=new Scanner(System.in);
        String url;
        System.out.print("Paste the url here : ");
        url=input.nextLine();
        String source=getSourceCode(url);
        saveToFile(source);
        launchSourceCode();
    }
}
