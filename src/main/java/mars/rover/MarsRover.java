package mars.rover;

import static mars.rover.Direction.N;

public class MarsRover {

  public static String move(Position position, Parameters parameters) {
    if (!parameters.getInstructions()
		.isEmpty()) {
      char instruction = parameters.getInstructions()
		  .charAt(0);
      if (instruction == 'L') {
        return turnLeft(position,
						new Parameters(parameters.getDirection(), parameters.getInstructions()));
      } else if (instruction == 'R') {
        return turnRight(position,
						 new Parameters(parameters.getDirection(), parameters.getInstructions()));
      } else if (instruction == 'M') {
        return  goFront(position,
						new Parameters(parameters.getDirection(), parameters.getInstructions()));
      }
    }
    return position.getX() + " " + position.getY() + " " + parameters.getDirection();
  }

  private static String goFront(Position position, Parameters parameters) {
    return switch (parameters.getDirection()) {
      case N -> move(
		  new Position(position.getX(), position.getY() + 1),
		  new Parameters(Direction.N, getInstructions(parameters.getInstructions())));
      case S -> move(
            new Position(position.getX(), position.getY() - 1),
			new Parameters(Direction.S, getInstructions(parameters.getInstructions())));
      case W -> move(
            new Position(position.getX() - 1, position.getY()),
			new Parameters(Direction.W, getInstructions(parameters.getInstructions())));
	  default -> move(
            new Position(position.getX() + 1, position.getY()),
			new Parameters(Direction.E, getInstructions(parameters.getInstructions())));
    };
  }

  private static String turnRight(Position position, Parameters parameters) {
    return switch (parameters.getDirection()) {
      case N -> move(goNewPosition(position),
					 new Parameters(Direction.E, getInstructions(parameters.getInstructions())));
      case W ->move(goNewPosition(position), new Parameters(N, getInstructions(
		  parameters.getInstructions())));
      case S -> move(goNewPosition(position),
					 new Parameters(Direction.W, getInstructions(parameters.getInstructions())));
      default -> move(goNewPosition(position),
					  new Parameters(Direction.S, getInstructions(parameters.getInstructions())));
    };

  }

  private static String turnLeft(Position position, Parameters parameters) {
    return switch (parameters.getDirection()) {
      case N -> move(goNewPosition(position),
					 new Parameters(Direction.W, getInstructions(parameters.getInstructions())));
      case W -> move(goNewPosition(position),
					 new Parameters(Direction.S, getInstructions(parameters.getInstructions())));
      case S -> move(goNewPosition(position),
					 new Parameters(Direction.E, getInstructions(parameters.getInstructions())));
      default -> move(goNewPosition(position), new Parameters(N, getInstructions(
		  parameters.getInstructions())));
    };
  }

  private static Position goNewPosition(Position position) {
    return new Position(position.getX(), position.getY());
  }

  private static String getInstructions(String instructions) {
    return instructions.substring(1, instructions.length());
  }
}
