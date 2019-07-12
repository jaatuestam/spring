package com.seas.patron.strategy.excepciones;

/**
 * Clase que define la excepcion de constructor incorrecto.
 *
 * @author SEAS - Estudios abiertos.
 */
public class ConstructorIncorrectoException extends Exception {

    public ConstructorIncorrectoException() {
        super("El constructor utilizado no es correcto para ese cuerpo "
                + "geométrico.");
    }

}
