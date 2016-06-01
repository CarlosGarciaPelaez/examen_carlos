package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {

	/**
	 * 
	 * @param paraules "Aquesta funcio s'encarrega de guardar la cadena que ha d'encertar l'usuari"
	 * @param index "Numero aleatori que s'encarrega de determinar quina sera la paraula ha encertar"
	 * @param p "String que registra la resposta del usuari"
	 */
    static protected String paraules[] = {"hola","programaci√≥","casa"};
    static protected int index;
    static protected String p;

    public static void main(String[] args) {
        System.out.println("Comen√ßa el joc!");

        Random rand = new Random();/**Creem un objecte que ens proporciona un umer aleatori 
        */
        index = rand.nextInt(3);
        for (int i=0; i<paraules[index].length(); i++) {/**Aquest bucle s'encarrega de mostrar les paraules com guions baixos perque l'usuari no vegi el contingut de la paraula
       @param i "FunciÛ d'indexaciÛ per el for"
        */
            p += "_";
        }

        System.out.println(p);

        Scanner reader = new Scanner(System.in);

        int num_errors = 0;

        while (!p.equals(paraules[index]) && num_errors < 5) {
            if (!nova_lletra(reader.next().charAt(0))) {/**Amb aquest procediment agafem lletres introduides per l'usuari i fins que no s'esgotin els errors o be fins que no es descubreixin totes les lletres no s'acaba el joc
            @param num_errors "variable que acumula els errors de l'usuari "
            */
                num_errors++;
            }
            System.out.println(p);
        }
   }

    static public boolean nova_lletra(char nova) {/** Aquesta funcio, retorna cert o fals en funciÛ de si la lletra introduida coincideix o no, a mÈs si la lletra est‡ acertada, la canviara per la lletra en questiÛ sino deixar‡ el caracter "_" 
  @return true or false 
  */
        boolean trobada = false;
        String paraula_old = p;
        p = "";
        for (int i=0; i<paraules[index].length(); i++) {
            if (paraules[index].charAt(i) == nova) {
                p += paraules[index].charAt(i);
                trobada = true;
            }
            else {
                p += paraula_old.charAt(i);
            }
        }
        return trobada;
    }

}

