package com.arenterprise.alertdialogs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CustomDialog.CustomDiaologListner {

    private Button dialogButon,customButton;
    private TextView textName,textPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialogButon = (Button) findViewById(R.id.dialogButton);
        dialogButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
        customButton = (Button)findViewById(R.id.customDialogbutton);
        textName = (TextView)findViewById(R.id.textname);
        textPass = (TextView)findViewById(R.id.textpass);
        customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCustomDialog();
            }
        });
    }

    private void openCustomDialog() {
        CustomDialog customDialog = new CustomDialog();
        customDialog.show(getSupportFragmentManager(),"Custom Dialog");
    }

    private void openDialog() {
        SimpleDialog simpleDialog = new SimpleDialog();
        simpleDialog.show(getSupportFragmentManager(),"Simple Dialog");
    }


    @Override
    public void ApplyText(String user, String pass) {

        textPass.setText(pass);
        textName.setText(user);
    }
}
