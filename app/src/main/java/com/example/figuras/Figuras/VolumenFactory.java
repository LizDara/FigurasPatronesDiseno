package com.example.figuras.Figuras;

import com.example.figuras.Interface.Cilindro;
import com.example.figuras.Interface.Cubo;
import com.example.figuras.Interface.Esfera;
import com.example.figuras.Interface.Piramide;
import com.example.figuras.Interface.OperacionFactory;

public class VolumenFactory implements OperacionFactory {
    @Override
    public Piramide createOperacionPiramide() {
        return new VolumenPiramide();
    }

    @Override
    public Cubo createOperacionCubo() {
        return new VolumenCubo();
    }

    @Override
    public Esfera createOperacionEsfera() {
        return new VolumenEsfera();
    }

    @Override
    public Cilindro createOperacionCilindro() {
        return new VolumenCilindro();
    }
}
