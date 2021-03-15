package com.example.figuras.Figuras;

import com.example.figuras.Interface.Cilindro;

public class VolumenCilindro extends Cilindro {
    @Override
    public void createFormula() {
        this.resultado = (float) (Math.PI * Math.pow(this.radio, 2) * this.altura);
        this.formula = "π * " + this.radio + "² * " + this.altura + " = " + this.resultado;
    }
}
