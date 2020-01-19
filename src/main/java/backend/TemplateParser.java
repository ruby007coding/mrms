package backend;

import backend.elements.Meeting;
import backend.elements.MeetingRoom;
import backend.elements.Show;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * TemplateParser is to parse the given CSV file which contains all input information provided by the client.
 * The original excel template can be found here:
 * >> src/main/java/com/spaceant/singaporeproject/mrms/service/template/MRS_Input_Template.xlsx
 * The template has to be exported as CSV with separator defined as `;` in order for the TemplateParser
 * to be able to parse it.
 */

public class TemplateParser {


    private final String input_data_path;
    private String CSV_SEPARATOR=";";

    private FileReader file;
    private BufferedReader csvReader;

    public Show show;
    private String line, showName, clientName;


    private ArrayList<MeetingRoom> parsedRooms;
    private ArrayList<Meeting> parsedMeetings;

    public TemplateParser(String input_data_path){
        this.input_data_path = input_data_path;
    }

    public void parse_template(){
        parse_csv_file();
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
            this.parsedRooms = new ArrayList<MeetingRoom>();
            this.parsedMeetings = new ArrayList<Meeting>();
            this.csvReader = new BufferedReader(this.file);

            while ((line = csvReader.readLine()) != null) {
                String[] data = line.split(CSV_SEPARATOR);
                if(data.length > 0) {
                    if (data[0].equals("Meta Info")){
                        if (data[1].equals("Show Name")){
                            showName = data[2];
                        } else if (data[1].equals("Client Name")){
                            clientName = data[2];
                        } else if (data[1].equals("Room Info")){
                            String roomName = data[2];
                            int roomCapacity = Integer.parseInt(data[3]);
                            parsedRooms.add(new MeetingRoom(roomName, roomCapacity));
                        }
                    }
                    if (data[0].equals("Meeting Info")){
                        parse_meeting(data);
                    }
                }

            }
            create_entities();
            System.out.println("show's client " + show.getClientName());
        } catch (IOException e){
            System.out.println("IO Exception caught!!");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("line " + line);
        }
        try{
            csvReader.close();
        } catch (IOException e){
            System.out.println("IO Exception caught!!");
        }
    }

    protected void parse_meeting(String[] data){
        try {
            Date meetingDate = new SimpleDateFormat("dd/MM/yyyy").parse(data[1]);
            Date meetingStartTime = parse_date_and_time(data[1], data[2]);
            Date meetingEndTime = parse_date_and_time(data[1], data[3]);
            String room = data[4];
            String status = data[5];
            String company = data[6];
            String guests = data[7];
            String hosts = data[8];
            int totalParticipants = Integer.parseInt(data[9]);
            Meeting meeting = new Meeting(meetingDate, meetingStartTime, meetingEndTime,
                                            room, status, company, guests, hosts, totalParticipants);
            parsedMeetings.add(meeting);
        } catch (ParseException e) {
            // TODO log exception
            e.printStackTrace();
        }
    }

    protected Date parse_date_and_time(String date, String time){
        Date parsedDate = null;
        String joinedDate = date + " " + time;
        try{
            parsedDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(joinedDate);
        } catch (ParseException e) {
            // TODO log exception
            e.printStackTrace();
        }
        return parsedDate;
    }

    protected void create_entities(){
        // TODO: this.show or new show? if new return show object
        this.show = new Show(showName, clientName);

        for (MeetingRoom room : parsedRooms){
            String roomRoomName = room.getMeetingRoomName();
            for (Meeting meeting : parsedMeetings){
                String roomName = meeting.getRoom();
                if (roomName.equals(roomRoomName)){
                    room.addMeetingToRoom(meeting);
                }
            }
            show.addRoomToShow(room);
        }
        //return show;
    }



    /* TODO:

    set up logger
    logic: if meeting is in room which is not listed
    logic: check if meetings collide

    change template: date, start end time sucks, cuz local date takes year 1970 WTF

    */
}
