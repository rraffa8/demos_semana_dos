package com.example.semana2demo1;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity 
						implements OnItemClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String[] arrayCountries = new String[]{
				"Brasilia", "DF", "Bogota","Argentina", "Lima", "Caracas", "Santiago", "Quito", "Guatemala", "Cuba"
		};
		ArrayList<String>Countries = new ArrayList<String>(Arrays.asList(arrayCountries));
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, Countries);
		ListView list = (ListView)findViewById(R.id.listView);
		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
		String country = adapterView.getItemAtPosition(position).toString();
		Intent intent = new Intent(this, CountryDetailActivity.class);
		intent.putExtra(CountryDetailActivity.COUNTRY, country);
		startActivity(intent);
	}

}
