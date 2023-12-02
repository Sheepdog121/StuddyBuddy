package edu.utsa.cs3443.StuddyBuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.utsa.cs3443.StuddyBuddy.model.GeneralStudies;

public class InteractiveMap extends AppCompatActivity implements View.OnClickListener {

    private static final String key1 = "building_name";

    /**
     *      setupButton
     * @param buttonID
     */
    public void setupButton(int buttonID){
        Button button = findViewById(buttonID);
        button.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interactive_map);


        setupButton(R.id.IMBB_name);
        setupButton(R.id.IMJPL_name);
        setupButton(R.id.IMMH_name);
        setupButton(R.id.IMMS_name);
        setupButton(R.id.IMNPB_name);
        setupButton(R.id.IMSEB_name);
        setupButton(R.id.IMStudentUnion_name);
    }

    @Override
    public void onClick(View view){
        Button clickedButton;
        String chosenBuilding = "";

        if (view.getId() == R.id.IMBB_name){
            clickedButton = (Button) view;
            chosenBuilding = "Business Building (BB)";
            Intent intent = new Intent(this, BuildingPageActivity.class);
            intent.putExtra(key1, chosenBuilding);
            startActivity(intent);
        }
        else if (view.getId() == R.id.IMJPL_name){
            clickedButton = (Button) view;
            chosenBuilding = "JPL";
            Intent intent = new Intent(this, BuildingPageActivity.class);
            intent.putExtra(key1, chosenBuilding);
            startActivity(intent);
        }
        else if (view.getId() == R.id.IMMH_name){
            clickedButton = (Button) view;
            chosenBuilding = "McKinney Humanities Building (MH)";
            Intent intent = new Intent(this, BuildingPageActivity.class);
            intent.putExtra(key1, chosenBuilding);
            startActivity(intent);
        }
        else if (view.getId() == R.id.IMMS_name){
            clickedButton = (Button) view;
            chosenBuilding = "MultiDisciplinary Building (MS)";
            Intent intent = new Intent(this, BuildingPageActivity.class);
            intent.putExtra(key1, chosenBuilding);
            startActivity(intent);
        }
        else if (view.getId() == R.id.IMNPB_name){
            clickedButton = (Button) view;
            chosenBuilding = "North Paseo Building (NPB)";
            Intent intent = new Intent(this, BuildingPageActivity.class);
            intent.putExtra(key1, chosenBuilding);
            startActivity(intent);
        }
        else if (view.getId() == R.id.IMSEB_name){
            clickedButton = (Button) view;
            chosenBuilding = "Science-Engineering Building (SEB)";
            Intent intent = new Intent(this, BuildingPageActivity.class);
            intent.putExtra(key1, chosenBuilding);
            startActivity(intent);
        }
        else if (view.getId() == R.id.IMStudentUnion_name){
            clickedButton = (Button) view;
            chosenBuilding = "Student Union (SU)";
            Intent intent = new Intent(this, BuildingPageActivity.class);
            intent.putExtra(key1, chosenBuilding);
            startActivity(intent);
        }
    }
}