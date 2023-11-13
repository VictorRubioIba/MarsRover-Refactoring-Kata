package mars.rover;
public class Movement
{	private final Direction direction;
	private final String instructions;
	public Movement( Direction direction,  String instructions)
	{
		this.direction = direction;
		this.instructions = instructions;
	}
public Direction   getDirection() {
  return direction;
}public String   getInstructions() {
  return instructions;
}}
