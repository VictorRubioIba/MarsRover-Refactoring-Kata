package mars.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {

    @Test
    public void
    acceptance_test_1() {
        String newPosition = MarsRover.move(new Position(1, 2),
                                            new Movement(Direction.N, "LMLMLMLMM"));
        assertEquals("1 3 N", newPosition);
    }

    @Test
    public void
    acceptance_test_2() {
        String newPosition = MarsRover.move(new Position(3, 3),
                                            new Movement(Direction.E, "MMRMMRMRRM"));
        assertEquals("5 1 E", newPosition);
    }

}