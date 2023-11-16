package mars.rover;

import static mars.rover.Direction.N;

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
    return switch (direction1) {
      case N -> move(
		  new Position(position.getX(), position.getY() + 1),
		  Direction.N, getInstructions(instructions));
      case S -> move(
            new Position(position.getX(), position.getY() - 1),
            Direction.S,
            getInstructions(instructions));
      case W -> move(
            new Position(position.getX() - 1, position.getY()),
            Direction.W,
            getInstructions(instructions));
	  default -> move(
            new Position(position.getX() + 1, position.getY()),
            Direction.E,
            getInstructions(instructions));
    };
  }

  private static String turnRight(Position position, Direction direction1, String instructions) {
    return switch (direction1) {
      case N -> move(goNewPosition(position), Direction.E, getInstructions(instructions));
      case W ->move(goNewPosition(position), N, getInstructions(instructions));
      case S -> move(goNewPosition(position), Direction.W, getInstructions(instructions));
      default -> move(goNewPosition(position), Direction.S, getInstructions(instructions));
    };

  }

  private static String turnLeft(Position position, Direction direction1, String instructions) {
    return switch (direction1) {
      case N -> move(goNewPosition(position), Direction.W, getInstructions(instructions));
      case W -> move(goNewPosition(position), Direction.S, getInstructions(instructions));
      case S -> move(goNewPosition(position), Direction.E, getInstructions(instructions));
      default -> move(goNewPosition(position), N, getInstructions(instructions));
    };
  }

  private static Position goNewPosition(Position position) {
    return new Position(position.getX(), position.getY());
  }

  private static String getInstructions(String instructions) {
    return instructions.substring(1, instructions.length());
  }
}
