string=""
x=1
j=1
while [ $x -le 200 ]
do
 string="touch randomfile$((j+x)) && git add . && git commit -m '$((j+x)):randfile_$((j+x))'"
 echo $string
 eval "$string"
 x=$[$x+1]
done
git push
