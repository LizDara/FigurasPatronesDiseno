package com.example.figuras.Figuras;

import com.example.figuras.Interface.Esfera;

public class AreaEsfera extends Esfera {
    @Override
    public void createFormula() {
        this.resultado = (float) (4 * Math.PI * Math.pow(this.radio, 2));
        this.formula = "4 * π * " + this.radio + "² = " + this.resultado;
    }
}
