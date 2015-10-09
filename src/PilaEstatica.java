
public class PilaEstatica implements InterfacePila {

	public Object[] vec;
	public int tope;
	
	public PilaEstatica(int n){
		if(n<10)
			n=10;
		
		vec = new Object[n];
		tope=-1;
	}
	
	public PilaEstatica(){
		this(10);
	}
	
	@Override
	public void apilar(Object x) {
		/*if(tope==vec.length-1){
			Object aux[]= new Object[2*vec.length];
			for(int i=0;i<=tope;i++)
			{
				aux[i]=vec[i];
			}
			vec=aux;
		}*/
		tope++;
		vec[tope] = x;
	}

	@Override
	public void desapilar() {
		tope--;
	}

	@Override
	public Object verTope() {
		return vec[tope];
	}

	@Override
	public boolean esVacia() {
		return tope==-1;
	}

	@Override
	public int getSize() {
		return tope+1;
	}

	@Override
	public String toString()
	{
		return ("Este objeto pila tiene:\n "+vec[2]+" (Tope)\n"+" "+vec[1]+"\n"+" "+vec[0]+"\n");
	}
}
