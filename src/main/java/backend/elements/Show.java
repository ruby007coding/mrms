package backend.elements;

import java.util.Collection;

public class Show {

    protected String showName, clientName;
    protected Collection meetingRooms;

    public Show(String showName, String clientName){
        this.showName = showName;
        this.clientName = clientName;
    }

    protected void addRoomsToShow(MeetingRoom meetingRoom){
        this.meetingRooms.add(meetingRoom);
    }

    // TODO: make this class a Singleton?

}
