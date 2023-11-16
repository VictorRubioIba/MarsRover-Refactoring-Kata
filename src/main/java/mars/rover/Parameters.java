package mars.rover;
public class Parameters
{	private final Direction direction;
	private final String instructions;
	public Parameters( Direction direction,  String instructions)
	{
		this.direction = direction;
		this.instructions = instructions;
	}
public Direction   getDirection() {
  return direction;
}public String   getInstructions() {
  return instructions;
}}
