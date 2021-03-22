package hu.nive.ujratervezes.zarovizsga.people;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class People {
    public int getNumberOfMales(String path){
        try{
            List<String> lines= Files.readAllLines(Path.of(path));
            return numberOfM(lines);

        }catch(IOException ioe){
            throw new IllegalStateException("can not read fole", ioe);
        }
    }
    private int numberOfM(List<String>lines){
        int numberOfM= 0;
        for(String line :lines){
            String[] parts = line.split(",");
            String male= parts[4];
            if(male.equals("Male")){
                numberOfM++;
            }
        }
        return numberOfM;
    }
}
