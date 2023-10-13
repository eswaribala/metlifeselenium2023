package com.example.vebdentalcare;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Text;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PatientAdapter extends ArrayAdapter<Patient> {

    Context mCtx;
    int listLayoutRes;
    List<Patient> patientsList;
    SQLiteDatabase mDatabase;
    public PatientAdapter(@NotNull Context mCtx, int listLayoutRes, List<Patient> patientsList, SQLiteDatabase mDatabase) {
        super(mCtx, listLayoutRes, patientsList);

        this.mCtx = mCtx;
        this.listLayoutRes = listLayoutRes;
        this.patientsList = patientsList;
        this.mDatabase = mDatabase;
    }

    @NotNull
    @Override
    public View getView(int position, @Nullable View convertView, @NotNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(listLayoutRes, null);

        //getting patient of the specified position
        Patient patient = patientsList.get(position);


        //getting views
        TextView firstName = view.findViewById(R.id.txtfirstName);
        TextView lastName = view.findViewById(R.id.txtlastName);
        TextView age = view.findViewById(R.id.txtAge);
        TextView mobileNo=view.findViewById(R.id.txtMobileNo);
        TextView gender = view.findViewById(R.id.txtGender);
        ImageView imgView=view.findViewById(R.id.photo);
        //adding data to views
        firstName.setText(patient.getFirstName());
        lastName.setText(patient.getLastName());
        age.setText(patient.getDob());
        mobileNo.setText(String.valueOf(patient.getMobileNo()));
        gender.setText(patient.getGender());
        /*BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bm = BitmapFactory.decodeFile(patient.getImagePath(), options);
        imgView.setImageBitmap(bm);
        */
        Button buttonDelete = view.findViewById(R.id.btnEditPatient);
        Button buttonEdit = view.findViewById(R.id.btnDeletePatient);

        return view;
    }
}
