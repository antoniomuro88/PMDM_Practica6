package practica6.studium.pmdm_practica6;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class EditarPreferencias extends AppCompatActivity {

    Button btnEditar, btnCancelar;
    EditText txtNumTel, txtEmail;

    Spinner spnPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_preferencias);

        spnPersona = findViewById(R.id.spnPersona);
        txtNumTel = findViewById(R.id.txtNumTel);
        txtEmail = findViewById(R.id.txtEmail);
        btnEditar = findViewById(R.id.btnEditar);
        btnCancelar = findViewById(R.id.btnCancelar);

        //Rellenar los spinners
        ArrayAdapter arrayAdapter;
        arrayAdapter = ArrayAdapter.createFromResource(this, R.array.arrayPersonas, R.layout.support_simple_spinner_dropdown_item);
        spnPersona.setAdapter(arrayAdapter);

        btnEditar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                String numtel = "", email = "";

                if(spnPersona.getSelectedItem().toString().equals(getString(R.string.p1)))
                {
                    numtel = "NumTel1";
                    email = "Email1";
                }

                if(spnPersona.getSelectedItem().toString().equals(getString(R.string.p2)))
                {
                    numtel = "NumTel2";
                    email = "Email2";
                }

                if(spnPersona.getSelectedItem().toString().equals(getString(R.string.p3)))
                {
                    numtel = "NumTel3";
                    email = "Email3";
                }

                if(spnPersona.getSelectedItem().toString().equals(getString(R.string.p4)))
                {
                    numtel = "NumTel4";
                    email = "Email4";
                }

                if(spnPersona.getSelectedItem().toString().equals(getString(R.string.p5)))
                {
                    numtel = "NumTel5";
                    email = "Email5";
                }

                if(spnPersona.getSelectedItem().toString().equals(getString(R.string.p6)))
                {
                    numtel = "NumTel6";
                    email = "Email6";
                }

                SharedPreferences prefs = getSharedPreferences("cnfg", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();

                editor.putString(numtel, "tel:" + txtNumTel.getText().toString());
                editor.putString(email, txtEmail.getText().toString());

                editor.commit();

                finish();
            }
        });

        btnCancelar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
