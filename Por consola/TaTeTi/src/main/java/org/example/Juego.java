package org.example;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Juego {
    Scanner lLector = new Scanner(System.in);
    //Jugadores
    private String lPlayer1;
    private String lPlayer2;
    ArrayList<Jugador> oJugadores;

    //Tablero y puntos
    public int[][] tablero = new int [3][3];
    private int lPuntajeP1;
    private int lPuntajeP2;

    //Perdedor
    private int lUltimoPerdedor;

    //Primera Partida
    private boolean lPrimeraPartida = true;

    //Turnos
    private int lTurno;


    public void Jugar(){

        //Bienvenida
        System.out.println("--Bienvendio al juego del Ta Te Ti--");
        System.out.println("(1) Ingrese el nombre del jugador 1: ");
        lPlayer1 = lLector.nextLine();
        System.out.println("(2) Ingrese el nombre del jugador 2: ");
        lPlayer2 = lLector.nextLine();


        //String Abandonar Partida
        String JugarOtraPartida = "pJugar";

        //Partidas Ganadas
        int lPartidaGanadaP1 = 0;
        int lPartidaGanadaP2 = 0;

        while (!JugarOtraPartida.equalsIgnoreCase("Salir"))
        {
            System.out.println("------------------------------------------");

            oJugadores = new ArrayList<>();
            oJugadores.add(new Jugador(lPlayer1, 1));
            oJugadores.add(new Jugador(lPlayer2, 2));

            //Random Primera Partida
            if (lPrimeraPartida)
            {
                Random lRandom = new Random();
                lTurno = lRandom.nextInt(2);
            }
            else
            {
                lTurno = lUltimoPerdedor;
            }

            tablero = new int[3][3];
            System.out.println("() El jugador que inicia la partida es: " + oJugadores.get(lTurno).getNombre());

            boolean lJuegoTerminado = false;
            while (!lJuegoTerminado)
            {
                System.out.println("------------------------------------------");
                mostrarTablero();
                int lFila, lColumna;
                int lTanque;


                do
                {
                    System.out.print("Jugador " + oJugadores.get(lTurno).getNombre() + ", Ingrese la fila (1-3)");
                    lFila = lLector.nextInt() - 1;
                    System.out.print("Jugador " + oJugadores.get(lTurno).getNombre() + ", Ingrese la columna (1-3)");
                    lColumna = lLector.nextInt() - 1;

                    lTanque = lTurno;

                    if(lTurno == 0 && movValido(lFila, lColumna)){
                        lTurno = 1;
                    }
                    else if (lTurno == 1 && movValido(lFila, lColumna)){
                        lTurno = 0;
                    }

                }
                while (!movValido(lFila, lColumna));

                tablero[lFila][lColumna] = oJugadores.get(lTanque).getNumero();

                if(ganador())
                {
                    System.out.println("------------------------------------------");
                    mostrarTablero();
                    System.out.println("¡Felicitaciones " + oJugadores.get(lTanque).getNombre() + ", ganaste la partida!");
                    lJuegoTerminado = true;

                    if(oJugadores.get(lTanque).getNumero() == 1)
                    {
                        lPartidaGanadaP1++;
                        lUltimoPerdedor = 1;
                    }
                    else
                    {
                        lPartidaGanadaP2++;
                        lUltimoPerdedor = 0;
                    }

                }
                else if (tableroLleno())
                {
                    System.out.println("------------------------------------------");
                    mostrarTablero();
                    System.out.println("¡Juego Terminado en Empate!");
                    lJuegoTerminado = true;
                }
            }

            System.out.println("------------------------------------------");
            System.out.println("() Partidas Ganadas: ");
            System.out.println(oJugadores.get(0).getNombre() + ": " + lPartidaGanadaP1);
            System.out.println(oJugadores.get(1).getNombre() + ": " + lPartidaGanadaP2);
            System.out.println("------------------------------------------");

            System.out.println("() ¿Desea jugar otra partida? (Jugar/Salir)");
            JugarOtraPartida = lLector.next();

            if(JugarOtraPartida.equalsIgnoreCase("Salir"))
            {
                if(lPartidaGanadaP1>lPartidaGanadaP2)
                {
                    System.out.println("------------------------------------------");
                    System.out.println("¡Felicidades " + oJugadores.get(0).getNombre() + ", ganaste el juego!");
                    System.out.println("------------------------------------------");
                }
                else if(lPartidaGanadaP2>lPartidaGanadaP1)
                {
                    System.out.println("------------------------------------------");
                    System.out.println("¡Felicidades " + oJugadores.get(1).getNombre() + ", ganaste el juego!");
                    System.out.println("------------------------------------------");
                }
                else
                {
                    System.out.println("------------------------------------------");
                    System.out.println("¡El juego termino en empate!");
                    System.out.println("------------------------------------------");
                }
            }
            else
            {
                lPrimeraPartida = false;
            }

        }

    }

    //Crear y mostrar el tablero
    public int[][] mostrarTablero()
    {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++)
        {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++)
            {
                if(tablero[i][j] == 0)
                {
                    System.out.print("- ");
                } else if (tablero[i][j] == 1)
                {
                    System.out.print("X ");
                }
                else
                {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }

        return tablero;
    }

    //Ganador
    boolean ganador()
    {
        //Verificar Filas
        for(int i = 0; i < 3; i++)
        {
            if(tablero[i][0] != 0 && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2])
            {
                return true;
            }
        }
        //Verificar Columnas
        for(int k = 0; k < 3; k++)
        {
            if(tablero[0][k] != 0 && tablero[0][k] == tablero[1][k] && tablero[1][k] == tablero[2][k])
            {
                return true;
            }
        }
        //Verificar Diagonales
        if(tablero[0][0] != 0 && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2])
        {
            return true;
        }
        else if(tablero[0][2] != 0 && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0])
        {
            return true;
        }
        return false;
    }

    //Tablero lleno
    boolean tableroLleno()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (tablero[i][j] == 0)
                {
                    return false;
                }
            }
        }
        return true;
    }

    //Movimientos Validos
    boolean movValido(int fila, int colum)
    {
        if(fila < 0 || fila >2 || colum < 0 || colum > 2)
        {
            System.out.println("() La fila y la columna deben estar entre 1 y 3");
            return false;
        }
        else if (tablero[fila][colum] !=0)
        {
            System.out.println("() La casilla ya esta ocupada");
            return false;
        }
        else
        {
            return true;
        }
    }

}
