
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

```
Example 1:

Input: nums = [1,2,3,1]
Output: true

Example 2:

Input: nums = [1,2,3,4]
Output: false

Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
```


Constraints:

- 1 <= nums.length <= 105
- -109 <= nums[i] <= 109

## 方法一

先排序，在比较相邻两个元素是否相等。

### C

```c
// qsort() 函数是 stdlib.h 中的标准函数。

int cmpfunc(const void *a ,const void *b){
    return (*(int *)a-*(int *)b);
}


bool containsDuplicate(int* nums, int numsSize){
    qsort(nums,numsSize,sizeof(int),cmpfunc);//对函数进行排序

    if(numsSize==1){
        return false;
    }

    for(int i=0;i<numsSize-1;i++){
        if(nums[i]==nums[i+1]){
            return true;
        }
    }
    return false;

}
```

### JAVA

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;

    }
}
```

