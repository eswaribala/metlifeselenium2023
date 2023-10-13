package com.example.vebdentalcare;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.graphics.Color;
import android.location.LocationListener;
import android.net.sip.SipSession;
import android.os.IBinder;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.DatePicker;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

import android.content.pm.PackageManager;
import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import android.graphics.Bitmap;
import android.app.Activity;
import android.os.Environment;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.widget.Toast;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import static android.location.LocationManager.*;


import android.content.ContentValues;
import android.widget.RadioButton;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageButton btnsave,launch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.parseColor("#303F9F"));
        launch = (ImageButton) findViewById(R.id.button_x);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {

                Intent mInHome = new Intent(MainActivity.this, LoginActivity.class);
                MainActivity.this.startActivity(mInHome);
                MainActivity.this.finish();
            }
        }, 7000);
    }

    @Override
    public void onBackPressed()
    {

            finish();
        System.exit(0);
    }




}
