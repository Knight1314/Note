```
<?php
/**
 * Created by PhpStorm.
 * User: jankeyfu
 * Date: 2018/7/9
 * Time: 下午7:46
 */

/**    PHPExcel root directory */
if (!defined('AVROKAFKA_ROOT')) {
    /**
     * @ignore
     */
    define('AVROKAFKA_ROOT', dirname(__FILE__) . '/');
    require(AVROKAFKA_ROOT . 'autoload.php');
}

class AvroKafkaFactory{


    public static function createAvroKafkaToolInstance($env,$subjectName){
        return GuaziCall\AvroKafka\AvroKafkaTool::getInstance($env,$subjectName);
    }


}
```

```
{
  "repositories": [
    {
      "type": "composer",
      "url": "https://packages.guazi-corp.com",
      "options": {
        "ssl": {
          "verify_peer": false,
          "verify_peer_name": false,
          "allow_self_signed": true
        }
      }
    }
  ],
  "require":{
     "guazicall/avrokafka":"2.1.2"
  }
}
```