package com.company;
package colgado;

import java.util.Scanner;
import java.util.Random;

public class Main extends Analisis_paraula {//Hem creat una super classe que realitza multiples funcions amb la paraula que introdueix l'usuari

	private static final int MAX_ERRORS = 5;
	/**
	 *
	 * @param paraules "Aquesta funcio s'encarrega de guardar la cadena que ha d'encertar l'usuari"
	 * @param index "Numero aleatori que s'encarrega de determinar quina sera la paraula ha encertar"
	 * @param Paraula_usuari "String que registra la resposta del usuari"
	 */
    static protected String paraules[] = {"hola","programaciÃ³","casa"};
    static protected int index;
    static protected String Paraula_usuari; // Per fer el codi mes entenedor he substituit p per Paraula_usuari

    public static void main(String[] args) {
        System.out.println("ComenÃ§a el joc!");

        Seleccio_paraula();// Hem fet un nou metode per simplificar codi que s'encarrega de triar la paraula que s'haurà d'encertar

        System.out.println(Paraula_usuari);

        Scanner reader = new Scanner(System.in);

        int Errors = 0;

        while (!Paraula_usuari.equals(paraules[index]) && Errors < MAX_ERRORS) {// Em declarat una constant per el nombre màxims d'erros i hem canviat la variable num_errors per Errors
            if (!nova_lletra(reader.next().charAt(0))) {/**Amb aquest procediment agafem lletres introduides per l'usuari i fins que no s'esgotin els errors o be fins que no es descubreixin totes les lletres no s'acaba el joc
            											@param num_errors "variable que acumula els errors de l'usuari "
             											*/
                Errors++;
            }
            System.out.println(Paraula_usuari);
        }
   }

	private static void Seleccio_paraula() {
		Random rand = new Random();/**Creem un objecte que ens proporciona un umer aleatori
		 							*/
        index = rand.nextInt(3);
        for (int i=0; i<paraules[index].length(); i++) {/**Aquest bucle s'encarrega de mostrar les paraules com guions baixos perque l'usuari no vegi el contingut de la paraula
       													@param i "Funció d'indexació per el for"
         												*/
            Paraula_usuari += "_";
        }
	}

    static public boolean nova_lletra(char nova) {/** Aquesta funcio, retorna cert o fals en funció de si la lletra introduida coincideix o no, a més si la lletra està acertada, la canviara per la lletra en questió sino deixarà el caracter "_"
  @param paraula_old "Guarda el contingut de la string paraula abans de ser modificada"
  @return true or false
  */
        boolean trobada = false;
        String paraula_old = Paraula_usuari;
        Paraula_usuari = "";
        trobada = Comprobacio_i_modificacio(nova, trobada, paraula_old); // Hem seprat en nou metode nomes la part que comproba i modifica
        return trobada;
    }

	private static boolean Comprobacio_i_modificacio(char nova, boolean trobada, String paraula_old) {
		for (int i=0; i<paraules[index].length(); i++) {
            if (paraules[index].charAt(i) == nova) {
                Paraula_usuari += paraules[index].charAt(i);
                trobada = true;
            }
            else {
                Paraula_usuari += paraula_old.charAt(i);
            }
        }
		return trobada;
	}

}
