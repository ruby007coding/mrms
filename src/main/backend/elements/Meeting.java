package main.backend.elements;

import java.sql.Time;
import java.sql.Date;

@Getter
@Setter
public class Meeting {

    protected Date meetingDate;
    protected Time meetingStartTime, meetingEndTime;
    protected String status, company, guests, hosts;
    protected int totalParticipants;


    public Meeting (Date meetingDate, Time meetingStartTime, Time meetingEndTime,
                    String status, String company, String guests, String hosts, int totalParticipants){
        this.meetingDate = meetingDate;
        this.meetingStartTime = meetingStartTime;
        this.meetingEndTime = meetingEndTime;
        this.status = status;
        this.company = company;
        this.guests = guests;
        this.hosts = hosts;
        this.totalParticipants = totalParticipants;
    }


}
