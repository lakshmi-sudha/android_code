package com.example.listviewtest;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView lv;
	ArrayAdapter<String> adapter;
	EditText inputSearch;
	ArrayList< HashMap<String,String>> productList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String products[]={"Dell Inspiron", "HTC One X", "HTC Wildfire S", 
							"HTC Sense", "HTC Sensation XE",
							"iPhone 4S", "Samsung Galaxy Note 800",
							"Samsung Galaxy S3", "MacBook Air", "Mac Mini", "MacBook Pro"};
		
		lv=(ListView) findViewById(R.id.list_view);
		inputSearch=(EditText) findViewById(R.id.inputSearch);
		
		adapter=new ArrayAdapter<String>(this, R.layout.list_item,R.id.product_name,products);
		lv.setAdapter(adapter);
		
		inputSearch.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence cs, int start, int before, int count) {
				// TODO Auto-generated method stub
			MainActivity.this.adapter.getFilter().filter(cs);	
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
