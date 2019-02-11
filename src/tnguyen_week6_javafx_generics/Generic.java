package tnguyen_week6_javafx_generics;

/** 
 * @Course: SDEV 250 ~ Java Programming I
 * @Author Name: Trinh Nguyen
 * @Assignment Name: 
 * @Date: Oct 14, 2018
 * @Subclass Generic Description: generic class for a special type
 */ 
//Imports
import java.util.ArrayList;
//Begin Subclass Generic

public class Generic<Trinh> {
    
    ArrayList<Trinh> list = new ArrayList<>();
    int size;
    
    /**
     * get object at index value
     * @param i
     * @return 
     */
    public Trinh get(int i){
        return list.get(i);
    }
    
    /**
     * return the size of the list
     * @return 
     */
    public int getSize(){
        return list.size();
    }
    
    /**
     * add to the list 
     * @param T 
     */
    public void Add(Trinh T){
        list.add(T);
    }
    
    /**
     * remove item from list
     * @return 
     */
    public Trinh Remove(){
        return list.remove(getSize()-1);
    }
    
    /**
     * clear the whole list
     */
    public void Clear(){
        list.clear();
    }

} //End Subclass Generic 