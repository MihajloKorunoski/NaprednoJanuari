package mk.ukim.finki.napredno.ispitni.ispitni.genericmapmerge;

interface MergeStrategy<T> {
    T merge(T left, T right);
}
