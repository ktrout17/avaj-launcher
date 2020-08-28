package avaj.simulator;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Logger {
    
    private static Writer writer = null;

    public static void setOutputFile(String filename) throws IOException {
        
        if (Logger.writer != null)
            Logger.writer.close();
            
        FileOutputStream fos = new FileOutputStream(filename);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
        Logger.writer = new BufferedWriter(osw);
    }

    public static void log(String message) {
        
        try {
            Logger.writer.write(message + "\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println("Error trying to write to file.");
            System.exit(1);
        }
    }
}