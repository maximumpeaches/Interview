Consider that a relational database can handle somewhere in the ballpark of ~10k transactions per second, according to:
https://philip.greenspun.com/blog/2011/01/10/how-many-updates-per-second-can-a-standard-rdbms-process/
This is a very rough estimate, but if you're designing a system that's going to have somewhere in the ballpark of ~8k
tps for the database, then you will need to consider sharding or using one of the NoSQL alternatives, or having read replicas.
Remember that one guy said that read replicas have their own problems, so they're best to avoid if possible, because
you inevitably end up reading data from the read replica that is stale because it is not sync'd with the database yet,
i.e. you lose atomicity.

ACID stands for
atomicity
consistency
isolation
durability

# How to choose a database?
- Some answers here: https://www.youtube.com/watch?v=cODCpXtPHbQ