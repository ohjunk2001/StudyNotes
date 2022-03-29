
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

```
Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1
```


Constraints:

- 1 <= nums.length <= 3 * 104

- -3 * 104 <= nums[i] <= 3 * 104

Each element in the array appears twice except for one element which appears only once.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/single-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

go

```go
func singleNumber(nums []int) int {
	number:=0
	for _,v :=range nums{
		number^=v
	}
	return number
}
```

java

```java
class Solution {
    public int singleNumber(int[] nums) {
        int number=0;
        for (int num:nums){
            number^=num;
        }
        return number;
    }
}
```

c

```c
int singleNumber(int* nums, int numsSize){
    int number=0;
    for(int i=0;i<numsSize;i++){
        number^=nums[i];
    }
    return number;

}
```

python

```python
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        return reduce(lambda x, y: x ^ y, nums)
```

