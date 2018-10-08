#!/bin/sh

base_path="$(dirname "$0")/.."

accent_variants="$base_path/app/src/main/assets/overlays/android/type1a_*_accent.xml"
accent_color_resource="accent_material_dark"
replacable_accent_color="00ff00"
out_dir="$base_path/wallpapers"
preview_dir="$base_path/wallpapers/preview"
in_walls=("$base_path/graphics/wallpaper_1000.svg" "$base_path/graphics/wallpaper_1100.svg")
tmp_wall="$base_path/graphics/wallpaper_tmp.svg"
out_dpi=360
preview_dpi=90

index_header="$base_path/generate_wallpapers/index_header.txt"
index_footer="$base_path/generate_wallpapers/index_footer.txt"
index_target="$base_path/wallpapers/index.txt"
repo_raw_link="https://raw.githubusercontent.com/SpiritCroc/DarkCroc-Android-theme/9.0-substratum/wallpapers"
repo_preview_link="https://raw.githubusercontent.com/SpiritCroc/DarkCroc-Android-theme/9.0-substratum/wallpapers/preview"

generate_wall() {
    local wall_source="$1"
    local accent_color="$2"
    local accent_name="$3"
    local out_name="$(basename "$wall_source" | sed "s/.svg/-$accent_name.png/" | sed 's/wallpaper_//g')"
    cp "$wall_source" "$tmp_wall"
    sed -i "s|#$replacable_accent_color|#$accent_color|g" "$tmp_wall"
    inkscape --file="$tmp_wall" --export-png="$out_dir/$out_name" -C --export-dpi="$out_dpi"
    inkscape --file="$tmp_wall" --export-png="$preview_dir/$out_name" -C --export-dpi="$preview_dpi"
    rm "$tmp_wall"
}

# Generate accent specific wallpapers
for variant in $accent_variants; do
    variant_name="$(echo "$variant" | sed 's/.*type1a_//g' | sed 's/_accent.xml//g')"
    variant_color="$(grep "$accent_color_resource" "$variant" | sed 's/.*>#//g' | sed 's|</.*||g')"
    echo "$variant_color $variant_name"
    for wall in "${in_walls[@]}"; do
        generate_wall "$wall" "$variant_color" "$variant_name"
    done
done

# Generate index.txt
cat "$index_header" > "$index_target"
for wall in "$out_dir"/*.png; do
    wall_name="$(basename "$wall")"
    wall_id="$(echo "$wall_name" | sed 's/.png//')"
    echo '    <wallpaper id="'"$wall_id"'">' >> "$index_target"
    echo '        <link>'"$repo_raw_link/$wall_name"'</link>' >> "$index_target"
    echo '        <preview>'"$repo_preview_link/$wall_name"'</preview>' >> "$index_target"
    echo '    </wallpaper>' >> "$index_target"
done
cat "$index_footer" >> "$index_target"
