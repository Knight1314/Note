- 删除远程分支

- ```shell
  git push origin --delete <branch_name>
  ```

- 删除本地分支

- ```shell
  git branch -D <branch_name>
  ```

- 删除远程分支的某个文件夹

  ```shell
  git rm -r --cached directory
  git commit -m""
  git push
  ```

- stash

- ```shell
  git stash
  
  git stash list
  
  git stash pop
  
  git stash clear
  
  # 从stash中获取指定编号的存储
  git stash apply stash@{1}
  git stash apply --index
  git stash drop stash@{1}
  ```

- 标签

  ```shell
  git tag -a tag_name -m "comment"	//带有附注的标签
  git tag tag_name					//轻量级的标签
  git tag -v tag_name					//验证标签
  git tag -a tag_name commitNum		//追加标签
  
  git push origin tag_name			//将标签推送到远程分支
  git psuh origin --tags				//推送所有新增分支
  ```


- 版本

- ```shell
  git reset --soft HEAD~2				//回退前两个版本，然后将所有修改放置在staging区域
  ```

- 记录上次发布至当前所做的修改

- ```
  git log --pretty=oneline --abbrev-commit --graph --first-parent  [上次tag]..
  ```

- 

