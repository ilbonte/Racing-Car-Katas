package tddmicroexercises.turnticketdispenser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicketDispenserTest {
    @Test
    public void creates_a_turn_ticket() {
        TicketDispenser ticketDispenser = new TestableTicketDispenser();

        TurnTicket turnTicket = ticketDispenser.getTurnTicket();

        assertEquals(0, turnTicket.getTurnNumber());
    }

    private class TestableTicketDispenser extends TicketDispenser {
        @Override
        protected int getNextTurnNumber() {
            return 0;
        }
    }
}