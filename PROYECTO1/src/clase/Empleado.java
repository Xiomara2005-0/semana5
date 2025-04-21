package clase;

public class Empleado {
	private String cod, nom, areal;
	private double sue;
	private int he, afilia;
	public Empleado(String cod, String nom, String areal, double sue, int he, int afilia) {
		this.cod = cod;
		this.nom = nom;
		this.areal = areal;
		this.sue = sue;
		this.he = he;
		this.afilia = afilia;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAreal() {
		return areal;
	}
	public void setAreal(String areal) {
		this.areal = areal;
	}
	public double getSue() {
		return sue;
	}
	public void setSue(double sue) {
		this.sue = sue;
	}
	public int getHe() {
		return he;
	}
	public void setHe(int he) {
		this.he = he;
	}
	public int getAfilia() {
		return afilia;
	}
	public void setAfilia(int afilia) {
		this.afilia = afilia;
	}
	public double montoHE() {
		return sue*he/240;
	}
	public double suebruto() {
		return sue+montoHE();
	}
	public double AFP() {
		return 0.11*suebruto();
	}
	public double SNP() {
		return 0.06*suebruto();
	}
	public double ESSALUD() {
		return 0.03*suebruto();
	}
	public double SN() {
		if(afilia==0)
		return suebruto()-ESSALUD()-AFP();
		else
		return suebruto()-ESSALUD()-SNP();
	}

}
