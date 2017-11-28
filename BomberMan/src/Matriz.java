import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Matriz {

	public void play(int f, int c, int b,int mg, List<Cordenada> cordenadas) {

		Random r = new Random();
		List<Cordenada> exploCad = new ArrayList<Cordenada>();
		List<Cordenada> desastre = new ArrayList<Cordenada>();
		char[][] tablero = new char[f][c];
		for (int i = 0; i < f; i++) {
			for (int j = 0; j < c; j++) {
				tablero[i][j] = '#';
			}
		}
		System.out.println("+= TABLERO =+");
		for (int i = 0; i < f; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(tablero[i][j]);
			}
			System.out.println();
		}

		System.out.println("//////////////////////");

		for (Cordenada cd : cordenadas) {
			tablero[cd.getY()][cd.getX()] = 'Ó';
		}
		System.out.println("+= BOMBAS =+");
		for (int i = 0; i < f; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(tablero[i][j]);
			}
			System.out.println();
		}

		int magnitud = mg;
		int bombas = 0;
		// VERTICAL ABAJO
		for (int i = 1; i <= magnitud; i++) {
			if (cordenadas.get(0).getY() + i <= f - 1) {
				tablero[cordenadas.get(0).getY()][cordenadas.get(0).getX()] = '-';
				if (tablero[cordenadas.get(0).getY() + i][cordenadas.get(0).getX()] == 'Ó') {
					bombas++;
					tablero[cordenadas.get(0).getY() + i][cordenadas.get(0).getX()] = '-';
					Cordenada nc = new Cordenada();
					nc.setX(cordenadas.get(0).getX());
					nc.setY(cordenadas.get(0).getY() + i);
					exploCad.add(nc);
				}
			}
		}
		// VERTICAL ARRIBA
		for (int i = 1; i <= magnitud; i++) {
			if (cordenadas.get(0).getY() - i >= 0) {
				tablero[cordenadas.get(0).getY()][cordenadas.get(0).getX()] = '-';
				if (tablero[cordenadas.get(0).getY() - i][cordenadas.get(0).getX()] == 'Ó') {
					bombas++;
					tablero[cordenadas.get(0).getY() - i][cordenadas.get(0).getX()] = '-';
					Cordenada nc = new Cordenada();
					nc.setX(cordenadas.get(0).getX());
					nc.setY(cordenadas.get(0).getY() - i);
					exploCad.add(nc);
				}
			}
		}
		
		
		// HORIZONTAL DERECHA
		for (int i = 1; i <= magnitud; i++) {
			if (cordenadas.get(0).getX() + i <= c - 1) {
				tablero[cordenadas.get(0).getY()][cordenadas.get(0).getX()] = '-';
				if (tablero[cordenadas.get(0).getY()][cordenadas.get(0).getX() + i] == 'Ó') {
					bombas++;
					tablero[cordenadas.get(0).getY()][cordenadas.get(0).getX() + i] = '-';
					Cordenada nc = new Cordenada();
					nc.setX(cordenadas.get(0).getX() + i);
					nc.setY(cordenadas.get(0).getY());
					exploCad.add(nc);
				}
			}
		}
		// HORIZONTAL IZQUIERDA
		for (int i = 1; i <= magnitud; i++) {
			if (cordenadas.get(0).getX() - i >= 0) {
				tablero[cordenadas.get(0).getY()][cordenadas.get(0).getX()] = '-';
				if (tablero[cordenadas.get(0).getY()][cordenadas.get(0).getX() - i] == 'Ó') {
					bombas++;
					tablero[cordenadas.get(0).getY()][cordenadas.get(0).getX() - i] = '-';
					Cordenada nc = new Cordenada();
					nc.setX(cordenadas.get(0).getX() - i);
					nc.setY(cordenadas.get(0).getY());
					exploCad.add(nc);
				}
			}
		}
		
		
		
		while(exploCad.size() > 0){
			for (int w = 0; w < exploCad.size(); w++) {
				// VERTICAL ABAJO
				for (int i = 1; i <= magnitud; i++) {
					if (exploCad.get(w).getY() + i <= f - 1) {
						tablero[exploCad.get(w).getY()][exploCad.get(w).getX()] = '-';
						if (tablero[exploCad.get(w).getY() + i][exploCad.get(w).getX()] == 'Ó') {
							bombas++;
							tablero[exploCad.get(w).getY() + i][exploCad.get(w).getX()] = '-';
							Cordenada nc = new Cordenada();
							nc.setX(exploCad.get(w).getX());
							nc.setY(exploCad.get(w).getY() + i);
							desastre.add(nc);
						}
					}
				}
				// VERTICAL ARRIBA
				for (int i = 1; i <= magnitud; i++) {
					if (exploCad.get(w).getY() - i >= 0) {
						tablero[exploCad.get(w).getY()][exploCad.get(w).getX()] = '-';
						if (tablero[exploCad.get(w).getY() - i][exploCad.get(w).getX()] == 'Ó') {
							bombas++;
							tablero[exploCad.get(w).getY() - i][exploCad.get(w).getX()] = '-';
							Cordenada nc = new Cordenada();
							nc.setX(exploCad.get(w).getX());
							nc.setY(exploCad.get(w).getY() - i);
							desastre.add(nc);
						}
					}
				}
				
				
				// HORIZONTAL DERECHA
				for (int i = 1; i <= magnitud; i++) {
					if (exploCad.get(w).getX() + i <= c - 1) {
						tablero[exploCad.get(w).getY()][exploCad.get(w).getX()] = '-';
						if (tablero[exploCad.get(w).getY()][exploCad.get(w).getX() + i] == 'Ó') {
							bombas++;
							tablero[exploCad.get(w).getY()][exploCad.get(w).getX() + i] = '-';
							Cordenada nc = new Cordenada();
							nc.setX(exploCad.get(w).getX() + i);
							nc.setY(exploCad.get(w).getY());
							desastre.add(nc);
						}
					}
				}
				// HORIZONTAL IZQUIERDA
				for (int i = 1; i <= magnitud; i++) {
					if (exploCad.get(w).getX() - i >= 0) {
						tablero[exploCad.get(w).getY()][exploCad.get(w).getX()] = '-';
						if (tablero[exploCad.get(w).getY()][exploCad.get(w).getX() - i] == 'Ó') {
							bombas++;
							tablero[exploCad.get(w).getY()][exploCad.get(w).getX() - i] = '-';
							Cordenada nc = new Cordenada();
							nc.setX(exploCad.get(w).getX() - i);
							nc.setY(exploCad.get(w).getY());
							desastre.add(nc);
						}
					}
				}
			}
			
			exploCad.removeAll(exploCad);
			exploCad.addAll(desastre);
			desastre.removeAll(desastre);
		}
		
		System.out.println("//////////////////////");
		System.out.println("+= FIN =+");
		for (int i = 0; i < f; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(tablero[i][j]);
			}
			System.out.println();
		}
		System.out.println("BOMBAS ALCANZADAS: " + bombas);

	}
}
