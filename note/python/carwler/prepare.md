##### 安装python3

```shell
brew install python3
```

##### 安装依赖库

```shell
pip3 install requests
pip3 install selenium

pip3 install aiohttp
pip3 install cchardet aiodns

pip3 install lxml
pip3 install beautifulsoup4
pip3 install pyquery


brew install imagemagick 
brew install tesseract --with-all-languages
pip3 install tesserocr pillow


brew install mongodb
brew install redis
pip3 install pymysql
pip3 install pymongo
pip3 install redis    gem install redis-dump


pip3 install flask
pip3 install tornado

pip3 install pyspider

erro fix:
pip3 uninstall pycurl# 卸载库
export PYCURL_SSL_LIBRARY=openssl
export LDFLAGS=-L/usr/local/opt/openssl/lib
export CPPFLAGS=-I/usr/local/opt/openssl/include# openssl相关头文件路径
pip3 install pycurl --compile --no-cache-dir # 重新编译安装
```

##### 安装软件

chromedriver  http://chromedriver.chromium.org/downloads

phantomjs       http://phantomjs.org/download.html

