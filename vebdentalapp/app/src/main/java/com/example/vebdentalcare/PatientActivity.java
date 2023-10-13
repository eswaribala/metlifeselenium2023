package com.example.vebdentalcare;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.provider.Settings;

import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

public class PatientActivity extends AppCompatActivity {
    final Calendar myCalendar = Calendar.getInstance();
    private MultiSelectionSpinner  treatmentSpinner;
    Button btnDOB, genderButton,btnsave,btnChecked;
    DatePickerDialog picker;
    ImageButton takePictureButton;
    ImageButton launch;
    ImageView imageView;
    String userChoosenTask;
    public static String selectedNames;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    Button btnGPSShowLocation;
    Button btnShowAddress,btnDisplay;
    TextView tvAddress;
    protected LocationManager locationManager;
    private final static int DISTANCE_UPDATES = 1;
    private final static int TIME_UPDATES = 1;
    Location location;
    private boolean LocationAvailable;
    AppLocationService appLocationService;
    private static final int PERMISSION_REQUEST_CODE = 1;
    private TextView firstName;
    private TextView lastName;
    private TextView dob;
    private TextView age;
    private TextView mobileNo;
    private RadioGroup radioGroup;
    private File destination;
    private   MenuInflater menuInflater;
    private LinearLayout linearLayout;
    private EditText etDOB;
    private ArrayAdapter<String> adapter;
    private  ListView listView;
    public static ArrayList<String> selectedItems=new ArrayList<String>();
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //View view = this.getWindow().getDecorView();
        //view.setBackgroundColor(Color.BLUE);

        firstName=(TextView) findViewById(R.id.txtfirstName);
        lastName=(TextView) findViewById(R.id.txtlastName);
        //age= (TextView) findViewById(R.id.txtAge);
        dob=(TextView)findViewById(R.id.editDOB);
        age=(TextView)findViewById(R.id.txtAge);
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
                picker = new DatePickerDialog(PatientActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                etDOB.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

       /* btnDOB=(Button)findViewById(R.id.btnDOB);
        btnDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dob.setText(etDOB.getText());
            }
        });
*/
        mobileNo=(TextView) findViewById(R.id.txtMobileNo);


        String regex = "\\d{10}";
        //Creating a pattern object
        final Pattern pattern = Pattern.compile(regex);
        mobileNo .addTextChangedListener(new TextWatcher() {
            String mno = mobileNo.getText().toString().trim();
            public void afterTextChanged(Editable s) {

                if (pattern.matcher(mno).matches() && s.length() > 0)
                {
                    Toast.makeText(getApplicationContext(),"valid mobile no",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid mobile no",Toast.LENGTH_SHORT).show();
                    //or
                    //mobileNo.setText("invalid mobi");
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // other stuffs
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // other stuffs
            }
        });



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
        // imageView = (ImageView) findViewById(R.id.imageview);


        //tvAddress = (TextView) findViewById(R.id.tvAddress);
        /*
        appLocationService = new AppLocationService(
                MainActivity.this);

        btnGPSShowLocation = (Button) findViewById(R.id.btnGPSShowLocation);
        btnGPSShowLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {


                Location gpsLocation = appLocationService
                        .getLocation(LocationManager.GPS_PROVIDER);
                if (gpsLocation != null) {
                    double latitude = gpsLocation.getLatitude();
                    double longitude = gpsLocation.getLongitude();
                    String result = "Latitude: " + gpsLocation.getLatitude() +
                            " Longitude: " + gpsLocation.getLongitude();
                    tvAddress.setText(result);
                } else {
                    showSettingsAlert();
                }


            }

        });

        btnShowAddress = (Button) findViewById(R.id.btnShowAddress);
        btnShowAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Location location = appLocationService
                        .getLocation(GPS_PROVIDER);

                //you can hard-code the lat & long if you have issues with getting it
                //remove the below if-condition and use the following couple of lines
                //double latitude = 37.422005;
                //double longitude = -122.084095

                if (location != null) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    LocationAddress locationAddress = new LocationAddress();
                    locationAddress.getAddressFromLocation(latitude, longitude,
                            getApplicationContext(), new GeocoderHandler());
                } else {
                    showSettingsAlert();
                }

            }
        });

*/
        /*findViewsById();
        String[] treatments = getResources().getStringArray(R.array.treatment_array);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, treatments);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

        btnChecked.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                SparseBooleanArray checked = listView.getCheckedItemPositions();
                ArrayList<String> selectedItems = new ArrayList<String>();
                for (int i = 0; i < checked.size(); i++) {
                    // Item position in adapter
                    int position = checked.keyAt(i);
                    // Add sport if it is checked i.e.) == TRUE!
                    if (checked.valueAt(i))
                        selectedItems.add(adapter.getItem(position));
                }

                String[] outputStrArr = new String[selectedItems.size()];

                for (int i = 0; i < selectedItems.size(); i++) {
                    outputStrArr[i] = selectedItems.get(i);
                }

                Intent intent = new Intent(getApplicationContext(),
                        PatientActivity.class);

                // Create a bundle object
                Bundle b = new Bundle();
                b.putStringArray("selectedItems", outputStrArr);

                // Add the bundle to the intent.
                intent.putExtras(b);

                // start the ResultActivity
                startActivity(intent);
            }
        });*/
        addListenerOnButton();
        btnsave.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                saveToDB();
            }
        });

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

        treatmentSpinner = (MultiSelectionSpinner) findViewById(R.id.treatmentSpinner);
        treatmentSpinner.setItems(items);

        /*btnChecked = (Button) findViewById(R.id.btnChecked);

        btnChecked.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

              Toast.makeText(PatientActivity.this,treatmentSpinner.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
            }

        });*/
    }

    // Initiating Menu XML file (menu.xml)
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout, menu);
        return true;
    }


    /**
     * Event Handling for Individual menu item selected
     * Identify single menu item by it's id
     * */

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId())
        {

            case R.id.menu_save:
                Toast.makeText(PatientActivity.this, "Save is Selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_search:
                Toast.makeText(PatientActivity.this, "Search is Selected", Toast.LENGTH_SHORT).show();
                // Start PatientDetails.class
                startActivity(new Intent(this, PatientDetails.class));
                return true;


            case R.id.menu_delete:
                Toast.makeText(PatientActivity.this, "Delete is Selected", Toast.LENGTH_SHORT).show();
                return true;



            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case Utility.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(userChoosenTask.equals("Take Photo"))
                        cameraIntent();
                    else if(userChoosenTask.equals("Choose from Library"))
                        galleryIntent();
                } else {
                    //code for deny
                }
                break;


        }
    }
    public boolean isValidPhone(CharSequence phone) {
        if (TextUtils.isEmpty(phone)) {
            return false;
        } else {
            return android.util.Patterns.PHONE.matcher(phone).matches();
        }
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

                SQLiteDatabase database = new SampleSQLiteDBHelper(PatientActivity.this).getWritableDatabase();
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


                values.put(SampleSQLiteDBHelper.CASE_HISTORY_MOBILENO,Long.parseLong(mobileNo.getText().toString()));
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
                long newRowId = database.insert(SampleSQLiteDBHelper.CASE_HISTORY_TABLE_NAME, null, values);
                firstName.setText("");
                lastName.setText("");
                etDOB.setText("");
                mobileNo.setText("");
                genderButton.setText("");


                Toast.makeText(PatientActivity.this, "Record Added and id is " + newRowId, Toast.LENGTH_LONG).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        PatientActivity.this.finish();
                    }
                }, 2000);
                startActivity(new Intent(PatientActivity.this, PatientMenuActivity.class));
                // Do nothing
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
    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose from Library",
                "Cancel" };

        AlertDialog.Builder builder = new AlertDialog.Builder(PatientActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result=Utility.checkPermission(PatientActivity.this);

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

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        btnDOB.setText(sdf.format(myCalendar.getTime()));
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
        int result = ContextCompat.checkSelfPermission(PatientActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(PatientActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(PatientActivity.this, "Write External Storage permission allows us to save files. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(PatientActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
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


    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                PatientActivity.this);
        alertDialog.setTitle("SETTINGS");
        alertDialog.setMessage("Enable Location Provider! Go to settings menu?");
        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        PatientActivity.this.startActivity(intent);
                    }
                });
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    }

    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }
            tvAddress.setText(locationAddress);
        }
    }

    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(PatientActivity.this, PatientMenuActivity.class));
        finish();
        super.onBackPressed();
    }


   /* private void findViewsById() {
        listView = (ListView) findViewById(R.id.lvMain);
        btnChecked = (Button) findViewById(R.id.btnChecked);
    }*/


/*
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {

        }
    }
*/


}

