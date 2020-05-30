package br.com.local.appcardview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    EditText txtUsuario, txtPassword;
    TextView lblForget, lblSignUp;

    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPassword = findViewById(R.id.txtPassword);
        txtUsuario = findViewById(R.id.txtUsername);
        lblForget = findViewById(R.id.lblForget);
        lblSignUp = findViewById(R.id.lblSignUp);

        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = autenticarUsuario(txtUsuario.getText().toString(), txtPassword.getText().toString());

                if (flag == true) {
                    Toast.makeText(getApplicationContext(),
                            "Bem vindo ao sistema...",
                            Toast.LENGTH_SHORT).show();
                    limparJanela();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Usuário ou senha inválidos.",
                            Toast.LENGTH_SHORT).show();
                    limparJanela();
                }
            }
        });
        lblForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Cliquei em recuperar usuário ou senha",
                        Toast.LENGTH_SHORT).show();
            }
        });
        lblSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Cliquei no SignUp",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean autenticarUsuario(String usuario, String senha) {

        if (usuario.equals("etecia@etecia.com.br") && senha.equals("etecia238")) {
            return true;
        } else {
            return false;
        }
    }

    public void limparJanela() {
        txtUsuario.setText("");
        txtPassword.setText("");
        txtUsuario.requestFocus();
    }
}
