public class FutureTuitionApplication {
	
	public static void main(String [] args){

		double currentTuition = 10000.0;
		int count = 1;

		while (count <= 10){
			currentTuition = currentTuition + (currentTuition * .05);

			count++;

		}

		System.out.println("The tuition in ten years will be " + currentTuition);
	}
}