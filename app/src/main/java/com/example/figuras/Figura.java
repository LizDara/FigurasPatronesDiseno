package com.example.figuras;

import android.util.Log;

import com.example.figuras.Figuras.AreaFactory;
import com.example.figuras.Figuras.VolumenFactory;
import com.example.figuras.Interface.Cilindro;
import com.example.figuras.Interface.Cubo;
import com.example.figuras.Interface.Esfera;
import com.example.figuras.Interface.OperacionFactory;
import com.example.figuras.Interface.Piramide;
import com.example.figuras.Memento.Memento;

public class Figura {
    private OperacionFactory factory;

    private Piramide piramide;
    private Esfera esfera;
    private Cubo cubo;
    private Cilindro cilindro;

    private String operationType;
    private String type;
    private float data[];
    private String result;

    public void setOperacionType(String type) {
        operationType = type;
    }

    public String setFigura(String type, float data[]) {
        this.type = type;
        this.data = data;

        if (operationType.equals("Volumen"))
            factory = new VolumenFactory();
        if (operationType.equals("Area"))
            factory = new AreaFactory();

        if (type.equals("Piramide")) {
            piramide = factory.createOperacionPiramide();
            Log.i("ERROR", data[0] + " " + data[1] + " " + data[2]);
            piramide.setBase(data[0]);
            piramide.setAltura(data[1]);
            piramide.setProfundidad(data[2]);
            piramide.createFormula();
            Log.i("ERROR", "R: "+piramide.getResultado());
            this.data[3] = piramide.getResultado();
            result = piramide.getFormula();
            return piramide.getFormula();
        }
        if (type.equals("Esfera")) {
            esfera = factory.createOperacionEsfera();
            esfera.setRadio(data[0]);
            esfera.createFormula();
            this.data[1] = esfera.getResultado();
            result = esfera.getFormula();
            return esfera.getFormula();
        }
        if (type.equals("Cubo")) {
            cubo = factory.createOperacionCubo();
            cubo.setBase(data[0]);
            cubo.setAltura(data[1]);
            cubo.setProfundidad(data[2]);
            cubo.createFormula();
            this.data[3] = cubo.getResultado();
            result = cubo.getFormula();
            return cubo.getFormula();
        }
        if (type.equals("Cilindro")) {
            cilindro = factory.createOperacionCilindro();
            cilindro.setRadio(data[0]);
            cilindro.setAltura(data[1]);
            cilindro.createFormula();
            this.data[2] = cilindro.getResultado();
            result = cilindro.getFormula();
            return cilindro.getFormula();
        }
        return null;
    }

    public String getOperationType() {
        return operationType;
    }

    public String getType() {
        return type;
    }

    public float[] getData() {
        return data;
    }

    public String getResult() {
        return result;
    }

    public Memento createMemento() {
        Memento memento = new Memento();
        memento.setOperationType(operationType);
        memento.setType(type);
        memento.setData(data);
        memento.setResult(result);
        return memento;
    }

    public void setMemento(Memento memento) {
        operationType = memento.getOperationType();
        type = memento.getType();
        data = memento.getData();
        result = memento.getResult();
    }
}
