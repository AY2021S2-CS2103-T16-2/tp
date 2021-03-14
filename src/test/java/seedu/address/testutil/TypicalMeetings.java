package seedu.address.testutil;

import static seedu.address.logic.commands.MeetingCommandTestUtil.VALID_NAME_MEETING1;
import static seedu.address.logic.commands.MeetingCommandTestUtil.VALID_NAME_MEETING2;
import static seedu.address.logic.commands.MeetingCommandTestUtil.VALID_START_MEETING1;
import static seedu.address.logic.commands.MeetingCommandTestUtil.VALID_START_MEETING2;
import static seedu.address.logic.commands.MeetingCommandTestUtil.VALID_TERMINATE_MEETING1;
import static seedu.address.logic.commands.MeetingCommandTestUtil.VALID_TERMINATE_MEETING2;
import static seedu.address.logic.commands.MeetingCommandTestUtil.VALID_PRIORITY_MEETING1;
import static seedu.address.logic.commands.MeetingCommandTestUtil.VALID_PRIORITY_MEETING2;
import static seedu.address.logic.commands.MeetingCommandTestUtil.VALID_DESCRIPTION_MEETING1;
import static seedu.address.logic.commands.MeetingCommandTestUtil.VALID_DESCRIPTION_MEETING2;
import static seedu.address.logic.commands.MeetingCommandTestUtil.VALID_TAG_MEETING1;
import static seedu.address.logic.commands.MeetingCommandTestUtil.VALID_TAG_MEETING2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.meeting.Meeting;
import seedu.address.model.person.Person;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalMeetings {

    // Manually added - Meeting's details found in {@code CommandTestUtil}
    public static final Meeting MEETING1 = new MeetingBuilder().withName(VALID_NAME_MEETING1).withStart(VALID_START_MEETING1)
            .withTerminate(VALID_TERMINATE_MEETING1).withPriority(VALID_PRIORITY_MEETING1).withDescription(VALID_DESCRIPTION_MEETING1)
            .withTags(VALID_TAG_MEETING1).build();
    public static final Meeting MEETING2 = new MeetingBuilder().withName(VALID_NAME_MEETING2).withStart(VALID_START_MEETING2)
            .withTerminate(VALID_TERMINATE_MEETING2).withPriority(VALID_PRIORITY_MEETING2).withDescription(VALID_DESCRIPTION_MEETING2)
            .withTags(VALID_TAG_MEETING2).build();

    public static final Meeting MEETING3 = new MeetingBuilder().withName("CS2103 ONLINE Lecture")
            .withStart("2020-03-11 14:00").withTerminate("2020-03-11 16:00")
            .withPriority("5").withDescription("Taught by Damith")
            .withTags("Lectures").build();
    public static final Meeting MEETING4 = new MeetingBuilder().withName("CS2106 ONLINE Lecture")
            .withStart("2020-03-10 10:00").withTerminate("2020-03-10 12:00")
            .withPriority("5").withDescription("Taught by Djordje")
            .withTags("Lectures").build();
    public static final Meeting MEETING5 = new MeetingBuilder().withName("Chess Club Meetings")
            .withStart("2020-03-17 10:00").withTerminate("2020-03-17 12:00")
            .withPriority("3").withDescription("Bring your chess board")
            .withTags("Extracurricular").build();



    // Still don't know what this part is doing, will check later.
//    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER
//
//    private TypicalPersons() {} // prevents instantiation

//    /**
//     * Returns an {@code AddressBook} with all the typical persons.
//     */
//    public static AddressBook getTypicalAddressBook() {
//        AddressBook ab = new AddressBook();
//        for (Person person : getTypicalPersons()) {
//            ab.addPerson(person);
//        }
//        return ab;
//    }

    public static List<Meeting> getTypicalMeetings() {
        return new ArrayList<>(Arrays.asList(MEETING1, MEETING2, MEETING3, MEETING4, MEETING5));
    }
}
