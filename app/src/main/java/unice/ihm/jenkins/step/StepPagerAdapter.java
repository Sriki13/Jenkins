package unice.ihm.jenkins.step;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import unice.ihm.jenkins.Recipe;

public class StepPagerAdapter extends FragmentStatePagerAdapter {

    private Recipe recipe;

    public StepPagerAdapter(Recipe recipe, FragmentManager fm) {
        super(fm);
        this.recipe = recipe;
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new StepFragment();
        Bundle args = new Bundle();
        args.putSerializable(StepFragment.STEP_KEY, recipe.getSteps().get(i));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return recipe.getSteps().size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Etape " + (position + 1);
    }

}
