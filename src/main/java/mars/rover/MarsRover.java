package mars.rover;

public class MarsRover {

    public static String move(Position position, Direction direction1, String instructions) {
        if (!instructions.isEmpty()) {
            char instruction = instructions.charAt(0);
			switch (instruction) {
				case 'L': {
					String position1 = turnLeft(position, direction1, instructions);
					if (position1 != null)
						return position1;
					break;
				}
				case 'R': {
					String position1 = turnRight(position, direction1, instructions);
					if (position1 != null)
						return position1;
					break;
				}
				case 'M': {
					String position1 = goFront(position, direction1, instructions);
					if (position1 != null)
						return position1;
					break;
				}
			}
        }
        return position.getX() + " " + position.getY() + " " + direction1;
    }

    private static String goFront(Position position, Direction direction1, String instructions) {
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
        return null;
    }

    private static String turnRight(Position position, Direction direction1, String instructions) {
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
            return move(new Position(position.getX(), position.getY()), Direction.S,
                        instructions.substring(1, instructions.length()));
        }
        return null;
    }

    private static String turnLeft(Position position, Direction direction1, String instructions) {
        if (direction1.equals(Direction.N)) {
            return move(new Position(position.getX(), position.getY()), Direction.W,
                        instructions.substring(1, instructions.length()));
        } else if (direction1.equals(Direction.W)) {
            return move(new Position(position.getX(), position.getY()), Direction.S,
                        instructions.substring(1, instructions.length()));
        } else if (direction1.equals(Direction.S)) {
            return move(new Position(position.getX(), position.getY()), Direction.E,
                        instructions.substring(1, instructions.length()));
        } else if (direction1.equals(Direction.E)) {
            return move(new Position(position.getX(), position.getY()), Direction.N,
                        instructions.substring(1, instructions.length()));
        }
        return null;
    }
}
