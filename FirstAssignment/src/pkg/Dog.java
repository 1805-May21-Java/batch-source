package pkg;

public class Dog extends Animal {
	private String furColor;

	Dog() {
		super();
	}

	Dog(String furColor) {
		super(4);
		this.furColor = furColor;
	}

	public String getFurColor() {
		return furColor;
	}

	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}
}
