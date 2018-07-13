#### 元素选择器

```javascript
$("element_name")
$(".class_name")
$("#id_name")
$("*")
$("element1,element2,...")
```

#### 属性选择器

```javascript
//所有包含有属性值的元素
$("[attr_name]")

$("[attr_name='val']")
$("[attr_name!='val']")

//含有以val结尾的属性值的元素
$("[attr_name$='val']")

//含有以val开头的属性值的元素
$("[attr_name^='val']")

//等于val或者以'val-'开头的字符的元素
$("[attr_name|='val']")

//属性值包含字符'val'在内的元素
$("[attr_name*='val']")

//属性值用空格分割后包含有val这个词的元素
$("[attr_name~='val']")

//多重属性选择器
$("[attr_name1][attr_name2]")
```

#### CSS选择器

修改选中元素的CSS样式值

```javascript
$(element).css("key","val")
```

