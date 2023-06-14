package com.example.usuplace.activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.usuplace.Database.DBmanager;
import com.example.usuplace.Database.User;
import com.example.usuplace.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText txtName;
    private EditText txtEmail;
    private EditText txtPhone;
    private EditText txtMunicipality;
    private EditText txtDepartment;
    private EditText txtPassword;
    private Button btnRegister;
    private DBmanager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        dbManager = new DBmanager(this);

        // Obtener referencias de los elementos de la interfaz
        txtName = findViewById(R.id.editTextName);
        txtEmail = findViewById(R.id.editTextEmail);
        txtPhone = findViewById(R.id.editTextPhone);
        txtMunicipality = findViewById(R.id.editTextMunicipality);
        txtDepartment = findViewById(R.id.editTextDepartment);
        txtPassword = findViewById(R.id.editTextPassword);
        btnRegister = findViewById(R.id.buttonRegister);

        // Configurar el evento de clic del botón de registro
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        // Obtener los valores ingresados por el usuario
        String name = txtName.getText().toString().trim();
        String email = txtEmail.getText().toString().trim();
        String phone = txtPhone.getText().toString().trim();
        String municipality = txtMunicipality.getText().toString().trim();
        String department = txtDepartment.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();

        // Validar los campos

        // Verificar si el usuario ya existe
        if (dbManager.checkUserExists(email)) {
            Toast.makeText(this, "El correo electrónico ya está registrado", Toast.LENGTH_SHORT).show();
            return;
        }

        // Crear un objeto User con los datos ingresados
        User user = new User(name, email, phone, municipality, department, password);

        // Agregar el usuario a la base de datos
        dbManager.addUser(user);

        // Mostrar un mensaje de éxito
        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();

        // Puedes agregar aquí el código para redirigir al usuario a otra actividad después del registro
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
