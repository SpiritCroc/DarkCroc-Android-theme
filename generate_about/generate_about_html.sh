#!/bin/sh

base_path="$(dirname "$0")/.."
header_html="$base_path/generate_about/header.html"
footer_html="$base_path/generate_about/footer.html"
about_markdown="$base_path/about.md"
depp_html="$base_path/generate_about/depp.html"
out_about_html="$base_path/app/src/main/assets/about/index.html"
out_depp_html="$base_path/app/src/main/assets/about/depp.html"

mkdir -p "$(dirname "$out_about_html")"

cat "$header_html" > "$out_about_html"
python -m markdown "$about_markdown" >> "$out_about_html" || echo "About generation error, please complain to whoever compiled this" >> "$out_about_html"
cat "$footer_html" >> "$out_about_html"

mkdir -p "$(dirname "$out_depp_html")"
cat "$header_html" > "$out_depp_html"
cat "$depp_html" >> "$out_depp_html"
cat "$footer_html" >> "$out_depp_html"
