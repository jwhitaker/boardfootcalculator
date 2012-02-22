package ca.thewhitakers.boardfootcalculator;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class BoardFootCalculatorActivity extends Activity {
	private final static String TAG = "BoardFootCalculatorActivity";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Button calculateButton = (Button)findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				float length = getValue(R.id.lengthEditText, R.id.lengthSpinner);
				float width = getValue(R.id.widthEditText, R.id.widthSpinner);
				float height = getValue(R.id.heightEditText, R.id.heightSpinner);
				
				float boardFeet = (length * width * height) / 144;
				
				TextView boardFeedTextView = (TextView)findViewById(R.id.boardFeetTextView);
				boardFeedTextView.setText(new DecimalFormat("#.##").format(boardFeet));
			}
		});
    }
    
	private float getValue(int editTextId, int spinnerId) {
    	float value = 0.0f;
    	
    	try {    	
    		final EditText editText = (EditText)findViewById(editTextId);
    		final Spinner spinner = (Spinner)findViewById(spinnerId);
    		
    		String unit = spinner.getSelectedItem().toString();

    		value = Float.parseFloat(editText.getText().toString());
    		
    		if (unit.equalsIgnoreCase("feet")) {
    			return value * 12;
    		}    		
    		
    		return value;
    	} catch(Exception e) { }
    	
    	return value;
    }
}