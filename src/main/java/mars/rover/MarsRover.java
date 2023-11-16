package mars.rover;

public class MarsRover {

    public static String move(Position position, Direction direction1, String instructions) {
        if (!instructions.isEmpty()) {
            char instruction = instructions.charAt(0);
            if (instruction == 'L') {
                String position1 = turnLeft(position, direction1, instructions);
                if (position1 != null) {
                    return position1;
                }
            } else if (instruction == 'R') {
                String position1 = turnRight(position, direction1, instructions);
                if (position1 != null) {
                    return position1;
                }
            } else if (instruction == 'M') {
                String position1 = goFront(position, direction1, instructions);
                if (position1 != null) {
                    return position1;
                }
            }
        }
        return position.getX() + " " + position.getY() + " " + direction1;
    }

    private static String goFront(Position position, Direction direction1, String instructions) {
		switch (direction1) {
			case N:
				return move(new Position(position.getX(), position.getY() + 1),
							Direction.N, getInstructions(instructions));
			case S:
				return move(new Position(position.getX(), position.getY() - 1),
							Direction.S, getInstructions(instructions));
			case W:
				return move(new Position(position.getX() - 1, position.getY()),
							Direction.W, getInstructions(instructions));
			case E:
				return move(new Position(position.getX() + 1, position.getY()),
							Direction.E, getInstructions(instructions));
		}
        return null;
    }

    private static String turnRight(Position position, Direction direction1, String instructions) {
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
        return null;
    }

    private static String turnLeft(Position position, Direction direction1, String instructions) {
        if (direction1.equals(Direction.N)) {

            return move(goNewPosition(position), Direction.W, getInstructions(instructions));

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
        return null;
    }

    private static Position goNewPosition(Position position) {
        return new Position(position.getX(), position.getY());
    }

    private static String getInstructions(String instructions) {
        return instructions.substring(1, instructions.length());
    }
}
