package mars.rover;

public class MarsRover {

    public static String move(Position position, Direction direction, String instructions) {
        if (!instructions.isEmpty()) {
            char instruction = instructions.charAt(0);
			switch (instruction) {
				case 'L': {
					return turnLeft(position, direction, instructions);
				}
				case 'R': {
					return turnRight(position, direction, instructions);
				}
				case 'M': {
					 return goFront(position, direction, instructions);
				}
				default:
					throw new IllegalStateException("Unexpected value: " + instruction);
			}
        }
        return position.getX() + " " + position.getY() + " " + direction;
    }

    private static String goFront(Position position, Direction direction, String instructions) {
		switch (direction) {
			case N:
				return move(new Position(position.getX(), position.getY() + 1),
							Direction.N, instructions.substring(1, instructions.length()));
			case S:
				return move(new Position(position.getX(), position.getY() - 1),
							Direction.S, instructions.substring(1, instructions.length()));
			case W:
				return move(new Position(position.getX() - 1, position.getY()),
							Direction.W, instructions.substring(1, instructions.length()));
			case E:
				return move(new Position(position.getX() + 1, position.getY()),
							Direction.E, instructions.substring(1, instructions.length()));
			default:
				throw new IllegalStateException("Unexpected value: " + direction);
		}

    }

    private static String turnRight(Position position, Direction direction, String instructions) {
		switch (direction) {
			case N:
				return move(new Position(position.getX(), position.getY()), Direction.E,
							instructions.substring(1, instructions.length()));
			case W:
				return move(new Position(position.getX(), position.getY()), Direction.N,
							instructions.substring(1, instructions.length()));
			case S:
				return move(new Position(position.getX(), position.getY()), Direction.W,
							instructions.substring(1, instructions.length()));
			case E:
				return move(new Position(position.getX(), position.getY()), Direction.S,
							instructions.substring(1, instructions.length()));
			default:
				throw new IllegalStateException("Unexpected value: " + direction);
		}

    }

    private static String turnLeft(Position position, Direction direction1, String instructions) {
		switch (direction1) {
			case N:
				return move(new Position(position.getX(), position.getY()), Direction.W,
							instructions.substring(1, instructions.length()));
			case W:
				return move(new Position(position.getX(), position.getY()), Direction.S,
							instructions.substring(1, instructions.length()));
			case S:
				return move(new Position(position.getX(), position.getY()), Direction.E,
							instructions.substring(1, instructions.length()));
			case E:
				return move(new Position(position.getX(), position.getY()), Direction.N,
							instructions.substring(1, instructions.length()));
			default:
				throw new IllegalStateException("Unexpected value: " + direction1);
		}

    }
}
