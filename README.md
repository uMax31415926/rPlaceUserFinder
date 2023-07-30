# rPlaceUserFinder

Find out your user ID with the help of this tool!

### How To Use

1. Make sure you have Java installed.
2. Download the [CSV data for r/place](https://placedata.reddit.com/data/canvas-history/2023/index.html) and extract the files into a directory.
3. Download [`place.jar`](https://github.com/uMax31415926/rPlaceUserFinder/raw/main/place.jar) and [`areas.txt`](https://github.com/uMax31415926/rPlaceUserFinder/raw/main/areas.txt) into the same directory.
4. Modify `areas.txt` to include areas in which you have placed your pixels. Each line contains the coordinates of the top-left pixel and the coordinates of the bottom-right pixel. Make sure to follow the format exactly (coordinates separated by commas) and do not include additional characters such as spaces.
5. Right-click in the directory and open a PowerShell / console.
6. Enter `java -jar place.jar` and hit enter.

### Build Yourself

1. Install [Kotlin](https://kotlinlang.org/docs/command-line.html#install-the-compiler).
2. Download [`place.kt`](https://github.com/uMax31415926/rPlaceUserFinder/raw/main/place.kt) and [`Makefile`](https://github.com/uMax31415926/rPlaceUserFinder/raw/main/place.kt).
3. Execute `make` or `kotlinc place.kt -include-runtime -d place.jar`.
