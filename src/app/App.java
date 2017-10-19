package app;



import java.util.Random;

import app.Bolsa;
import app.Sales;

public class App {
	Random r= new Random();
	public static void main(String[] args) {
	
	Bolsa<Sales> venta = new Bolsa<Sales>(Sales.class,12);
		
	
	for (int i = 0; i < venta.getData().length; i++) {
		venta.getData()[i]=new Sales(i+1,i+10*10+.87,i+1);	
	}
	
	venta.heapSort(venta.getData());
	for(Sales ven:venta.getData()){
		System.out.println(ven);
		
	}
	
	System.out.println("");
	
	//Venta a buscar
	System.out.println("Venta buscada: "+venta.binarySearch(new Sales(0,105.87,0)));
		
	}
	
}
