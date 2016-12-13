
import java.io.*;
import java.util.*;
import java.util.Scanner;

class Pizza{
    Fw sizeAndPrice;
    public Pizza(Fw f){
	sizeAndPrice=f;
    }
    public int getCost(){
	return sizeAndPrice.cost;
    }
    public int getSize(){
	return sizeAndPrice.size;
    }
}
class QuesoPizza extends Pizza{
    public QuesoPizza(Fw f){
	super(f);
    }
}
class PeperoniPizza extends Pizza{
    public PeperoniPizza(Fw f){
	super(f);
    }
}
class CarnivoraPizza extends Pizza{
    public CarnivoraPizza(Fw f){
	super(f);
    }
}
class PortebelloPizza extends Pizza{
    public PortebelloPizza(Fw f){
	super(f);
    }
}

class Orden{
    private int amountOfSodas;
    private int amountOfSalads;
    private int costOfSalad;
    private Vector<Pizza> pizzas;
    private Vector amountOfPizzas;
    
    public Orden(){
	pizzas=new Vector<Pizza>();
	amountOfPizzas=new Vector();
    }
    public void addNewPizzas(Pizza p, short amount){
	pizzas.add(p);
	amountOfPizzas.add(amount);
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
	public int costofpizzas()
	{
	    int total=0;
	    for(int c=0; c<pizzas.size(); c++)
		total+= ((Pizza)pizzas.get(c)).getCost() * (short)amountOfPizzas.get(c);
	    return total;
	}
    public Vector<Pizza> getPizzas(){
	return pizzas;
    }
    public int getEnsaladas(){ return amountOfSalads;}
    
    public int getSodas(){ return amountOfSodas;}

    public short getAmountPizzas(int pos){ return (short) amountOfPizzas.get(pos);}
}
class Fw{//Flyweight
    public short size, cost;
    
    public Fw(short s, short c){size=s; cost=c;}
}

class Builder{
    private Orden nuevaOrden;
    
    public Builder(){
	nuevaOrden=new Orden();
    }
       
    public void addPizza(Pizza p, short amount){
	nuevaOrden.addNewPizzas(p, amount);
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
    private static HashMap<String ,Fw> FwMap = new HashMap();
    public static void main(String[] args) throws IOException {
		ordenes=new Vector();
		Scanner in=new Scanner(System.in);
		Scanner typeReader=new Scanner(System.in);
		bd=new Builder();
		ord=new Orden();
		int option;
		do
		{
			System.out.print("Bienvenidos a pizzeria Don Chuy\n");
			System.out.print("1) Ordenar una pizza\n");
			System.out.print("2) Ordenar una soda\n");
			System.out.print("3) Ordenar una ensalada\n");
			System.out.print("4) Total del pedido (Se tomara la orden al momento de seleccionar)\n");
			System.out.print("5) Reporte del dia\n");
			System.out.print("6) Salir\n");
			System.out.print("Seleccione una opción: ");			
			option=in.nextInt();
		
			switch(option)
			{
			case 1:
			    int getNumPizzas, getNumSizePizza;
			    String type;
			    Pizza p;
			    System.out.println("De que tipo de Pizza quieres?");
			     System.out.println("Portobello");
			     System.out.println("Queso");
			     System.out.println("Peperoni");
			     System.out.println("Carnivora");
			       System.out.println("Ingrese el tipo:\n");
			    
			    type=typeReader.nextLine();
			    System.out.println("De que tamanio la Pizza (10, 16, 20)?");
			    getNumSizePizza=in.nextInt();
			    System.out.println("Cuantas Pizzas quieres?");
			    getNumPizzas=in.nextInt();
			    p=FactoryBuilderPizza(type, (short) getNumSizePizza);
			    if(p!=null)
				bd.addPizza(p, (short) getNumPizzas);
			    System.out.println("Todo fine");
			break;

			case 2:
				int getnum;
				System.out.println("Cuantas sodas quiere?");
				getnum=in.nextInt();
				bd.addSodas(getnum);
				
			break;
			case 3:
				int getnumsalad;
				System.out.println("Cuantas ensaladas quiere?");
				getnumsalad=in.nextInt();
				bd.addSalads(getnumsalad);
			break;
			case 4:

			    int totalsoda, totalsalad, totalpizza, totalgeneral=0;
				ordenes.add(bd.getOrden());
				bd=new Builder();
				totalsoda=ordenes.lastElement().costofsodas(20);
				System.out.print("Costo de las sodas:  " +totalsoda+"\n");
				totalsalad=ordenes.lastElement().costofsalads(70);
				System.out.print("Costo de las ensaladas:  " +totalsalad+"\n");
				totalpizza=ordenes.lastElement().costofpizzas();
				System.out.print("Costo de las pizzas:  " +totalpizza+"\n");
				totalgeneral=totalsoda+totalsalad+totalpizza;
				System.out.print("Total: " +totalgeneral+"\n");
			break;
			
			case 5://reportes
			    if(ordenes.size()==0){
				System.out.println("No hay ordenes, favor de pasar a realizar una orden primero. ");
				break;
			    }
			    java.util.Iterator<Orden> it=ordenes.iterator();
			    System.out.println("Obteniendo reportes");
			    int cont=1;
			    Vector<Pizza> pi;
			    Orden or;
			    while(it.hasNext())
					{
					    or=it.next();
					    System.out.println("La orden N. "+cont+" contiene:");
					    System.out.println("Pizzas: ");
					    pi=or.getPizzas();
					    for(int c=0; c<pi.size(); c++)
						System.out.println("La pizza es de tipo: "+ pi.get(c).getClass()
								   +" .Con una cantidad de "+or.getAmountPizzas(c)
								   +" Y un precio de "+pi.get(c).getCost());
					    System.out.println("=====================================");
					    System.out.println("Cantidad de Sodas: "+or.getSodas());
					    System.out.println("Costo por Sodas: "+or.costofsodas(20));
					    System.out.println("=====================================");
					    System.out.println("Cantidad de Ensaladas: "+or.getEnsaladas());
					    System.out.println("Costo por Ensaladas: "+or.costofsalads(70));
					    System.out.println("=====================================\n\n");
					    
					    cont+=1;
					    
					   }					
			break;
			}

		  }while(option!=6);
    }
	
    public static Pizza FactoryBuilderPizza(String type, short size){
	Pizza nuevaPizza;
	Fw example=(Fw) FwMap.get(size+"");
	if(example == null){
	    example = new Fw(size ,(short) (size==10 ? 60 :(size==16? 80 : 120)));
	    FwMap.put(size+"", example);
	}
	if(type.equalsIgnoreCase("queso"))
	    nuevaPizza=new QuesoPizza(example);
	else if(type.equalsIgnoreCase("peperoni"))
	    nuevaPizza=new PeperoniPizza(example);
	else if(type.equalsIgnoreCase("carnivora"))
	    nuevaPizza=new CarnivoraPizza(example);
	else if(type.equalsIgnoreCase("portebello"))
	    nuevaPizza=new PortebelloPizza(example);
	else
	    nuevaPizza=null;
	return nuevaPizza;
    }
}
