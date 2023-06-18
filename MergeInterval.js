function merge(intervals) {
  if(intervals.length < 2) return intervals
  
  //sort
  intervals.sort((a,b) => a[0]-b[0])
  
  for(let i = 1; i < intervals.length; i++) {
    let current = intervals[i]
    let previous = intervals[i-1]
    
    if(current[0] <= previous[1]) {
      intervals[i] = [previous[0], Math.max(previous[1], current[1])]
      intervals.splice(i-1, 1)
      i--
    }
  }
  
  return intervals
}

merge([[1,4], [2,5], [7,9]])//[[1,5], [7,9]], Since the first two intervals [1,4] and [2,5] overlap, we merged them into one [1,5].
merge([[6,7], [2,4], [5,9]])//[[2,4], [5,9]], Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].
merge([[1,4], [2,6], [3,5]])//[[1,6]], Since all the given intervals overlap, we merged them into one.
merge([[2,5]])