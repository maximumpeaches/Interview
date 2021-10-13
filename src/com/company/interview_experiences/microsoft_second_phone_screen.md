I had another Microsoft phone screen today. It seemed to go fine. I solved it as quickly as I think was reasonable.
I went for a one-pass solution instead of two-pass, which took longer.

The question was simple but I had to concentrate on corner cases. Question was this:

Compare two Strings and say which one is greater. Here are some examples:
1.32.43 > 1.23.43
First one is greater because 32 > 23
1.234.23 > 1.23.23
First one is greater because 234 > 23
1.23&*(#(@.23 == 1.23.23
These are equal because ignore non-integers.
... == 0.0.0.0
if nothing is present then this means it is a zero

At first I mentioned that it is possible to use the Java method String#split and split up the String around the periods. 
I then said, well, it is also possible to do a one-pass solution, and he encouraged me to do that instead. This took a 
while to implement and we didn't have time to finish. There are a lot of corner cases such as comparing 1.23. and 1.23.0 
you have to somehow remember for the first string that you have a 0 in the last spot even though you've reached the end
of the string.

I had another Microsoft phone screen today. It seemed to go fine. I solved it as quickly as I think was reasonable. I went for a one-pass solution instead of two-pass, which took longer.

The question was simple but I had to concentrate on corner cases. Question was this:

Compare two Strings and say which one is greater. Here are some examples:
1.32.43 > 1.23.43
First one is greater because 32 > 23
1.234.23 > 1.23.23
First one is greater because 234 > 23
1.23&*(#(@.23 == 1.23.23
These are equal because ignore non-integers.
... == 0.0.0.0
if nothing is present then this means it is a zero

At first I mentioned that it is possible to use the Java method String#split and split up the String around the periods. 
I then said, well, it is also possible to do a one-pass solution, and he encouraged me to do that instead. This took a 
while to implement and we didn't have time to finish. There are a lot of corner cases such as comparing 1.23. and 1.23.0
you have to somehow remember for the first string that you have a 0 in the last spot even though you've reached the end 
of the string.