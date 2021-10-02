# 283.Move Zeroes

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:

```
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
```


Example 2:

```
Input: nums = [0]
Output: [0]
```


Constraints:

- 1 <= nums.length <= 104
- -2^31^ <= nums[i] <= 2^31^ - 1

go

```
func moveZeroes(nums []int) {
	length := len(nums)
	var temp int
	v := 0
	var temp2 int
	for i := 0; i < length; i++ { // 遍历 length 次
		if nums[v] == 0 && v+1 < length {
			temp2 = v
			for j := v + 1; j < length; j++ {
				temp = nums[v]
				nums[v] = nums[j]
				nums[j] = temp
				v++
			}
			v = temp2 // 还原 v 的值
		} else if nums[v] != 0 && v+1 < length { //非 0 元素跳过
			v++
		}
	}
}
```

