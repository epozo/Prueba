package examenBloc1;

/*
 * Els colors es generen a partir de tres colors base: Magenta, Groc i Cian. Implementeu un programa en Java que
Demana una lletra corresponent l primer color base: M: Magenta o N: Cap color
Demana una segona lletra coresponent al segon color base:  G: Groc o N: Cap color
Demana la tercera lletra corresponent al tercer color base: C: Cian o N: Cap color
Valida que l’entrada de dades sigui correcte. Si no és així no farà res mes i avisarà per pantalla.
Mostra per pantalla el nou color generat
 */
import java.util.Scanner;

public class Colors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);  
		char color1, color2, color3;
		boolean error = false;
	
		System.out.print("El primer color base: ");
		color1 = reader.next().charAt(0);  
		
		System.out.print("El primer color base: ");
		color2 = reader.next().charAt(0);  
		
		System.out.print("El primer color base: ");
		color3 = reader.next().charAt(0);  
		
		//Validem les dades d'entrada
		if (color1 != 'M' && color1 != 'N') {
			error = true;
		}
		else {
			if (color2 != 'G' && color2 != 'N') {
				error = true;
			}
			else {
				if (color3 != 'C' && color1 != 'N') {
					error = true;
				}
			}
		}
		
		if (error == true) {
			System.out.println("Error a les dades d'entrada");
		}
		else {  //Dades correctes
			if (color1 == 'M' ) {
				if (color2 == 'G') {
					if (color3 == 'C') {  //MGC
						System.out.println("Negre");
					}
					else { //MGN
						System.out.println("Vermell");
					}
				}
				else { 
					if (color3 == 'C') { //MNC
						System.out.println("Violeta");
					}
					else { //MNN
						System.out.println("Magenta");
					}
				}	
			}
			else { 
				if (color2 == 'G') {
					if (color3 == 'C') {  //NGC
						System.out.println("Verd");
					}
					else { //NGN
						System.out.println("Groc");
					}
				}
				else {
					if (color3 == 'C') { //NNC
						System.out.println("Cian");
					}
					else { //NNN
						System.out.println("Blanc");
					}
				}	
			}
			
		}
		
		
	}

}
