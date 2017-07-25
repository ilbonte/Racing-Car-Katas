package tddmicroexercises.turnticketdispenser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicketDispenserTest {
    @Test
    public void creates_a_turn_ticket() {
        TicketDispenser ticketDispenser = new TicketDispenser(new TurnNumberSequence());

        TurnTicket turnTicket = ticketDispenser.getTurnTicket();

        assertEquals(0, turnTicket.getTurnNumber());
    }

    // Legacy behaviour
    @Test
    public void two_tickets_dispenser_share_the_same_turn_number_sequence() {
        TicketDispenser first = new TicketDispenser();
        TicketDispenser second = new TicketDispenser();

        TurnTicket firstTicket = first.getTurnTicket();
        TurnTicket secondTicket = second.getTurnTicket();

        assertEquals(0, firstTicket.getTurnNumber());
        assertEquals(1, secondTicket.getTurnNumber());
    }

    // Modern behaviour
    @Test
    public void two_tickets_dispenser_can_share_the_same_turn_number_sequence() {
        TurnNumberSequence sequence = new TurnNumberSequence();
        TicketDispenser first = new TicketDispenser(sequence);
        TicketDispenser second = new TicketDispenser(sequence);

        TurnTicket firstTicket = first.getTurnTicket();
        TurnTicket secondTicket = second.getTurnTicket();

        assertEquals(0, firstTicket.getTurnNumber());
        assertEquals(1, secondTicket.getTurnNumber());
    }

}

// cosa non è unit test:
// 1. legge dal db
// 2. legge da fs
// 3. legge da network
// 4. test lenti
// 5. non posso eseguire i test in parallelo o l'ordine è importante