package edu.utsa.cs3443.StuddyBuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     *      Attributes
     */
    private static final String key1 = "building_name";
    private final Random random = new Random();

    /**
     *      getIdx
     * @param arr
     * @return
     * @param <T>
     */
    public <T> T getIdx(T[] arr){
        int idx = random.nextInt(arr.length);
        return arr[idx];
    }

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
        setContentView(R.layout.activity_main);

        setupButton(R.id.HPButton1_name);
        setupButton(R.id.HPButton2_name);
        setupButton(R.id.HPButton3_name);
    }

    @Override
    public void onClick(View view){
        Button clickedButton;

        if (view.getId() == R.id.HPButton1_name){
            clickedButton = (Button) view;
            Intent intent = new Intent(this, InteractiveMap.class);
            startActivity(intent);
        }
        else if (view.getId() == R.id.HPButton2_name){
            clickedButton = (Button) view;
            Intent intent = new Intent(this, BuildingList.class);
            startActivity(intent);
        }
        else if (view.getId() == R.id.HPButton3_name){
            clickedButton = (Button) view;
            String[] buildings = {"Business Building (BB)", "McKinney Humanities Building (MH)", "MultiDisciplinary Building (MS)", "North Paseo Building (NPB)", "JPL", "Science-Engineering Building (SEB)", "Student Union (SU)"};
            String building = getIdx(buildings);
            Intent intent = new Intent(this, BuildingPageActivity.class);
            intent.putExtra(key1, building);
            startActivity(intent);
        }
    }

}