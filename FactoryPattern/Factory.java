public class Factory {

	public static Cars getCar(String carName) {
		Cars car = null;

		if (carName.equalsIgnoreCase("maruthi")) {
			car = new Maruthi();
		} else if (carName.equalsIgnoreCase("benz")) {
			car = new Benz();
		}

		return car;
	}
}