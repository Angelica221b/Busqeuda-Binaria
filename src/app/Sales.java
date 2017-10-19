package app;

import java.util.Comparator;


public class Sales implements Comparable<Sales>,Comparator<Sales> {
	private int dia;
	private double venta;
	private int mes;
	public Sales(){
		this (1,0.0d,1);
		
	}
	public Sales(int dia, double venta, int mes) {
		this.dia = dia;
		this.venta = venta;
		this.mes = mes;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public double getVenta() {
		return venta;
	}
	public void setVenta(double venta) {
		this.venta = venta;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Día: "+this.dia+" Mes: "+this.mes+" Venta: "+this.venta;
	}
	@Override
	public int compare(Sales o1, Sales o2) {
		// TODO Auto-generated method stub
		return o1.compareTo(o2);
	}
	@Override
	public int compareTo(Sales o) {
		// TODO Auto-generated method stub
		if(this.venta==o.getVenta())
			return 0;
		else
		return this.venta>o.getVenta()?1:-1;
	}
	
}