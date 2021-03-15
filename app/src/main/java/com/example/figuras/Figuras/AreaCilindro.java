package com.example.figuras.Figuras;

import com.example.figuras.Interface.Cilindro;

public class AreaCilindro extends Cilindro {
    @Override
    public void createFormula() {
        this.resultado = (float) (2 * Math.PI * this.radio * (this.altura + this.radio));
        this.formula = "2 * π * " + this.radio
                + " * (" + this.altura + " + " + this.radio + ") = " + this.resultado;
    }
}
