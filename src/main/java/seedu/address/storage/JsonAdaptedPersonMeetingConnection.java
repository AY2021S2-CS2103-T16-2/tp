package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.parser.DateTimeUtil;
import seedu.address.model.connection.PersonMeetingConnection;
import seedu.address.model.meeting.DateTime;
import seedu.address.model.meeting.Meeting;
import seedu.address.model.meeting.MeetingBook;
import seedu.address.model.meeting.MeetingName;
import seedu.address.model.person.AddressBook;
import seedu.address.model.person.Person;
import seedu.address.model.person.PersonName;

public class JsonAdaptedPersonMeetingConnection {
    public static final String CONNECTION_FIELD_MESSAGE_FORMAT = "Connection's %s field is missing!";

    private final String personName;
    private final String startDateTime;
    private final String meetingName;

    /**
     * Constructs a {@code JsonAdoptedMeeting} with the given meeting details.
     */

    @JsonCreator
    public JsonAdaptedPersonMeetingConnection(@JsonProperty("personName") String personName,
                              @JsonProperty("startDateTime") String startDateTime,
                              @JsonProperty("meetingName") String meetingName) {
        this.personName = personName;
        this.startDateTime = startDateTime;
        this.meetingName = meetingName;
        }


    /**
     * Converts a given {@code Meeting} into this class for Jackson use.
     */
    public JsonAdaptedPersonMeetingConnection(Meeting meetingSource, Person personSource) {
        personName = personSource.getName().fullName;
        startDateTime = DateTimeUtil.formatDateTime(meetingSource.getStart().value);
        meetingName = meetingSource.getName().fullName;
    }

    /**
     * Converts this Jackson-friendly adapted meeting object into the model's {@code Meeting} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted meeting.
     */

    public PersonMeetingConnection toModelType(AddressBook addressBook, MeetingBook meetingBook, PersonMeetingConnection connection) throws IllegalValueException {
        Person person = addressBook.getPersonByName(new PersonName(personName));
        Meeting meeting = meetingBook.getMeetingByNameAndStartTime(new MeetingName(meetingName), new DateTime(startDateTime));
        if (connection.existPersonMeetingConnection(person, meeting)) {
            throw new IllegalValueException(JsonSerializableConnection.MESSAGE_DUPLICATE_CONNECTION);
        }
        connection.addPersonMeetingConnection(person, meeting);
        return connection;
    }
}
