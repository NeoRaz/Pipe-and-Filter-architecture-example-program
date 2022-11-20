import java.io.EOFException;
import java.util.ArrayList;

public class Sort extends Filter{
    // a list to sort
    private ArrayList<String> list;
    // constructor for Sort
	public Sort(int numOFIns, int numOFOut) {
        super(numOFIns, numOFOut);
        // creating a new array list
		list = new ArrayList<String>();
	}
	// run function for Sort
	@Override
	public void run() {
        // this time around we are using a boolean in order to break out of the while loop
        // this is because we need all the elements first and then sort so we cannot continue reading
        boolean turn = true;
            while(turn) {
                try {
                    // read from the respective pipe
                    String s = read(0);
                    // add to the list
                    list.add(s);
                    // check the size of the pipe if its 0 then break out
                    if(this.ins[0].size() == 0) 
                        turn = false;
                } catch(EOFException e) {
                    break;
                }
            }
            
            try{
                // when done readnig sort the list
                ArrayList<String> res =  sortList(list);
                // when sorted write each element 1 by 1
                while(res.size() != 0){
                    write(res.get(0) + "\n",0);
                    // remove the written element from the list
                    res.remove(0);
                    // extera code for showing pipe and filter architecture
                    Thread.sleep(1000);
	            } 
            }catch(InterruptedException e){
                System.out.println(e.getStackTrace());
            }
            
    }
    // sort function
    public ArrayList<String> sortList(ArrayList<String> list){
        System.out.println("---------------------");
        System.out.println();
        // create a result array list
        ArrayList<String> res = new ArrayList<>();
        // loop through the elements of the parameter given- this gives us the number of results
        for(int i=0;i<list.size();i++){
            //store the current element
            String temp = list.get(i);
            // check the following elements
            for(int j=1;j<list.size();j++){
                // if the following element comes before the current element change the indexes
                if(list.get(j).compareToIgnoreCase(temp) < 0){
                    temp = list.get(j);
                }
            }
            // the code above will get element that comes before everything else
            // add that element to result
            res.add(temp);
            // remove that element from the parameter
            list.remove(temp);
            // decrease the number of i because an element has been removed
            i--;
        }
        return res;
    }

    
                
}
