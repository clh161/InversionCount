# Merge Sort and Inversion Count [![Build Status](https://travis-ci.org/clh161/InversionCount.svg?branch=master)](https://travis-ci.org/clh161/InversionCount)

This library uses [merge sort](https://en.wikipedia.org/wiki/Merge_sort) algorithm to sort an array and gives the [inversion](https://en.wikipedia.org/wiki/Inversion_(discrete_mathematics)) count.

## Performace 

O(nlog(n))

Inversion is counted during the merge sort 

Consider the follow array:
```java
[1,5,100,200,7,20,2,9]
```

From the last step of merge sort we have 2 sorted arrays 

```java
a=[1,5,100,200]
b=[2,9,7,20]
```
The idea is when the the element `a[i]` is bigger than `b[j]`, there will be `j+1` inversion because `b` is a sorted array and `a[i]` is bigger than `b[j]` , `b[j-1]`, `b[j-2]` ... `b[0]` 