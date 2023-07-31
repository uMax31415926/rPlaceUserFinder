# rPlaceUserFinder

Find out your user ID with the help of this tool!

### How To Use

1. Make sure you have Java installed.
2. Download the [CSV data for r/place](https://placedata.reddit.com/data/canvas-history/2023/index.html) and extract the files into a directory. GNU/Linux users can use [this shell script](https://gist.github.com/uMax31415926/ba0244ff6d1b38f90981a8d39c2c39d3).
3. Download [`place.jar`](https://github.com/uMax31415926/rPlaceUserFinder/releases/download/release/place.jar) and [`areas.txt`](https://github.com/uMax31415926/rPlaceUserFinder/releases/download/release/areas.txt) into the same directory.
4. Modify `areas.txt` to include areas in which you have placed your pixels. Each line contains the coordinates of the top-left pixel and the coordinates of the bottom-right pixel. Make sure to follow the format exactly (coordinates separated by commas) and do not include additional characters such as spaces. For example, the line `0,10,50,30` indicates an area from `(0, 10)` to `(50, 30)`.
5. Right-click in the directory and open a PowerShell / console / terminal.
6. Enter `java -jar place.jar` and hit enter.
7. The tool will scan all CSV files and output the possible user IDs. That will take a minute.
8. Search the CSV files for your user ID. GNU/Linux users can use [this shell script](https://gist.github.com/uMax31415926/fcf488263668cd1cebabe423bd2bc423) to extract all relevant lines into one file.

### Build Yourself

1. Install [Kotlin](https://kotlinlang.org/docs/command-line.html#install-the-compiler).
2. Clone the project.
3. Execute `make` or `kotlinc place.kt -include-runtime -d place.jar`.
