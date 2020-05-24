package pl.edu.uwr.studinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button btn_back, btn_log;
    EditText edlog, edpass;
    DataBaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_back = findViewById(R.id.back_button);
        btn_log = findViewById(R.id.login_btn);
        edlog = findViewById(R.id.et_Log);
        edpass = findViewById(R.id.et_logpassword);




        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
            }
        });

        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"Zadziała już wkrótce!",Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void openRegister(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
