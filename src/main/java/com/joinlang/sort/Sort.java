package com.joinlang.sort;

import java.util.Collection;
import java.util.List;

public interface Sort<T extends Comparable<T>> {
    List<? extends T> sort(Collection<? extends T> collection);
}
