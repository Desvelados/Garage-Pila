
public class Auto {
	private String patente,modelo;
	
	public Auto(String mod,String pat){
		modelo=mod;
		patente=pat;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
}
