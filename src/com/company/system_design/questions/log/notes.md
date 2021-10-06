Facebook wrote a distributed log system described here: https://engineering.fb.com/2017/08/31/core-data/logdevice-a-distributed-data-store-for-logs/
One important thing they did was they distributed log writes across multiple nodes, so that writing spikes could
be more evenly spread out, and so there is redundancy amongst nodes if one goes down. It can also level out reading
spikes. They give each log a sequence number so the order is known, before writing it.