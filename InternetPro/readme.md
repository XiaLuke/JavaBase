## 网络编程三要素
1. 确定对方电脑在互联网上的IP地址
2. 接收数据的端口号
3. 确定传输规则--协议

端口号：应用程序在设备中的标识

协议：UDP、TCP、http

## IP

网络协议地址，也成为 IP 地址，设备在网络中的地址是唯一的，常见的有
IPv4、IPv6

### IPv4

互联网通信协议第四版，八位一组，总长32位，共表示≈ 43亿个地址

#### 分类形式
- 公网地址 + 私有地址
- 192.168.开头的为私有地址，范围从 192.168.0.0 ~ 192.168.255.255

#### 特殊IP
- 0.0.0.0：本机地址，没有网卡，没有IP地址
- 255.255.255.255：广播地址，所有主机都能收到
- 127.0.0.1：本机地址，localhost

### IPv6

采用128位地址长度，共八组。使用 冒分十六进制 表示

如：`2001:0D88:0000:0023:0008:0800:200C:417C`,一个完成的IPv6地址

进行简化后为：`2001:D88:0:23:8:800:200C:417C`

特殊进行压缩：`FF01:0:0:0:0:0:0:1100` => `FF01::1100`

## InetAddress使用

抽象类，需要通过静态方法获取对象，得到当前使用的是IPv4 | IPv6

## 端口
 一个应用对应一个端口

## 协议：
 网络通信协议：链接和通信的规则

    OSI参考模型：7层网络模型，从上到下依次为：应用程，表示层，会话层，传输层，网络层，数据链路层，物理层
    TCP/IP参考模型：4层模型：应用层、传输层、网络层、数据链路层
    
 UDP协议
    面向无连接通信协议，速度快，有大小限制（最多64K）数据不安全，易丢失
    
    适用于：会议，视频

 UDP的三种通信方式：单播、组播、广播


 TCP协议
    面向链接，速度慢，无大小限制，安全

    适用于：软件下载，聊天，邮件
    
    可靠的通信协议，在双端分别建立socket对象；通信前要保证链接已建立；通过Socket产生IO进行通信
    
    客户端：创建socket对象；获取输出流，写数据；释放资源
    服务端：创建服务端Socket；监听客户端链接，返回socket对象；获取输入流，读数据，显示；关流

## 三次握手--保证建立链接
1.客户端向向服务器发送请求连接 -- 等待服务器确认
2.服务器向客户端返回响应 -- 服务器收到客户端请求
3.客户端向服务器发送确认信息 -- 连接确认

## 四次挥手--确保链接断开
1.客户端发送取消链接请求 -- 
2.服务器向客户端返回响应 -- 收到客户端的取消请求
3.等待服务器数据处理完毕后，向客户端发送确认取消 
4.客户端发送确认消息 -- 连接取消

## 聊天室
### 需求：
1. 利用TCP协议，完成带登录、注册、控制台的多人聊天室

2. 客户端启动后，需要连接服务器，在控制台可输入标签进入不同功能(登录、注册)
3. 登录时，按照要求输入用户名/密码，回车进行校验，校验有以下方式（登录成功、密码错误、用户名不存在）
4. 登录成功进行消息群发（因只有UDP存在群发功能，TCP中可将所有用户socket放入一个集合中，发送消息时遍历数据发送）
5. 
### 知识点
循环、判断、集合、IO、多线程、网络编程