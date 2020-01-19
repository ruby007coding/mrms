package backend.elements;

import java.util.ArrayList;
import java.util.Collection;

public class MeetingRoom {

    protected String meetingRoomName;
    protected int meetingRoomCapacity;
    protected Collection meetings;

    public MeetingRoom(String meetingRoomName, int meetingRoomCapacity){
        this.meetingRoomName = meetingRoomName;
        this.meetingRoomCapacity = meetingRoomCapacity;
        this.meetings = new ArrayList<Meeting>();
    }

    public void addMeetingToRoom(Meeting meeting){
        this.meetings.add(meeting);
    }

    public int getMeetingRoomCapacity() {
        return meetingRoomCapacity;
    }

    public void setMeetingRoomCapacity(int meetingRoomCapacity) {
        this.meetingRoomCapacity = meetingRoomCapacity;
    }

    public void setMeetingRoomName(String meetingRoomName) {
        this.meetingRoomName = meetingRoomName;
    }

    public void setMeetings(Collection meetings) {
        this.meetings = meetings;
    }

    public String getMeetingRoomName() {
        return meetingRoomName;
    }
    public Collection getMeetings() {
        return meetings;
    }

}
