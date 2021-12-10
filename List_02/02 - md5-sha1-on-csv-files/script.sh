#!/bin/bash
if [ ! -e ./data.csv ]; then
  curl https://zenodo.org/record/3469741/files/2014_01-Traffic_Sensors_Fortaleza.csv?download=1 -o data.csv
fi

echo "--- Hashing data.csv ---" > solve-hash.txt

printf "\n" >> solve-hash.txt

echo "md5sum: $(md5sum data.csv)" >> solve-hash.txt
echo "sha1sum: $(sha1sum data.csv)" >> solve-hash.txt

echo "-- Time between each type of compression --" > solve-compression.txt

printf "\n" >> solve-compression.txt

echo "zip:" >> solve-compression.txt
{ time zip data.zip data.csv -q ; } 2>> solve-compression.txt
wait
ls -lah data.zip >> solve-compression.txt
rm -rf data.zip

printf "\n" >> solve-compression.txt

echo "gzip:" >> solve-compression.txt
{ time gzip -c data.csv > data.gz ; } 2>> solve-compression.txt
wait
wait
ls -lah data.gz >> solve-compression.txt
rm -rf data.gz

printf "\n" >> solve-compression.txt

echo "bzip2:" >> solve-compression.txt
{ time bzip2 data.csv ; } 2>> solve-compression.txt
wait
ls -lah data.csv.bz2 >> solve-compression.txt
bzip2 -d data.csv.bz2

printf "\n" >> solve-compression.txt

echo "7zip:" >> solve-compression.txt
{ time 7z a data.7z data.csv > null ; } 2>> solve-compression.txt
wait
ls -lah data.7z >> solve-compression.txt
rm -rf null
rm -rf data.7z 

printf "\n" >> solve-compression.txt

echo "rar:" >> solve-compression.txt
{ time rar a data.rar data.csv > null ; } 2>> solve-compression.txt
wait
ls -lah data.rar >> solve-compression.txt
rm -rf null
rm -rf data.rar 

rm -rf data.csv