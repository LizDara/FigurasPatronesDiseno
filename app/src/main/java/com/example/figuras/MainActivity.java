package com.example.figuras;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.figuras.Memento.Caretaker;
import com.example.figuras.Memento.Memento;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.menu_figuras)
    LinearLayout menu_figuras;
    @BindView(R.id.figura)
    LinearLayout figura_linearLayout;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.pyramid)
    ImageView pyramid;
    @BindView(R.id.sphere)
    ImageView sphere;
    @BindView(R.id.cube)
    ImageView cube;
    @BindView(R.id.cylinder)
    ImageView cylinder;
    @BindView(R.id.type)
    TextView type;
    @BindView(R.id.solucion)
    TextView solucion;

    private int widthPixels;
    private Figura figura;
    private Memento memento;
    private Caretaker caretaker;

    @OnClick(R.id.volumen_button)
    public void onClickVolumen(View v) {
        setEnable(true);
        figura_linearLayout.setVisibility(View.GONE);
        menu_figuras.setVisibility(View.VISIBLE);
        figura.setOperacionType("Volumen");
    }

    @OnClick(R.id.area_button)
    public void onClickArea(View v) {
        setEnable(true);
        figura_linearLayout.setVisibility(View.GONE);
        menu_figuras.setVisibility(View.VISIBLE);
        figura.setOperacionType("Area");
    }

    @OnClick(R.id.pyramid)
    public void onClickPyramid(View v) {
        setPyramidData(false);
        setPyramidImage();
    }

    @OnClick(R.id.sphere)
    public void onClickSphere(View v) {
        setSphereData(false);
        setSphereImage();
    }

    @OnClick(R.id.cube)
    public void onClickCube(View v) {
        setCubeData(false);
        setCubeImage();
    }

    @OnClick(R.id.cylinder)
    public void onClickCylinder(View v) {
        setCylinderData(false);
        setCylinderImage();
    }

    @OnClick(R.id.save_button)
    public void onClickSave(View v) {
        memento = figura.createMemento();
        caretaker.addMemento(memento);
    }

    @OnClick(R.id.next_button)
    public void onClickNext(View v) {
        memento = caretaker.next();
        if (memento != null) {
            figura.setMemento(memento);
            if (figura.getType().equals("Piramide"))
                setPyramidImage();
            if (figura.getType().equals("Esfera"))
                setSphereImage();
            if (figura.getType().equals("Cubo"))
                setCubeImage();
            if (figura.getType().equals("Cilindro"))
                setCylinderImage();
            type.setText(figura.getOperationType() + " " + figura.getType());
            solucion.setText(figura.getResult());
        }
    }

    @OnClick(R.id.back_button)
    public void onClickBack(View v) {
        memento = caretaker.back();
        if (memento != null) {
            figura.setMemento(memento);
            if (figura.getType().equals("Piramide"))
                setPyramidImage();
            if (figura.getType().equals("Esfera"))
                setSphereImage();
            if (figura.getType().equals("Cubo"))
                setCubeImage();
            if (figura.getType().equals("Cilindro"))
                setCylinderImage();
            type.setText(figura.getOperationType() + " " + figura.getType());
            solucion.setText(figura.getResult());
        }
    }

    @OnClick(R.id.image)
    public void onClickImage(View v) {
        if (memento != null) {
            if (figura.getType().equals("Piramide"))
                setPyramidData(true);
            if (figura.getType().equals("Esfera"))
                setSphereData(true);
            if (figura.getType().equals("Cubo"))
                setCubeData(true);
            if (figura.getType().equals("Cilindro"))
                setCylinderData(true);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().hide();

        widthPixels = getResources().getDisplayMetrics().widthPixels;
        setEnable(false);
        figura = new Figura();
        caretaker = new Caretaker();
    }

    public void setEnable(boolean state) {
        pyramid.setEnabled(state);
        sphere.setEnabled(state);
        cube.setEnabled(state);
        cylinder.setEnabled(state);
    }

    public void setPyramidImage() {
        menu_figuras.setVisibility(View.GONE);
        image.setImageResource(R.drawable.pyramid);
        figura_linearLayout.setVisibility(View.VISIBLE);
    }

    public void setSphereImage() {
        menu_figuras.setVisibility(View.GONE);
        image.setImageResource(R.drawable.sphere);
        figura_linearLayout.setVisibility(View.VISIBLE);
    }

    public void setCubeImage() {
        menu_figuras.setVisibility(View.GONE);
        image.setImageResource(R.drawable.cube);
        figura_linearLayout.setVisibility(View.VISIBLE);
    }

    public void setCylinderImage() {
        menu_figuras.setVisibility(View.GONE);
        image.setImageResource(R.drawable.cylinder);
        figura_linearLayout.setVisibility(View.VISIBLE);
    }

    public void setPyramidData(boolean existData) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.pyramid_dialog, null);
        final AlertDialog dialog = new AlertDialog.Builder(this).create();
        Button insertar = view.findViewById(R.id.insertar_datos_pyramid);
        EditText base = view.findViewById(R.id.base_pyramid);
        EditText altura = view.findViewById(R.id.altura_pyramid);
        EditText profundidad = view.findViewById(R.id.profundidad_pyramid);
        if (existData) {
            float[] data = figura.getData();
            base.setText(String.valueOf(data[0]));
            altura.setText(String.valueOf(data[1]));
            profundidad.setText(String.valueOf(data[2]));
        }
        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = figura.setFigura("Piramide",
                        new float[]{Float.parseFloat(base.getText().toString()),
                                Float.parseFloat(altura.getText().toString()),
                                Float.parseFloat(profundidad.getText().toString()), 0});
                type.setText(figura.getOperationType() + " " + figura.getType());
                solucion.setText(result);
                dialog.dismiss();
            }
        });
        dialog.setView(view);
        dialog.show();
        dialog.getWindow().setLayout(widthPixels * 5 / 6, LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    public void setSphereData(boolean existData) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.sphere_dialog, null);
        final AlertDialog dialog = new AlertDialog.Builder(this).create();
        Button insertar = view.findViewById(R.id.insertar_datos_sphere);
        EditText radio = view.findViewById(R.id.radio_sphere);
        if (existData) {
            float[] data = figura.getData();
            radio.setText(String.valueOf(data[0]));
        }
        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = figura.setFigura("Esfera",
                        new float[]{Float.parseFloat(radio.getText().toString()), 0});
                solucion.setText(result);
                type.setText(figura.getOperationType() + " " + figura.getType());
                dialog.dismiss();
            }
        });
        dialog.setView(view);
        dialog.show();
        dialog.getWindow().setLayout(widthPixels * 5 / 6, LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    public void setCubeData(boolean existData) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.cube_dialog, null);
        final AlertDialog dialog = new AlertDialog.Builder(this).create();
        Button insertar = view.findViewById(R.id.insertar_datos_cube);
        EditText base = view.findViewById(R.id.base_cube);
        EditText altura = view.findViewById(R.id.altura_cube);
        EditText profundidad = view.findViewById(R.id.profundidad_cube);
        if (existData) {
            float[] data = figura.getData();
            base.setText(String.valueOf(data[0]));
            altura.setText(String.valueOf(data[1]));
            profundidad.setText(String.valueOf(data[2]));
        }
        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = figura.setFigura("Cubo",
                        new float[]{Float.parseFloat(base.getText().toString()),
                                Float.parseFloat(altura.getText().toString()),
                                Float.parseFloat(profundidad.getText().toString()), 0});
                solucion.setText(result);
                type.setText(figura.getOperationType() + " " + figura.getType());
                dialog.dismiss();
            }
        });
        dialog.setView(view);
        dialog.show();
        dialog.getWindow().setLayout(widthPixels * 5 / 6, LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    public void setCylinderData(boolean existData) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.cylinder_dialog, null);
        final AlertDialog dialog = new AlertDialog.Builder(this).create();
        Button insertar = view.findViewById(R.id.insertar_datos_cylinder);
        EditText radio = view.findViewById(R.id.radio_cylinder);
        EditText altura = view.findViewById(R.id.altura_cylinder);
        if (existData) {
            float[] data = figura.getData();
            radio.setText(String.valueOf(data[0]));
            altura.setText(String.valueOf(data[1]));
        }
        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = figura.setFigura("Cilindro",
                        new float[]{Float.parseFloat(radio.getText().toString()),
                                Float.parseFloat(altura.getText().toString()), 0});
                solucion.setText(result);
                type.setText(figura.getOperationType() + " " + figura.getType());
                dialog.dismiss();
            }
        });
        dialog.setView(view);
        dialog.show();
        dialog.getWindow().setLayout(widthPixels * 5 / 6, LinearLayout.LayoutParams.WRAP_CONTENT);
    }
}
