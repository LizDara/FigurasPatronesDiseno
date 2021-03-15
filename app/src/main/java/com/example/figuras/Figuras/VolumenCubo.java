package com.example.figuras.Figuras;

import com.example.figuras.Interface.Cubo;

public class VolumenCubo extends Cubo {
    @Override
    public void createFormula() {
        this.resultado = this.base * this.altura * this.profundidad;
        this.formula = this.base + " * " + this.altura + " * " + this.profundidad + " = " + this.resultado;
    }
}
