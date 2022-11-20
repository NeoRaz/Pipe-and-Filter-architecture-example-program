import java.io.EOFException;

public class Sink extends Filter{
    // constructor for Sink
    public Sink(int numOFIns, int numOFOut) {
        super(numOFIns, numOFOut);
    }
    // run function for sink
    @Override
    public void run() {
        // while true means it is running constantly
        while(true){
            try{
                
                System.out.println();
                //print the read result from the specified incoming pipe
                System.out.println(read(0).trim());
                
            }catch(EOFException e){
                break;
            }
        }
    }
}
