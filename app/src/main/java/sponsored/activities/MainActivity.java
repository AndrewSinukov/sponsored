package sponsored.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.sponsored.R;

import sponsored.fragments.MainFragment;

public class MainActivity extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_fragmen_container);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            setSupportActionBar(toolbar);
        }

        if (savedInstanceState == null) {
            if (currentFragment == null)
                startFragment(new MainFragment(), false);
            else
                startFragment(currentFragment, false);
        }
    }
}