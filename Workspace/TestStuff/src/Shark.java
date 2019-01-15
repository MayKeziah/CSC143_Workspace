public class Shark extends Critter{
	private Direction direction;
	private int stepsToTake;
	
	public Shark() {
		direction = Direction.NORTH;
		stepsToTake = 1;
	}
    public Direction getMove() {
    	stepsToTake++;
    	if (direction == Direction.NORTH) {
    		direction = Direction.SOUTH;
    	}
    	else if (direction == Direction.SOUTH) {
    		direction = Direction.NORTH;
    	}
    	return direction;
    }
	
    public boolean eat(){
    
    }
    public Attack fight(String opponent){
        
    }

}