package backend.elements;

import java.sql.Time;
import java.sql.Date;

public class Meeting {

    protected Date meetingDate;
    protected Time meetingStartTime, meetingEndTime;
    protected Boolean displayMeetingDate, displayMeetingStartTime, displayMeetingEndTime;
    protected int totalParticipants;
    protected String status, company, guests, hosts;
    protected Boolean displayStatus, displayCompany, displayGuests, displayHosts, displayTotalParticipants;


    public Meeting (Date meetingDate, Time meetingStartTime, Time meetingEndTime,
                    String status, String company, String guests, String hosts, int totalParticipants){
        this.meetingDate = meetingDate;
        this.displayMeetingDate = true;
        this.meetingStartTime = meetingStartTime;
        this.displayMeetingStartTime = true;
        this.meetingEndTime = meetingEndTime;
        this.displayMeetingEndTime = true;
        this.status = status;
        this.displayStatus = true;
        this.company = company;
        this.displayCompany = true;
        this.guests = guests;
        this.displayGuests = true;
        this.hosts = hosts;
        this.displayHosts = true;
        this.totalParticipants = totalParticipants;
        this.displayTotalParticipants = true;
    }


}
