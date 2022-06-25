

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

![1](https://images-1302683597.cos.ap-nanjing.myqcloud.com/images/StudyNotes/Algorithm/leetcode/48Rotate%20Image/images_20220606161047.png)

Constraints:

- `n == matrix.length == matrix[i].length`
- `1 <= n <= 20`
- `-1000 <= matrix[i][j] <= 1000`

在 L1 上取一个点，先沿 L2 对称，再沿 L3 对称，这样就旋转了 90度。

同理 L1 上任意一个点可以通过类似的操作完成旋转

进而可以知道，与 L1 平行的直线上的点可以通过类似的操作完成旋转

![2](https://images-1302683597.cos.ap-nanjing.myqcloud.com/images/StudyNotes/Algorithm/leetcode/48Rotate%20Image/images_20220606160410.png)

