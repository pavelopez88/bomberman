import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String ... args){
		Scanner t = new Scanner(System.in);
		List<Cordenada> cordenadas = new ArrayList<Cordenada>();
		System.out.println("filas: ");
		int f = t.nextInt();
		System.out.println("columnas: ");
		int c = t.nextInt();
		System.out.println("Magnitud de la bomba: ");
		int mg = t.nextInt();
		System.out.println("numero de bombas: ");
		int b = t.nextInt();
		System.out.println("Ingrese cordenadas: ");
		for (int i = 0; i < b; i++) {
			Cordenada cord = new Cordenada();
			System.out.println("*Bomba "+(i+1));
			System.out.print("X: ");
			cord.setX(t.nextInt());
			System.out.print("Y: ");
			cord.setY(t.nextInt());
			cordenadas.add(cord);
		}
		System.out.println("////////////////");
		Matriz m = new Matriz();
		m.play(f,c,b,mg,cordenadas);
		
	}
	
}
