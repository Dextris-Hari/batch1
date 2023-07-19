package ballcom.xworkz.ball;

public class Ball {

	private String name;
	private String brand;

	public Ball(String name, String brand) {
		super();
		this.name = name;
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Ball [name=" + name + ", brand=" + brand + "]";
	}

}
