# Day20-BST-Part9
● 669. 修剪二叉搜索树 

找到不合标准的点，如果比low小，return它的右部分，如果比high大，那么return它的左部分。

● 108.将有序数组转换为二叉搜索树 

先找到中间点，然后把数组分为左右两部分，注意分隔边界，一般使用左闭右开。

● 538.把二叉搜索树转换为累加树 

反中序遍历，然后用pre指针记录上一个节点的数组，持续累加。

Morris: 正序

遍历节点直到当前节点为null

如果当前节点左孩子为null，加入当前节点，往右移动

如果当前节点左孩子不为null，找到predecessor。即为左孩子最右的节点，且不能为当前节点。

    如果predecessor右孩子为null，则指向当前节点，当前节点左移。

    如果predecessor不为null，则加入当前节点，当前节点右移。

直到遍历完整棵树。

如果烦序则一切左右调换即可。
