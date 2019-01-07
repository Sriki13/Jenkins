package unice.ihm.jenkins.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import unice.ihm.jenkins.R;
import unice.ihm.jenkins.step.StepPagerAdapter;

public class FollowActivity extends FragmentActivity {

    private StepPagerAdapter mDemoCollectionPagerAdapter;
    private ViewPager mViewPager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.follow_main);

        mDemoCollectionPagerAdapter = new StepPagerAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.step_pager);
        mViewPager.setAdapter(mDemoCollectionPagerAdapter);
    }


}
