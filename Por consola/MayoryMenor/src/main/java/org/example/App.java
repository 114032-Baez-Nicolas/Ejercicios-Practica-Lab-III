package org.example;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner lLector = new Scanner(System.in);

        System.out.println("**Bienvendio al juego de Mayor y Menor**");
        System.out.println("Ingrese su nombre: ");
        String lNombre = lLector.nextLine();

        System.out.println("Para salir del juego, ingrese 'END' en cualquier momento");
        Jugador lJugador = new Jugador(lNombre);


        int lPuntosJugador = 0;
        int lPuntosPC = 0;


        String pSalir = "";
        while (!pSalir.equalsIgnoreCase("salir")){

            Juego lJuego = new Juego();
            System.out.println("------------------------------------------");

            int lValorJugador = lJuego.getValorRandom();
            int lValorPC = lJuego.getValorRandom();

            System.out.println("() Tu carta tiene el valor de: " + lValorJugador);
            System.out.println("() ¿El valor de la carta del BOT sera mayor o menor?");
            System.out.println("() Ingrese 'MAYOR' o 'MENOR'");
            System.out.println("(1) Puntos Jugador: " + lPuntosJugador);
            System.out.println("(2) Puntos BOT: " + lPuntosPC);

            String lMayorMenor = lLector.nextLine();

            if(lJuego.getGanador(lValorJugador, lValorPC, lMayorMenor).equals("0")){
                System.out.println("------------------------------------------");
                System.out.println("La carta de " + lJugador.getlNombre() + " tenía el valor de: " + lValorJugador);
                System.out.println("La carta del BOT tenía el valor de: " + lValorPC);
                System.out.println("Empate, ¡No se suman puntos!");
            }
            else if(lJuego.getGanador(lValorJugador, lValorPC, lMayorMenor).equals("1")){
                lPuntosJugador++;
                System.out.println("------------------------------------------");
                System.out.println("La carta de " + lJugador.getlNombre() + " tenía el valor de: " + lValorJugador);
                System.out.println("La carta del BOT tenía el valor de: " + lValorPC);
                System.out.println("¡" + lJugador.getlNombre() + " suma 1 punto!");
            }
            else if(lJuego.getGanador(lValorJugador, lValorPC, lMayorMenor).equals("2")){
                lPuntosPC++;
                System.out.println("------------------------------------------");
                System.out.println("La carta de " + lJugador.getlNombre() + " tenía el valor de: " + lValorJugador);
                System.out.println("La carta del BOT tenía el valor de: " + lValorPC);
                System.out.println("¡BOT suma 1 punto!");
            }


            if(lMayorMenor.equalsIgnoreCase("END")){

                if(lPuntosJugador>lPuntosPC){
                    System.out.println("------------------------------------------");
                    System.out.println("¡Felicidades " + lJugador.getlNombre() + " ganaste la partida!");
                    System.out.println("------------------------------------------");
                    pSalir = "salir";
                }
                else if(lPuntosPC>lPuntosJugador){
                    System.out.println("------------------------------------------");
                    System.out.println("¡Oh no, " + lJugador.getlNombre() + " perdiste la partida!");
                    System.out.println("------------------------------------------");
                    pSalir = "salir";
                }
                else if(lPuntosJugador==lPuntosPC){
                    System.out.println("------------------------------------------");
                    System.out.println("¡La partida termino en empate!");
                    System.out.println("------------------------------------------");
                    pSalir = "salir";
                }


            }

        }

    }
}
