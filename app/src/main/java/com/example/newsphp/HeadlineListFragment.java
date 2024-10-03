package com.example.newsphp;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

public class HeadlineListFragment extends ListFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Example headlines
        String[] headlines = {
                "BLEACH: Rebirth of Souls Gets Early 2025 Release Date, New Trailer",
                "Sucker Punch Announces Ghost of Tsushima Sequel Game, Ghost of Yotei, for 2025",
                "The Eminence in Shadow Gets Animated Trailer for Master of Garden Game"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                R.layout.headline_list_item, R.id.headline_text, headlines);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        String selectedHeadline = (String) l.getItemAtPosition(position);
        ((MainActivity) getActivity()).showNewsContent(selectedHeadline);
    }
}
