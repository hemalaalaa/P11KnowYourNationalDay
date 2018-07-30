package com.example.a16022706.p11_knowyournationalday;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> al;
    ArrayAdapter<String> aa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        lv = (ListView)findViewById(R.id.lvThemeSG);

        al = new ArrayList<String>();
        al.add("Singapore National Day is on 9 Aug");
        al.add("Singapore is 52 years old");
        al.add("Theme is '#OneNationTogether'");


        aa = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String selectedYear = al.get(position);
//
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                intent.putExtra("year", selectedYear);
//                startActivity(intent);

            }
        });
    }




    @Override
    public void onResume() {
        super.onResume();


//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
//
//        String strName= prefs.getString("name","John");
//        Float gpa= prefs.getFloat("gpa",0);
//        int intGender= prefs.getInt("gender",R.id.radioButtonGenderMale);
//
//        etName.setText(strName);
//        etGPA.setText(gpa+"");
//        rgGender.check(intGender);


        LayoutInflater inflater = (LayoutInflater)
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout accessLayout =
                (LinearLayout) inflater.inflate(R.layout.access_code, null);
        final EditText etAccessCode = (EditText) accessLayout
                .findViewById(R.id.editTextAccessCode);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Access Code")


                .setView(accessLayout)
                .setCancelable(false)


                .setNegativeButton("NO ACCESS CODE",  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        finish();


                    }
                })


                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {


                        int code = Integer.parseInt(etAccessCode.getText().toString());
                        if (code == 738964) {

                        } else {
                            finish();

                        }
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        String strName = et.getText().toString();
//        float gpa = Float.valueOf(etGPA.getText().toString());
//        int intGender = rgGender.getCheckedRadioButtonId();
//
//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
//
//
//        SharedPreferences.Editor preEdit = prefs.edit();
//
//        preEdit.putString("name", strName);
//        preEdit.putFloat("gpa", gpa);
//        preEdit.putInt("gender", intGender);
//
//
//        preEdit.commit();
//
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Tally against the respective action item clicked
        //  and implement the appropriate action
        if (item.getItemId() == R.id.quit) {


            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Quit?")
                    // Set text for the positive button and the corresponding
                    //  OnClickListener when it is clicked
                    .setPositiveButton("QUIT", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(MainActivity.this, "You clicked QUIT",
                                    Toast.LENGTH_LONG).show();

                            finish();
                        }


                    })
                    // Set text for the negative button and the corresponding
                    //  OnClickListener when it is clicked
                    .setNegativeButton("NOT REALLY", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(MainActivity.this, "You clicked NOT REALLY",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
            // Create the AlertDialog object and return it
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        } else if (item.getItemId() == R.id.sendFriend) {

            String[] list = new String[]{"Email", "SMS"};

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Select the way to enrich your friend")
                    // Set the list of items easily by just supplying an
                    //  array of the items
                    .setItems(list, new DialogInterface.OnClickListener() {
                        // The parameter "which" is the item index
                        // clicked, starting from 0
                        public void onClick(DialogInterface dialog, int which) {
                            if (which == 0) {


                                Snackbar sb = Snackbar.make(getWindow().getDecorView().getRootView(), "You're using Email to send ", Snackbar.LENGTH_LONG);


                                sb.setAction("Send Email", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(MainActivity.this, "Missed me?", 				Toast.LENGTH_SHORT).show();
                                    }
                                });

                                sb.show();
                            } else {


                                Snackbar sb = Snackbar.make(getWindow().getDecorView().getRootView(), "You're using SMS to send ", Snackbar.LENGTH_LONG);


                                sb.setAction("Send SMS", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        Intent email = new Intent(Intent.ACTION_SEND);
                                        email.putExtra(Intent.EXTRA_EMAIL,
                                                new String[]{"jason_lim@rp.edu.sg"});
                                        email.putExtra(Intent.EXTRA_SUBJECT,
                                                "Test Email from C347");
                                        email.putExtra(Intent.EXTRA_TEXT,
                                                "HI");
                                        email.setType("message/rfc822");
                                        startActivity(Intent.createChooser(email,
                                                "Choose an Email client :"));
                                        Toast.makeText(MainActivity.this, "Missed me?", Toast.LENGTH_SHORT).show();
                                    }
                                });

                                sb.show();

                            }
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        }
        return super.onOptionsItemSelected(item);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return true;

    }
}
