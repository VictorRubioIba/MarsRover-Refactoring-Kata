package mars.rover;

public class MarsRover {

    public static String move(Position position, Movement movement) {
        if (!movement.getInstructions()
			.isEmpty()) {
            char instruction = movement.getInstructions()
				.charAt(0);
			switch (instruction) {
				case 'L': {
					return turnLeft(position, new Movement(movement.getDirection(),
														   movement.getInstructions()));
				}
				case 'R': {
					return turnRight(position, new Movement(movement.getDirection(),
															movement.getInstructions()));
				}
				case 'M': {
					 return goFront(position, new Movement(movement.getDirection(), movement.getInstructions()));
				}
				default:
					throw new IllegalStateException("Unexpected value: " + instruction);
			}
        }
        return position.getX() + " " + position.getY() + " " + movement.getDirection();
    }

    private static String goFront(Position position, Movement movement) {
		switch (movement.getDirection()) {
			case N:
				return move(new Position(position.getX(), position.getY() + 1),
							new Movement(Direction.N, movement.getInstructions().substring(1)));
			case S:
				return move(new Position(position.getX(), position.getY() - 1),
							new Movement(Direction.S, movement.getInstructions().substring(1)));
			case W:
				return move(new Position(position.getX() - 1, position.getY()),
							new Movement(Direction.W, movement.getInstructions().substring(1)));
			case E:
				return move(new Position(position.getX() + 1, position.getY()),
							new Movement(Direction.E, movement.getInstructions().substring(1)));
			default:
				throw new IllegalStateException("Unexpected value: " + movement.getDirection());
		}

    }

    private static String turnRight(Position position, Movement movement) {
		switch (movement.getDirection()) {
			case N:
				return move(new Position(position.getX(), position.getY()),
							new Movement(Direction.E, movement.getInstructions().substring(1)));
			case W:
				return move(new Position(position.getX(), position.getY()),
							new Movement(Direction.N, movement.getInstructions().substring(1)));
			case S:
				return move(new Position(position.getX(), position.getY()),
							new Movement(Direction.W, movement.getInstructions().substring(1)));
			case E:
				return move(new Position(position.getX(), position.getY()),
							new Movement(Direction.S,
										 movement.getInstructions()
											 .substring(1)));
			default:
				throw new IllegalStateException("Unexpected value: " + movement.getDirection());
		}

    }

    private static String turnLeft(Position position, Movement movement) {
		switch (movement.getDirection()) {
			case N:
				return move(new Position(position.getX(), position.getY()),
							new Movement(Direction.W,
										 movement.getInstructions()
											 .substring(1)));
			case W:
				return move(new Position(position.getX(), position.getY()),
							new Movement(Direction.S,
										 movement.getInstructions()
											 .substring(1)));
			case S:
				return move(new Position(position.getX(), position.getY()),
							new Movement(Direction.E,
										 movement.getInstructions()
											 .substring(1)));
			case E:
				return move(new Position(position.getX(), position.getY()),
							new Movement(Direction.N,
										 movement.getInstructions()
											 .substring(1)));
			default:
				throw new IllegalStateException("Unexpected value: " + movement.getDirection());
		}

    }
}
