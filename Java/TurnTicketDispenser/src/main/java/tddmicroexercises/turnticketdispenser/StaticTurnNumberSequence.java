package tddmicroexercises.turnticketdispenser;

public class StaticTurnNumberSequence {

    static TurnNumberSequence sequence;

    public static TurnNumberSequence create() {
        if (sequence == null) {
            sequence = new TurnNumberSequence();
        }
        return sequence;
    }
}
