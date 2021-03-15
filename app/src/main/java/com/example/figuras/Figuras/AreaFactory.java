package com.example.figuras.Figuras;

import com.example.figuras.Interface.Cilindro;
import com.example.figuras.Interface.Cubo;
import com.example.figuras.Interface.Esfera;
import com.example.figuras.Interface.Piramide;
import com.example.figuras.Interface.OperacionFactory;

public class AreaFactory implements OperacionFactory {
    @Override
    public Piramide createOperacionPiramide() {
        return new AreaPiramide();
    }

    @Override
    public Cubo createOperacionCubo() {
        return new AreaCubo();
    }

    @Override
    public Esfera createOperacionEsfera() {
        return new AreaEsfera();
    }

    @Override
    public Cilindro createOperacionCilindro() {
        return new AreaCilindro();
    }
}
