
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
	
	public void ingresarAuto(Auto auto,GUI context){
		if(Estacionamiento.getSize()==6)
		{
			if(Espera.cantidad()==2){
				System.out.println("No hay Lugar");
			}
			else 
			{
				context.addEspera(getPosEsp(), auto.color);
				Espera.encolar(auto);
				recaudacion+=5;
			}
		}	
		else{
			context.addEstAutos(getPosEst()+1, auto.color);
			Estacionamiento.apilar(auto);
			recaudacion+=5;
		}
	}
	public int getPosEst(){
		return Estacionamiento.getSize()-1;
	}
	public int getPosEsp(){
		return Espera.cantidad();
	}
	public int getPosAux(){
		return aux.getSize();
	}
	public void sacarAuto(String patente, GUI carlos){
		if(!Estacionamiento.esVacia()){
			for(int i=Estacionamiento.getSize();i>0;i--){
				Auto pirulo= (Auto)Estacionamiento.verTope();
				if(pirulo.getPatente().compareTo(patente)==0)
				{
					carlos.addEstAutos(i-1,-1);
					Estacionamiento.desapilar();
					break;
				}
				else{
					carlos.addAux(getPosAux(),pirulo.color);
					aux.apilar(pirulo);
					Estacionamiento.desapilar();
					carlos.addEstAutos(i - 1, -1);
				}
			}
			
			while(!aux.esVacia()){
				Auto pepe = (Auto)aux.verTope();
				carlos.addEstAutos(getPosEst()+1,pepe.color);
				Estacionamiento.apilar(aux.verTope());
				aux.desapilar();
				carlos.addAux(getPosAux(),-1);
			}
			
			if(!Espera.esVacia()){
				Auto pepe = (Auto)Espera.verFrente();
				Estacionamiento.apilar(Espera.verFrente());
				Espera.desencolar();
				if(getPosEsp()==1) {
					carlos.addEspera(1,-1);
					Auto p = (Auto)Espera.verFrente();
					carlos.addEspera(0,p.color);
				}
				else{
					carlos.addEspera(0,-1);
				}
				carlos.addEstAutos(getPosEst(), pepe.color);
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
