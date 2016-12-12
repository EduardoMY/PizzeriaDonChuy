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
    private int costOfSalad;
    
    public Orden(){
    }
    public void addNewPizza(){
    }
    public void setAmountOfSodas(int amount){
	amountOfSodas=amount;
    }
    public void setAmountOfSalads(int amount){
	amountOfSalads=amount;
    }
	public int costofsodas(int costOfSoda)
	{int totals=0;
		totals=amountOfSodas*costOfSoda;
		return totals;
    
	}
	public int costofsalads(int costOfSalad)
	{int totals2=0;
		totals2=amountOfSalads*costOfSalad;
		return totals2;

	}
}
class Fw{//Flyweight
    
}
class Iterator{
    
}
class Builder{
    private Orden nuevaOrden;
    
    public Builder(){
	nuevaOrden=new Orden();
    }
       
    public void addPizza(int amount, String type){
	
    }
    
    public void addSodas(int amount){
	nuevaOrden.setAmountOfSodas(amount);
    }
    
    public void addSalads(int amount){
	nuevaOrden.setAmountOfSalads(amount);
    }
    
    public Orden getOrden(){
	return nuevaOrden;
    }
}


public class Pizzeria
{
    public static Vector<Orden> ordenes;
	public static Builder bd;
	public static Orden ord;
    public static void main(String[] args) throws IOException {
		ordenes=new Vector();
		Scanner in=new Scanner(System.in);
		bd=new Builder();
		ord=new Orden();
		int option;
		do
		{
			System.out.print("Bienvenidos a pizzeria Don Chuy\n");
			
			System.out.print("1) Ordenar una pizza\n");
			System.out.print("2) Ordenar una soda\n");
			System.out.print("3) Ordenar una ensalada\n");
			System.out.print("4) Total del pedido\n");
			System.out.print("5) Reporte del dia\n");
			System.out.print("6)Salir\n");
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
				bd.addSodas(getnum);
				
					//soda();
			break;
			case 3:
				int getnumsalad;
				System.out.println("Cuantas ensaladas quiere?");
				getnumsalad=in.nextInt();
				bd.addSalads(getnumsalad);
					//ensalada();
			break;
			case 4:

					int totalsoda;int totalsalad;int totalgeneral=0;
					ordenes.add(bd.getOrden());
				totalsoda=ordenes.lastElement().costofsodas(20);
				System.out.print("Costo de las sodas:  " +ordenes.lastElement().costofsodas(20)+"\n");
					totalsalad=ordenes.lastElement().costofsalads(70);
				System.out.print("Costo de las ensaladas:  " +ordenes.lastElement().costofsalads(70)+"\n");
				
				totalgeneral=totalsoda+totalsalad;
				System.out.print("Total: " +totalgeneral+"\n");
					//total(costosoda,costoensalada,costopizza);
			break;
			
			case 5://reportes
			break;
			}

		  }while(option!=6);
    }
	
	
	
}
