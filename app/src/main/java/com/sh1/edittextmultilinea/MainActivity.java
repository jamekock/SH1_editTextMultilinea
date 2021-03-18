package com.sh1.edittextmultilinea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    TextView txtMultiline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMultiline = findViewById(R.id.editTextTextMultiLine);

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("notas.txt")));
            String line = br.readLine();
            br.close();
            txtMultiline.setText(line);
        }
        catch (Exception e){

        }

    }
    public void Save(View v){
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("notas.txt",
                    MODE_PRIVATE));
            archivo.write(txtMultiline.getText().toString());
            archivo.flush();
            archivo.close();
        } catch (Exception e) {
        }
        finish();
    }
}