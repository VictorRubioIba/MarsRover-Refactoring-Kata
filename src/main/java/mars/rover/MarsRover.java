package mars.rover;

public class MarsRover {

    public static String move(Position position, char direction, String instructions) {
        if (!instructions.isEmpty()) {
            char instruction = instructions.charAt(0);
            if (instruction == 'L') {
                if (direction == 'N') {
                    return move(new Position(position.getX(), position.getY()), 'W', instructions.substring(1, instructions.length()));
                } else if (direction == 'W') {
                    return move(new Position(position.getX(), position.getY()), 'S', instructions.substring(1, instructions.length()));
                } else if (direction == 'S') {
                    return move(new Position(position.getX(), position.getY()), 'E', instructions.substring(1, instructions.length()));
                } else if (direction == 'E') {
                    return move(new Position(position.getX(), position.getY()), 'N', instructions.substring(1, instructions.length()));
                }
            } else if (instruction == 'R') {
                if (direction == 'N') {
                    return move(new Position(position.getX(), position.getY()), 'E', instructions.substring(1, instructions.length()));
                } else if (direction == 'W') {
                    return move(new Position(position.getX(), position.getY()), 'N', instructions.substring(1, instructions.length()));
                } else if (direction == 'S') {
                    return move(new Position(position.getX(), position.getY()), 'W', instructions.substring(1, instructions.length()));
                } else if (direction == 'E') {
                    return move(new Position(position.getX(), position.getY()), 'S', instructions.substring(1, instructions.length()));
                }
            } else if (instruction == 'M') {
                if (direction == 'N') {
                    return move(new Position(position.getX(), position.getY() + 1), 'N', instructions.substring(1, instructions.length()));
                } else if (direction == 'S') {
                    return move(new Position(position.getX(), position.getY() - 1), 'S', instructions.substring(1, instructions.length()));
                } else if (direction == 'W') {
                    return move(new Position(position.getX() - 1, position.getY()), 'W', instructions.substring(1, instructions.length()));
                } else if (direction == 'E') {
                    return move(new Position(position.getX() + 1, position.getY()), 'E', instructions.substring(1, instructions.length()));
                }
            }
        }
        return position.getX() + " " + position.getY() + " " + direction;
    }
}
