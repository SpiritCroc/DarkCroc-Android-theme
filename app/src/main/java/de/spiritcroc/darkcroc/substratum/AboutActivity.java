/*
 * Copyright (C) 2017-2018 SpiritCroc
 * Email: spiritcroc@gmail.com
 *
 * This work is licensed under the Creative Commons
 * Attribution-NonCommercial-ShareAlike 4.0 International License.
 * To view a copy of this license,
 * visit https://creativecommons.org/licenses/by-sa/4.0/.
 */

package de.spiritcroc.darkcroc.substratum;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class AboutActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean forceAbout = getIntent().getBooleanExtra(Util.EXTRA_FORCE_ABOUT, false);

        Fragment fragment = forceAbout ? new ForcedAboutFragment()
                : !Util.TEST_DEPP && Util.isPackageInstalled(this, Util.SUBSTRATUM_PACKAGE_NAME)
                    ? new AboutFragment()
                    : new DeppFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, fragment).commit();
    }

}
