package backend.elements;

import java.util.ArrayList;
import java.util.Collection;

public class Show {

    protected String showName;
    protected String clientName;
    protected Collection meetingRooms;

    public Show(String showName, String clientName){
        this.showName = showName;
        this.clientName = clientName;
        this.meetingRooms = new ArrayList<MeetingRoom>();
    }

    public void addRoomToShow(MeetingRoom meetingRoom){
        this.meetingRooms.add(meetingRoom);
    }

    // TODO: make this class a Singleton? or maybe a goddam utility class? ahhh

    public String getClientName() {
        return clientName;
    }

    public String getShowName() {
        return showName;
    }

    public Collection getMeetingRooms() {
        return meetingRooms;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public void setMeetingRooms(Collection meetingRooms) {
        this.meetingRooms = meetingRooms;
    }

}
