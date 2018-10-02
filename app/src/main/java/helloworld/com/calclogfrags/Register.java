package helloworld.com.calclogfrags;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;

public class Register extends AppCompatActivity {

    EditText name;
    EditText lastname;
    EditText university;
    EditText phone;
    EditText username;
    EditText password;
    Button register;

    Realm realm;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        realm = Realm.getDefaultInstance();


        name = (EditText) findViewById(R.id.name);
        lastname = (EditText) findViewById(R.id.lastname);
        university = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        register = (Button) findViewById(R.id.buttonReg);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setNombre(name.getText().toString());
                user.setApellidos(lastname.getText().toString());
                user.setUniversity(university.getText().toString());
                user.setTelefono(phone.getText().toString());
                user.setPassword(password.getText().toString());
                user.setUsername(username.getText().toString());

                realm.beginTransaction();

                Log.v("register","registering");
                Puntuacion iniPts = new Puntuacion();
                iniPts.setPuntuacion(0);
                final User userrealm = realm.copyToRealm(user);
                userrealm.getPunt().add(iniPts);
                realm.commitTransaction();

                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                Log.v("endregister","end registering");
            }
        });



    }
}
