package fda;
import java.util.*;
import dataStructures.ArrayLinearList;
public class MyArrayLinearList extends ArrayLinearList {
	public MyArrayLinearList(int initialCapacity) {
		super(initialCapacity);
	}
     public MyArrayLinearList() {
    	 super(10);
     }
     public MyArrayLinearList(MyArrayLinearList mylist) {
    	 super(mylist.size());
    	 for(int i=0 ; i<mylist.size() ; i++)
    		 this.add(i, mylist.element[i]);
     }
     public MyArrayLinearList reverse() {
    	 MyArrayLinearList temp= new MyArrayLinearList(this.size());
    	 int j=0; 
    	 for( int i= this.size()-1 ; i>=0 ; i--)
    		 temp.add(j++, this.element[i]);
    	 return temp;
     } 
     public MyArrayLinearList unique()
     {
    	 MyArrayLinearList temp = new MyArrayLinearList(this);
    	 MyArrayLinearList temp1 = new MyArrayLinearList();
    	 Arrays.sort(temp.element);     
    	 int j=0;
    	 for(int i=0 ; i<temp.size()-1 ; i++) {
    		 if(temp.element[i] != temp.element[i+1]) {
    			 temp1.add(j++, temp.element[i]);
    		 }
    	 }
    	 temp1.add(j++, temp.element[temp.size()-1]);
    	 return temp1;
    	 }
     public MyArrayLinearList rand()
     {
    	 int rkey;
    	 MyArrayLinearList copylist= new MyArrayLinearList(this);
    	 MyArrayLinearList temp = new MyArrayLinearList();
    	 Random rd = new Random();
    	 while(!copylist.isEmpty()) {
    		 rkey=rd.nextInt(copylist.size());
    		 temp.add(0, copylist.element[rkey]);
    		 copylist.remove(rkey);
    	 } 
    	 return temp;
     }
     public MyArrayLinearList merge(MyArrayLinearList arrayList) {
    	 MyArrayLinearList temp= new MyArrayLinearList(this);
    	 for(int i=0 ; i<arrayList.size(); i++)
    		 temp.add(temp.size(), arrayList.element[i]);
    	 return temp;
     }
     public int Max()
     {
    	 int m = (int)this.get(0);
    	 for( int i=0 ; i<this.size() ; i++)
    		 if(m< (int)this.get(i))
    	           m=(int)this.get(i);
    	           return m;
     }
     public int Min()
     {
    	 int m = (int)this.get(0);
    	 for( int i=0 ; i<this.size() ; i++)
    		 if(m> (int)this.get(i))
    	           m=(int)this.get(i);
    	           return m;
     }
     public int sum()
     {
    	int j=0;
    	for(int i=0 ; i<this.size() ; i++)
    		j=j+(int)this.get(i);
    	return j;
     }
     public double average()
     {
    	 int j=0;
     	for(int i=0 ; i<this.size() ; i++)
     		j=j+(int)this.get(i);
     	double d=(double)j/size();
     	return d;
    	 
     }
     public void removeOdd()
     {
    	 for( int i=0 ; i<this.size() ; i++)
    	 {
    		 int d= (int)this.get(i);
    	 if(d% 2 == 1) 
    	 {
    		remove(i);
    		i--;
    	 }
         }
     }
     public void Sort()
     {
    	 Arrays.sort(this.element);
     }
     
}    
