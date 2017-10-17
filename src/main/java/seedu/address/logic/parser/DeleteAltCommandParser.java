package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.DeleteAltCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteAltCommand object
 */
public class DeleteAltCommandParser implements Parser<DeleteAltCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteAltCommand
     * and returns an DeleteAltCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteAltCommand parse(String args) throws ParseException {
        try {
            String name = ParserUtil.parseString(args);
            return new DeleteAltCommand(name);
        } catch (IllegalValueException ive) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteAltCommand.MESSAGE_USAGE));
        }
    }

}
