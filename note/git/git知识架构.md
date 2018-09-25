#### Git的演进过程

本地版本控制系统—>集中化的版本控制系统（CVCS）—>分布式版本控制系统（DVCS）

- 集中化的版本控制系统的缺点是中央服务器的单点故障，如果宕机一小时，那么在这一小时内谁都无法提交更新，也就无法协同工作。 如果中心数据库所在的磁盘发生损坏，又没有做恰当备份，毫无疑问你将丢失所有数据——包括项目的整个变更历史，只剩下人们在各自机器上保留的单独快照

#### Git保存文件的原理

Git保存文件只保存文件的最新快照，如果文件没有改动，则当前文件状态引用上一次的结果值。

![](/Users/jankeyfu/Documents/personal_file/note/git/snapshots.png)

#### Git的三种状态

已修改（modified）、已暂存（staged）和已提交（committed），这三种状态分别对应着三个区域工作目录、暂存区域以及 Git 仓库

![](/Users/jankeyfu/Documents/personal_file/note/git/areas.png)

