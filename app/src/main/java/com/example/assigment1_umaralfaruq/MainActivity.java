package com.example.assigment1_umaralfaruq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
;

public class MainActivity extends AppCompatActivity {

    private static final String RESULT = "RESULT";
    EditText MyedtBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyedtBox = (EditText) findViewById(R.id.MyedtBox);


    }
  @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences mySharedPref = getSharedPreferences("Saved",MODE_PRIVATE);
        SharedPreferences.Editor editor =mySharedPref.edit();
        editor.putString("edtInput",MyedtBox.getText().toString());
        editor.apply();
    }
    @Override

    protected void onResume() {
        super.onResume();
        SharedPreferences MySharedPref = getSharedPreferences("Saved",MODE_PRIVATE);
      String  currenEditText = MySharedPref.getString("edtInput","");
       MyedtBox.setText(currenEditText);

   }
}