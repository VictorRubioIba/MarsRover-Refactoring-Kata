package mars.rover;

public class MarsRover {

    public static String move(Position position, char direction, String instructions) {
        if (!instructions.isEmpty()) {
            char instruction = instructions.charAt(0);
            if (instruction == 'L') {
                if (direction == 'N') {
                    return move(new Position(position.getX(), position.getY()), 'W', getInstructions(instructions));
                } else if (direction == 'W') {
                    return move(new Position(position.getX(), position.getY()), 'S', getInstructions(instructions));
                } else if (direction == 'S') {
                    return move(new Position(position.getX(), position.getY()), 'E', getInstructions(instructions));
                } else if (direction == 'E') {
                    return move(new Position(position.getX(), position.getY()), 'N', getInstructions(instructions));
                }
            } else if (instruction == 'R') {
                if (direction == 'N') {
                    return move(new Position(position.getX(), position.getY()), 'E', getInstructions(instructions));
                } else if (direction == 'W') {
                    return move(new Position(position.getX(), position.getY()), 'N', getInstructions(instructions));
                } else if (direction == 'S') {
                    return move(new Position(position.getX(), position.getY()), 'W', getInstructions(instructions));
                } else if (direction == 'E') {
                    return move(new Position(position.getX(), position.getY()), 'S', getInstructions(instructions));
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

    private static String getInstructions(String instructions) {
        return instructions.substring(1, instructions.length());
    }
}
