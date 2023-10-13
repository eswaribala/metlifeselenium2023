package com.example.vebdentalcare;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PatientDetailById extends Activity {
    private ListView listViewPatients;
    private PatientAdapter adapter;
    private Button btnSearch;
    TextView searchTextView;
    TextView firstName,lastName,dob,gender,imageName,treatments,reportDate,age;
   // private SQLiteDatabase mDatabase;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchlayout);
        //Toast.makeText(this, "Mobile No is " + searchTextView.getText().toString(), Toast.LENGTH_LONG).show();
        btnSearch=findViewById(R.id.btnsearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                searchTextView = (TextView) findViewById(R.id.patientId);
                showPatientsFromDatabase(Long.parseLong(searchTextView.getText().toString()));
            }
        });




    }

    private void showPatientsFromDatabase(long mobileNo) {
        //opening the database
        SQLiteDatabase database = new SampleSQLiteDBHelper(this).getReadableDatabase();


        firstName=(TextView) findViewById(R.id.firstName);
         lastName=(TextView) findViewById(R.id.lastName);
         dob=(TextView) findViewById(R.id.dob);
         age=(TextView) findViewById(R.id.txtAge);
         gender=(TextView) findViewById(R.id.gender);
        //imageName=(TextView) findViewById(R.id.imageName);
         treatments=(TextView) findViewById(R.id.treatments);
         reportDate=(TextView) findViewById(R.id.reportDate);
        Cursor cursorPatients = database.rawQuery("SELECT * FROM VEB_CASE_HISTORY WHERE MOBILE_NO = ? ", new String[] { String.valueOf(mobileNo) });
        Toast.makeText(this, "Mobile No is " + mobileNo, Toast.LENGTH_LONG).show();

        //if the cursor has some data
        if (cursorPatients.moveToFirst()) {



                        //cursorPatients .getString(1),
                    firstName.setText(cursorPatients .getString(1));
                    lastName.setText(cursorPatients .getString(2));
                   dob.setText(cursorPatients.getString(3));
                   age.setText(cursorPatients.getString(4));
                     gender.setText(cursorPatients .getString(6));
                     treatments.setText(cursorPatients .getString(8));
                        reportDate.setText(cursorPatients .getString(9));


            try {
                File file=new File(cursorPatients .getString(7));
                Bitmap bitMap = BitmapFactory.decodeStream(new FileInputStream(file));
                ImageView img=(ImageView)findViewById(R.id.imageView);
                img.setImageBitmap(bitMap);
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }




            //imageName.setText(cursorPatients .getString(6));
           //File imgFile = new File("file://"+cursorPatients.getString(6));

            //MediaScannerConnection.scanFile(this, new String[] { imgFile.getPath() }, new String[] { "image/jpeg" }, null);
            //File extStore = Environment.getExternalStorageDirectory();
            //String mPath = extStore.getAbsolutePath() + cursorPatients .getString(6);
          /*
            if(imgFile.exists()){

                Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

                ImageView myImage = (ImageView) findViewById(R.id.imageView);

                myImage.setImageBitmap(myBitmap);

            }
            */

       }



        //closing the cursor
         cursorPatients.close();


    }
    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(PatientDetailById.this, PatientMenuActivity.class));
        finish();
        super.onBackPressed();
    }

}
