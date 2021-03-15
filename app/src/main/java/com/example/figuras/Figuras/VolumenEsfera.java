package com.example.figuras.Figuras;

import com.example.figuras.Interface.Esfera;

public class VolumenEsfera extends Esfera {
    @Override
    public void createFormula() {
        this.resultado = (float) (4 * Math.PI * Math.pow(this.radio, 3)) / 3;
        this.formula = "4/3 * π * " + this.radio + "³ = " + this.resultado;
    }
}
