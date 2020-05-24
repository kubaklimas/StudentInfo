package pl.edu.uwr.studinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button reg_btn,log_btn;
    EditText et_nrindeksu, et_password1, et_password2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reg_btn = findViewById(R.id.reg_btn);
        log_btn = findViewById(R.id.log_btn);
        et_nrindeksu = findViewById(R.id.et_login);
        et_password1 = findViewById(R.id.et_pass1);
        et_password2 = findViewById(R.id.et_pass2);

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserModel userModel;
                try{
                    userModel = new UserModel(et_nrindeksu.getText().toString(),et_password1.getText().toString(),et_password2.getText().toString());

                    Toast.makeText(MainActivity.this,userModel.toString(),Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                    Toast.makeText(MainActivity.this,"Wystąpił błąd w tworzeniu profilu",Toast.LENGTH_SHORT).show();
                    userModel = new UserModel("-1","null","null");

                }
                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
                boolean success = dataBaseHelper.addOne(userModel);
                Toast.makeText(MainActivity.this,"Success=" + success,Toast.LENGTH_SHORT).show();
            }
        });

        log_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginActivity();
                //Toast.makeText(MainActivity.this,"It works too!",Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void openLoginActivity() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}
