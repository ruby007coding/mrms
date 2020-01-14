package backend;

import backend.elements.Show;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * TemplateParser is to parse the given CSV file which contains all input information provided by the client.
 * The original excel template can be found here:
 * >> src/main/java/com/spaceant/singaporeproject/mrms/service/template/MRS_Input_Template.xlsx
 * The template has to be exported as CSV with separator defined as `;` in order for the TemplateParser
 * to be able to parse it.
 */

public class TemplateParser {


    private final String input_data_path;
    private FileReader file;
    private BufferedReader csvReader;
    private String line, showName, clientName;
    private String CSV_SEPARATOR=";";

    public TemplateParser(String input_data_path){
        this.input_data_path = input_data_path;
    }


    protected void parse_csv_file(){
        try {
            // TODO: change this part. file will be uploaded...
            // drag & drop returns a path?
            // probably a path will be given here.. i guess :)
            this.file = new FileReader(this.input_data_path);
        } catch (IOException e) {
            //TODO: change this accordingly..
            System.out.println("File does not exist: " + input_data_path);
        }
        try{
            int roomCounter = 0;
            this.csvReader = new BufferedReader(this.file);
            while ((line = csvReader.readLine()) != null) {
                String[] data = line.split(CSV_SEPARATOR);
                if (data[0].equals("Meta Info")){
                    System.out.println("meta info " + line);
                    if (data[1].equals("Show Name")){
                        showName = data[2];
                        System.out.println("show name" + data[2]);
                    } else if (data[1].equals("Client Name")){
                        clientName = data[2];
                    } else if (data[1].equals("Room Info")){
                        roomCounter += 1;
                        // TODO save room info in extra array
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
