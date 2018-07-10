package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSV {
    public static List<String[]> read(String file){
        List<String[]> data = new LinkedList<>();
        String raw;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((raw = br.readLine()) != null){
                String[] dataRecords = raw.split(",");
                data.add(dataRecords);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }
}
