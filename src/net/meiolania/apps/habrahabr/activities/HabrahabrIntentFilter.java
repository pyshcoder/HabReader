/*
   Copyright (C) 2011 Andrey Zaytsev <a.einsam@gmail.com>
  
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
  
        http://www.apache.org/licenses/LICENSE-2.0
  
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package net.meiolania.apps.habrahabr.activities;

import net.meiolania.apps.habrahabr.ui.activities.CompaniesActivity;
import net.meiolania.apps.habrahabr.ui.activities.EventsActivity;
import net.meiolania.apps.habrahabr.ui.activities.EventsShowActivity;
import net.meiolania.apps.habrahabr.ui.activities.PostsActivity;
import net.meiolania.apps.habrahabr.ui.activities.PostsShowActivity;
import net.meiolania.apps.habrahabr.ui.activities.QaActivity;
import net.meiolania.apps.habrahabr.ui.activities.QaShowActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class HabrahabrIntentFilter extends Activity{
    private final static String LOG_TAG = "Meiolania.HabrahabrIntentFilter";

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        final String uri = getIntent().getDataString();
        final String[] parts = uri.split("/");
        final Intent intent = new Intent();

        Log.i(LOG_TAG, "Link: " + uri);
        Log.i(LOG_TAG, "Length: " + parts.length);

        if(parts.length >= 3){
            // Blogs
            if(parts[3].equalsIgnoreCase("blogs") && parts.length == 3){
                Log.i(LOG_TAG, "Target: PostsActivity.class");
                intent.setClass(this, PostsActivity.class);
                startActivity(intent);
            }else if(parts[3].equalsIgnoreCase("blogs") && parts.length == 4){
                Log.i(LOG_TAG, "Target: PostsActivity.class");
                intent.setClass(this, PostsActivity.class);
                intent.putExtra("link", uri);
                startActivity(intent);
            }else if(parts[3].equals("blogs") && parts.length == 6){
                Log.i(LOG_TAG, "Target: PostsShowActivity.class");
                intent.setClass(this, PostsShowActivity.class);
                intent.putExtra("link", uri);
                startActivity(intent);
            }
            // Events
            else if(parts[3].equalsIgnoreCase("events") && parts.length == 3){
                Log.i(LOG_TAG, "Target: EventsActivity.class");
                intent.setClass(this, EventsActivity.class);
                startActivity(intent);
            }else if(parts[3].equalsIgnoreCase("events") && parts.length == 4){
                Log.i(LOG_TAG, "Target: EventsShowActivity.class");
                intent.setClass(this, EventsShowActivity.class);
                intent.putExtra("link", uri);
                startActivity(intent);
            }
            // Companies
            else if(parts[3].equalsIgnoreCase("companies") && parts.length == 3){
                Log.i(LOG_TAG, "Target: CompaniesActivity.class");
                intent.setClass(this, CompaniesActivity.class);
                startActivity(intent);
            }else if(parts[3].equalsIgnoreCase("company") && parts.length == 4){
                Log.i(LOG_TAG, "Target: CompaniesShow.class");
                intent.setClass(this, CompaniesShow.class);
                intent.putExtra("link", uri);
                startActivity(intent);
            }
            // People
            else if(parts[3].equalsIgnoreCase("people") && parts.length == 3){
                Log.i(LOG_TAG, "Target: People.class");
                intent.setClass(this, People.class);
                startActivity(intent);
            }else if(parts[3].equalsIgnoreCase("users") && parts.length == 4){
                Log.i(LOG_TAG, "Target: PeopleShow.class");
                intent.setClass(this, PeopleShow.class);
                intent.putExtra("link", uri);
                startActivity(intent);
            }
            // Q&A
            else if(parts[3].equalsIgnoreCase("qa") && parts.length == 3){
                Log.i(LOG_TAG, "Target: QA.class");
                intent.setClass(this, QaActivity.class);
                startActivity(intent);
            }else if(parts[3].equalsIgnoreCase("qa") && parts.length == 4){
                Log.i(LOG_TAG, "Target: QAShow.class");
                intent.setClass(this, QaShowActivity.class);
                intent.putExtra("link", uri);
                startActivity(intent);
            }
        }
        // No action for this
        finish();
    }

}