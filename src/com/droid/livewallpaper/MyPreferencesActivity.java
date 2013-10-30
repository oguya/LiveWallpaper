package com.droid.livewallpaper;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.widget.Toast;

public class MyPreferencesActivity extends PreferenceActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.prefs);
		
		// We want to add a validator to the number of circles so that it only
	    // accepts numbers
		Preference circlePreference = getPreferenceScreen().findPreference("numberOfCircles");
		
		//add the validator
		circlePreference.setOnPreferenceChangeListener(numberCheckListener);
		
	}
	
	//Checks that a preference is a valid numerical value
	
	Preference.OnPreferenceChangeListener numberCheckListener = new OnPreferenceChangeListener() {
		
		@Override
		public boolean onPreferenceChange(Preference preference, Object newValue) {
			// check if string is integer
			if(newValue != null && newValue.toString().length() > 0 && newValue.toString().matches("\\d*"))
				return true;
			else 
				Toast.makeText(MyPreferencesActivity.this, "Invalid Input", Toast.LENGTH_LONG).show();
				return true;
			
		}
	};
}
