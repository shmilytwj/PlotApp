package com.example.curvedrawing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     TextView txtFunction=null;
     CustomView customView=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtFunction=(TextView)findViewById(R.id.txtFunction);
        customView=(CustomView)findViewById(R.id.plotview);
        Button buttonPlot=(Button)findViewById(R.id.buttonPlot);
        customView.setStrFunction("");
        customView.invalidate();
        buttonPlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(customView!=null){
                    String strFunction=txtFunction.getText().toString();
                    customView.setStrFunction(strFunction);
                    customView.invalidate();
                }
            }
        });
}
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id) {
            case R.id.Largen:
                if(customView!=null){
                    String strFunction=txtFunction.getText().toString();
                    customView.setStrFunction(strFunction);
                    if(customView.getLargen()<=1 && customView.getLargen()-0.2>=0.2) {
                        customView.setLargen(customView.getLargen()-0.2);
                        if(customView.getLargen()<=0.5)
                            customView.setChange(2);
                        customView.invalidate();
                    }
                    else {
                        customView.setLargen(0.2);
                        customView.invalidate();
                        Toast.makeText(MainActivity.this, "不能再放大", Toast.LENGTH_LONG).show();

                    }
                }
                break;
            case R.id.Lessen:
                if(customView!=null){
                    String strFunction=txtFunction.getText().toString();
                    customView.setStrFunction(strFunction);
                    if(customView.getLessen()>=1 && customView.getLessen()+0.2<=1.2) {
                        customView.setLessen(customView.getLessen()+0.2);
                        customView.invalidate();
                    }
                    else if(customView.getLargen()<1){
                        customView.setLargen(customView.getLargen()+0.2);
                        customView.invalidate();
                    }
                    else {
                        customView.setLessen(1.2);
                        customView.invalidate();
                        Toast.makeText(MainActivity.this, "不能再缩小", Toast.LENGTH_LONG).show();

                    }
                }
                break;
            case R.id.Clear:
                if(customView!=null){
                    customView.setStrFunction("");
                    customView.invalidate();
                }

        }


        return super.onOptionsItemSelected(item);
    }
}