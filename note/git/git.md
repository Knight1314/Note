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
  
  ```

  

