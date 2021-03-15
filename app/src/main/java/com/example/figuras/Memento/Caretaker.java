package com.example.figuras.Memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
    private List<Memento> historialFiguras;
    private int index;

    public Caretaker() {
        historialFiguras = new ArrayList<>();
        index = 0;
    }

    public void addMemento(Memento memento) {
        historialFiguras.add(memento);
        index = historialFiguras.size();
    }

    public Memento next() {
        index++;
        return getMemento();
    }

    public Memento back() {
        index--;
        return getMemento();
    }

    public Memento getMemento() {
        if (index > 0 && index <= historialFiguras.size())
            return historialFiguras.get(index - 1);
        return null;
    }
}
