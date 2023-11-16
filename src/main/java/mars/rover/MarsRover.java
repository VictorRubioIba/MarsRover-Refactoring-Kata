package mars.rover;
import static mars.rover.Direction.E;
import static mars.rover.Direction.N;
import static mars.rover.Direction.S;
import static mars.rover.Direction.W;


public class MarsRover {

  public static String move(Position position, Parameters parameters) {
    if (!parameters.getInstructions()
		.isEmpty()) {
      char instruction = parameters.getInstructions()
		  .charAt(0);
      if (instruction == 'L') {
        return turnLeft(position, getParameters(parameters));
      } else if (instruction == 'R') {
        return turnRight(position,
						 getParameters(parameters));
      } else if (instruction == 'M') {
        return  goFront(position,
						getParameters(parameters));
      }
    }
    return position.getX() + " " + position.getY() + " " + parameters.getDirection();
  }

	private static Parameters getParameters(Parameters parameters) {
		return new Parameters(parameters.getDirection(), parameters.getInstructions());
	}

	private static String goFront(Position position, Parameters parameters) {
    return switch (parameters.getDirection()) {
      case N -> move(moreOneInY(position),
		  new Parameters(N, getInstructions(parameters.getInstructions())));
      case S -> move(
		  lessOneInY(position),
			new Parameters(S, getInstructions(parameters.getInstructions())));
      case W -> move(
		  lessOneInX(position),
			new Parameters(W, getInstructions(parameters.getInstructions())));
	  default -> move(
		  moreOneInX(position),
			new Parameters(E, getInstructions(parameters.getInstructions())));
    };
  }
	private static String turnRight(Position position, Parameters parameters) {
		return switch (parameters.getDirection()) {
			case N -> move(goNewPosition(position), setParameters(E,parameters));
			case W ->move(goNewPosition(position), setParameters(N,parameters));
			case S -> move(goNewPosition(position), setParameters(W,parameters));
			default -> move(goNewPosition(position), setParameters(S,parameters));
		};

	}

	private static Parameters setParameters(Direction direction,Parameters parameters) {
		return new Parameters(direction, getInstructions(parameters.getInstructions()));
	}

	private static String turnLeft(Position position, Parameters parameters) {
		return switch (parameters.getDirection()) {
			case N -> move(goNewPosition(position), setParameters(W,parameters));
			case W -> move(goNewPosition(position), setParameters(S,parameters));
			case S -> move(goNewPosition(position), setParameters(E,parameters));
			default -> move(goNewPosition(position), setParameters(N,parameters));
		};
	}
	private static Position moreOneInX(Position position) {
		return new Position(position.getX() + 1, position.getY());
	}

	private static Position lessOneInX(Position position) {
		return new Position(position.getX() - 1, position.getY());
	}

	private static Position lessOneInY(Position position) {
		return new Position(position.getX(), position.getY() - 1);
	}

	private static Position moreOneInY(Position position) {
		return new Position(position.getX(), position.getY() + 1);
	}

  private static Position goNewPosition(Position position) {
    return new Position(position.getX(), position.getY());
  }

  private static String getInstructions(String instructions) {
    return instructions.substring(1, instructions.length());
  }
}
