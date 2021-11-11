package com.udalny.entity.statistics;

import java.math.BigDecimal;

public class DocumentsStatistics {

    private final long count;
    private final BigDecimal averageSum;

    public DocumentsStatistics(long count, BigDecimal averageSum) {
        this.count = count;
        this.averageSum = averageSum;
    }

    public long getCount() {
        return count;
    }

    public BigDecimal getAverageSum() {
        return averageSum;
    }

    @Override
    public String toString() {
        return "DocumentsStatistics{" +
                "count=" + count +
                ", averageSum=" + averageSum +
                '}';
    }
}
