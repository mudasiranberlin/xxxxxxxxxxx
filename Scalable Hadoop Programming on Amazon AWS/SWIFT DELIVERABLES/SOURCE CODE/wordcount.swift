type file;

type infile;

type outfile;

type script;

app (outfile o) wordcount (script s, infile i) 

{
 
 java "-jar" @filename(s)  @filename(i) stdout=@filename(o);

}

script s <"/home/ubuntu/Wordcount.jar">;

infile input1<"words1.txt">;
outfile of1<"count1.txt">;
of1 = wordcount(s,input1);



infile input2<"words2.txt">;
outfile of2<"count2.txt">;
of2 = wordcount(s,input2);


infile input3<"words3.txt">;
outfile of3<"count3.txt">;
of3 = wordcount(s,input3);



infile input4<"words4.txt">;
outfile of4<"count4.txt">;
of4 = wordcount(s,input4);


infile input5<"words5.txt">;
outfile of5<"count5.txt">;
of5 = wordcount(s,input5);


infile input6<"words6.txt">;
outfile of6<"count6.txt">;
of6 = wordcount(s,input6);


infile input7<"words7.txt">;
outfile of7<"count7.txt">;
of7 = wordcount(s,input7);


infile input8<"words8.txt">;
outfile of8<"count8.txt">;
of8 = wordcount(s,input8);


infile input9<"words9.txt">;
outfile of9<"count9.txt">;
of9 = wordcount(s,input9);


infile input10<"words10.txt">;
outfile of10<"count10.txt">;
of10 = wordcount(s,input10);


infile input11<"words11.txt">;
outfile of11<"count11.txt">;
of11 = wordcount(s,input11);


infile input12<"words12.txt">;
outfile of12<"count12.txt">;
of12 = wordcount(s,input12);


infile input13<"words13.txt">;
outfile of13<"count13.txt">;
of13 = wordcount(s,input13);


infile input14<"words14.txt">;
outfile of14<"count14.txt">;
of14 = wordcount(s,input14);


infile input15<"words15.txt">;
outfile of15<"count15.txt">;
of15 = wordcount(s,input15);
