# August 26th 2021
Solved pretty quickly on first try.
Not sure if it's better to write
if (map.get(i) == null) {
    map.put(i, 1);
} else {
    map.put(i, map.get(i) + 1);
}
or
map.put(i, map.get(i) == null ? 1 : map.get(i) + 1);