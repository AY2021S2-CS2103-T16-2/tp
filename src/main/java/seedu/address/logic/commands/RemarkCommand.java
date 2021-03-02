package seedu.address.logic.commands;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;
import seedu.address.model.person.Remark;

import java.util.List;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REMARK;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

/**
     * Changes the remark of an existing person in the address book.
     */
    public class RemarkCommand extends Command {

        public static final String MESSAGE_ARGUMENTS = "Index: %1$d, Remark: %2$s";
        public static final String COMMAND_WORD = "remark";

        public static final String MESSAGE_USAGE = COMMAND_WORD + ":" + " adds a remark under a person at a certain index. "
                + " Parameters : \n"
                + "1 "
                + PREFIX_REMARK
                + "It's the anime man";

        private final Index index;
        private final Remark remark;

        public static final String MESSAGE_ADD_REMARK_SUCCESS = "MARKED SUCCESS";
        public static final String MESSAGE_DELETE_REMARK_SUCCESS = "MESSAGE DELETED!";

        /**
         * @param index of the person in the filtered person list to edit the remark
         * @param remark of the person to be updated to
         */
        public RemarkCommand(Index index, Remark remark) {
            requireAllNonNull(index, remark);

            this.index = index;
            this.remark = remark;
        }
        @Override
        public CommandResult execute(Model model) throws CommandException {
            List<Person> lastShownList = model.getFilteredPersonList();

            if (index.getZeroBased() >= lastShownList.size()) {
                throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
            }

            Person personToEdit = lastShownList.get(index.getZeroBased());
            Person editedPerson = new Person(personToEdit.getName(), personToEdit.getPhone(), personToEdit.getEmail(),
                    personToEdit.getAddress(),personToEdit.getTags(), remark);

            model.setPerson(personToEdit, editedPerson);
            model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);

            return new CommandResult(generateSuccessMessage(editedPerson));
        }

        private String generateSuccessMessage(Person personToEdit) {
            String message = !remark.value.isEmpty() ? MESSAGE_ADD_REMARK_SUCCESS : MESSAGE_DELETE_REMARK_SUCCESS;
            return String.format(message, personToEdit);
        }

        @Override
        public boolean equals(Object other) {
            // short circuit if same object
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof RemarkCommand)) {
                return false;
            }

            // state check
            RemarkCommand e = (RemarkCommand) other;
            return index.equals(e.index)
                    && remark.equals(e.remark);
        }
    }

