package edu.utsa.cs3443.StuddyBuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SpotsActivity extends AppCompatActivity implements View.OnClickListener{

    /**
     *      Attributes
     */
    private String spotName;
    private String desc1;
    private String desc2;
    private String location;
    private String spotImage;

    public void displayInfo(String spotName, String desc1, String desc2, String location, String spotImage){
        TextView name = findViewById(R.id.spotname_text);
        name.setText(spotName);

        ImageView image = (ImageView) findViewById(R.id.spotImage);
        int imageRes = getResources().getIdentifier(spotImage, "drawable", getPackageName());
        image.setImageResource(imageRes);

        TextView loc = findViewById(R.id.location_text);
        loc.setText(location);

        TextView firstDesc = findViewById(R.id.spotDesc1_text);
        firstDesc.setText(desc1);

        TextView secondDesc = findViewById(R.id.spotDesc2_text);
        secondDesc.setText(desc2);


    }

    /**
     * setupImageButton
     *
     * @param buttonID
     */
    private void setupImageButton(int buttonID){    //sets up Image Button
        ImageButton image = findViewById(buttonID);
        image.setOnClickListener(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spots);

        setupImageButton(R.id.homepage_button);

        if (savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if (extras == null){
                spotName = null;
                desc1 = null;
                desc2 = null;
                location = null;
                spotImage = null;
            }
            else{
                spotName = extras.getString("spotName_name");
                desc1 = extras.getString("desc1_name");
                desc2 = extras.getString("desc2_name");
                location = extras.getString("location_name");
                spotImage = extras.getString("image_name");
            }
        }
        else{
            spotName = (String) savedInstanceState.getSerializable("spotName_name");
            desc1 = (String) savedInstanceState.getSerializable("desc1_name");
            desc2 = (String) savedInstanceState.getSerializable("desc2_name");
            location = (String) savedInstanceState.getSerializable("location_name");
            spotImage = (String) savedInstanceState.getSerializable("image_name");
        }

        displayInfo(spotName, desc1, desc2, location, spotImage);
    }

    @Override
    public void onClick(View view){

        if (view.getId() == R.id.homepage_button){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}