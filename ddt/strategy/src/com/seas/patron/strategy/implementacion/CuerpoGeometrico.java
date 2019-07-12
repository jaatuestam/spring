package com.seas.patron.strategy.implementacion;

import com.seas.patron.strategy.base.AbstractArea;
import com.seas.patron.strategy.clases.derivadas.AreaCircular;
import com.seas.patron.strategy.clases.derivadas.AreaPoligonoRegular;
import com.seas.patron.strategy.clases.derivadas.AreaRectangulo;
import com.seas.patron.strategy.clases.derivadas.AreaTriangulo;
import com.seas.patron.strategy.excepciones.ConstructorIncorrectoException;
import com.seas.patron.strategy.excepciones.PoligonoNoExisteException;
import com.seas.patron.strategy.excepciones.PoligonoNoSoportadoException;

/**
 * Clase que implementa el patron y que decidira la estrategia a aplicar.
 *
 * @author SEAS - Estudios abiertos.
 */
public class CuerpoGeometrico {

    private AbstractArea _estrategia;
    private final float radio;
    private final int lados;
    private final float base;
    private final float altura;

    /**
     * Constructor del objeto para poligonos regulares.
     *
     * @param radio float longitud del radio.
     * @param lados int numero de lados.
     * @throws ConstructorIncorrectoException excepcion de constructor
     * incorrecto.
     */
    public CuerpoGeometrico(float radio, int lados) throws
            ConstructorIncorrectoException {
        if(lados < 5)
            throw new ConstructorIncorrectoException();
        this.radio = radio;
        this.lados = lados;
        this.base = 0;
        this.altura = 0;
    }

    /**
     * Constructor del objeto para un circulo.
     *
     * @param radio float longitud del radio.
     */
    public CuerpoGeometrico(float radio) {
        this.radio = radio;
        this.lados = (int) Float.POSITIVE_INFINITY;
        this.base = 0;
        this.altura = 0;
    }

    /**
     * Constructor del objeto para un triangulo.
     *
     * @param base float longitud de la base.
     * @param altura float longitud de la altura.
     * @param lados int numero de lados.
     */
    public CuerpoGeometrico(float base, float altura, int lados) {
        this.radio = 0;
        this.lados = lados;
        this.base = base;
        this.altura = altura;
    }

    /**
     * Metodo que establece la estrategia a desarrollar en funcion de los
     * parametros establecidos.
     *
     * @throws PoligonoNoExisteException excepcion si no existe el poligono.
     * @throws PoligonoNoSoportadoException excecepcion si es un poligono
     * irregular.
     */
    public void estableceCalculadoraArea() throws PoligonoNoExisteException,
            PoligonoNoSoportadoException {
        if (isCirculo()) {
            _estrategia = new AreaCircular(radio);
        } else if (isTriangulo()) {
            _estrategia = new AreaTriangulo(base, altura);
        } else if (isRectangulo()) {
            _estrategia = new AreaRectangulo(base, altura);
        } else if (isPoligonoRegular()) {
            _estrategia = new AreaPoligonoRegular(lados, radio);
        } else if (lados == 2 || lados == 0) {
            throw new PoligonoNoExisteException();
        } else {
            throw new PoligonoNoSoportadoException();
        }
    }

    /**
     * Metodo que imprime por pantalla el resultado del calculo.
     */
    public void imprimeArea() {
        System.out.println("El área del " + _estrategia.getNombreFigura()
                + " es: " + _estrategia.calculaArea());
    }

    private boolean isCirculo() {
        return lados == (int) Float.POSITIVE_INFINITY && radio != 0;
    }

    private boolean isPoligonoRegular() {
        return radio != 0 && lados != 0 && lados != 2;
    }

    private boolean isTriangulo() {
        return base != 0 && altura != 0 && lados == 3;
    }

    private boolean isRectangulo() {
        return base != 0 && altura != 0 && lados == 4;
    }

}

