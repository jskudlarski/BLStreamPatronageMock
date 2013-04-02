package com.blstream.urbangame.mock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class GameDetailsActivity extends Activity {
	
	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_details);
		
		Intent intent = getIntent();
	}
}