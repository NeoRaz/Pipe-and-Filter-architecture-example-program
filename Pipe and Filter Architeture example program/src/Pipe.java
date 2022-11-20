import java.io.EOFException;
import java.util.LinkedList;


public class Pipe{

    // this linked list is the stream of data in the pipe
    private LinkedList<String> stream;
    // a boolean to check whether the pipe is closed or not
    private boolean closed;
    // pipe constructor
    public Pipe(){
        // declare the stream
        stream = new LinkedList<String>();
        // open the pipe
        closed = false;
    }

    // write a string to the pipe
    public void write(String s){
        // if pipe is closed throw and exception
        if(closed){
            throw new IllegalStateException("Pipe is closed");
        }
        // to write into a pipe we will add the input to the stream linkecList
        stream.add(s);
    }

    // Read from the Pipe.
    public String read() throws EOFException{
        // error checking to see if pipe is empty.. this indicates that when reading from a pipe we will contiously do so untill it is closed or
        // an error pops up else we will continue reading every 10 milisecond
        while(true){
            if(stream.size() == 0){
                if(closed){
                    throw new EOFException("Pipe is closed");
                }
                try{
                    Thread.sleep(10);
                }catch(InterruptedException e){
                    System.err.println("Interrupted Excpetion caught in Pipe");
                }
            }else{
                // return the waiting item from the queue and remove it from the queue as well (FIFO)
                return stream.pop();
            }
        }
    }
    // function to get the number of elements in the pipe at a point in time
    public int size(){
        return stream.size();
    }

    // Close the pipe.
    public void close(){
        closed = true;
    }
}