package com.seas.patron.strategy.principal;

import com.seas.patron.strategy.excepciones.ConstructorIncorrectoException;
import com.seas.patron.strategy.excepciones.PoligonoNoExisteException;
import com.seas.patron.strategy.excepciones.PoligonoNoSoportadoException;
import com.seas.patron.strategy.implementacion.CuerpoGeometrico;

/**
 * Clase que prueba el patron Strategy.
 *
 * @author SEAS - Estudios abiertos.
 */
public class StrategyPrincipal {

    /**
     * Metodo main donde probamos el ejemplo desarrollado 
     * del patron Strategy.
     *
     * @param args String[] parametros.
     */
    public static void main(String[] args) {
        try {
            CuerpoGeometrico p = new CuerpoGeometrico(2f);
            p.estableceCalculadoraArea();
            p.imprimeArea();
            p = new CuerpoGeometrico(2f, 3f, 3);
            p.estableceCalculadoraArea();
            p.imprimeArea();
            p = new CuerpoGeometrico(2f, 4);
            p.estableceCalculadoraArea();
            p.imprimeArea();
            p = new CuerpoGeometrico(Math.abs((float)(2f * Math.cos(90))), 
                    Math.abs((float)(2f * Math.sin(90))), 4);
            p.estableceCalculadoraArea();
            p.imprimeArea();
            p = new CuerpoGeometrico(2f, 3f, 4);
            p.estableceCalculadoraArea();
            p.imprimeArea();
            p = new CuerpoGeometrico(2f, 12);
            p.estableceCalculadoraArea();
            p.imprimeArea();
            p = new CuerpoGeometrico(0, 12);
            p.estableceCalculadoraArea();
            p.imprimeArea();
        } catch (PoligonoNoExisteException | PoligonoNoSoportadoException |
                ConstructorIncorrectoException ex) {
            System.err.println(ex.getMessage());
        }
    }
}


