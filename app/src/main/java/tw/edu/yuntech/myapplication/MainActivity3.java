package tw.edu.yuntech.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
int ii=0;
ListView L1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ListView L1=findViewById(R.id.L1);

        String a[]=new String[501];
        for (int i=0;i<501;i++){
            a[i]="item "+i;
        }


        ArrayAdapter ad =new ArrayAdapter(MainActivity3.this,R.layout.support_simple_spinner_dropdown_item,a);
        L1.setAdapter(ad);

        L1.setOnItemClickListener(new ListView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity3.this);
                ii=i;
                builder.setTitle("Title"+i);

                builder.setIcon(R.drawable.ic_launcher_background);
                builder.setMessage("item "+String.valueOf(i));
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int k) {
                        Context context = getApplicationContext(); //1
                        CharSequence text = String.valueOf(ii);//2
                        int duration = Toast.LENGTH_SHORT; //3

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                });

                builder.show();
                Intent intent =new Intent(MainActivity3.this , MainActivity4.class);
                Bundle bundle1 =new Bundle();
                bundle1.putInt("num1" , i);
                intent.putExtras(bundle1);
                Transition trans1= TransitionInflater.from(MainActivity3.this).inflateTransition(android.R.transition.slide_top);
                getWindow().setExitTransition(trans1);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity3.this).toBundle());
            }
        });
    }
}