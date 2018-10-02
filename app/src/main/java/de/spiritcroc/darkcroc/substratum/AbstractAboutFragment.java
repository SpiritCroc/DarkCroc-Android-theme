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

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class AbstractAboutFragment extends Fragment {

    private static String styleHtml(Context context, String html) {
        TypedArray ta = context.obtainStyledAttributes(new int[] {
                android.R.attr.textColorPrimary,
                android.R.attr.colorAccent,
                R.attr.colorWarning}
        );
        String textColorPrimary = String.format("#%06X", (0xFFFFFF & ta.getColor(0, Color.GRAY)));
        String accentColor = String.format("#%06X", (0xFFFFFF & ta.getColor(1, Color.GRAY)));
        String warning_color = String.format("#%06X", (0xFFFFFF & ta.getColor(2, Color.GRAY)));
        String substratumVersion = getVersionName(context, Util.SUBSTRATUM_PACKAGE_NAME);
        String themeVersion = getVersionName(context, Util.THEME_PACKAGE_NAME);
        String androidVersion = getVersionName(context, null);
        ta.recycle();
        html = html.replaceAll("\\?android:attr/textColorPrimary", textColorPrimary);
        html = html.replaceAll("\\?android:attr/colorAccent", accentColor);
        html = html.replaceAll("\\?attr/colorWarning", warning_color);
        html = html.replaceAll("\\?attr/substratumVersion", substratumVersion);
        html = html.replaceAll("\\?attr/themeVersion", themeVersion);
        html = html.replaceAll("\\?attr/androidVersion", androidVersion);
        return html;
    }

    private static String getVersionName(Context context, String packageName) {
        if (packageName == null) {
            return Build.VERSION.RELEASE;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            return context.getString(R.string.version_name_and_code, packageInfo.versionName,
                    String.valueOf(packageInfo.versionCode));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return context.getString(R.string.unknown_version);
        }
    }

    protected void loadHtml(WebView webView, String htmlAssetPath) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(
                    getActivity().getAssets().open(htmlAssetPath)));
            String line;
            StringBuilder htmlBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                //process line
                htmlBuilder.append(line);
            }
            webView.loadDataWithBaseURL("http://de.spiritcroc.defaultdarktheme-oms.phantomfile",
                    styleHtml(getActivity(), htmlBuilder.toString()),
                    "text/html", "UTF-8", null);
        } catch (Exception e) {
            e.printStackTrace();
            webView.loadDataWithBaseURL("http://de.spiritcroc.defaultdarktheme-oms.phantomfile",
                    styleHtml(getActivity(), getString(R.string.about_internal_error, e)),
                    "text/html", "UTF-8", null);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
