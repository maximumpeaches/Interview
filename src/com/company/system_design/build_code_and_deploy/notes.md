## Algoexpert
algoexpert covered this question [here](https://www.algoexpert.io/systems/workspace/Design%20A%20Code-Deployment%20System)
He split the question into two parts: the build and the deployment. The build part uses a queue. Workers take build 
jobs off the queue and then when they're done they submit the binary to an object storage (he refers to this as a 
[blob](https://en.wikipedia.org/wiki/Binary_large_object) storage, but you store blobs in object storage, as 
described [here](https://cloud.google.com/blog/topics/developers-practitioners/map-storage-options-google-cloud)).

## Netflix
[How We Build Code at Netflix](https://netflixtechblog.com/how-we-build-code-at-netflix-c5d9bd727f15)
Netflix builds code into Amazon Machine Images (which are virtual machine images) as the last step of build, before 
deployment. It would also make sense to build them into Docker images as a last step (but probably not build 
binaries like Algoexpert suggested).