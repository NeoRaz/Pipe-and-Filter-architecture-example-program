import java.io.EOFException;

public class CircularLeftShift extends Filter {
	// constructor for CircularLeftShift
    public CircularLeftShift(int numOFIns, int numOFOut) {
		super(numOFIns, numOFOut);
		
	}
	// run function for CircularLeftShift
	@Override
	public void run() {
		// while true indicated consistent running 
		while (true) {
			try {
				// read from the pipe selected and store it
				String s = read(0);
				// split the result into words
				String words[] = s.split("\\s");
				// create sentences based on the order in the array
				for(int i = 0; i < words.length; i++) {
	
                    String toWrite = "";
					for(int j = 0; j < words.length; j++) {
						toWrite+=words[j] + " ";
					}
					toWrite+="\n";
					// circular shift the arry in order to be able to create new order for the next loop
					shiftLeft(words);
					write(toWrite,0);
				}

			} catch (EOFException e) {
				break;
			}
		}
	}
	// A function for shifting an array to left
    private void shiftLeft(String[] array) {
		// store the first element
		String temp = array[0];
		int i;
		// loop through the array
		for (i = 0; i < array.length - 1; i++)
			array[i] = array[i + 1]; // shift the position of each element to left
		array[i] = temp;// put the first element in the last index
	}
}

