package main.backend;

public class MRSMain {

    private static  String input_data_path = null;

    public static void main(String args[]){

        input_data_path = args[0];
        System.out.println("Thats the path: " + input_data_path);

        TemplateParser reader = new TemplateParser(input_data_path);
        reader.parse_csv_file();
    }
}
