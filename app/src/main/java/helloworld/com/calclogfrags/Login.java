package helloworld.com.calclogfrags;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;

public class Login extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Realm realm;
    private RealmResults<User> userResults;


    Button login;
    EditText editTextUser;
    EditText editTextPass;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initRealm();
        loadRealmData();

        login = (Button) findViewById(R.id.buttonSignin);
        editTextUser = (EditText) findViewById(R.id.editTextUser);
        editTextPass = (EditText) findViewById(R.id.password);
        register = (Button) findViewById(R.id.buttonReg);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userinput = editTextUser.getText().toString();
                //Find user
                userResults = realm.where(User.class).equalTo("username",userinput).findAll();
                User u = realm.where(User.class).equalTo("username",editTextUser.getText().toString()).findFirst();

                //User doesn't exist
                if (userResults.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"User does not exist. You should register.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), Register.class);

                    startActivity(intent);
                }
                else {
                    //Password Check
                    Log.v("passcheck", "passcheck");
                    String insertedpass = editTextPass.getText().toString();


                    String truePass = u.getPassword();
                    Log.v("pppp", truePass);
                    //boolean res = u.checkPass(insertedpass);
                    Log.v("rrrr", insertedpass);

                    if (truePass.equals(insertedpass)) {
                        Log.v("true", "true");
                        String nameuser = u.getNombre();
                        String username = u.getUsername();
                        Log.v("nombre", nameuser);
                        saveUser(nameuser,username);
                        Intent intent = new Intent(getApplicationContext(), Drawer.class);

                        startActivity(intent);

                    } else {
                        Log.v("false", "false");
                        Toast.makeText(getApplicationContext(), "Wrong Password. Try again!", Toast.LENGTH_SHORT).show();


                    }
                }
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);

            }
        });

    }

    private void initRealm() {
        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();
    }

    private void loadRealmData() {
        userResults = realm.where(User.class).findAll();
    }

    void saveUser(String Name, String Username){
        SharedPreferences sp = getSharedPreferences("prefs", 0);

        SharedPreferences.Editor editor = sp.edit();

        editor.putString("name", Name);
        editor.putString("username", Username);

        editor.apply();
    }

}
