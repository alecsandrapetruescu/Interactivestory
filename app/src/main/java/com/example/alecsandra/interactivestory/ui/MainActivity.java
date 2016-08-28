package com.example.alecsandra.interactivestory.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alecsandra.interactivestory.R;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private EditText mNameField;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign the Views from the layout file to the corresponding variable
        mNameField = (EditText) findViewById(R.id.editText);
        mStartButton = (Button) findViewById(R.id.startButton);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Set the variable to the value from this EditText.
                String name = mNameField.getText().toString();
                // Toast provides information in a small popup
                Toast.makeText(MainActivity.this, "Welcome " + name + " !", Toast.LENGTH_LONG).show();
                startStory(name);
            }
        });
    }

    private void startStory(String name) {
        // Create a new intent for a new activity
        Intent intent = new Intent(this, StoryActivity.class);
        // Attach data to intent object
        intent.putExtra(getString(R.string.key_name), name);
        // Start activity
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mNameField.setText("");
    }
}
