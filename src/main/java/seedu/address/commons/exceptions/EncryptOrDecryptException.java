package seedu.address.commons.exceptions;

/**
 * Signals an error caused by encryption and decryption.
 * The reason can be wrong keyword.
 */
public class EncryptOrDecryptException extends Exception {

    public EncryptOrDecryptException(){
        super();
    }

}
