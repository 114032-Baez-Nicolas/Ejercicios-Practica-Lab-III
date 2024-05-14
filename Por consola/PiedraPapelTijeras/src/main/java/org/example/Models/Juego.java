package org.example.Models;

import java.util.Random;

public class Juego {


    public Juego() {
    }


    public static String getMovimiento() {
        String[] Movimiento = new String[]{"PIEDRA", "PAPEL", "TIJERA"};
        Random lRandom = new Random();
        int lNumero = lRandom.nextInt(Movimiento.length);

        return Movimiento[lNumero];
    }


    public String getGanador(String movimientoJugador, String movimientoPC) {

        String lNumero = "xd";

        if(movimientoJugador.equalsIgnoreCase(movimientoPC)){
            lNumero =  "0";
        }

        else if (movimientoJugador.equalsIgnoreCase("PIEDRA"))
        {
            if(movimientoPC.equalsIgnoreCase("TIJERA")) {
                lNumero = "1";

            }
            else if(movimientoPC.equalsIgnoreCase("PAPEL")) {
                lNumero = "2";
            }
        }

        else if (movimientoJugador.equalsIgnoreCase("PAPEL"))
        {
            if(movimientoPC.equalsIgnoreCase("PIEDRA")) {
                lNumero = "1";
            }
            else if(movimientoPC.equalsIgnoreCase("TIJERA")) {
                lNumero =  "2";
            }
        }

        else if (movimientoJugador.equalsIgnoreCase("TIJERA"))
        {
            if(movimientoPC.equalsIgnoreCase("PAPEL")) {
                lNumero = "1";
            }
            else if(movimientoPC.equalsIgnoreCase("PIEDRA")) {
                lNumero = "2";
            }
        }

        return lNumero;
    }


}



