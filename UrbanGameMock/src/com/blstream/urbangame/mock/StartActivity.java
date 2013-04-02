package com.blstream.urbangame.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class StartActivity extends ListActivity {
	private ArrayList<HashMap<String, String>> data;
	
	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mockData();
	}
	
	private void mockData() {
		this.data = getMockData();
		
		SimpleAdapter simpleAdapter = new SimpleAdapter(StartActivity.this, data, R.layout.list_item_game,
			new String[] { "game_name", "operator_name", "operator_link", "days_left", "hours_left", "minutes_left",
				"has_joined", "accomplished_tasks", "total_tasks", "accomplished_points", "total_points",
				"current_players_number", "free_slots" }, new int[] { R.id.textViewGameName, R.id.textViewOperatorName,
				R.id.textViewOperatorLink, R.id.textViewDaysLeftValue, R.id.textViewHoursLeftValue,
				R.id.textViewMinutesLeftValue, R.id.textViewJoined, R.id.textViewCompletedTasksValue,
				R.id.textViewTotalTasks, R.id.textViewPointsValue, R.id.textViewTotalPoints,
				R.id.textViewNumberOfPlayersValue, R.id.textViewFreeSlotsValue });
		
		setListAdapter(simpleAdapter);
	}
	
	public ArrayList<HashMap<String, String>> getMockData() {
		ArrayList<HashMap<String, String>> listOfMap = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = null;
		Random random = new Random();
		
		for (int i = 0; i < 10; i++) {
			map = new HashMap<String, String>();
			map.put("game_name", "Krasnale Wroc³awskie");
			map.put("operator_name", "BLStream");
			map.put("operator_link", "http://www.blstream.com/");
			map.put("days_left", String.valueOf(random.nextInt(50)));
			map.put("hours_left", String.valueOf(random.nextInt(50)));
			map.put("minutes_left", String.valueOf(random.nextInt(50)));
			map.put("has_joined", random.nextBoolean() ? "joined" : "not joined");
			map.put("accomplished_tasks", String.valueOf(random.nextInt(50)));
			map.put("total_tasks", String.valueOf(random.nextInt(50)));
			map.put("accomplished_points", String.valueOf(random.nextInt(50)));
			map.put("total_points", String.valueOf(random.nextInt(50)));
			map.put("current_players_number", String.valueOf(random.nextInt(50)));
			map.put("free_slots", String.valueOf(random.nextInt(50)));
			listOfMap.add(map);
		}
		
		return listOfMap;
	}
	
	@Override protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		HashMap<String, String> item = data.get(position);
		Set<Entry<String, String>> entrySet = item.entrySet();
		Intent intent = new Intent(StartActivity.this, GameDetailsActivity.class);
		
		for (Map.Entry<String, String> entry : entrySet) {
			intent.putExtra(entry.getKey(), entry.getValue());
		}
		
		startActivity(intent);
	}
}