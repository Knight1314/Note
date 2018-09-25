#### 数组key

- 包含有合法整型值的字符串会被转换为整型。例如键名 *"8"* 实际会被储存为 *8*。但是 *"08"* 则不会强制转换，因为其不是一个合法的十进制数值。
- 浮点数也会被转换为整型，意味着其小数部分会被舍去。例如键名 *8.7* 实际会被储存为 *8*。
- 布尔值也会被转换成整型。即键名 *true* 实际会被储存为 *1* 而键名 *false* 会被储存为 *0*。
- [Null](http://php.net/manual/zh/language.types.null.php)会被转换为空字符串，即键名 *null* 实际会被储存为 *""*。
- 数组和对象*不能*被用为键名。坚持这么做会导致警告：*Illegal offset type*。

- 如果在数组定义中多个单元都使用了同一个键名，则只使用了最后一个，之前的都被覆盖了。

- 方括号和花括号可以互换使用来访问数组单元（例如 $array[42] 和 $array{42} 效果相同）。

自 PHP 5.4 起可以用直接对函数或方法调用的结果进行数组解引用，在此之前只能通过一个临时变量。自 PHP 5.5 起可以直接对一个数组原型进行数组解引用

```php
function getArray(){
    return array(1,2,3);
}

//previous
$tmp = getArray();
$first = $tmp[0];

//php5.4
$first = getArray()[0];

//php5.5
list($first,) = getArray();
```

如果给出方括号但没有指定键名，则取当前最大整数索引值，新的键名将是该值加上 1（但是最小为 0）。如果当前还没有整数索引，则键名将为 *0*。注意这里所使用的最大整数键名*不一定*当前就在数组中。它只要在上次数组重新生成索引后曾经存在过就行了。

```php
$array = array(1, 2, 3, 4, 5);
foreach ($array as $i => $value) {
    unset($array[$i]);
}
$array[] = 6;	//这里是array[5] = 6 而不是array[0] = 6
```

#### 数组函数

##### array_change_key_case

> array array_change_key_case ( array $array [, int $case = CASE_LOWER ] )

修改数组一维键名为大写或者小写，case有两种模式：`CASE_LOWER`（默认值） 和 `CASE_UPPER`。 如果一个数组中的多个键名经过本函数后变成一样的话（例如 "*keY*" 和 "*kEY*"），最后一个值将覆盖其它的值。

```php
 [
    "first" => 1,
    "second" => [
        "second_first" => 2.1
    ]
]

=====> 
[
    "FIRST" => 1,
    "SECOND"=> [
    	"second_first" => 2.1
    ]
]
```

深度key转换

```php
function array_change_key_case_recursive($arr) {
    return array_map(function ($item) {
        if (is_array($item))
            $item = array_change_key_case_recursive($item);
        return $item;
    }, array_change_key_case($arr,CASE_UPPER));
}
```

##### array_chunk

> array array_chunk ( array $array , int $size [, bool $preserve_keys = false ] )

将一个数组分割成多个数组，其中每个数组的单元数目由 `size` 决定。最后一个数组的单元数目可能会少于 `size` 个。参数$preserve_keys设为 **TRUE**，可以使 PHP 保留输入数组中原来的键名。如果你指定了 **FALSE**，那每个结果数组将用从零开始的新数字索引。默认值是 **FALSE**。

```php
$arr3 = [
    "first" => 1,
    "second" => 2,
    "third" => 3,
    "fourth" => 4,
];

var_dump(array_chunk($arr3,2,true));

/*
array(2) {
  [0] =>
  array(2) {
    'first' =>
    int(1)
    'second' =>
    int(2)
  }
  [1] =>
  array(2) {
    'third' =>
    int(3)
    'fourth' =>
    int(4)
  }
}
*/
```

##### array_column

> array array_column ( array `$input` , [mixed](http://php.net/manual/zh/language.pseudo-types.php#language.types.mixed) `$column_key` [, [mixed](http://php.net/manual/zh/language.pseudo-types.php#language.types.mixed) `$index_key` = null ] )

**array_column()** 返回`input`数组中键值为`column_key`的列， 如果指定了可选参数`index_key`，那么`input`数组中的这一列的值将作为返回数组中对应值的键。

```php
$records = array(
    array(
        'id' => 2135,
        'first_name' => 'John',
        'last_name' => 'Doe',
    ),
    array(
        'id' => 3245,
        'first_name' => 'Sally',
        'last_name' => 'Smith',
    ),
    array(
        'id' => 5342,
        'first_name' => 'Jane',
        'last_name' => 'Jones',
    ),
    array(
        'id' => 5623,
        'first_name' => 'Peter',
        'last_name' => 'Doe',
    )
);
$last_names = array_column($records, 'last_name', 'id');
print_r($last_names);
/*
Array
(
    [2135] => Doe
    [3245] => Smith
    [5342] => Jones
    [5623] => Doe
)
*/
```

##### array_shift

> [mixed](http://php.net/manual/zh/language.pseudo-types.php#language.types.mixed) array_shift ( array `&$array` )

**array_shift()** 将 `array` 的第一个单元移出并作为结果返回，将 `array` 的长度减一并将所有其它单元向前移动一位。所有的数字键名将改为从零开始计数，文字键名将不变。

##### array_unshift

> int array_unshift ( array `&$array` , [mixed](http://php.net/manual/zh/language.pseudo-types.php#language.types.mixed) `$value1` [, [mixed](http://php.net/manual/zh/language.pseudo-types.php#language.types.mixed) `$...` ] )

**array_unshift()** 将传入的单元插入到 `array` 数组的开头。注意单元是作为整体被插入的，因此传入单元将保持同样的顺序。所有的数值键名将修改为从零开始重新计数，所有的文字键名保持不变。

##### array_walk

> bool array_walk ( array `&$array` , [callable](http://php.net/manual/zh/language.types.callable.php) `$callback` [, [mixed](http://php.net/manual/zh/language.pseudo-types.php#language.types.mixed) `$userdata` = **NULL** ] )

使用用户自定义函数对数组中的每个元素做回调处理。典型情况下 `callback` 接受两个参数。`array` 参数的值作为第一个，键名作为第二个（也就是说回调函数默认情况下只允许有两个参数值，一个为key，一个为value）。如果提供了可选参数 userdata，将被作为第三个参数传递给 callback funcname。

```
function callbackT($val, $key){
    
}
```

**类中的回调方法**

```php
//静态方法
array_walk($array, array('self', 'walkFunction'));
array_walk($array, array('className', 'walkFunction'));

//非静态方法
array_walk($array, array($this, 'walkFunction'));
```





