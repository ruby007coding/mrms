package main.backend.elements;

@Getter
@Setter
public class MeetingRoom {

    protected String meetingRoomName;
    protected Meeting meeting;

    public MeetingRoom(String meetingRoomName){
        this.meetingRoomName = meetingRoomName;
    }

    // TODO: add meeting to room method

}
