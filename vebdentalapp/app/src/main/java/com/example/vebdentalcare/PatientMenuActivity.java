package com.example.vebdentalcare;

import android.app.Activity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;
public class PatientMenuActivity extends Activity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuactivity_main);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);


        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();

                if(listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition).equals("Add Information"))
                {
                    Intent mInHome = new Intent(PatientMenuActivity.this, PatientActivity.class);
                    PatientMenuActivity.this.startActivity(mInHome);
                    PatientMenuActivity.this.finish();
                }

                if(listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition).equals("View Patient By Mobile No"))
                {
                    Intent mInHome = new Intent(PatientMenuActivity.this, PatientDetailById.class);
                    PatientMenuActivity.this.startActivity(mInHome);
                    PatientMenuActivity.this.finish();
                }
                if(listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition).equals("Update Information"))
                {
                    Intent mInHome = new Intent(PatientMenuActivity.this, UpdatePatientDetailByMobileNo.class);
                    PatientMenuActivity.this.startActivity(mInHome);
                    PatientMenuActivity.this.finish();
                }

                if(listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition).equals("RPD LIST"))
                {
                    Intent mInHome = new Intent(PatientMenuActivity.this, RPDActivity.class);
                    PatientMenuActivity.this.startActivity(mInHome);
                    PatientMenuActivity.this.finish();
                }

                if(listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition).equals("CD LIST"))
                {
                    Intent mInHome = new Intent(PatientMenuActivity.this, CDActivity.class);
                    PatientMenuActivity.this.startActivity(mInHome);
                    PatientMenuActivity.this.finish();
                }

                if(listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition).equals("Ortho LIST"))
                {
                    Intent mInHome = new Intent(PatientMenuActivity.this, OrthoActivity.class);
                    PatientMenuActivity.this.startActivity(mInHome);
                    PatientMenuActivity.this.finish();
                }
                if(listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition).equals("Implant LIST"))
                {
                    Intent mInHome = new Intent(PatientMenuActivity.this, ImplantActivity.class);
                    PatientMenuActivity.this.startActivity(mInHome);
                    PatientMenuActivity.this.finish();
                }
                if(listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition).equals("Oral Profile Access LIST"))
                {
                    Intent mInHome = new Intent(PatientMenuActivity.this, OralProfileAccessActivity.class);
                    PatientMenuActivity.this.startActivity(mInHome);
                    PatientMenuActivity.this.finish();
                }

                if(listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition).equals("Impacted"))
                {
                    Intent mInHome = new Intent(PatientMenuActivity.this, ImpactedActivity.class);
                    PatientMenuActivity.this.startActivity(mInHome);
                    PatientMenuActivity.this.finish();
                }

                if(listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition).equals("Extraction Generic List"))
                {
                    Intent mInHome = new Intent(PatientMenuActivity.this, ExtractionGenericActivity.class);
                    PatientMenuActivity.this.startActivity(mInHome);
                    PatientMenuActivity.this.finish();
                }

                if(listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition).equals("Silver Amalgam"))
                {
                    Intent mInHome = new Intent(PatientMenuActivity.this, SilverAmalgamActivity.class);
                    PatientMenuActivity.this.startActivity(mInHome);
                    PatientMenuActivity.this.finish();
                }
                if(listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition).equals("Gold"))
                {
                    Intent mInHome = new Intent(PatientMenuActivity.this, GoldActivity.class);
                    PatientMenuActivity.this.startActivity(mInHome);
                    PatientMenuActivity.this.finish();
                }
                if(listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition).equals("Composite"))
                {
                    Intent mInHome = new Intent(PatientMenuActivity.this, CompositeActivity.class);
                    PatientMenuActivity.this.startActivity(mInHome);
                    PatientMenuActivity.this.finish();
                }

                if(listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition).equals("GIC"))
                {
                    Intent mInHome = new Intent(PatientMenuActivity.this, GICActivity.class);
                    PatientMenuActivity.this.startActivity(mInHome);
                    PatientMenuActivity.this.finish();
                }

                if(listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition).equals("Filling Generic List"))
                {
                    Intent mInHome = new Intent(PatientMenuActivity.this, FillingGenericActivity.class);
                    PatientMenuActivity.this.startActivity(mInHome);
                    PatientMenuActivity.this.finish();
                }
                if(listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition).equals("RCT ANT Metal Crown"))
                {
                    Intent mInHome = new Intent(PatientMenuActivity.this, RCTAMetalCrownActivity.class);
                    PatientMenuActivity.this.startActivity(mInHome);
                    PatientMenuActivity.this.finish();
                }

                if(listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition).equals("RCT ANT Ceramic Metal Crown"))
                {
                    Intent mInHome = new Intent(PatientMenuActivity.this, RCTAMetalCeramicCrownActivity.class);
                    PatientMenuActivity.this.startActivity(mInHome);
                    PatientMenuActivity.this.finish();
                }


                if(listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition).equals("RCT ANT Ceramic Crown"))
                {
                    Intent mInHome = new Intent(PatientMenuActivity.this, RCTACeramicCrownActivity.class);
                    PatientMenuActivity.this.startActivity(mInHome);
                    PatientMenuActivity.this.finish();
                }

                if(listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition).equals("RCT POST Metal Crown"))
                {
                    Intent mInHome = new Intent(PatientMenuActivity.this, RCTPMetalCrownActivity.class);
                    PatientMenuActivity.this.startActivity(mInHome);
                    PatientMenuActivity.this.finish();
                }

                if(listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition).equals("RCT POST Ceramic Metal Crown"))
                {
                    Intent mInHome = new Intent(PatientMenuActivity.this, RCTPMetalCeramicCrownActivity.class);
                    PatientMenuActivity.this.startActivity(mInHome);
                    PatientMenuActivity.this.finish();
                }


                if(listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition).equals("RCT POST Ceramic Crown"))
                {
                    Intent mInHome = new Intent(PatientMenuActivity.this, RCTPCeramicCrownActivity.class);
                    PatientMenuActivity.this.startActivity(mInHome);
                    PatientMenuActivity.this.finish();
                }

                /*if(listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition).equals("Firebase Backup"))
                {
                    Intent mInHome = new Intent(PatientMenuActivity.this, BackupActivity.class);
                    PatientMenuActivity.this.startActivity(mInHome);
                    PatientMenuActivity.this.finish();
                }*/
                return false;
            }
        });
    }




    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Patient");
        listDataHeader.add("Extractions");
        listDataHeader.add("Fillings");
        listDataHeader.add("RCT Anterior");
        listDataHeader.add("RCT Posterior");
        listDataHeader.add("RPD");
        listDataHeader.add("Implant");
        listDataHeader.add("CD");
        listDataHeader.add("Oral Profile Access");
        listDataHeader.add("Ortho");
        listDataHeader.add("Backup");
        listDataHeader.add("Restore");

        // Adding child data
        List<String> patientList = new ArrayList<String>();
        patientList.add("Add Information");
        patientList.add("Update Information");
        patientList.add("Remove Information");
        patientList.add("View Patient By Mobile No");


        List<String> extractionsList = new ArrayList<String>();
        extractionsList.add("Impacted");
        extractionsList.add("Extraction Generic List");

        List<String> fillingsList = new ArrayList<String>();
        fillingsList.add("Silver Amalgam");
        fillingsList.add("GIC");
        fillingsList.add("Composite");
        fillingsList.add("Gold");
        fillingsList.add("Filling Generic List");

        List<String> rctAnteriorList = new ArrayList<String>();
        rctAnteriorList.add("RCT ANT Metal Crown");
        rctAnteriorList.add("RCT ANT Metal Ceramic Crown");
        rctAnteriorList.add("RCT ANT Ceramic Crown");

        List<String> rctPosteriorList = new ArrayList<String>();
        rctPosteriorList.add("RCT POST Metal Crown");
        rctPosteriorList.add("RCT POST Metal Ceramic Crown");
        rctPosteriorList.add("RCT POST Ceramic Crown");

        List<String> rpdList = new ArrayList<String>();
        rpdList.add("RPD LIST");

        List<String> implantList = new ArrayList<String>();
        implantList.add("Implant LIST");

        List<String> cdList = new ArrayList<String>();
        cdList.add("CD LIST");

        List<String> oralMedicineList = new ArrayList<String>();
        oralMedicineList.add("Oral Profile Access LIST");

        List<String> orthoList = new ArrayList<String>();
        orthoList.add("Ortho LIST");

        List<String> backupList = new ArrayList<String>();
        orthoList.add("Firebase Backup");

        List<String> restoreList = new ArrayList<String>();
        orthoList.add("Firebase Restore");



        listDataChild.put(listDataHeader.get(0), patientList);
        listDataChild.put(listDataHeader.get(1), extractionsList); // Header, Child data
        listDataChild.put(listDataHeader.get(2), fillingsList);
        listDataChild.put(listDataHeader.get(3), rctAnteriorList);
        listDataChild.put(listDataHeader.get(4), rctPosteriorList);
        listDataChild.put(listDataHeader.get(5), rpdList);
        listDataChild.put(listDataHeader.get(6), implantList);
        listDataChild.put(listDataHeader.get(7), cdList);
        listDataChild.put(listDataHeader.get(8), oralMedicineList);
        listDataChild.put(listDataHeader.get(9), orthoList);
        listDataChild.put(listDataHeader.get(10), backupList);
        listDataChild.put(listDataHeader.get(11), restoreList);

    }
    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(PatientMenuActivity.this, MainActivity.class));
        finish();
        super.onBackPressed();
    }

}