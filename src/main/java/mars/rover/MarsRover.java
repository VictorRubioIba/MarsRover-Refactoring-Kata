package mars.rover;

public class MarsRover {

    public static String move(Position position, char direction, String instructions) {
        if (!instructions.isEmpty()) {
            char instruction = instructions.charAt(0);
            if (instruction == 'L') {
                if (direction == 'N') {
                    return move(goNewPosition(position), 'W', getInstructions(instructions));
                } else if (direction == 'W') {
                    return move(goNewPosition(position), 'S', getInstructions(instructions));
                } else if (direction == 'S') {
                    return move(goNewPosition(position), 'E', getInstructions(instructions));
                } else if (direction == 'E') {
                    return move(goNewPosition(position), 'N', getInstructions(instructions));
                }
            } else if (instruction == 'R') {
                if (direction == 'N') {
                    return move(goNewPosition(position), 'E', getInstructions(instructions));
                } else if (direction == 'W') {
                    return move(goNewPosition(position), 'N', getInstructions(instructions));
                } else if (direction == 'S') {
                    return move(goNewPosition(position), 'W', getInstructions(instructions));
                } else if (direction == 'E') {
                    return move(goNewPosition(position), 'S', getInstructions(instructions));
                }
            } else if (instruction == 'M') {
                if (direction == 'N') {
                    return move(new Position(position.getX(), position.getY() + 1), 'N', getInstructions(instructions));
                } else if (direction == 'S') {
                    return move(new Position(position.getX(), position.getY() - 1), 'S', getInstructions(instructions));
                } else if (direction == 'W') {
                    return move(new Position(position.getX() - 1, position.getY()), 'W', getInstructions(instructions));
                } else if (direction == 'E') {
                    return move(new Position(position.getX() + 1, position.getY()), 'E', getInstructions(instructions));
                }
            }
        }
        return position.getX() + " " + position.getY() + " " + direction;
    }

    private static Position goNewPosition(Position position) {
        return new Position(position.getX(), position.getY());
    }

    private static String getInstructions(String instructions) {
        return instructions.substring(1, instructions.length());
    }
}
