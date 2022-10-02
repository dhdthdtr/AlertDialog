package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_ketqua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder mydialog = new AlertDialog.Builder(this);
        mydialog.setTitle("Message");
        tv_ketqua = findViewById(R.id.textView_ketqua);
        final CharSequence[] items = {"Đỏ", "Vàng", "Cam"};
        final boolean[] arrayCheck = {false, false, false};
        // show items on textView through dialog
//        mydialog.setItems(items, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int position) {
//                tv_ketqua.setText(items[position].toString());
//            }
//        });

        // show radio buttons on dialog
//        mydialog.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int position) {
//                tv_ketqua.setText(items[position].toString());
//            }
//        });

        // show checkbox on dialog
        mydialog.setMultiChoiceItems(items, arrayCheck, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position, boolean isChecked) {
                // handling
                arrayCheck[position] = isChecked;
            }
        });

        mydialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {
                String st = "";
                for(int i = 0; i < items.length; i++)
                    if(arrayCheck[i])
                        st += items[i].toString() + "\n";
                tv_ketqua.setText(st);
            }
        });

        // Button Yes
//        mydialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                tv_ketqua.setText("B chọn có");
//            }
//        });
        // Button No
        mydialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv_ketqua.setText("B chọn không");
            }
        });
        AlertDialog alertDialog = mydialog.create();
        alertDialog.show();
    }
}