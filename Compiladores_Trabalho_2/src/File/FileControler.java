/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import Visual.Main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Rafhael
 */
public class FileControler {
    
    public File newFile(Main chose, String Ftext){
        File file = null;
        
        try {
            JFileChooser fc = new JFileChooser();
            int result = fc.showSaveDialog(chose);
            if (result == JFileChooser.CANCEL_OPTION) {
                return null;
//                System.exit(1);
            }
            java.io.File fileName = fc.getSelectedFile();
            java.io.FileReader input = null;
            file = new File(Ftext, fileName.getName(), (fc.getSelectedFile()).toString());
            
        } catch (ArrayIndexOutOfBoundsException e)
        {
            e.printStackTrace();
        }       
        return file;
    }
    
    public File getFile(Main chose)
    {
        File file = null;
        try {
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = fc.showOpenDialog(chose);
            if (result == JFileChooser.CANCEL_OPTION) {
                return null;
//                System.exit(1);
            }
            java.io.File fileName = fc.getSelectedFile();
            java.io.FileReader input = null;
            try {
                input = new java.io.FileReader(fileName);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            BufferedReader bufRead = new BufferedReader(input);
            String line = null;
            line = (String) bufRead.readLine();
            String Ftext= "";
            while (line != null) {
                Ftext=Ftext+line + "\n";
                line = bufRead.readLine();
            }
            file = new File(Ftext, fileName.getName(),(fc.getSelectedFile()).toString());
            bufRead.close();
            
        } catch (ArrayIndexOutOfBoundsException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }       
        return file;
    }
    
    public void saveFile(File file, String str) throws IOException
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.getFilePath()))) {
            writer.write(str);
        }
    }
    
    public int countCharacters(File file)
    {
        return file.getfText().length();
    }
    
    public int countCharNoSpaces(File file)
    {
        return file.getfText().replaceAll("\\s+","").length();
    }
    
    public String[] countWords(File file)
    { 
        String processed = file.getfText().replace("(", " ").replace(")", " ").replace("-", " ").replace("+", " ").replace("*", " ").replaceAll("/", " ").replaceAll("=", " ").replaceAll("\\d", "");   
        return processed.toUpperCase().split("\\s+");
    }
    
    public String[] countIdentifiers(File file)
    {
        String[] Identify = file.Words;
        Arrays.sort(Identify);
        String allIdentifiers = "";
        String last = "";
        for(String Identify1: Identify)
        {
            if(!(last.equals(Identify1)))
            {
                last = Identify1;
                allIdentifiers+= Identify1+" ";
            }
        }
        return allIdentifiers.split("\\s+");        
    }
    
    public String[] countNumbers(File file)
    {
        String digits = file.getfText().replaceAll("[^0-9.]", " ").replaceAll("^\\s+", "");
        return digits.split("\\s+");
    }
    
    public String[] countOperators(File file)
    {
        String digits = file.getfText().replaceAll("[0-9.]", " ").replaceAll("[a-z,A-Z]", " ").replaceAll("\"", "").replace("(", "").replace(")", "");
        return digits.replaceAll("^\\s+", "").split("\\s+");
    }
    
    public int countLines(File file)//refazer
    {
        int lineN = file.getfText().split("\\n").length;
        return lineN;
    }
   
    public String AIndexOrganizer(File file)
    {
        String[] id= file.getIdentifiers();
        String returningOrganizedList = "";
        int line = 1;
        char charac;
        int count=0;
        String spliting = file.getfText().replace("(", " ").replace(")", " ").replace("-", " ").replace("+", " ").replace("*", " ").replaceAll("/", " ").replaceAll("=", " ").replaceAll("\\d", "").toUpperCase();
        String [] splitedLines = spliting.split("\\n");        
        Arrays.sort(id);
        charac = id[0].charAt(0);
        returningOrganizedList+=charac+"\n";
        for(String id1: id)
        {
            if(charac!=id1.charAt(0))
            {
                charac = id1.charAt(0);
                returningOrganizedList+= "\n"+ charac+"\n";
            }
            line = 1;
            for(String splitedLines1: splitedLines)
            {
                String []forMomentSpliting = splitedLines1.split("\\s+");
                for(String forMomentSpliting1:forMomentSpliting)
                {
                    if(forMomentSpliting1.equals(id1))
                    {
                        count+=1;
                    }
                }
                if(count > 0){
                    returningOrganizedList = returningOrganizedList+"Line "+line+": "+id1+" ("+ count+"x)\n";
                    count = 0;
                }
                line+=1;
            }
        }       
        
        return returningOrganizedList;
    }
}
