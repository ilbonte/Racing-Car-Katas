package tddmicroexercises.turnticketdispenser;

public class TicketDispenser
{

    private TurnNumberSequence turnNumberSequence;

    public TicketDispenser(){
        this(StaticTurnNumberSequence.create());
    }

    public TicketDispenser(TurnNumberSequence turnNumberSequence) {
        this.turnNumberSequence = turnNumberSequence;
    }

    public TurnTicket getTurnTicket()
    {
        int newTurnNumber = turnNumberSequence.next();
        TurnTicket newTurnTicket = new TurnTicket(newTurnNumber);

        return newTurnTicket;
    }

}
