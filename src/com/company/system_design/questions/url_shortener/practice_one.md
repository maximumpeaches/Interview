So this is just me practicing answering this question.
Let's say we have 25 million new URLs per year.
What is the read to write ratio? It's 100 reads per 1 write.
Will URLs expire? i.e. should we clean them up after some time? In this example, no they don't.
For each URL, what is the API and what are we storing?
API can look like this
POST /api/v1/data/shorten
it receives a request parameter like this: {longUrl: www.google.com/searchquery?p=how%to%build%a%model%airplane}
it's going to return a JSON payload like this {shortUrl: www.tinyurl.com/ajwo398C}
There will also be an API like this
GET /api/v1/shortUrl
that will issue a 301 HTTP redirect
So, first let's just say we store the shortUrl and longUrl.
longUrl let's say has average character length of 100 characters. Short URL has X number of characters.
If we have 25 million new URLs per year, then let's say we have URLs are composed of only upper and lowercase letters
and numbers, then short URL will have 62 possible values for each character. If we say short URL is length 5 then
it is 5^62 which is about 2*10^43, and 25 million is like 2*10^8, so we have enough for over 100 years since 100 * 2*10^8
is only 2*10^10.
If we only have 5 characters per short URL, then each character might be like one byte (this is an overestimate since
you could potentially fit them in 6 bits since you're only using upper and lowercase letters and numbers, so that's
62 values and 2^6=64 so you could fit 62 values inside of 2^6, but we can just estimate one byte). So if you have 5
bytes per short URL, and maybe you have 100 characters at one byte each for the long URL, then you have 105 bytes per
URL. You also have 25 million URLs per year so let's say that's 100 bytes * 25,000,000 = 1,000,000 * 2,500 or 2,500 MB
which is just 2.5GB per year. Modern servers can fit 256GB in main memory (according to Educative) so you could fit
100 years of data in memory in just one machine.

If you have 25 million new URLs per year then you have 25,000,000 / (365 * 24 * 60 = 525600) URLs per minute, or 47.5 URLs
per minute. A single server could easily generate this many unique URLs per minute. I would think it could generate hundreds
per minute if necessary.

I like the idea of having an offline key generator service that generates keys and puts them into a stockpile for future
use. We just need one machine to do this since as discussed it only needs to generate ~50 URLs per minute. It could
use a counter as the input to a hash function, and use some sort of consistent hash like MD5. It could run offline, maybe
as a function-as-a-service, and save / retrieve the counter to disk somewhere in case it crashes or if it's a function-as
-a-service. Then it maybe writes the new URLs to a set in-memory somewhere, like a memcache or redis instance.

The write API where the user submits the long URL could then retrieve the short URL from the memcache or redis instance. Alternatively,
if we want the long URL to short URL mapping to be one-to-one then the write API could check first if the long URL already
has a short URL before retrieving one from the stockpile. Once it retrieves it, it could write the mapping to another
database... again if the long to short mapping must be one-to-one then it needs to do a conditional insert into the database,
otherwise it can just write it. The database that contains the long to short mapping needs to be optimized for reads
since there will be many more reads than writes.

We could consider something like Redis for the database since it provides caching, and is a key-value store. To be honest
I'm not super familiar with database choices, so I should probably study this section more, another time.

We know we want to redirect the user to the long URL when they call our Read API with the short URL. When we redirect
them, there are two types of redirects. One is HTTP code 301 and it's a permanent redirect. It means the URL is permanently
at the location. The browser then caches this new location for the short URL. The other is HTTP code 302 and it is a temporary
redirect. In this case the browser won't cache the location of the URL, since it's temporary. 302 is better if we want
to track user visits to other websites because the user has to come back to our website each time they want to visit
the long URL through our short URL.