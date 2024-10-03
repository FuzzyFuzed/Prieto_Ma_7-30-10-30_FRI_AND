package com.example.newsphp;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {
    private boolean isLandscape = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (isLandscape) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_headline, new HeadlineListFragment())
                    .replace(R.id.fragment_news_content, new NewsContentFragment())
                    .commit();
        } else {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, new HeadlineListFragment())
                    .commit();
        }
    }

    public void showNewsContent(String headline) {
        String content;
        int imageResId;

        // Define content and corresponding image for each headline
        switch (headline) {
            case "BLEACH: Rebirth of Souls Gets Early 2025 Release Date, New Trailer":
                content = "BLEACH: Rebirth of Souls game revealed an early 2025 release date at the Tokyo Game Show, along with a new trailer titled “Reawakening.” The new trailer features Ichigo and Ulquiorra showing off their awakened forms, and you can check it out below.";
                imageResId = R.drawable.bleach;
                break;
            case "Sucker Punch Announces Ghost of Tsushima Sequel Game, Ghost of Yotei, for 2025":
                content = "Ghost of Yotei (Ghost of Yōtei) game has been announced for 2025, coming as sort of a spiritual sequel to the popular Ghost of Tsushima. They love origin stories at Sucker Punch, so that’s why they decided to explore what it could mean to uncover the legend of a new hero with a Ghost mask.";
                imageResId = R.drawable.ghostofyotei;
                break;
            case "The Eminence in Shadow Gets Animated Trailer for Master of Garden Game":
                content = "The Eminence in Shadow: Master of Garden game has revealed a new trailer to commemorate the release of the Requiem for the Fallen Shadows side story. The trailer was animated by studio Nexus, which also animated the TV anime and is working on the upcoming movie.";
                imageResId = R.drawable.eminence;
                break;
            default:
                content = "No content available.";
                imageResId = R.drawable.defaultimg;
                break;
        }

        if (isLandscape) {
            NewsContentFragment contentFragment = (NewsContentFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_news_content);
            if (contentFragment != null) {
                contentFragment.updateContent(content, imageResId);
            }
        } else {
            NewsContentFragment contentFragment = new NewsContentFragment();
            Bundle args = new Bundle();
            args.putString("content", content);
            args.putInt("imageResId", imageResId);
            contentFragment.setArguments(args);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, contentFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
