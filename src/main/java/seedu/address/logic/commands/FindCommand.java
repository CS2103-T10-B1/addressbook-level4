package seedu.address.logic.commands;

import seedu.address.model.person.ReadOnlyPerson;
import seedu.address.model.tag.Tag;

import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import static seedu.address.logic.parser.modeparser.CommandModeUtil.PREFIX_MODE_INDICATOR;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case sensitive.
 */
public class FindCommand extends Command {

    public static final String COMMAND_WORD = "find";
    public static final String COMMAND_ALIAS = "f";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose names contain any of "
            + "the specified keywords (case-sensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " alice bob charlie";

    /* Mode prefix definitions */

    public static final String PREFIX_FIND_IN_DETAIL = PREFIX_MODE_INDICATOR + "d";
    public static final String PREFIX_FIND_FUZZY_FIND = PREFIX_MODE_INDICATOR + "u";
    public static final String PREFIX_FIND_BY_NAME = "";

    private final Predicate<ReadOnlyPerson> predicate;

    public FindCommand(Predicate<ReadOnlyPerson> predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute() {
        model.updateFilteredPersonList(predicate);
        return new CommandResult(getMessageForPersonListShownSummary(model.getFilteredPersonList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindCommand // instanceof handles nulls
                && this.predicate.equals(((FindCommand) other).predicate)); // state check
    }

    /**
     * Stores the details to find the person with. Each non-empty field value will be used to compare
     * to contacts in the list.
     */
    public static class FindDetailDescriptor {
        private String name;
        private String phone;
        private String email;
        private String address;
        private Set<Tag> tags;

        public FindDetailDescriptor() {
        }

        public FindDetailDescriptor(FindDetailDescriptor toCopy) {
            this.name = toCopy.name;
            this.phone = toCopy.phone;
            this.email = toCopy.email;
            this.address = toCopy.address;
            this.tags = toCopy.tags;
        }

        public Optional<String> getName() {
            return Optional.ofNullable(name);
        }

        public void setName(String name) {
            this.name = name;
        }

        public Optional<String> getPhone() {
            return Optional.ofNullable(phone);
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Optional<String> getEmail() {
            return Optional.ofNullable(email);
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Optional<String> getAddress() {
            return Optional.ofNullable(address);
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Optional<Set<Tag>> getTags() {
            return Optional.ofNullable(tags);
        }

        public void setTags(Set<Tag> tags) {
            this.tags = tags;
        }

        @Override
        public boolean equals(Object other) {
            // short circuit if same object
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof FindDetailDescriptor)) {
                return false;
            }

            // state check
            FindDetailDescriptor e = (FindDetailDescriptor) other;

            return getName().equals(e.getName())
                    && getPhone().equals(e.getPhone())
                    && getEmail().equals(e.getEmail())
                    && getAddress().equals(e.getAddress())
                    && getTags().equals(e.getTags());
        }
    }
}
