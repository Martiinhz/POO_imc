package Class;

import java.util.ArrayList;

public class Logica {
	
	double imc;
	
	ArrayList<PersonaVO> listaPersonas;
	
	public Logica() {
		listaPersonas=new ArrayList<>();
	}

	public String RegistrarPersonas(PersonaVO persona) {
		String resp="Persona registrada con exito!\n";
		resp+="Documento: "+persona.getDocumento()+"\n";
		resp+="Nombre: "+persona.getNombre()+"\n";
		resp+="Edad: "+persona.getEdad()+"\n";
		resp+="Peso: "+persona.getPeso()+"\n";
		resp+="Altura: "+persona.getAltura()+"\n";
		imc=persona.getPeso()/(persona.getAltura()*persona.getAltura());
		
		String imcMsj=CalcularIMC(imc);
		resp+=""+imcMsj+"\n";
		
		persona.setIMC(imc);
		listaPersonas.add(persona);
		return resp;
	}
	
	public String CalcularIMC(double imc) {
		
		String msj="";
		if(imc<18) {
			msj="Anorexia";
		}else {
			if(imc>=18 && imc<20) {
				msj="Delgadez";
			}else {
				if(imc>=20 && imc<27) {
					msj="Normalidad";
				}else {
					if(imc>=27 && imc<30) {
						msj="Obesidad Grado 1";
					}else {
						if(imc>=30 && imc<35) {
							msj="Obesidad Grado 2";
						}else {
							if(imc>=35 && imc<40) {
								msj="Obesidad Grado 3";
							}else {
								if(imc>=40) {
									msj="Obesidad mórbida";
								}
							}
						}
					}
				}
			}
		}
		
		return "Su IMC es: "+imc+" su imc indica que tiene "+msj;
	}
	
	
	public String consultarListaPersona() {
		String resultado="";
		PersonaVO p=null;
		for (int i = 0; i < listaPersonas.size(); i++) {
			p=listaPersonas.get(i);
			resultado+="Documento: "+p.getDocumento()+"\n";
			resultado+="Nombre: "+p.getNombre()+"\n";
			resultado+="Edad : "+p.getEdad()+"\n";
			resultado+="Peso: "+p.getPeso()+"\n";
			resultado+="Altura : "+p.getAltura()+"\n";
			resultado+="IMC : "+p.getIMC()+"\n";
			resultado+="*************************\n";
		}
		
		return resultado;
	}

	public String consultarPromedio() {
		String resultado="";
		double suma=0;
		for (int i = 0; i < listaPersonas.size(); i++) {
			suma=suma+listaPersonas.get(i).getIMC();
		}
		
		double prom=suma/listaPersonas.size();
		resultado=CalcularIMC(prom);
		
		return resultado;
	}
}
