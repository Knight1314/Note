#### schema数据类型

##### Primitive Types

- null: no value
- boolean: a binary value
- int: 32-bit signed integer
- long: 64-bit signed integer
- float: single precision (32-bit) IEEE 754 floating-point number
- double: double precision (64-bit) IEEE 754 floating-point number
- bytes: sequence of 8-bit unsigned bytes
- string: unicode character sequence

##### Complex Types

Avro提供六种符合类型，分别是：records, enums, arrays, maps, unions and fixed.

**records**

```json
{
  "type": "record",
  "name": "LongList",
  "aliases": ["LinkedLongs"],                      // old name for this
  "fields" : [
    {"name": "value", "type": "long"},             // each element has a long
    {"name": "next", "type": ["null", "LongList"]} // optional next element
  ]
}
```

```go
/** 支付订单结果 */
record AfterLoanOrderPayResult {
    /** 借款唯一id */
    int borrow_id;
    /** Order Type */
    OrderType order_type;
    /** 事件时间戳（秒） */
    long timestamp;
    /** 订单ID */
    string order_no;
    /** 成功金额 */
    long success_amount;
    /** 支付网关订单号 */
    string biz_no;
    /** Response Code */
    int response_code;
    /** Response Message */
    string response_message;
  }
```

**enums**

```json
{ "type": "enum",
  "name": "Suit",
  "symbols" : ["SPADES", "HEARTS", "DIAMONDS", "CLUBS"]
}
```

```go
enum OrderType {
    /** 未结清,结清 */
    PAY,
    RECEIVE
}
```

**Arrays**

```json
{"type": "array", "items": "string"}
```

**Maps**

map的key默认是string类型的数据，只需要定义values的数据类型即可

```json
{"type": "map", "values": "long"}
```

**Unions**

union使用Json数组来定义一个字符的类型，如["null", "string"]则定义了一种规则表示此字段对应的值既可以为null，也可以为字符串。当union类型要定义默认值的时候，通常匹配其第一个类型，如当union为["null","string"]时，其默认值为null。

union不能包含两个Array类型的或者不能包含两个Map类型，而且也不能包含其他的union类型

```go
union {null, string} jr_link_source = null;
```

**Fixed**

```josn
{"type": "fixed", "size": 16, "name": "md5"}
```