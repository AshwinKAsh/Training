public class FactoryTester {

	public static void main(String[] args) {

		String carName = "benz";

		Cars car = Factory.getCar(carName);
		car.ride();
	}
}