package mk.ukim.finki.napredno.exercises.ispitni.genericmapmerge;

interface MergeStrategy<T> {
    T merge(T left, T right);
}
