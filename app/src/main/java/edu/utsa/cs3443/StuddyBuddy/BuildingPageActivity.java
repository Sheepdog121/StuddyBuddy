package edu.utsa.cs3443.StuddyBuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import edu.utsa.cs3443.StuddyBuddy.model.Building;
import edu.utsa.cs3443.StuddyBuddy.model.GeneralStudies;
import edu.utsa.cs3443.StuddyBuddy.model.StudySpot;

public class BuildingPageActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     *      Attributes
     */
    GeneralStudies studies;
    private String buildingName;
    private final static String key1 = "spotName_name";
    private final static String key2 = "desc1_name";
    private final static String key3 = "desc2_name";
    private final static String key4 = "location_name";
    private final static String key5 = "image_name";


    /**
     *      createStudies
     */
    public void createStudies(){
        studies = new GeneralStudies();
        studies.loadSpots(this, "buildingsandspots.csv");
    }

    /**
     *      displayInfo
     * @param buildingName
     */
    public void displayInfo(String buildingName){
        Building currBuild = null;
        int count = 1;

        for (Building b : studies.getBuildings()){
            if (b.getName().equals(buildingName)){
                currBuild = b;
            }
        }

        TextView buildingNameText = findViewById(R.id.building_text);
        buildingNameText.setText(buildingName);

        //FIXME: this is where we will set the image for the building
        ImageView imageBuild = (ImageView) findViewById(R.id.myImage);
        int imageRes = getResources().getIdentifier(currBuild.getBuildImage(), "drawable", getPackageName());
        imageBuild.setImageResource(imageRes);

        TextView desc1Text = findViewById(R.id.desc1_text);
        desc1Text.setText(currBuild.getDesc1());


        TextView desc2Text = findViewById(R.id.desc2_text);
        desc2Text.setText(currBuild.getDesc2());

        TextView desc3Text = findViewById(R.id.desc3_text);
        desc3Text.setText(currBuild.getDesc3());

        for (StudySpot s : currBuild.getSpots()){   //will only account for 3 spots right now
            if (count == 1){
                count++;
                TextView firstSpot = findViewById(R.id.spot1_text);
                firstSpot.setText(s.getName());
            }
            else if (count == 2){
                count++;
                TextView secondSpot = findViewById(R.id.spot2_text);
                secondSpot.setText(s.getName());
            }
            else if (count == 3){   //if more spots added, need to add count++ below
                TextView thirdSpot = findViewById(R.id.spot3_text);
                thirdSpot.setText(s.getName());
            }
        }
    }


    public void setupButton(int buttonID){
        Button button = findViewById(buttonID);
        button.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_page);

        createStudies();

        setupButton(R.id.spot1Link_button);
        setupButton(R.id.spot2Link_button);
        setupButton(R.id.spot3Link_button);

        if (savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if (extras == null){
                buildingName = null;
            }
            else{
                buildingName = extras.getString("building_name");
            }
        }
        else{
            buildingName = (String) savedInstanceState.getSerializable("building_name");
        }

        displayInfo(buildingName);
    }


    public void onClick(View view){
        Button clickedButton;
        StudySpot currSpot;

        if (view.getId() == R.id.spot1Link_button){
            clickedButton = (Button) view;
            currSpot = studies.getSpot(buildingName, 0);
            Intent intent = new Intent(this, SpotsActivity.class);
            intent.putExtra(key1, currSpot.getName());
            intent.putExtra(key2, currSpot.getDesc1());
            intent.putExtra(key3, currSpot.getDesc2());
            intent.putExtra(key4, currSpot.getLocation());
            intent.putExtra(key5, currSpot.getImage());
            startActivity(intent);
        }
        else if (view.getId() == R.id.spot2Link_button){
            clickedButton = (Button) view;
            currSpot = studies.getSpot(buildingName, 1);
            Intent intent = new Intent(this, SpotsActivity.class);
            intent.putExtra(key1, currSpot.getName());
            intent.putExtra(key2, currSpot.getDesc1());
            intent.putExtra(key3, currSpot.getDesc2());
            intent.putExtra(key4, currSpot.getLocation());
            intent.putExtra(key5, currSpot.getImage());
            startActivity(intent);
        }
        else if (view.getId() == R.id.spot3Link_button){
            clickedButton = (Button) view;
            currSpot = studies.getSpot(buildingName, 2);
            Intent intent = new Intent(this, SpotsActivity.class);
            intent.putExtra(key1, currSpot.getName());
            intent.putExtra(key2, currSpot.getDesc1());
            intent.putExtra(key3, currSpot.getDesc2());
            intent.putExtra(key4, currSpot.getLocation());
            intent.putExtra(key5, currSpot.getImage());
            startActivity(intent);
        }
    }
}