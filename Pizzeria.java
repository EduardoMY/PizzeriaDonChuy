import java.io.*;
import java.util.*;
import java.util.Scanner;

class Pizza{
    
    public Pizza(){
	    
    }
}
class QuesoPizza extends Pizza{
    public QuesoPizza(){
    }
}
class PeperoniPizza extends Pizza{
    public PeperoniPizza(){
    }
}
class CarnivoraPizza extends Pizza{
    public CarnivoraPizza(){
    }
}
class PortebelloPizza extends Pizza{
    public PortebelloPizza(){
    }
}

class Orden{
    private int amountOfSodas;
    private int amountOfSalads;
    private int costOfSoda;
    private int costOfSalad;
    
    public Orden(){
	costOfSoda=15;
	costOfSalad=30;
    }
    public void addNewPizza(){
    }
    public void setAmountOfSodas(int amount){
	amountOfSodas=amount;
    }
    public void setAmountOfSalads(int amount){
	amountOfSalads=amount;
    }
    
}
class Fw{//Flyweight
    
}
class Iterator{
    
}
class Builder{
    private Orden nuevaOrden;
    
    private Builder(){
	nuevaOrden=new Orden();
    }
       
    public void addPizza(int amount, String type){
	
    }
    
    public void addSodas(int amount){
	nuevaOrden.setAmountOfSodas(amount);
    }
    
    public void addSalads(int amount){
	nuevaOrden.setAmountOfSodas(amount);
    }
    
    public Orden getOrden(){
	return nuevaOrden;
    }
}


public class Pizzeria
{
    
    public static void main(String[] args) throws IOException {
    
		Scanner in=new Scanner(System.in);
		int option;
		do
		{
			System.out.print("Bienvenidos a pizzeria Don Chuy\n");
			
			System.out.print("1) Ordenar una pizza\n");
			System.out.print("2) Ordenar una soda\n");
			System.out.print("3) Ordenar una ensalada\n");
			System.out.print("4) Total del pedido\n");
			System.out.print("5)Salir\n");
			System.out.print("Seleccione una opción\n");
			option=in.nextInt();
		
			switch(option)
			{
			case 1:
					//pizza();
			break;

			case 2:
				int getnum;
				System.out.println("Cuantas sodas quiere?");
				getnum=in.nextInt();
				soda(getnum);
				
					//soda();
			break;
			case 3:
					//ensalada();
			break;
			case 4:
					
					//total(costosoda,costoensalada,costopizza);
			break;
			}

		  }while(option!=5);
    }
	
	public static int total(int costosoda,int costoensalada,int costopizza)
	{
		int suma=costosoda+costoensalada+costopizza;
		return suma;
	   }
	public static int soda(int sodas)
	{
		int sodaprice=20;
		int sodatotal=0;
		sodatotal=sodas*sodaprice;
		System.out.print("Total soda\n"+sodatotal);
		return sodatotal;
		//builder.addSoda();
	}
}
