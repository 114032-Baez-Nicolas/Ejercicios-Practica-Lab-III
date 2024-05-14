package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class JuegoTest {

@Test
@DisplayName("Test Ganador")
    void testJugar() {
    Juego lJuego = new Juego();
    Boolean esperado = false;
    Boolean real = lJuego.ganador();
    assertEquals(esperado, real);
}

 @Test
 @DisplayName("Test Movimiento Valido")
    void movValido(){
    Juego lJuego = new Juego();

    Boolean esperado = true;
    Boolean real = lJuego.movValido(0,0);
    assertEquals(esperado, real);
 }

    @Test
    @DisplayName("Test Movimiento Valido")
    void tableroLleno(){
        Juego lJuego = new Juego();

        Boolean esperado = false;
        Boolean real = lJuego.tableroLleno();
        assertEquals(esperado, real);
    }

}