package practica6.studium.pmdm_practica6;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class BlocDeNotas extends AppCompatActivity {

    EditText txtBloc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bloc_de_notas);

        txtBloc = findViewById(R.id.txtBloc);

        SharedPreferences prefs = getSharedPreferences("cnfg_bdn", Context.MODE_PRIVATE);

        txtBloc.setText(prefs.getString("bdn", "Escriba aquí para guardar una nota."));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_guardar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuGuardar:

                SharedPreferences prefs = getSharedPreferences("cnfg_bdn", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();

                editor.putString("bdn", txtBloc.getText().toString());

                editor.commit();
                Toast.makeText(this, "La nota se ha guardado correctamente", Toast.LENGTH_LONG).show();

                break;
        }

        return true;
    }
}
