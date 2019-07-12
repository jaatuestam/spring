package com.seas.patron.strategy.excepciones;

/**
 * Clase que define la excepcion de poligonos que no existen.
 *
 * @author SEAS - Estudios abiertos.
 */
public class PoligonoNoExisteException extends Exception {

    /**
     * Constructor de la excepcion.
     */
    public PoligonoNoExisteException() {
        super("El polígono no existe.");
    }

}

