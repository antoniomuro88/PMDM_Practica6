package practica6.studium.pmdm_practica6;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import static android.Manifest.permission.CALL_PHONE;

public class Persona extends AppCompatActivity {


    ImageView p1, p2, p3, p4, p5, p6;

    String numtel, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona);

        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        p3 = findViewById(R.id.p3);
        p4 = findViewById(R.id.p4);
        p5 = findViewById(R.id.p5);
        p6 = findViewById(R.id.p6);

        registerForContextMenu(p1);
        registerForContextMenu(p2);
        registerForContextMenu(p3);
        registerForContextMenu(p4);
        registerForContextMenu(p5);
        registerForContextMenu(p6);


    }


    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();

        if (v.getId() == R.id.p1) {
            SharedPreferences prefs = getSharedPreferences("cnfg", Context.MODE_PRIVATE);
            numtel = prefs.getString("NumTel1", "tel:611111111");
            email = prefs.getString("Email1", "Ejemplo1@correo.com");
        }

        if (v.getId() == R.id.p2) {
            SharedPreferences prefs = getSharedPreferences("cnfg", Context.MODE_PRIVATE);
            numtel = prefs.getString("NumTel2", "tel:622222222");
            email = prefs.getString("Email2", "Ejemplo2@correo.com");
        }

        if (v.getId() == R.id.p3) {
            SharedPreferences prefs = getSharedPreferences("cnfg", Context.MODE_PRIVATE);
            numtel = prefs.getString("NumTel3", "tel:633333333");
            email = prefs.getString("Email3", "Ejemplo3@correo.com");
        }

        if (v.getId() == R.id.p4) {
            SharedPreferences prefs = getSharedPreferences("cnfg", Context.MODE_PRIVATE);
            numtel = prefs.getString("NumTel4", "tel:644444444");
            email = prefs.getString("Email4", "Ejemplo4@correo.com");
        }

        if (v.getId() == R.id.p5) {
            SharedPreferences prefs = getSharedPreferences("cnfg", Context.MODE_PRIVATE);
            numtel = prefs.getString("NumTel5", "tel:655555555");
            email = prefs.getString("Email5", "Ejemplo5@correo.com");
        }

        if (v.getId() == R.id.p6) {
            SharedPreferences prefs = getSharedPreferences("cnfg", Context.MODE_PRIVATE);
            numtel = prefs.getString("NumTel6", "tel:666666666");
            email = prefs.getString("Email6", "Ejemplo6@correo.com");
        }

        inflater.inflate(R.menu.menu_persona, menu);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuLlamada:
                if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    Intent intLlam = new Intent(Intent.ACTION_CALL);
                    intLlam.setData(Uri.parse(numtel));
                    startActivity(intLlam);
                } else {
                    requestPermissions(new String[]{CALL_PHONE}, 1);
                }

                break;
            case R.id.menuEmail:
                Intent intEmail = new Intent(Intent.ACTION_SEND);
                intEmail.setType("text/plain");
                intEmail.putExtra(Intent.EXTRA_SUBJECT, "Esto es el asunto");
                intEmail.putExtra(Intent.EXTRA_TEXT, "Esto es el mensaje");
                intEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                startActivity(intEmail);
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_editar, menu);



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuEditar:
                Intent iMenEdit = new Intent(getApplicationContext(), EditarPreferencias.class);
                startActivity(iMenEdit);

        }

        return true;
    }
}
