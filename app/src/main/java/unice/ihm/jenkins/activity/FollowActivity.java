package unice.ihm.jenkins.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import unice.ihm.jenkins.R;
import unice.ihm.jenkins.Recipe;
import unice.ihm.jenkins.step.StepPagerAdapter;

public class FollowActivity extends FragmentActivity {

    public static final String RECIPE_KEY = "recipe";

    private StepPagerAdapter pagerAdapter;
    private ViewPager pager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.follow_main);
        Intent intent = getIntent();
        if (intent.getExtras() == null) {
            return;
        }
        Recipe recipe = (Recipe) intent.getExtras().get(RECIPE_KEY);
        pagerAdapter = new StepPagerAdapter(recipe, getSupportFragmentManager());
        pager = findViewById(R.id.step_pager);
        pager.setAdapter(pagerAdapter);
    }

}
