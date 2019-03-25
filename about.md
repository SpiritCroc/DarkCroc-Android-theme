# Supported platforms

This theme is mainly targeted at operating systems ("ROMs") that are
    close to the Android Open Source Project (AOSP, "pure Android"),
    with the primary focus being on custom ROMs.

However, this theme might work as well on stock ROMs,
    as long as the vendor does not do too many modifications to the
    Android system and system apps.

If you experience issues while using a stock ROM other than when using a
    Google device (those are quite close to AOSP, so issues that occur here
    are likely to be present on other ROMs as well) that don't apply to 3rd
    party apps, I usually won't be able to provide support for it.

Full support is only provided for custom ROMs that include the required
    Substratum exposure commits (they might be advertised with
    "Substratum support")

# Reporting bugs

### Before reporting
- Ensure that your device runs a supported operating system
- Ensure you have understood the available variants and which
    known issues each of them can produce
- Try rebooting your device after applying the theme
- Make sure you are using the latest version of Substratum
- Try uninstalling and re-installing the theme
- Check whether the [issue has already been reported on the project
    page](https://github.com/SpiritCroc/DarkCroc-Android-theme/issues?q=is%3Aissue)

### Required information
- ROM version
    - Are you using stock ROM (which device?) or a custom ROM
        (which one? release date? does it have Substratum support?)
    - Android version<!--x: ?attr/androidVersionx-->
- Substratum version<!--x: ?attr/substratumVersionx-->
- Theme version<!--x: ?attr/themeVersionx-->
- The overlay variants you applied
- Information specific to your issue:
    - In case of bad colors: please provide a screenshot and describe where it was taken!
    - In case of app crashes caused by the theme: Please provide a
        [logcat](https://raw.githubusercontent.com/nathanchance/Android-Tools/master/Guides/Proper_Bug_Reporting.txt)

### Report
If you have acknowledged the previous paragraphs and want to report an
    issue, please create an issue on
    [GitHub](https://github.com/SpiritCroc/DarkCroc-Android-theme/issues?q=is%3Aissue).

# Variants explained

## Notifications
- **Known issues** with dark and black notification variants:
    - Some application overwrite text colors, assuming a light background color, leading to dark text on dark background
    - On ROMs without the required exposure commits, the notification icon often gets colored with a bad contrast

## Android System
### Accent color
Preferred accent color used for the Android System, SystemUI and some system apps.
### Backgrounds
- **Black**:
    - Normal background: black
    - Floating background: dark
- **Black transparent**:
    - Normal background: black
    - Floating background: dark transparent
- **Dark**:
    - Dark backgrounds like the default Material dark theme
- **Dark transparent**:
    - Normal background: dark like the default Material dark theme
    - Floating background: dark transparent
- **More black**:
    - Normal background: black
    - Floating background: black
- **More black transparent**:
    - Normal background: black
    - Floating background: black transparent
<!--
### Behaviour
_ modest:
    _ Keep some parts of Android light in order to ensure readable texts.
    _ **Known issues** related to this variant:
        - Some settings search results have a black icon
_ aggressive:
    _ Try to make as much of Android dark as possible,
        possibly sacrificing readability in some apps that depend on a light system theme.
    _ **Known issues** related to this variant:
        - Some launchers have white text on white background
-->

## SystemUI
### QS
Select the color scheme for the quick settings and the volume panel.
### QS shape
Select the shape for quick settings tiles. Plain style will only work fine on custom ROMs with substratum support (i.e. having the required exposure commits).

# Telegram theme

Telegram has its own inbuilt theme engine.
    You can get themes in a similar style like this theme for both the
    Android and the desktop version [here](https://github.com/SpiritCroc/DefaultDarkTheme-telegram).

# Source code

This theme is open source, so anybody has the possibility to adapt it to
    their likings!
    The code is available on [GitHub](https://github.com/SpiritCroc/DarkCroc-Android-theme).