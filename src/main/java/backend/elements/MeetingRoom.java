package backend.elements;

import lombok.Setter;
import lombok.Getter;

import java.util.Collection;

@Getter
@Setter
public class MeetingRoom {

    protected String meetingRoomName;
    protected Collection meetings;

    public MeetingRoom(String meetingRoomName){
        this.meetingRoomName = meetingRoomName;
    }

    protected void addMeetingToMeetingRoom(Meeting meeting){
        this.meetings.add(meeting);
    }

}
