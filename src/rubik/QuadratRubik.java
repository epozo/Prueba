package rubik;

import java.util.Random;
import java.util.Scanner;

public class QuadratRubik {
	
	
	static Scanner reader = new Scanner(System.in);
	static final int MAX = 3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char color1, color2, color3;
		char [][] quadrat = new char[MAX][MAX];
		char continua = 's';
		char desp;
		int num;
		int sentit;
		
		do {
			color1 = demanarColor();
			color2 = demanarColor();
			color3 = demanarColor();
		} while (diferents(color1, color2, color3));
		
		omplir (quadrat, color1, color2, color3);
		
		do {
			mostrarQuadrat(quadrat);
			desp = demanarDesp();
			num = demanarNum();
			sentit = demanarSentit();
			aplicarDesp(quadrat, desp, num, sentit);
			if (quadratFormat(quadrat)) {
				mostrarMissatge("Has formar el quadrat de Rubik");
			}
			else mostrarMissatge("Continua jugant, encara no has acabat");
			mostrarMissatge("Vols continuar jugant?");
			continua = demanarResp();
			
		} while (continua == 's' || continua == 'S');
		
	}

	private static char demanarColor() {
		// TODO Auto-generated method stub
		
		char lletra;
		do {
			System.out.println("Indica una lletra (A - Z) pel color corresponent: ");
			lletra = llegirCar();
			
		} while ((lletra >= 'a' && lletra <= 'z') || (lletra >= 'A' && lletra <= 'Z'));
		
		return lletra;
	}

	private static char demanarResp() {
		// TODO Auto-generated method stub
		char resp;
		
		do {
			System.out.println("Vols continuar jugant a joc del quadrat de Rubik (s/n)? ");
			resp = reader.next().charAt(0);
		} while (resp != 'n' && resp != 'N' && resp != 's' && resp != 'S');
		
		
		return resp;
	}

	private static void mostrarMissatge(String string) {
		// TODO Auto-generated method stub
		System.out.println(string.toString());
	}

	private static boolean quadratFormat(char[][] quadrat) {
		// TODO Auto-generated method stub
		int i, j;
		boolean fet;
		char aux;
		
		fet = true;
		i = 0;
		while (i < MAX && fet){
			j = 1;
			aux = quadrat[i][0];
			while (j < MAX && quadrat[i][j] == aux) {
				j++;
			}
			if (j < MAX) fet = false;
		}
		
		if (!fet) {  //comprovem per columnes
			fet = true;
			j = 0;
			while (j < MAX && fet){
				i = 1;
				aux = quadrat[0][j];
				while (i < MAX && quadrat[i][j] == aux) {
					i++;
				}
				if (i < MAX) fet = false;
			}
		}
		return fet;
	}

	private static void aplicarDesp(char[][] quadrat, char desp, int num, int sentit) {
		// TODO Auto-generated method stub
		
	}

	private static int demanarSentit() {
		// TODO Auto-generated method stub
		int sentit;
		
		do {
			System.out.println("Indica el sentit del desplaçament: ");
			System.out.println("1. cap a la dreta o cap a baix");
			System.out.println("2. cap a la esquerra o cap a dalt");
			System.out.print("Introdueix una opció: ");
			sentit = llegirEnter();
		} while (sentit != -1 && sentit != 1);
		
		return sentit;
	}

	private static int llegirEnter() {
		// TODO Auto-generated method stub
		int num = 0;
		boolean valid = false;
		
		do {
			try {
				num = reader.nextInt();
				valid = true;
			}
			catch (Exception e) {
				System.out.println("Error, únicament números enters ");
				reader.nextLine();
			}
		} while (!valid);
		
		return num;
	}

	private static int demanarNum() {
		// TODO Auto-generated method stub
		int num = 0;
		
		do {
			System.out.print("Indica el número de fila / columna a desplaçar: ");
			num = llegirEnter();
		} while (num < 0 || num >= MAX);
		
		return num;
	}

	private static char demanarDesp() {
		// TODO Auto-generated method stub
		char fc;
		
		do {
			System.out.print("Indica si vols desplaçar una fila (f) o una columna (c): ");
			fc = llegirCar();
		} while (fc != 'f' && fc != 'F' && fc != 'c' && fc != 'C');
		
		return fc;
	}

	public static void mostrarQuadrat(char[][] quadrat) {
		// TODO Auto-generated method stub
		int i, j;
		for (i = 0; i < MAX; i++) {
			for (j = 0; j < MAX; j++)
				System.out.print(quadrat[i][j] + " - ");
			System.out.println();
		}
			
	}

	public static void omplir(char[][] quadrat, char color1, char color2, char color3) {
		// TODO Auto-generated method stub
		Random rnd = new Random();
		int num;
		int i, j, k;
		boolean dif;
		
		for (i = 0; i < MAX; i++) {
			j = 0;
			while (j < MAX) {	
				num = rnd.nextInt(3);
				switch (num) {
					case 0: quadrat[i][j] = color1;
						break;
					case 1: quadrat[i][j] = color2;
						break;
					case 2: quadrat[i][j] = color3;
						break;
				}
				k = 0;
				while (k < j && quadrat[i][j] != quadrat[i][k]) 
					k++;
				if (k == j) j++;
				
			
			}
		}
	}

	public static boolean diferents(char color1, char color2, char color3) {
		// TODO Auto-generated method stub
		boolean dif;
		
		if (color1 != color2 && color1 != color3 && color2 != color3) 
			dif = true;
		else 
			dif = false;
		
		return dif;
	}

	public static char llegirCar() {
		// TODO Auto-generated method stub
		char car;
		
		car = reader.next().charAt(0);
		return car;
	}

}
