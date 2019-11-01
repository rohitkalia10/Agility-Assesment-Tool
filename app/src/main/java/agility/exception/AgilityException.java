package agility.exception;

import agility.api.StatusError;
import agility.api.StatusMessage;

public class AgilityException extends  RuntimeException {
    private StatusError statusError;
    private StatusMessage statusMessage;

    public AgilityException(StatusMessage statusMsg) {
        this.statusMessage = statusMsg;
    }

    public AgilityException(StatusError statusErr) {
        this.statusError = statusErr;
    }

    public StatusError getStatusError() {
        return statusError;
    }

    public StatusMessage getStatusMessage() {
        return statusMessage;
    }

    public AgilityException() {
        super();
    }

    public AgilityException(String message) {
        super(message);
    }

    public AgilityException(String message, Throwable cause) {
        super(message, cause);
    }

    public AgilityException(Throwable cause) {
        super(cause);
    }

    public AgilityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
