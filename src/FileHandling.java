import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class FileHandling{

    public static void bestRead(String file){
        int ascii = 0;

        try {
            FileReader eg = new FileReader(file);
            BufferedReader egg = new BufferedReader(eg);

            while (ascii > -1) {
                ascii = egg.read();
                char letter = (char)ascii;
                if (ascii != -1) {
                    System.out.print(letter);
                }// if statement
            }// while loop
        }// try
        catch (IOException e) {
            e.printStackTrace();
        }// catch
        System.out.println();

    }// best read

    public static void greatestRead(String file){
        int ascii = 0;

        try {
            FileReader eg = new FileReader(file);
            BufferedReader egg = new BufferedReader(eg);

            String line = egg.readLine();

            while (line != null) {
                if (ascii != -1) {
                    System.out.print(line);
                    System.out.println();
                    line = egg.readLine();
                }// if statement
            }// while loop
        }// try
        catch (IOException e) {
            e.printStackTrace();
        }// catch
        System.out.println();

    }// best read

    public static ArrayList<String> lineReturn(String file){
        int ascii = 0;
        ArrayList names = new ArrayList<String>();

        try {
            FileReader eg = new FileReader(file);
            BufferedReader egg = new BufferedReader(eg);

            String line = egg.readLine();

            while (line != null) {
                if (ascii != -1) {
                    names.add(line);
                    line = egg.readLine();
                }// if statement
            }// while loop
        }// try
        catch (IOException e) {

            e.printStackTrace();
        }// catch
        System.out.println();

        return names;
    }// public static void line return


    public static void FileWrite(String Filename, String Text, Boolean append){

        try(
                FileWriter write = new FileWriter(Filename , append);
                PrintWriter writer= new PrintWriter(write);
        ){
            writer.println(Text);
        }// try
        catch(IOException e){
            e.printStackTrace();
        }// exception

    }// filewrite

    public static void FileWriteLine(String Filename, String Text, Boolean append){

        try(
                FileWriter write = new FileWriter(Filename , append);
                PrintWriter writer= new PrintWriter(write);
        ){
            writer.println(Text);
        }// try
        catch(IOException e){
            e.printStackTrace();
        }// exception

    }// filewrite

    public static String LineRead(int lineNumber , String fileName){
        int ascii = 0;
        int num = 0;
        String names = "";

        try {
            FileReader eg = new FileReader(fileName);
            BufferedReader egg = new BufferedReader(eg);

            String line = egg.readLine();

            while (line != null) {
                num = num + 1;
                if (ascii != -1 || num == lineNumber) {
                    names = line;
                    break;
                }// if statement
            }// while loop
        }// try
        catch (IOException e) {

            e.printStackTrace();
        }// catch
        System.out.println();

        return names;
    }// line read

    public static void compactFile(String fileName){
        ArrayList<String> lines = lineReturn(fileName);
        String NewElement = "";

        for (int i = 0; i < lines.size(); i++){

            String[] temp = lines.get(i).split(" ");

            for (int j = 0; j < temp.length; j ++){
                NewElement = NewElement + temp[j];
            }// for loop j

            lines.set(i , NewElement);
            NewElement = "";

        }// for loop i

        FileWrite(fileName , "" , false);

        for (int i = 0; i < lines.size(); i ++){
            FileWriteLine(fileName , lines.get(i) , true);
        }// for loop i

    }//compactFile

    public static void WriteToFileLine(int LineNumber , String text , String fileName){
        ArrayList<String> lines = lineReturn(fileName);

        for (int i = 0; i < lines.size(); i ++){

            if (i == LineNumber - 1){
                lines.set(i , text);
            }// if statement

        }// for loop i

        FileWrite("Document" , "" , false);

        for (int i = 0; i < lines.size(); i ++){
            FileWriteLine("Document" , lines.get(i) , true);
        }// for i < lines.size

    }// write to file line


    public static int RandomAccess(int line){
        String fileName = "e.txt";
        try{
            RandomAccessFile rf = new RandomAccessFile(fileName , "rws");
            rf.seek(line);
            return rf.read();

        }catch (IOException e){
            e.printStackTrace();
        }// try
        return -1;
    }// random access write method


}// class