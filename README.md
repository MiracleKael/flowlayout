# flowlayout
在鸿洋的流式布局库flowlayout（https://github.com/hongyangAndroid/FlowLayout）  ；的基础上，增加了数据刷新、初始化默认选中以及最少选中条数的功能
如何使用？
如何使用？

基本用法看鸿洋的，这里只描述一下新增的功能。



1.数据刷新：

```
brandAdapter.refreshData(List list);
```

通过使用这个方法，就不用频繁的去new Adapter()了

2.初始化默认选中：

```
flowlayout.setAdapter(brandAdapter,0);
```

3.最少选中条数

```
<com.miracle.flowlayout.TagFlowLayout
    android:id="@+id/brand_flowlayout"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:at_least_checked_num="1"
    app:max_select="1" />
```

最少要选中的数量，如设置1，那么最少要选中1个，如果已经只剩一个选中时，再次点击，无法取消这最后一个选中的状态

