package tw.edu.yuntech.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.xml.transform.Result;

public class MainActivity2 extends AppCompatActivity {


    TextView T3,T4,T5;
    Button B2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        T3=findViewById(R.id.T3);
        T4=findViewById(R.id.T4);
        T5=findViewById(R.id.T5);

        B2=findViewById(R.id.B2);
        Bundle bundle2 = getIntent().getExtras();
        Double v1=bundle2.getDouble("num1");
        Double v2=bundle2.getDouble("num2");
        Double v3=bundle2.getDouble("num3");
        T3.setText("寬："+v1);
        T4.setText("長："+v2);
        T5.setText("長："+v3);

        B2.setOnClickListener(new Button.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity2.this , MainActivity.class);
                Transition trans1= TransitionInflater.from(MainActivity2.this).inflateTransition(android.R.transition.slide_top);
                getWindow().setExitTransition(trans1);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity2.this).toBundle());
            }
        });
    }
}