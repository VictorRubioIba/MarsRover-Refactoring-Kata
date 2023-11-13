package mars.rover;

public class MarsRover {

    public static String move(Position position, Direction direction1, String instructions) {
        if (!instructions.isEmpty()) {
            char instruction = instructions.charAt(0);
            if (instruction == 'L') {
                if (direction1.equals(Direction.N)) {
                    return move(new Position(position.getX(), position.getY()), Direction.W,
                                instructions.substring(1, instructions.length()));
                } else if (direction1.equals(Direction.W)) {
                    return move(new Position(position.getX(), position.getY()),Direction.S,
                                instructions.substring(1, instructions.length()));
                } else if (direction1.equals(Direction.S)) {
                    return move(new Position(position.getX(), position.getY()), Direction.E,
                                instructions.substring(1, instructions.length()));
                } else if (direction1.equals(Direction.E)) {
                    return move(new Position(position.getX(), position.getY()), Direction.N,
                                instructions.substring(1, instructions.length()));
                }
            } else if (instruction == 'R') {
                if (direction1.equals(Direction.N)) {
                    return move(new Position(position.getX(), position.getY()), Direction.E,
                                instructions.substring(1, instructions.length()));
                } else if (direction1.equals(Direction.W)) {
                    return move(new Position(position.getX(), position.getY()), Direction.N,
                                instructions.substring(1, instructions.length()));
                } else if (direction1.equals(Direction.S)) {
                    return move(new Position(position.getX(), position.getY()), Direction.W,
                                instructions.substring(1, instructions.length()));
                } else if (direction1.equals(Direction.E)) {
                    return move(new Position(position.getX(), position.getY()),Direction.S,
                                instructions.substring(1, instructions.length()));
                }
            } else if (instruction == 'M') {
                if (direction1.equals(Direction.N)) {
                    return move(new Position(position.getX(), position.getY() + 1),
                                Direction.N, instructions.substring(1, instructions.length()));
                } else if (direction1.equals(Direction.S)) {
                    return move(new Position(position.getX(), position.getY() - 1),
                                Direction.S, instructions.substring(1, instructions.length()));
                } else if (direction1.equals(Direction.W)) {
                    return move(new Position(position.getX() - 1, position.getY()),
                                Direction.W, instructions.substring(1, instructions.length()));
                } else if (direction1.equals(Direction.E)) {
                    return move(new Position(position.getX() + 1, position.getY()),
                                Direction.E, instructions.substring(1, instructions.length()));
                }
            }
        }
        return position.getX() + " " + position.getY() + " " + direction1;
    }
}
