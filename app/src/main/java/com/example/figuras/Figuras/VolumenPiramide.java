package com.example.figuras.Figuras;

import com.example.figuras.Interface.Piramide;

public class VolumenPiramide extends Piramide {
    @Override
    public void createFormula() {
        this.resultado = this.base * this.profundidad * this.altura / 3;
        this.formula = "1/3 * " + this.base + " * " + this.profundidad
                + " * " + this.altura + " = " + this.resultado;
    }
}
