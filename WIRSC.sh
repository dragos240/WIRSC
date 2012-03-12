cd tmp
curl -o game.ws http://www.runescape.com/game.ws > /dev/null 2>&1
curl -o test `grep -R "iframe" game.ws | awk -Fsrc=\" '{print $2}' | awk -F\" '{print $1}'` > /dev/null 2>&1
grep -R "param name" test | grep -v \"28\" | awk -F\" '{print "      parameters.put(\"" $2 "\", \"" $4 "\");"}' > params
export WORLDURL=`grep -R "iframe" game.ws | awk -F// '{print $2}' | awk -F.ru '{print $1}' | grep world`
export JARFILENAME=`grep -R "jar" test | awk -Farchive= '{print $2}' | awk -F\  '{print $1}' | grep jar`
export fbid="DvM"
cat ../res/rsloader.java.part.1 > RSLoadertmp.java
cat params  >> RSLoadertmp.java
cat ../res/rsloader.java.part.2 >> RSLoadertmp.java
sed "s/WORLDURLHERE/$WORLDURL/" RSLoadertmp.java > RSLoader.java
sed "s/JARFILENAMEHERE/$JARFILENAME/" RSLoader.java > RSLoadertmp.java
if zenity --question --text="Do you wish to use a facebook login?"; then
	fbid=$(zenity --entry --text="Enter your facebook session id here:" | grep DvM)
	sed "s/FACEBOOKLOGIN/$fbid/" RSLoadertmp.java > ../src/RSLoader.java
	zenity --info --text="Done. Your facebook will be used to login."
else
	zenity --info --text="Facebook will not be used to login."
	sed "s/FACEBOOKLOGIN//" RSLoadertmp.java > ../src/RSLoader.java
fi
cd ..
rm -r ./tmp/*
javac -d ../bin ./src/RSLoader.java
cd bin
java RSLoader
cd ..
rm -r ./src/*
