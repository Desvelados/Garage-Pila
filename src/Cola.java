
public class Cola {

	private Object[] vec;
	private int frente,fondo,cant;
	
	public Cola(int n){
		vec= new Object[n];
		frente=0;
		fondo=-1;
		cant=0;
	}
	
	public void encolar (Object x){
		if(cant<vec.length){
			if(fondo==vec.length-1){
				fondo=0;
			}
			else{
				fondo++;
			}
			vec[fondo]=x;
			cant++;
		}
	}
	
	public void desencolar(){
		if(cant>0){
			if(frente==vec.length-1){
				frente=0;
			}
			else{
				frente++;
			}
			cant--;
		}
	}
	
	public boolean esVacia(){
		return cant==0;
	}
	
	public int cantidad(){
		return cant;
	}
	
	public Object verFrente(){
		return vec[frente];
	}
}
