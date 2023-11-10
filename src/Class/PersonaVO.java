package Class;

public class PersonaVO {

	private String Documento;
	private String Nombre;
	private int Edad;
	private double Peso;
	private double Altura;
	private double IMC;
	
	public PersonaVO() {
		
	}

	public PersonaVO(String documento, String nombre, int edad, double peso, double altura, double iMC) {
		super();
		Documento = documento;
		Nombre = nombre;
		Edad = edad;
		Peso = peso;
		Altura = altura;
		IMC = iMC;
	}

	public String getDocumento() {
		return Documento;
	}

	public void setDocumento(String documento) {
		Documento = documento;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public double getPeso() {
		return Peso;
	}

	public void setPeso(double peso) {
		Peso = peso;
	}

	public double getAltura() {
		return Altura;
	}

	public void setAltura(double altura) {
		Altura = altura;
	}

	public double getIMC() {
		return IMC;
	}

	public void setIMC(double iMC) {
		IMC = iMC;
	}
	
}
