/*
Copyright 2012-2013 Andrey Zaytsev, Sergey Ivanov

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

package net.meiolania.apps.habrahabr.fragments.feed;

import net.meiolania.apps.habrahabr.R;
import net.meiolania.apps.habrahabr.ui.TabListener;
import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragment;

public class FeedMainFragment extends SherlockFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
	super.onActivityCreated(savedInstanceState);

	showActionBar();
    }

    private void showActionBar() {
	ActionBar actionBar = getSherlockActivity().getSupportActionBar();
	actionBar.removeAllTabs();
	actionBar.setTitle(R.string.feed);
	actionBar.setDisplayHomeAsUpEnabled(true);
	actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

	/* Posts tab */
	Tab tab = actionBar.newTab();
	tab.setText(R.string.posts);
	tab.setTag("posts");
	tab.setTabListener(new TabListener<FeedPostsFragment>(getSherlockActivity(), "posts", FeedPostsFragment.class));
	actionBar.addTab(tab);

	/* Q&A tab */
	tab = actionBar.newTab();
	tab.setText(R.string.qa);
	tab.setTag("qa");
	tab.setTabListener(new TabListener<FeedQAFragment>(getSherlockActivity(), "qa", FeedQAFragment.class));
	actionBar.addTab(tab);

	/* Events tab */
	tab = actionBar.newTab();
	tab.setText(R.string.events);
	tab.setTag("events");
	tab.setTabListener(new TabListener<FeedEventsFragment>(getSherlockActivity(), "events", FeedEventsFragment.class));
	actionBar.addTab(tab);
    }

}