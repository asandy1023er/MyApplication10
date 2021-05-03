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

public class MainActivity4 extends AppCompatActivity {
TextView T6;
Button B4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        T6=findViewById(R.id.T6);
        B4=findViewById(R.id.B4);

        Bundle bundle3 = getIntent().getExtras();
        int v5=bundle3.getInt("num1");
        T6.setText(String.valueOf(v5));

        B4.setOnClickListener(new Button.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(MainActivity4.this , MainActivity.class);
                Transition trans1= TransitionInflater.from(MainActivity4.this).inflateTransition(android.R.transition.slide_top);
                getWindow().setExitTransition(trans1);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity4.this).toBundle());
            }
        });
    }
}