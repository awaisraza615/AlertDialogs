package com.arenterprise.alertdialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class CustomDialog extends AppCompatDialogFragment {

    private EditText DtextName,DtextPass;
    private CustomDiaologListner listner;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
       AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
       LayoutInflater inflater = getActivity().getLayoutInflater();
       View view = inflater.inflate(R.layout.custom_dialog,null);

       builder.setView(view)
               .setTitle("login")
               .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {

                   }
               })
               .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {

                       String user = DtextName.getText().toString();
                       String pass = DtextPass.getText().toString();
                       listner.ApplyText(user,pass);
                   }
               });


       DtextName = view.findViewById(R.id.Dtextname);
       DtextPass = view.findViewById(R.id.Dtextpass);

       return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listner = (CustomDiaologListner) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+"must implement dialog box");
        }
    }

    public interface CustomDiaologListner{

         void ApplyText(String user,String pass);

    }
}
