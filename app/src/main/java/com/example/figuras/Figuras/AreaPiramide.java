package com.example.figuras.Figuras;

import com.example.figuras.Interface.Piramide;

public class AreaPiramide extends Piramide {
    @Override
    public void createFormula() {
        this.resultado = (float) (this.base *
                (this.profundidad + Math.sqrt(4 * Math.pow(this.altura, 2) + Math.pow(this.base, 2))));
        this.formula = this.profundidad + " * ("
                + this.base + " + √4 * " + this.altura + "² + " + this.base + "²) = " + this.resultado;
    }
}
