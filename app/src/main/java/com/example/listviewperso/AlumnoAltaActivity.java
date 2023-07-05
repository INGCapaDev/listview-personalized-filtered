package com.example.listviewperso;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class AlumnoAltaActivity extends AppCompatActivity {
    private Button btnGuardar, btnRegresar;
    private Alumno alumno;
    private EditText txtNombre, txtMatricula, txtGrado;
    private ImageView imgAlumno;
    private TextView lblImagen;
    private int posicion;
    private Uri selectedImageUri;

    private static final int REQUEST_PERMISSION_EXTERNAL_STORAGE = 1;
    private static final int REQUEST_CODE_PERMISSIONS = 1001;
    private static final String[] REQUIRED_PERMISSIONS = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};

    private ActivityResultLauncher<Intent> imagePickerLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            if (data != null) {
                                selectedImageUri = data.getData();
                                if (selectedImageUri != null) {
                                    imgAlumno.setImageURI(selectedImageUri);
                                    if (alumno != null) {
                                        alumno.setImg(selectedImageUri.toString());
                                    }
                                    getContentResolver().takePersistableUriPermission(selectedImageUri, Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                                }
                            }
                        }

                    });


    private boolean isUriValid(String uriString) {
        Uri uri = Uri.parse(uriString);
        return uri != null && "content".equals(uri.getScheme());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_alta);
        btnGuardar = findViewById(R.id.btnSalir);
        btnRegresar = findViewById(R.id.btnRegresar);
        txtMatricula = findViewById(R.id.txtMatricula);
        txtNombre = findViewById(R.id.txtNombre);
        txtGrado = findViewById(R.id.txtGrado);
        imgAlumno = findViewById(R.id.imgAlumno);
        Button btnSeleccionarImagen = findViewById(R.id.btnSeleccionarImagen);
        btnSeleccionarImagen.setOnClickListener(v -> {
            if (checkPermission()) {
                pickImage();
            } else {
                requestPermission();
            }
        });

        Bundle bundle = getIntent().getExtras();
        alumno = (Alumno) bundle.getSerializable("alumno");
        posicion = bundle.getInt("posicion", posicion);

        if (posicion >= 0) {
            txtMatricula.setText(alumno.getMatricula());
            txtNombre.setText(alumno.getNombre());
            txtGrado.setText(alumno.getCarrera());
            if (!TextUtils.isEmpty(alumno.getImg())) {
                if (isUriValid(alumno.getImg())) {
                    imgAlumno.setImageURI(Uri.parse(alumno.getImg()));
                } else {
                    imgAlumno.setImageResource(R.drawable.avatar);
                }
            }
        }

        btnGuardar.setOnClickListener(v -> {
            if (alumno == null) {
                if (validar()) {
                    alumno = new Alumno();
                    alumno.setCarrera(txtGrado.getText().toString());
                    alumno.setMatricula(txtMatricula.getText().toString());
                    alumno.setNombre(txtNombre.getText().toString());
                    alumno.setImg(selectedImageUri != null ? selectedImageUri.toString() : "");

                    Aplicacion.alumnosDb.insertAlumno(alumno);
                    Aplicacion.alumnos.add(alumno);
                    setResult(Activity.RESULT_OK);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Faltó capturar datos", Toast.LENGTH_SHORT).show();
                    txtMatricula.requestFocus();
                }
            }
            if (posicion >= 0) {
                alumno.setMatricula(txtMatricula.getText().toString());
                alumno.setNombre(txtNombre.getText().toString());
                alumno.setCarrera(txtGrado.getText().toString());
                alumno.setImg(selectedImageUri != null ? selectedImageUri.toString() : "");

                Aplicacion.alumnosDb.updateAlumno(alumno);
                Aplicacion.alumnos.set(posicion, alumno);

                Toast.makeText(getApplicationContext(), "Se modificó con éxito", Toast.LENGTH_SHORT).show();
                setResult(Activity.RESULT_OK);
                finish();
            }
        });

        btnRegresar.setOnClickListener(v -> {
            finish();
        });
    }

    private boolean validar() {
        boolean exito = true;
        Log.d("nombre", "validar: " + txtNombre.getText());
        if (txtNombre.getText().toString().isEmpty()) exito = false;
        if (txtGrado.getText().toString().isEmpty()) exito = false;
        if (txtMatricula.getText().toString().isEmpty()) exito = false;

        return exito;
    }

    private boolean checkPermission() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {

            ActivityCompat.requestPermissions(this, new String[] {
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.MANAGE_DOCUMENTS,
                    Manifest.permission.MANAGE_EXTERNAL_STORAGE,
            }, REQUEST_PERMISSION_EXTERNAL_STORAGE);


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_EXTERNAL_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                pickImage();
            } else {
                Toast.makeText(getApplicationContext(), "Permiso denegado", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void pickImage() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("image/*");
        imagePickerLauncher.launch(intent);
    }
}