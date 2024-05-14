package org.example.Models;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner lLector = new Scanner(System.in);

        System.out.println("**Bienvendio al juego de Piedra/Papel/Tijeras**");
        System.out.println("Ingrese su nombre..");
        String lNombre = lLector.nextLine();

        System.out.println("Para salir del juego, ingrese 'END' en cualquier momento");
        Jugador lJugador = new Jugador(lNombre);


        int lPuntosJugador = 0;
        int lPuntosPC = 0;


        String pSalir = "";

        while (!pSalir.equalsIgnoreCase("salir")){

            Juego lJuego = new Juego();
            System.out.println("------------------------------------------");
            System.out.println("() Elija: 'Piedra', 'Papel' o 'Tijera':");
            System.out.println("(1) Puntos Jugador: " + lPuntosJugador);
            System.out.println("(2) Puntos BOT: " + lPuntosPC);

            String lMovimientoJugador = lLector.nextLine();
            String lMovimientoPC = Juego.getMovimiento();


            if(lJuego.getGanador(lMovimientoJugador, lMovimientoPC).equals("0")){
                System.out.println("------------------------------------------");
                System.out.println("Ingresaste: " + lMovimientoJugador);
                System.out.println("PC ingreso: " + lMovimientoPC);
                System.out.println("Empate, ¡No se suman puntos!");
            }
            else if(lJuego.getGanador(lMovimientoJugador, lMovimientoPC).equals("1")){
                lPuntosJugador++;
                System.out.println("------------------------------------------");
                System.out.println("Ingresaste: " + lMovimientoJugador);
                System.out.println("PC ingreso: " + lMovimientoPC);
                System.out.println("¡" + lJugador.getNombre() + " suma 1 punto!");
            }
            else if(lJuego.getGanador(lMovimientoJugador, lMovimientoPC).equals("2")){
                lPuntosPC++;
                System.out.println("------------------------------------------");
                System.out.println("Ingresaste: " + lMovimientoJugador);
                System.out.println("PC ingreso: " + lMovimientoPC);
                System.out.println("¡BOT suma 1 punto!");
            }


            if(lMovimientoJugador.equalsIgnoreCase("END")){

                if(lPuntosJugador > lPuntosPC){
                    System.out.println("------------------------------------------");
                    System.out.println("¡Felicidades " + lJugador.getNombre() + ", ganaste el juego!");
                    System.out.println("------------------------------------------");
                    pSalir = "salir";
                }
                else if(lPuntosJugador < lPuntosPC){
                    System.out.println("------------------------------------------");
                    System.out.println("¡Oh no " + lJugador.getNombre() + ", perdiste el juego!");
                    System.out.println("------------------------------------------");
                    pSalir = "salir";
                }
                else{
                    System.out.println("------------------------------------------");
                    System.out.println("¡El juego termino en empate!");
                    System.out.println("------------------------------------------");
                    pSalir = "salir";
                }
            }


        }


    }
}
