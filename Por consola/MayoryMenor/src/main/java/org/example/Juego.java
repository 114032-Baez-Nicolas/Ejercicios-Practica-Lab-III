package org.example;

import java.util.Random;

public class Juego {

    public static int getValorRandom() {
        int[] valor = new int[]{1, 2, 3, 4, 5, 6, 7, 10, 11, 12};
        Random lRandom = new Random();
        int lNumero = lRandom.nextInt(valor.length);
        return valor[lNumero];
    }

    public String getGanador(int lNumeroJugador, int lNumeroPC, String MayorMenor) {

        String lNumero = "xd";

        if(lNumeroJugador == lNumeroPC){
            lNumero =  "0";
            //Empate con 0
        }

        else if (MayorMenor.equalsIgnoreCase("MAYOR"))
        {
            if(lNumeroPC>lNumeroJugador) {
                lNumero = "1";
                //Gana Jugador

            }
            else if(lNumeroJugador>lNumeroPC) {
                lNumero = "2";
                //Gana la PC
            }
        }

        else if (MayorMenor.equalsIgnoreCase("MENOR"))
        {
            if(lNumeroJugador>lNumeroPC) {
                lNumero = "1";
                //Gana Jugador
            }
            else if(lNumeroPC>lNumeroJugador) {
                lNumero =  "2";
                //Gana la PC
            }
        }

        return lNumero;
    }

    public Juego() {
    }
}
