package pl.edu.uwr.studinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView tv;
    String temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tv = (TextView)findViewById(R.id.tv_hello);
        Intent intent = getIntent();
        temp = intent.getStringExtra("loginfo");
        String onemoretemp = "Hello "+temp;
        tv.setText(onemoretemp);


    }
}
