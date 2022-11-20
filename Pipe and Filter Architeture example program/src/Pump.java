import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pump extends Filter{
    // buffer reader to read the input from the user
    private BufferedReader reader;
    // constructor for Pump
    public Pump(int numOFIns, int numOFOut) {
        super(numOFIns, numOFOut);
        // making a new buffer reader
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    // run function for Pump
    @Override
    public void run() {
        try {
            // while true means that in never ends because it is always true
            while(true) {
                // read the line
                String s = reader.readLine();
                if(s == null) {
                    write(null, 0);
                    break;
                }
                // we would write to the chosen pipe this should be synced with pipe line and inside main function
                write(s + "\n",0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
