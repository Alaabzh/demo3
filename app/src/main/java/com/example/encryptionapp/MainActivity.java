package com.example.encryptionapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylibrary.Ads;
import com.scottyab.aescrypt.AESCrypt;

import java.security.GeneralSecurityException;

public class MainActivity extends AppCompatActivity {

    EditText etKey;
    EditText etText;
    TextView etMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Ads ads=new Ads(this);
        ads.displayAds();
        etKey = findViewById(R.id.etKey);
        etText = findViewById(R.id.etText);
        etMsg = findViewById(R.id.etMsg);

    }
    public void encrypt(View view) throws GeneralSecurityException {

        String encrpyted = AESCrypt.encrypt(etKey.getText().toString(), etText.getText().toString());
        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("lable", encrpyted);
        clipboardManager.setPrimaryClip(clipData);
        Toast.makeText(this, "  ", Toast.LENGTH_SHORT).show();
        etText.setText("");
        etKey.setText("");
        etMsg.setText(String.format("   %s", encrpyted));

    }

    public void decrypt(View view) throws GeneralSecurityException {
        String encrpyted = AESCrypt.decrypt(etKey.getText().toString(), etText.getText().toString());
        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("lable", encrpyted);
        clipboardManager.setPrimaryClip(clipData);
        Toast.makeText(this, "Your Message Was Copied to clip board", Toast.LENGTH_SHORT).show();
        etText.setText("");
        etKey.setText("");
        etMsg.setText(String.format(" %s", encrpyted));


    }

    public void logout(View view) throws GeneralSecurityException{
        this.finish();

    }
}