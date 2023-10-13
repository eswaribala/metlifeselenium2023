package com.example.vebdentalcare;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

public class ImplantActivity extends Activity {
    private ListView listViewPatients;
    private PatientAdapter adapter;
    private TableLayout tableLayout;
    TextView firstName,lastName,dob,gender,reportDate;
   // private SQLiteDatabase mDatabase;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.implant);
        //Toast.makeText(this, "Mobile No is " + searchTextView.getText().toString(), Toast.LENGTH_LONG).show();
        tableLayout=(TableLayout)findViewById(R.id.implantLayout);
        showPatientsFromDatabase();

    }

    private void showPatientsFromDatabase() {
        //opening the database
        SQLiteDatabase database = new SampleSQLiteDBHelper(this).getReadableDatabase();


       /* firstName=(TextView) findViewById(R.id.firstName);
         lastName=(TextView) findViewById(R.id.lastName);
         dob=(TextView) findViewById(R.id.dob);
         gender=(TextView) findViewById(R.id.gender);
        //imageName=(TextView) findViewById(R.id.imageName);
        // treatments=(TextView) findViewById(R.id.treatments);
         reportDate=(TextView) findViewById(R.id.reportDate);*/
       // Cursor cursorPatients = database.rawQuery("select  * from "+"VEB_CASE_HISTORY"+" where "+"TREATMENT_LIST"+" LIKE \"%RPD%\" ", new String[]{});

        String[] selectionArgs = new String[] { "%Implant%"};
        Cursor cursorPatients = database.rawQuery("Select * from VEB_CASE_HISTORY where TREATMENT_LIST LIKE ? ", selectionArgs);

        //Toast.makeText(RPDActivity.this,cursorPatients.getCount(),Toast.LENGTH_SHORT).show();
        Toast.makeText(ImplantActivity.this,"Outside Cursor",Toast.LENGTH_SHORT).show();

       if (cursorPatients.moveToFirst()) {
           Toast.makeText(ImplantActivity.this,"Inside Cursor",Toast.LENGTH_SHORT).show();

           do {

               Toast.makeText(ImplantActivity.this,"Inside do",Toast.LENGTH_SHORT).show();
               View tableRow = LayoutInflater.from(this).inflate(R.layout.table_item, null, false);
               firstName = (TextView) tableRow.findViewById(R.id.firstName);
               lastName = (TextView) tableRow.findViewById(R.id.lastName);
               dob = (TextView) tableRow.findViewById(R.id.dob);
               gender = (TextView) tableRow.findViewById(R.id.gender);
               reportDate = (TextView) tableRow.findViewById(R.id.reportDate);


               //cursorPatients .getString(1),
               firstName.setText(cursorPatients.getString(1));
               lastName.setText(cursorPatients.getString(2));
               dob.setText(cursorPatients.getString(3));
               gender.setText(cursorPatients.getString(5));

               reportDate.setText(cursorPatients.getString(8));
               tableLayout.addView(tableRow);

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
           } while (cursorPatients.moveToNext());
       }
            //closing the cursor
            cursorPatients.close();


    }
    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(ImplantActivity.this, PatientMenuActivity.class));
        finish();
        super.onBackPressed();
    }

}
