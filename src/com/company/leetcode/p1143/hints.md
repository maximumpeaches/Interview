If you use an object-oriented key and a HashMap for the memoization of this problem, then you get a TLE. This is the 
approach of Solution.java and if you copy/paste it into LC you'll get a time limit exceeded. If you use an array to 
store the memo instead of a HashMap, then you won't get a TLE.