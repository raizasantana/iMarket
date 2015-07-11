package model;

public class TipoInteira extends Tipo{
 @Override
public double calcularPreco(Tipo t) {
	 System.out.println("Inteira");
	 return this.setPreco(10.6);
	 
}
}
