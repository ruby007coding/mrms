package backend.elements;

import java.util.Date;

public class Meeting {

    protected Date meetingDate;
    protected Date meetingStartTime, meetingEndTime;
    protected Boolean displayMeetingDate, displayMeetingStartTime, displayMeetingEndTime, displayRoom;
    protected int totalParticipants;
    protected String room;
    protected String status;
    protected String company;
    protected String guests;
    protected String hosts;
    protected Boolean displayStatus, displayCompany, displayGuests, displayHosts, displayTotalParticipants;


    public Meeting (Date meetingDate, Date meetingStartTime, Date meetingEndTime, String room,
                    String status, String company, String guests, String hosts, int totalParticipants){
        this.meetingDate = meetingDate;
        this.displayMeetingDate = true;
        this.meetingStartTime = meetingStartTime;
        this.displayMeetingStartTime = true;
        this.meetingEndTime = meetingEndTime;
        this.displayMeetingEndTime = true;
        this.room = room;
        this.displayRoom = true;
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


    public String getHosts() {
        return hosts;
    }

    public String getGuests() {
        return guests;
    }

    public String getCompany() {
        return company;
    }

    public String getStatus() {
        return status;
    }

    public String getRoom() {
        return room;
    }

    public int getTotalParticipants() {
        return totalParticipants;
    }

    public Date getMeetingEndTime() {
        return meetingEndTime;
    }

    public Date getMeetingStartTime() {
        return meetingStartTime;
    }

    public Date getMeetingDate() {
        return meetingDate;
    }
}
