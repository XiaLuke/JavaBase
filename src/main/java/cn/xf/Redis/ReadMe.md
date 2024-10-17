> 基本内容

1. redis默认有16个数据库，默认使用第0个 使用select index切换
2. set key value，设置键与值
3. keys * ，查看当前数据库所有key
4. flushdb ，清楚当前数据库
5. flushAll，清除所有数据库
6. expire key time，设置过期时间

> Redis是单线程的

redis基于内存操作，cpu不是redis的性能瓶颈，而是机器的内存和网络带宽；
> 单线程为何速度依然迅速

1. 基础-------redis是将所有数据放在内存中，所以使用单线程就是最高的

> Redis中的数据类型

1. String
    ```text
   1. append key value, 向字符串追加，如果key不存在则创建
   2. incr key , 自增1
   3. decr key , 自减1
   4. increby key 增量 ，增加指定步长
   5. decreby key 增量 ，减少指定步长
   6. getrange key start end ,截取长度
   7. setrange key start value,替换
   8. setex(set with exist) key time value ,对存在的键设置生命时间与值
   9. setnx(set if not exist) key value ,对存在的键设置值
   10. mset key value key value,批量设置
   11. mget key key ,批量获取
   12. msetnx key value key value，具有原子性，一起成功，一起失败
   13. 实际使用中，可以使用{类名}:{num}:{filter}
   14. getset key value , 返回获取到的值，修改原来的值为value
   ```
2. list
   ```text
   1. lpush（rpush） key value,存值--每次从左(右）边存一个值
   2. lrange list start end，获取指定长度数据（end=-1时为全部）
   3. l(r)pop list，从左（右）移除第一个元素
   4. lindex list value，获取下标为value的值
   5. llen list，获取list长度
   6. lrem list count value，移除指定个数的值
   7. ltrim list start end， 截取指定长度数据为list的值
   8. l(r)poplpush list newlist， 从左（右）弹出数据添加到新的list中
   ```
3. set
4. hash
5. zset

>事务
