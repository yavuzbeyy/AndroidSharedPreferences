package com.huns.sharedpreferencesandlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences store;
    SharedPreferences.Editor editor;
    EditText getNumber;
    Button add;
    String kaydedilecekSayi;
    TextView kayitGoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.addButton);
        getNumber = findViewById(R.id.editTextNumber);

        kayitGoster = findViewById(R.id.kayitGoster);

        store = getSharedPreferences("Sayilar",MODE_PRIVATE);

    }

    public void kayitOl(View view){

        kaydedilecekSayi = getNumber.getText().toString();
        String gosterilecekSayi = store.getString("Sayilar",null);
        if(kaydedilecekSayi.isEmpty()){

            kayitGoster.setText(gosterilecekSayi);
        }else{

            editor = store.edit();
            editor.putString("Sayilar",kaydedilecekSayi);
            editor.apply();

            Toast.makeText(getApplicationContext(),"Kayıt Başarılı",Toast.LENGTH_SHORT).show();

        }




    }


}