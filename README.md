# 概要
基于GREenDao1.3.6版本
本人不太倾向于3.x版本。唯一感兴趣的功能是加密。
因为本人习惯SQL去执行，但用了GreenDao其实应该使用它封装的增删改查，可以省事一些。
这个仁者见仁智者见智吧。封装的开启了事务，批量大数据量插入时会快很多。但是这种业务场景很少。
以后若有任何关于GreenDao的使用心得都会更新在此。


# 工程包含
1. 集成1.3.6版本的方式 （不使用Build）
2. 包组织结构
3. 实体类的使用严格执行 与数据库映射的实体不完全为业务服务（可以继承达到拓展比如UserCustomer）
4. DBHelper的封装，有同步Session和异步Session，使用实例代码在MainActivity





# 致谢
[GreenDao](http://greenrobot.org/greendao/)






