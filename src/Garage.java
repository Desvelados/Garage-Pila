
public class Garage {
	
	private PilaEstatica Estacionamiento; 
	private PilaEstatica aux;
	private Cola Espera;
	private double recaudacion=0.0;
	
	public Garage(){
		Estacionamiento= new PilaEstatica(6);
		aux=new PilaEstatica(5);
		Espera=new Cola(2);
	}
	
	public void ingresarAuto(Auto auto){
		if(Estacionamiento.getSize()==6)
		{
			if(Espera.cantidad()==2){
				System.out.println("No hay Lugar");
			}
			else 
			{
				Espera.encolar(auto);
				recaudacion+=5;
			}
		}	
		else{
			Estacionamiento.apilar(auto);
			recaudacion+=5;
		}
	}
	
	public void sacarAuto(String patente){
		if(!Estacionamiento.esVacia()){
			for(int i=Estacionamiento.getSize();i>0;i--){
				Auto pirulo= (Auto)Estacionamiento.verTope();
				if(pirulo.getPatente().compareTo(patente)==0)
				{
					Estacionamiento.desapilar();
					break;
				}
				else{
					aux.apilar(pirulo);
					Estacionamiento.desapilar();
				}
			}
			
			while(!aux.esVacia()){
				Estacionamiento.apilar(aux.verTope());
				aux.desapilar();
			}
			
			if(!Espera.esVacia()){
				Estacionamiento.apilar(Espera.verFrente());
				Espera.desencolar();
			}
		}
	}
	
	public double dineroRecaudado(){
		return recaudacion;
	}
	
	public int cantidadAutos(){
		return Estacionamiento.getSize()+Espera.cantidad();
	}
}
