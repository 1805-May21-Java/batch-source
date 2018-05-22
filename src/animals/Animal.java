package animals;

/*
 * Abraction:
 * Interface is implemented by the Mammal class.
 * Provides method declarations for some basic animal actions.
 * 
 */
public interface Animal{
	
	//These methods are implicitly abstract
	public void eatNow();
	
	public void walkFaster(int increment);
}