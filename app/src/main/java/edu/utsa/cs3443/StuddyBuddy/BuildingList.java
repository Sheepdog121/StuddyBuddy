package edu.utsa.cs3443.StuddyBuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BuildingList extends AppCompatActivity implements View.OnClickListener{

    /**
     *      Attributes
     */
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
        setContentView(R.layout.activity_building_list);

        setupButton(R.id.BLBB_name);
        setupButton(R.id.BLJPL_name);
        setupButton(R.id.BLMH_name);
        setupButton(R.id.BLMS_name);
        setupButton(R.id.BLNPB_name);
        setupButton(R.id.BLSEB_name);
        setupButton(R.id.BLStudentUnion_name);
    }

    @Override
    public void onClick(View view){
        Button clickedButton;
        String buildingName;

        if (view.getId() == R.id.BLBB_name){
            clickedButton = (Button) view;
            buildingName = "Business Building (BB)";
            Intent intent = new Intent(this, BuildingPageActivity.class);
            intent.putExtra(key1, buildingName);
            startActivity(intent);
        }
        else if (view.getId() == R.id.BLJPL_name){
            clickedButton = (Button) view;
            buildingName = "JPL";
            Intent intent = new Intent(this, BuildingPageActivity.class);
            intent.putExtra(key1, buildingName);
            startActivity(intent);
        }
        else if (view.getId() == R.id.BLMH_name){
            clickedButton = (Button) view;
            buildingName = "McKinney Humanities Building (MH)";
            Intent intent = new Intent(this, BuildingPageActivity.class);
            intent.putExtra(key1, buildingName);
            startActivity(intent);
        }
        else if (view.getId() == R.id.BLMS_name){
            clickedButton = (Button) view;
            buildingName = "MultiDisciplinary Building (MS)";
            Intent intent = new Intent(this, BuildingPageActivity.class);
            intent.putExtra(key1, buildingName);
            startActivity(intent);
        }
        else if (view.getId() == R.id.BLNPB_name){
            clickedButton = (Button) view;
            buildingName = "North Paseo Building (NPB)";
            Intent intent = new Intent(this, BuildingPageActivity.class);
            intent.putExtra(key1, buildingName);
            startActivity(intent);
        }
        else if (view.getId() == R.id.BLSEB_name){
            clickedButton = (Button) view;
            buildingName = "Science-Engineering Building (SEB)";
            Intent intent = new Intent(this, BuildingPageActivity.class);
            intent.putExtra(key1, buildingName);
            startActivity(intent);
        }
        else if (view.getId() == R.id.BLStudentUnion_name){
            clickedButton = (Button) view;
            buildingName = "Student Union (SU)";
            Intent intent = new Intent(this, BuildingPageActivity.class);
            intent.putExtra(key1, buildingName);
            startActivity(intent);
        }
    }
}