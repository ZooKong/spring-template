package springtemplate.redis.core.ticketbox;

import java.util.UUID;

public abstract class TicketBox {

    private final String prefix;

    protected TicketBox() {
        prefix = UUID.randomUUID().toString();
    }

    protected String getTicketKey(String id) {
        return new StringBuilder(getTicketPrefix()).append(getcketKeyLink()).append(id).toString();
    }

    protected String getTicketPrefix() {
        return prefix;
    }

    protected String getcketKeyLink() {
        return "-";
    }

    public void ticketing(String id) {
        String ticketId = getTicketKey(id);
    }

    protected abstract IssueTicketFunction issueTicket();

    protected abstract RetrieveTicketFunction retrieveTicket();

//    returnTicket;
//    issueTicket;
//    FailureTickettingFunction;

}