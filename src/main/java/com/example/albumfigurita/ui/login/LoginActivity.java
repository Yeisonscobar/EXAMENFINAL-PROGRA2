package com.example.albumfigurita.ui.login;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.albumfigurita.MainActivity;
import com.example.albumfigurita.controller.Gestor;
import com.example.albumfigurita.dao.DAOUsuarioImpl;
import com.example.albumfigurita.databinding.ActivityLoginBinding;
import com.example.albumfigurita.dto.UsuarioDTO;
import com.skydoves.elasticviews.ElasticLayout;


public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private Gestor gestor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        iniciarPermisos();
        this.gestor = new Gestor(this);

        try{
            this.gestor.iniciar();
        } catch(Exception e){
            e.printStackTrace();
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 10:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, "Se denegaron los permisos, la app no funcionará correctamente.", Toast.LENGTH_SHORT).show();
                }
                break;
            // Aquí más casos dependiendo de los permisos
            // case OTRO_CODIGO_DE_PERMISOS...
        }
    }
    
    private void iniciarPermisos() {

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            10);
                }
                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // The registered ActivityResultCallback gets the result of this request.
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
            }
        }

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            10);
                }
                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // The registered ActivityResultCallback gets the result of this request.
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
            }
        }
    }


    public void ingresar(View view) {
        final IconEditText usernameEditText = binding.username;
        final IconEditText passwordEditText = binding.password;
        final TextView lblResultado = binding.lblResultado;
        final ElasticLayout ly_msg = binding.lymsg;

        String usuario = usernameEditText.getText().toString();
        String pass = passwordEditText.getText().toString();

        if (gestor != null){
            if (!gestor.validar(usuario, pass)) {
                String msg = "Complete correctamente los campos.";
                lblResultado.setText(msg);
                ly_msg.performClick();
                return;
            }

            if (gestor.verifiarUsuario(usuario, pass)) {
                Intent intent = new Intent(this, MainActivity.class);
                UsuarioDTO usuarioDTO = gestor.obtenerUsuario(usuario, pass);
                intent.putExtra("USUARIO", usuarioDTO);
                this.startActivity(intent);
                this.finish();
            } else {
                String msg = "Usuario y/o contraseñia incorrectos.";

                lblResultado.setText(msg);
                ly_msg.performClick();
            }
        }
    }

    public void salir(View view) {
        this.finish();
    }
}