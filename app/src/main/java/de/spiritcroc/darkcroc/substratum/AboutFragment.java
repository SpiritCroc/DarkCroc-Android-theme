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

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class AboutFragment extends AbstractAboutFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.sc_about, container, false);

        WebView aboutWebView = (WebView) v.findViewById(R.id.about_web_view);
        View openSubstratumButton = v.findViewById(R.id.open_substratum_button);

        aboutWebView.setBackgroundColor(Color.TRANSPARENT);
        loadHtml(aboutWebView, "about/index.html");

        openSubstratumButton.setVisibility(
                Util.isPackageInstalled(getActivity(), Util.SUBSTRATUM_PACKAGE_NAME)
                        ? View.VISIBLE : View.GONE);
        openSubstratumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = intent.setClassName(Util.SUBSTRATUM_PACKAGE_NAME,
                        "projekt.substratum.activities.launch.ThemeLaunchActivity");
                intent.putExtra("package_name", Util.THEME_PACKAGE_NAME);
                intent.setAction("projekt.substratum.THEME");
                intent.setPackage(Util.THEME_PACKAGE_NAME);
                intent.putExtra("calling_package_name", Util.THEME_PACKAGE_NAME);
                intent.putExtra("oms_check", false);
                intent.putExtra("theme_mode", (String) null);
                intent.putExtra("notification", false);
                intent.putExtra("hash_passthrough", true);
                intent.putExtra("certified", false);
                startActivity(intent);
            }
        });

        // Remember which version of this screen the user has seen;
        Util.markAboutSeen(getActivity());

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.sc_about, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_hide_launcher:
                promptHideLauncher();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void promptHideLauncher() {
        new AlertDialog.Builder(getActivity())
                .setTitle(R.string.hide_launcher_title)
                .setMessage(R.string.hide_launcher_message)
                .setPositiveButton(R.string.hide_launcher_yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Util.disableLauncher(getActivity());
                    }
                })
                .setNegativeButton(R.string.hide_launcher_no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Only dismiss
                    }
                })
                .show();
    }
}
