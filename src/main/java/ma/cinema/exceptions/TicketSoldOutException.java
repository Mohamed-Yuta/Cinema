package ma.cinema.exceptions;
public class TicketSoldOutException extends Exception {
    public TicketSoldOutException(String message){
        super(message);
    }
}
