package springtemplate.redis.core.ticketbox;

@FunctionalInterface
public interface RetrieveTicketFunction {

    void retrieve(String ticketId);

}