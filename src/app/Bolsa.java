package app;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Bolsa<T extends Comparable<T>> implements Iterable<T> {
	private  T[] data;
	private Class<T> type = null;
	private int counter = 0;
	
	public T[] getData() {
		return data;
	}

	public void setData(T[] data) {
		this.data = data;
	}

	public Class<T> getType() {
		return type;
	}

	public void setType(Class<T> type) {
		this.type = type;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public Bolsa(Class<T> type) {
		// TODO Auto-generated constructor stub
		data = (T[]) Array.newInstance(type, 10);
		this.type = type;
	}

	public Bolsa(Class<T> type, int size) {
		data = (T[]) Array.newInstance(type, size);
		this.type = type;
	}

	public boolean add(T value) {
		if (counter < data.length) {
			data[counter++] = value;
			return true;
		} else
			return false;
	}

	public void printer() {
		for (int i = 0; i < counter; i++) {
			System.out.println(data[i].toString());
		}
	}
	
//////HeapSort ///////////////////////////

	public Bolsa<T> heapSort(T[] array){
		int length = array.length;
		Bolsa<T> newbag = new Bolsa<>(type,array.length);
		
		buildMaxHeap(array, length);
		for(int i= length -1; i>0; i--){
			T temp = array[0];
			array[0]=array[i];
			array[i]=temp;
			maxHeapify(array,1,i);
		}
		for(T comp : array){
			newbag.add(comp);
		}
		return newbag;
	}
	
	private void buildMaxHeap(T[] array, int heapSize){
		if(array == null){
			throw new NullPointerException("null");
		}
		if(array.length<=0 || heapSize <=0){
			throw new IllegalArgumentException("illegal");
		}
		if(heapSize > array.length){
			heapSize= array.length;
		}

		for(int i=heapSize/2; i>0; i--){
			maxHeapify(array, i, heapSize);
		}
	}
	private void maxHeapify(T[] array, int index, int heapSize){
		int l=index*2;
		int r = l +1;
		int largest;
		
		if (l<= heapSize && array[l-1].compareTo(array[index -1])==1) {
			largest = l;
		}else{
			largest=index;
		}
		
		if (r <= heapSize && array[r - 1].compareTo(array[largest - 1])==1) {
			largest=r;
		}
		if (largest != index) {
			T temp=array[index - 1];
			array[index - 1]=array[largest - 1];
			array[largest - 1] = temp;
			maxHeapify(array, largest, heapSize);
		}
	}
	
	//////////////Fin HeapSort/////////////////////////
	
	
	
	
	//Busqueda binaria
public T binarySearch(T toSearch){
		
		heapSort(data);
		return binarySearch(data, toSearch);
	}
	
	public T binarySearch(T[]sorted,T tosearch)
	{
		
		  int centro,sup=0,inf=sorted.length-1;
		   while(sup<=inf){
		     centro=(sup+inf)/2;
		     if(sorted[centro].compareTo(tosearch)==0)
		     {
		    	 return sorted[centro];
		    	 
		     }
		     else if(tosearch.compareTo(sorted [centro])==-1  ){
		        sup=centro-1;
		     }
		     else {
		       inf=centro+1;
		     }
		   }
		     
		return null;
	}
	///////////////////////////////////
	
	@Override
	public Iterator<T> iterator() {

		return new Iterator<T>() {
			int i=0;
			@Override
			public boolean hasNext() {

				return (i<counter);
			}
			@Override
			public T next() {
				
				return data[i++];
			}
		};
	}
}
