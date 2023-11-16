package mars.rover;

public class MarsRover {

    public static String move(Position position, Direction direction1, String instructions) {
        if (!instructions.isEmpty()) {
            char instruction = instructions.charAt(0);
            if (instruction == 'L') {
                if (direction1.equals(Direction.N)) {
                    return move(goNewPosition(position), Direction.W,
                                getInstructions(instructions));
                } else if (direction1.equals(Direction.W)) {
                    return move(goNewPosition(position), Direction.S,
                                getInstructions(instructions));
                } else if (direction1.equals(Direction.S)) {
                    return move(goNewPosition(position), Direction.E,
                                getInstructions(instructions));
                } else if (direction1.equals(Direction.E)) {
                    return move(goNewPosition(position), Direction.N,
                                getInstructions(instructions));
                }
            } else if (instruction == 'R') {
                if (direction1.equals(Direction.N)) {
                    return move(goNewPosition(position), Direction.E,
                                getInstructions(instructions));
                } else if (direction1.equals(Direction.W)) {
                    return move(goNewPosition(position), Direction.N,
                                getInstructions(instructions));
                } else if (direction1.equals(Direction.S)) {
                    return move(goNewPosition(position), Direction.W,
                                getInstructions(instructions));
                } else if (direction1.equals(Direction.E)) {
                    return move(goNewPosition(position), Direction.S,
                                getInstructions(instructions));
                }
            } else if (instruction == 'M') {
                if (direction1.equals(Direction.N)) {
                    return move(new Position(position.getX(), position.getY() + 1),
                                Direction.N, getInstructions(instructions));
                } else if (direction1.equals(Direction.S)) {
                    return move(new Position(position.getX(), position.getY() - 1),
                                Direction.S, getInstructions(instructions));
                } else if (direction1.equals(Direction.W)) {
                    return move(new Position(position.getX() - 1, position.getY()),
                                Direction.W, getInstructions(instructions));
                } else if (direction1.equals(Direction.E)) {
                    return move(new Position(position.getX() + 1, position.getY()),
                                Direction.E, getInstructions(instructions));
                }
            }
        }
        return position.getX() + " " + position.getY() + " " + direction1;
    }

    private static Position goNewPosition(Position position) {
        return new Position(position.getX(), position.getY());
    }

    private static String getInstructions(String instructions) {
        return instructions.substring(1, instructions.length());
    }
}
