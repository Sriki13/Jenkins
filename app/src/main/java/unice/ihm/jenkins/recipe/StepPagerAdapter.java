package unice.ihm.jenkins.recipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import unice.ihm.jenkins.entities.Recipe;

public class StepPagerAdapter extends FragmentStatePagerAdapter {

    private Recipe recipe;

    public StepPagerAdapter(Recipe recipe, FragmentManager fm) {
        super(fm);
        this.recipe = recipe;
    }

    @Override
    public Fragment getItem(int i) {
        Bundle args = new Bundle();
        Fragment fragment;
        if (i == recipe.getSteps().size()) {
            fragment = new EndFragment();
            args.putString(EndFragment.IMG_PATH_KEY, recipe.getImgPath());
        } else {
            fragment = new StepFragment();
            args.putSerializable(StepFragment.STEP_KEY, recipe.getSteps().get(i));
            args.putSerializable(StepFragment.INDEX_KEY, i);
        }
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return recipe.getSteps().size() + 1;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Etape " + (position + 1);
    }

}
