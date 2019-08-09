import java.io.*;
import java.util.Scanner;

public class FileDemo {
    public static String helloWorldProgramText() {
        String ret = "public class HelloWorldDemo {\n";
        ret += "        public static void main(String[] args) {\n";
        ret += "                System.out.println(\"Hello World!\");\n";
        ret += "        }\n";
        ret += "}\n";
        return ret;
    }
    public static void writeOut(String filename, String text) {
        try {
            FileWriter writer = new FileWriter(new File(filename));
            writer.write(text);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("A write error occurred.");
        } 
    } 
    public static void readOutToConsole(String filename) {
        System.out.println();
        try { 
            Scanner reader = new Scanner(new File(filename));
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("A read error occurred.");
        }
    }
    public static void main(String[] args) {
        writeOut("HelloWorldDemo.java", helloWorldProgramText());
        readOutToConsole("HelloWorldDemo.java");
    }
}
