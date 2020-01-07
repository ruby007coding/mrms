package backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TemplateParser {


    private final String input_data_path;
    private FileReader file;
    private BufferedReader csvReader;
    private String line, showName, clientName;

    public TemplateParser(String input_data_path){
        this.input_data_path = input_data_path;
    }


    protected void parse_csv_file(){
        try {
            this.file = new FileReader(this.input_data_path);
        } catch (IOException e) {
            System.out.println("File does not exist: " + input_data_path);
            // TODO: send message to user!! pop up file does not exist
        }
        try{
            int roomCounter = 0;
            this.csvReader = new BufferedReader(this.file);
            while ((line = csvReader.readLine()) != null) {
                String[] data = line.split(";");
                if (line.startsWith("Meta Info")){
                    System.out.println("meta info " + line);
                    if (data[1].equals("Show Name")) {
                        showName = data[2];
                    } else if (data[1].equals("Client Name")){
                        clientName = data[2];
                    } else if (data[1].equals("Room Info")){
                        roomCounter += 1;
                    }
                }
                if (line.startsWith("Meeting Info")){
                    System.out.println("meeting info " + line);
                }


            }


        } catch (IOException e){
            System.out.println("IO Exception caught!!");
        }

        try{
            csvReader.close();
        } catch (IOException e){
            System.out.println("IO Exception caught!!");
        }
    }

}
