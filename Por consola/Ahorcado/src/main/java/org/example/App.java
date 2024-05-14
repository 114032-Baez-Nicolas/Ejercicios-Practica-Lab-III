package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class App
{
    public static void main( String[] args ) {

        //Variables
        String palabraSecreta = getPalabraSecreta();
        char[] palabraGuiones = getGuionesFromPalabras(palabraSecreta);
        ArrayList<Character> letrasIngresadas = new ArrayList<>();

        //Puntos e Intentos
        int lIntentos = 5;
        int lPuntos = 0;

        Scanner lLector = new Scanner(System.in);
        System.out.println("**Bienvendio al ahorcado**" + "\n**Trata de adivinar la palabra secreta**");
        System.out.println("------------------------------------------");

        while (lIntentos > 0) {
            System.out.println("() Palabra a descubrir:");
            System.out.println(palabraGuiones);
            System.out.println("1) Intentos restantes: " + lIntentos);
            System.out.println("2) Puntos: " + lPuntos);
            System.out.println("Introduce una letra: ");

            //Validar que no se introduzca la misma letra 2 veces
            char letra = lLector.next().charAt(0);
            boolean algunaLetraAcertada = false;


            if(letrasIngresadas.contains(letra)){
                System.out.println("Error, ya has introducido esta letra antes" + "\nIngresa otra..");
                System.out.println("------------------------------------------");
                continue;
            }
            else{
                letrasIngresadas.add(letra);
            }

            for (int i = 0; i < palabraSecreta.length(); i++) {

                if (String.valueOf(palabraSecreta.charAt(i)).equalsIgnoreCase(String.valueOf(letra))) {
                    palabraGuiones[i] = letra;
                    algunaLetraAcertada = true;
                }
            }

            //Letra incorrecta
            if(!algunaLetraAcertada){
                System.out.println("Letra incorrecta..");
                System.out.println("------------------------------------------");
                lIntentos--;
            }
            //Letra correcta
            else{
                System.out.println("¡Letra correcta!");
                System.out.println("------------------------------------------");
                lPuntos++;
            }

            //Has Perdido
            if (lIntentos == 0) {
            System.out.println("------------------------------------------");
            System.out.println("¡Has perdido!, La palabra secreta era: " + palabraSecreta);
            System.out.println("Lograste: " + lPuntos + " puntos");
            }

            //Has Ganado!
            if(hayGuiones(palabraGuiones) == false) {
                System.out.println("------------------------------------------");
                System.out.println("¡Has ganado!, La palabra secreta era: " + palabraSecreta);
                System.out.println("Lograste: " + lPuntos + " puntos");
                break;
            }
        }


    }

    //Metodos Utilizados

    //Obtener palabra secreta
    static String getPalabraSecreta(){
        String[] palabras = {"CASA", "PERRO", "COCHE", "MOTO", "BICICLETA", "ORDENADOR", "TELEFONO", "CERVEZA", "VINO"};
        Random lRandom = new Random();
        int lNumero = lRandom.nextInt(palabras.length);

        return palabras[lNumero];
    }

    //Obtener Guiones
    static char[] getGuionesFromPalabras(String palabra){
        int lNumLetrasPalabraSecreta = palabra.length();
        char[] lGuiones = new char[lNumLetrasPalabraSecreta];

        Arrays.fill(lGuiones, '_');

        return lGuiones;
    }

    //ValidarGanador
    static boolean hayGuiones(char[] array){
       for (char c: array) {
                if(c == '_'){
                    return true;
                }
            }
            return false;
    }


}
