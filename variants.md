# Variants explained (TODO)

## Notifications
Known issues with dark and black notification variants:
- Some application overwrite text colors, assuming a light background color, leading to dark text on dark background
- On ROMs without the required exposure commits, the notification icon often gets colored with a bad contrast

## Android System
### Accent color
- Self-explanatory.
### Backgrounds
- Black:
    Normal background black, floating backgrounds like default dark
- Black transparent:
    Normal background black, floating backgrounds transparent grey
- Default dark:
    Grey backgrounds like the default Material dark theme
- Default dark transparent:
    Like default dark, with transparent background for floating
- More black:
    Normal and floating black backgrounds
- More black transparent:
    Normal background black, floating background transparent black
### Behaviour
- modest:
    - Keep more parts of Android light in order to ensure readable texts.
    - Known issues related to this variant:
        - Some settings search results have a black icon
- aggressive:
    - Try to make as much of Android dark as possible,
        possibly sacrificing readability in some apps that depend on a light system theme.
    - Known issues related to this variant:
        - Some launchers have white text on white background

## SystemUI
### Quick Settings (QS) and volume panel
- Dark
- Dark transparent
- Black
- Black transparent