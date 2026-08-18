package fruits;

public class Apple extends Fruit {

	  private String variety;

    public Apple(String variety) 
	{
		this.variety = variety;
    }

	
	@Override 
	public void taste() {
		System.out.println("sweet n sour in taste!");
	}

	public void jam() {
		System.out.println("Making Apple Jam");
	}
}
