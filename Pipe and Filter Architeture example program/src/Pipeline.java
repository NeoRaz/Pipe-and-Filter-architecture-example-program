public class Pipeline implements Runnable{
    // pipe line consists of filters, these filters need to be connect in some manner
    // we use the in and out pipe or pipes from each filter to connect them to the adjacent filters
    private Filter[] filters;

    // pipeline constructor
    public Pipeline(Filter ... filters) {
        this.filters = filters;

        // the following code can differ from system to system using pipe and filter architecture
        // its just like how pipes and filters are connect to each other in real life
        // since in this simulation there is only 1 pipe in and 1 pipe out of each filter the flow remains the same

        for(int i=0;i<filters.length-1;i++) {
            // for pump
            if(filters[i] instanceof Pump) {
                Pipe pipe = new Pipe();
                filters[i].setOut(pipe, 0);
                filters[i+1].setIn(pipe, 0);
            }
            // for circular shift
            else if(filters[i] instanceof CircularLeftShift) {
                Pipe pipe = new Pipe();
                    filters[i].setOut(pipe, 0);
                    filters[i+1].setIn(pipe, 0); 
            }
            // for sort
            else if(filters[i] instanceof Sort) {
                Pipe pipe = new Pipe();
                filters[i].setOut(pipe, 0);
                // this will indicate the in pipe for filter sink
                filters[i+1].setIn(pipe, 0);
            }
            
        }
        // there is no out pipe for sink because we will print it directly from the filter

    }

    // runnable interface will help us trigger the run function for each filter
    @Override
    public void run() {
        for(Filter filter : filters) {
            // we are creating separate threads for each filter
            // this indicates that filter are active at the same time.
            Thread thread = new Thread(filter);
            thread.start();
        }
        
    }
    
}
