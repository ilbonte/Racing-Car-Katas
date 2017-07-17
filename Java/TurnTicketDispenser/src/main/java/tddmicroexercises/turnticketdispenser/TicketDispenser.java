package tddmicroexercises.turnticketdispenser;

public class TicketDispenser
{
    public TurnTicket getTurnTicket()
    {
        int newTurnNumber = getNextTurnNumber();
        TurnTicket newTurnTicket = new TurnTicket(newTurnNumber);

        return newTurnTicket;
    }

    protected int getNextTurnNumber() {
        return TurnNumberSequence.getNextTurnNumber();
    }
}
