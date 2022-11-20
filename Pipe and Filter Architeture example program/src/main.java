public class main {
    public static void main(String[] args) {

        Pipeline pipeline = new Pipeline(new Pump(0,1), 
         new CircularLeftShift(1,1),
         new Sort(1,1) ,new Sink(1,0));
        pipeline.run();

       
    }

}

//https://slidetodoc.com/software-design-and-architecture-theoretical-principles-and-design/