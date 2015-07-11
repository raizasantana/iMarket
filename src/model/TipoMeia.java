package model;

public class TipoMeia extends Tipo{
	@Override
	public double calcularPreco(Tipo t) {
	
		 System.out.println("Meia");
		return this.setPreco(5.30);
		
	 }
}
