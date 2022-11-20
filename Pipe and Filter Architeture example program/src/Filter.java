import java.io.EOFException;


public abstract class Filter implements Runnable {



    // The input pipe.
    protected Pipe[] ins;
    // The output pipe.
    protected Pipe[] outs;
    // constructor for creating a filter
    public Filter(int numOFIns, int numOFOut) {
        // number of incoming pipes to the filter
        ins = new Pipe[numOFIns];
        // number of out going pipes from the filter
        outs = new Pipe[numOFOut];
    }
    // Set the input pipe.
    public void setIn(Pipe input, int pos) {
        this.ins[pos] = input;
    }
    // Set the output pipe.
    public void setOut(Pipe output, int pos) {
        this.outs[pos] = output;
    }
    // Write a string to the output pipe.
    public void write(String s, int whichPipe) {
        // if the incoming string is null we will close the pipe carrying the data
        if(s==null) {
            outs[whichPipe].close();
            return;
        }
        // writing into to the outgoing selected pipe
        outs[whichPipe].write(s);
    }

    // Read from the input pipe.
    public String read(int whichPipe) throws EOFException {
        //use the read function from the pipe class
        return ins[whichPipe].read();
    }


    @Override
    public void run() {
        // TODO Auto-generated method stub
    }
    
}
