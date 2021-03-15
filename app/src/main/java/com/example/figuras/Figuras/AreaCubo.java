package com.example.figuras.Figuras;

import com.example.figuras.Interface.Cubo;

public class AreaCubo extends Cubo {
    @Override
    public void createFormula() {
        this.resultado = (2 * this.base * this.profundidad) + (2 * this.profundidad * this.altura)
                + (2 * this.base * this.altura);
        this.formula = "(2 * " + this.base + " * " + this.profundidad + ") + (2 * " + this.profundidad
                + " * " + this.altura + ") + (2 * " + this.base + " * " + this.altura + ") = " + this.resultado;
    }
}
