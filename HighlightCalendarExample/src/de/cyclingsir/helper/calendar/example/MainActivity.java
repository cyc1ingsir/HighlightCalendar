package de.cyclingsir.helper.calendar.example;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/*
 * Copyright (C) 2013 M. Ritscher
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class MainActivity extends Activity implements OnClickListener {


	private Button btn_customCalendar;
	private Button btn_nativCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_customCalendar = (Button) findViewById(R.id.btn_customCalendar);
        btn_nativCalendar = (Button) findViewById(R.id.btn_nativCalendar);
        btn_customCalendar.setOnClickListener(this);
        btn_nativCalendar.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View view) {
		Intent intent = null;
		switch (view.getId()) {
		case R.id.btn_customCalendar:
			intent = new Intent(this, CustomCalendarActivity.class);
			break;
		case R.id.btn_nativCalendar:
			intent = new Intent(this, NativCalendarActivity.class);
			break;
		default:
			break;
		}
		if(intent != null)
			startActivity(intent);
	}

}
