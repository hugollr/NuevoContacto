package com.llavador.nuevocontacto;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.content.Intent.*;

public class MainConfirm extends AppCompatActivity {
    private Contacto este;
    protected TextView tvNombre;
    protected TextView tvFecha;
    protected TextView tvTelefono;
    protected TextView tvEmail;
    protected TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_confirm);
        Bundle parametros = getIntent().getExtras();
        este = new Contacto(parametros.getStringArrayList("datos"));
        String tmp;

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        tvNombre.setText(este.getNombre());
        tmp = getResources().getString(R.string.confirm_fecha) + "  " + este.getFecha();
        tvFecha.setText(tmp);
        tmp = getResources().getString(R.string.confirm_telf) + "  " + este.getTelefono();
        tvTelefono.setText(tmp);
        tmp = getResources().getString(R.string.confirm_email) + "  " + este.getEmail();
        tvEmail.setText(tmp);
        tvDescripcion.setText(este.getDescripcion());
    }

    protected void llamar(View v) {
        String numero = este.getTelefono();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(new Intent(ACTION_CALL, Uri.parse("tel:" + numero)));
    }

    protected void enviar(View v){
        String email = este.getEmail();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:" + email));
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Email"));
    }

    public void editarDatos(View v){
        this.finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //if (keyCode == KeyEvent.KEYCODE_BACK){
        //    Intent intent = new Intent(this, MainActivity.class);
        //    startActivity(intent);
        //}
        this.finish();
        return super.onKeyDown(keyCode, event);
    }
}
