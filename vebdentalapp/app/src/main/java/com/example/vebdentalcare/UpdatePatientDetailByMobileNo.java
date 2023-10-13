package com.example.vebdentalcare;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class UpdatePatientDetailByMobileNo extends Activity {
    private ListView listViewPatients;
    private PatientAdapter adapter;
    Button btnDOB, genderButton,btnsave,btnChecked;
    private MultiSelectionSpinnerUpdate  treatmentSpinner;
    private Button btnSearch;
    TextView searchTextView;
    private RadioGroup radioGroup;
    private static final int PERMISSION_REQUEST_CODE = 1;
    TextView firstName,lastName,txtMobileNo,dob,gender,imageName,treatments,reportDate,age;
    EditText etDOB;
    DatePickerDialog picker;
    ImageButton takePictureButton;
    ImageButton launch;
    ImageView imageView;
    String userChoosenTask;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    private File destination;
    public static ArrayList<String> selectedItems=new ArrayList<String>();
   private SQLiteDatabase database;
   private static String[] PERMISSIONS_STORAGE = {
           Manifest.permission.READ_EXTERNAL_STORAGE,
           Manifest.permission.WRITE_EXTERNAL_STORAGE
   };
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatelayout);
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
       database = new SampleSQLiteDBHelper(this).getReadableDatabase();


        firstName=(TextView) findViewById(R.id.txtfirstName);
         lastName=(TextView) findViewById(R.id.txtlastName);
         txtMobileNo=(TextView) findViewById(R.id.txtMobileNo);
         dob=(TextView) findViewById(R.id.editDOB);
        etDOB=(EditText) findViewById(R.id.editDOB);
        etDOB.setInputType(InputType.TYPE_NULL);
        etDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(UpdatePatientDetailByMobileNo.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                etDOB.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        age=(TextView) findViewById(R.id.txtAge);
        btnsave=(Button) findViewById(R.id.btnsave);
        radioGroup = (RadioGroup) findViewById(R.id.prefgroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                genderButton = (RadioButton) findViewById(checkedId);
                Toast.makeText(getBaseContext(),genderButton.getText(), Toast.LENGTH_SHORT).show();

            }
        });
        takePictureButton = (ImageButton) findViewById(R.id.btnphoto);
        imageView = (ImageView) findViewById(R.id.imageview);

        //takePictureButton = (Button) findViewById(R.id.btnphoto);
        takePictureButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                selectImage();
            }
        });

        Cursor cursorPatients = database.rawQuery("SELECT * FROM VEB_CASE_HISTORY WHERE MOBILE_NO = ? ", new String[] { String.valueOf(mobileNo) });
        Toast.makeText(this, "Mobile No is " + mobileNo, Toast.LENGTH_LONG).show();

        //if the cursor has some data
        if (cursorPatients.moveToFirst()) {



                        //cursorPatients .getString(1),
                    firstName.setText(cursorPatients .getString(1));
                    lastName.setText(cursorPatients .getString(2));
                   //dob.setText(cursorPatients.getString(3));
                   age.setText(cursorPatients.getString(4));
                     //gender.setText(cursorPatients .getString(6));
                    // treatments.setText(cursorPatients .getString(8));
                      //  reportDate.setText(cursorPatients .getString(9));


            /*try {
                File file=new File(cursorPatients .getString(7));
                Bitmap bitMap = BitmapFactory.decodeStream(new FileInputStream(file));
                ImageView img=(ImageView)findViewById(R.id.imageView);
                img.setImageBitmap(bitMap);
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }*/




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
        cursorPatients.close();
addListenerOnButton();
        btnsave.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                saveToDB();
            }
        });

        //closing the cursor




    }
    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(UpdatePatientDetailByMobileNo.this, PatientMenuActivity.class));
        finish();
        super.onBackPressed();
    }
    private void saveToDB() {
        //selectedItems = treatmentSpinner.getSelectedItems();
        // Toast.makeText(PatientActivity.this,treatmentSpinner.getSelectedItems().size(),Toast.LENGTH_SHORT).show();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Confirm");
        builder.setMessage("Are you sure?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // Do nothing but close the dialog

                dialog.dismiss();

               database = new SampleSQLiteDBHelper(UpdatePatientDetailByMobileNo.this).getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(SampleSQLiteDBHelper.CASE_HISTORY_FIRST_NAME, firstName.getText().toString());
                if(lastName==null)
                    values.put(SampleSQLiteDBHelper.CASE_HISTORY_LAST_NAME, "");
                else
                    values.put(SampleSQLiteDBHelper.CASE_HISTORY_LAST_NAME, lastName.getText().toString());
                if(dob==null)
                    values.put(SampleSQLiteDBHelper.CASE_HISTORY_DOB, "");
                else
                    values.put(SampleSQLiteDBHelper.CASE_HISTORY_DOB,dob.getText().toString());

                if(age==null)
                    values.put(SampleSQLiteDBHelper.CASE_HISTORY_AGE, "");
                else
                    values.put(SampleSQLiteDBHelper.CASE_HISTORY_AGE,age.getText().toString());


                //values.put(SampleSQLiteDBHelper.CASE_HISTORY_MOBILENO,Long.parseLong(txtMobileNo.getText().toString()));
                if(destination==null)
                    values.put(SampleSQLiteDBHelper.CASE_HISTORY_PHOTO, "");
                else
                    values.put(SampleSQLiteDBHelper.CASE_HISTORY_PHOTO, destination.getAbsolutePath());
                values.put(SampleSQLiteDBHelper.CASE_HISTORY_GENDER,genderButton.getText().toString());
                String treatments="";

                for(String value : selectedItems)
                {
                    treatments+=value+",";
                }

                values.put(SampleSQLiteDBHelper.CASE_TREATMENT_DONE,treatments);
                values.put(SampleSQLiteDBHelper.CASE_REPORT_DATE,getDateTime());
               // long newRowId = database.insert(SampleSQLiteDBHelper.CASE_HISTORY_TABLE_NAME, null, values);

               database.update(SampleSQLiteDBHelper.CASE_HISTORY_TABLE_NAME, values, SampleSQLiteDBHelper.CASE_HISTORY_MOBILENO + "=" + Long.parseLong(txtMobileNo.getText().toString()), null);

                firstName.setText("");
                lastName.setText("");
                etDOB.setText("");
                txtMobileNo.setText("");
                genderButton.setText("");


                Toast.makeText(UpdatePatientDetailByMobileNo.this, "Record Updated", Toast.LENGTH_LONG).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        UpdatePatientDetailByMobileNo.this.finish();
                    }
                }, 2000);
                startActivity(new Intent(UpdatePatientDetailByMobileNo.this, PatientMenuActivity.class));
                // Do nothing*/
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {


                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();




    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }


    // get the selected dropdown list value
    public void addListenerOnButton() {


        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Impacted",true));
        items.add(new Item("Extraction Generic List",true));
        items.add(new Item("Silver Amalgam",true));
        items.add(new Item("GIC",true));
        items.add(new Item("Composite",true));
        items.add(new Item("Gold",true));
        items.add(new Item("Filling Generic List",true));
        items.add(new Item("CD",true));
        items.add(new Item("RCTANT Metal Crown",true));
        items.add(new Item("RCTANT Metal Ceramic Crown",true));
        items.add(new Item("RCTANT Ceramic Crown",true));
        items.add(new Item("RCTPOST Metal Crown",true));
        items.add(new Item("RCTPOST Metal Ceramic Crown",true));
        items.add(new Item("RCTPOST Ceramic Crown",true));
        items.add(new Item("RPD",true));
        items.add(new Item("Implant",true));
        items.add(new Item("Oral Profile Access",true));
        items.add(new Item("Ortho",true));

        //items.add(Item.builder().name('Item 2').value('item-2').build());
        //items.add(Item.builder().name('Item 3').value('item-3').build());

        treatmentSpinner = (MultiSelectionSpinnerUpdate) findViewById(R.id.treatmentSpinner);
        treatmentSpinner.setItems(items);

        /*btnChecked = (Button) findViewById(R.id.btnChecked);

        btnChecked.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

              Toast.makeText(PatientActivity.this,treatmentSpinner.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
            }

        });*/
    }
    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose from Library",
                "Cancel" };

        AlertDialog.Builder builder = new AlertDialog.Builder(UpdatePatientDetailByMobileNo.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result=Utility.checkPermission(UpdatePatientDetailByMobileNo.this);

                if (items[item].equals("Take Photo")) {
                    userChoosenTask="Take Photo";
                    if(result)
                        cameraIntent();

                } else if (items[item].equals("Choose from Library")) {
                    userChoosenTask="Choose from Library";
                    if(result)
                        galleryIntent();

                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void cameraIntent()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    private void galleryIntent()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"),SELECT_FILE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
        }
    }

    private void onCaptureImageResult(Intent data) {

        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        /*


        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);

        //destination = new File(Environment.getExternalStorageDirectory(),
        //        System.currentTimeMillis() + ".jpg");

       destination=new File(Environment.getExternalStorageDirectory(),
                      System.currentTimeMillis() + ".jpg");

        Toast.makeText(getBaseContext(),"About to save",Toast.LENGTH_SHORT).show();
        try {
            destination.createNewFile();
            FileOutputStream fo = new FileOutputStream(destination);
            //fo= openFileOutput(file, Context.MODE_PRIVATE);
            fo.write(bytes.toByteArray());
            fo.close();
            Toast.makeText(getBaseContext(),"file saved"+destination.getAbsolutePath(),Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(getBaseContext(),"file not found "+e.getMessage(),Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(getBaseContext(),"file io error"+e.getMessage(),Toast.LENGTH_SHORT).show();
        }
         */
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (checkPermission()) {
                    String path = Environment.getExternalStorageDirectory().toString();
                    destination = new File(path, "P"+System.currentTimeMillis()+".jpg");
                    if (! destination.exists()) {
                        Log.d("path",  destination.toString());
                        try {
                            FileOutputStream fos = new FileOutputStream( destination);
                            thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                            fos.flush();
                            fos.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    requestPermission(); // Code for permission
                }
            } else {
                String path = Environment.getExternalStorageDirectory().toString();
                File file = new File(path, "UniqueFileName"+".jpg");
                if (!file.exists()) {
                    Log.d("path", file.toString());
                    FileOutputStream fos = null;
                    try {
                        fos = new FileOutputStream(file);
                        thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                        fos.flush();
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        imageView.setImageBitmap(thumbnail);
    }


    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(UpdatePatientDetailByMobileNo.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(UpdatePatientDetailByMobileNo.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(UpdatePatientDetailByMobileNo.this, "Write External Storage permission allows us to save files. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(UpdatePatientDetailByMobileNo.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }



    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {

        Bitmap bm=null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        imageView.setImageBitmap(bm);
    }

}
