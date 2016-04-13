#!/bin/bash

head -n 1 count1.txt | tr -cd [:digit:] > 1.txt

sed -n '2p' count1.txt | tr -cd [:digit:] > o1.txt



head -n 1 count2.txt | tr -cd [:digit:] > 2.txt

sed -n '2p' count2.txt | tr -cd [:digit:] > o2.txt


head -n 1 count3.txt | tr -cd [:digit:] > 3.txt

sed -n '2p' count3.txt | tr -cd [:digit:] > o3.txt


head -n 1 count4.txt | tr -cd [:digit:] > 4.txt

sed -n '2p' count4.txt | tr -cd [:digit:] > o4.txt


head -n 1 count5.txt | tr -cd [:digit:] > 5.txt

sed -n '2p' count5.txt | tr -cd [:digit:] > o5.txt


head -n 1 count6.txt | tr -cd [:digit:] > 6.txt

sed -n '2p' count6.txt | tr -cd [:digit:] > o6.txt


head -n 1 count7.txt | tr -cd [:digit:] > 7.txt

sed -n '2p' count7.txt | tr -cd [:digit:] > o7.txt


head -n 1 count8.txt | tr -cd [:digit:] > 8.txt

sed -n '2p' count8.txt | tr -cd [:digit:] > o8.txt


head -n 1 count9.txt | tr -cd [:digit:] > 9.txt

sed -n '2p' count9.txt | tr -cd [:digit:] > o9.txt


head -n 1 count10.txt | tr -cd [:digit:] > 10.txt

sed -n '2p' count10.txt | tr -cd [:digit:] > o10.txt


head -n 1 count11.txt | tr -cd [:digit:] > 11.txt

sed -n '2p' count11.txt | tr -cd [:digit:] > o11.txt


head -n 1 count12.txt | tr -cd [:digit:] > 12.txt

sed -n '2p' count12.txt | tr -cd [:digit:] > o12.txt


head -n 1 count13.txt | tr -cd [:digit:] > 13.txt

sed -n '2p' count13.txt  | tr -cd [:digit:]  > o13.txt


head -n 1 count14.txt | tr -cd [:digit:] > 14.txt

sed -n '2p' count14.txt | tr -cd [:digit:] >> o14.txt


head -n 1 count15.txt | tr -cd [:digit:] > 15.txt

sed -n '2p' count15.txt | tr -cd [:digit:] > o15.txt


read one < 1.txt
read two < 2.txt
read three < 3.txt
read four < 4.txt
read five < 5.txt
read six < 6.txt
read seven < 7.txt
read eight < 8.txt
read nine < 9.txt
read ten < 10.txt
read eleven < 11.txt
read twelve < 12.txt
read thirteen < 13.txt
read fourteen < 14.txt
read fifteen < 15.txt

read a < o1.txt
read b < o2.txt
read c < o3.txt
read d < o4.txt
read e < o5.txt
read f < o6.txt
read g < o7.txt
read h < o8.txt
read i < o9.txt
read j < o10.txt
read k < o11.txt
read l < o12.txt
read m < o13.txt
read n < o14.txt
read o < o15.txt

declare total;
total=$(($one + $two + $three + $four + $five + $six + $seven + $eight + $nine + $ten + $eleven + $twelve + $thirteen + $fourteen + $fifteen))

echo "Total words are" $total > WordCountFinal.txt;
echo " " >> WordCountFinal.txt

declare occur;
occur=$(($a + $b + $c + $d + $e + $f + $g + $h + $i + $j + $k + $l + $m + $n + $o))

echo "Total number of unique Words are" $occur >> WordCountFinal.txt

cat count1.txt count2.txt count3.txt count4.txt count5.txt count6.txt count7.txt count8.txt count9.txt count10.txt count11.txt count12.txt count13.txt count14.txt count15.txt > occurrances.txt

rm 1.txt 2.txt 3.txt 4.txt 5.txt 6.txt 7.txt 8.txt 9.txt 10.txt 11.txt 12.txt 13.txt 14.txt 15.txt count1.txt count2.txt count3.txt count4.txt count5.txt count6.txt count7.txt count8.txt count9.txt count10.txt count11.txt count12.txt count13.txt count14.txt count15.txt o1.txt o2.txt o3.txt o4.txt o5.txt o6.txt o7.txt o8.txt o9.txt o10.txt o11.txt o12.txt o13.txt o14.txt o15.txt words1.txt words2.txt words3.txt words4.txt words5.txt words6.txt words7.txt words8.txt words9.txt words10.txt words11.txt words12.txt words13.txt words14.txt words15.txt
