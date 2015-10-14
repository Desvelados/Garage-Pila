
public class Auto {
	private String patente,modelo;
	public int color;
	public Auto(String mod,String pat, int col){
		modelo=mod;
		patente=pat;
		color=col;
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
