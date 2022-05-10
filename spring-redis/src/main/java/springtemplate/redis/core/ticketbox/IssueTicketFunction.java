package springtemplate.redis.core.ticketbox;

@FunctionalInterface
public interface IssueTicketFunction {

    boolean issue(String ticketId);

}