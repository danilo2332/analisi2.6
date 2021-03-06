package gov.nysenate.openleg.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author GraylinKim
 */
public final class Meeting extends BaseObject
{
    /**
     * The date and time of the meeting.
     */
    protected Date meetingDateTime;

    /**
     * Day of the week; e.g. Wednesday.
     */
    protected String meetday = "";

    /**
     * The physical location of the meeting; e.g. 332 CAP.
     */
    protected String location = "";

    /**
     * The unique identifier for this object.
     */
    protected String oid;

    /**
     * The name of the committee that is meeting
     */
    protected String committeeName = "";

    /**
     * The full name of the chair of the committee
     */
    protected String committeeChair = "";

    /**
     * A list of bills on the agenda for the meeting
     */
    protected List<Bill> bills;

    /**
     * The notes for the meeting. Will often detail appointments to be made or experts to appear.
     */
    protected String notes = "";

    /**
     *
     */
    protected String addendum = "";
    private String Oid;
    private Date MeetingDateTime;
    private String CommitteeName;

    /**
     * JavaBean Constructor
     */
    public Meeting() {
        bills = new ArrayList<Bill>();
    }

    /**
     *
     * @param id
     */
    private Meeting(String committeeName, Date meetingDateTime) {
        this.CommitteeName=committeeName;
        this.MeetingDateTime=meetingDateTime;
        this.Oid=committeeName;

        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(meetingDateTime);
        this.setSession(calendar.get(java.util.Calendar.YEAR));
        this.setYear(calendar.get(java.util.Calendar.YEAR));

        bills = new ArrayList<Bill>();
    }

    /**
     * The object type of the meeting.
     */
    public String getOtype()
    {
        return "meeting";
    }

    /**
     * @return - The object's id.
     */
    public String getOid()
    {
        return this.oid;
    }

    /**
     * @param oid - The object's new oid
     */
    public void setOid(String oid)
    {
        this.oid = oid.replace(" ", "-").replace(",", "");
    }

    public String getCommitteeChair() {
        return committeeChair;
    }

    public void setCommitteeChair(String committeeChair) {
        this.committeeChair = committeeChair;
    }

    public int getYear() {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(this.getMeetingDateTime());
        return cal.get(java.util.Calendar.YEAR);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMeetday() {
        return meetday;
    }

    public void setMeetday(String meetday) {
        this.meetday = meetday;
    }


    public Date getMeetingDateTime() {
        return meetingDateTime;
    }

    public void setMeetingDateTime(Date meetingDateTime) {
        this.meetingDateTime = meetingDateTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public String getCommitteeName() {
        return committeeName;
    }

    public void setCommitteeName(String committeeName) {
        this.committeeName = committeeName;
    }

    public String getAddendum() {
        return addendum;
    }

    public void setAddendum(String addendum) {
        this.addendum = addendum;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj != null && obj instanceof Meeting)
        {
            if ( ((Meeting)obj).getOid().equals(this.getOid()))
                return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return this.oid + " : " + meetingDateTime.getTime();
    }
}