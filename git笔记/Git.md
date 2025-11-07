# Git

## 指令规则

![image-20251103150028238](./media/image-20251103150028238.png)

### 基本操作

git init //初始化仓库 

git add //添加至暂存处

git commit -m "简单摘要" //将更改提交至存储库

#### 推送

git push //更新远程仓库使其与本地仓库同步  

本地仓库在向远程仓库推送时，必须保证自己的版本比远程仓库更新，才可以将进行push操作。所以在推送时需要先git fetch,git merge,然后再git push

git pull //更新本地仓库 使其与远程仓库同步

git remote add origin https://github.com/<你的用户名>/<仓库名>.git  //关联远程仓库

git remote -v //查看当前绑定的远程仓库

git branch -M main  //指定分支

git remote set-url origin <读用的URL>  //更改设置远程仓库url

### git log 

#### 基本语法

```
git log [选项] [范围]
```

#### 案例

git log //默认打印所在分支的日志

git log main //打印main分支的log

git log --oneline  //美国提交一行显示

git log -n  //只显示前n行数据

## 回滚操作

### git revert

#### 基本语法

```
git revert [<选项>] <commit>...
```

#### 案例

git revert head     //撤销最近一次提交，文件会自动修改为上一次提交的状态。

git revert <commit_hash>   //撤销某次特定提交，立即提交。

git revert -n <commit_hash>  //撤销这次提交的改动，但不要马上提交，我想先看一看再手动提交。

### git reset

#### 基本语法

```
git reset [--soft|--mixed|--hard] <目标>
目标处填写以下内容：
提交哈希（commit ID）
分支名
标签名（tag）
HEAD 的相对位置（如 HEAD~1, HEAD^, HEAD~3）
甚至某个远程分支（如 origin/main）
```

#### 案例

git reset --soft HEAD~1  //抵消commit命令，执行了git add的文件依旧在暂存区，文件也是修改后的状态。

git reset --mixed HEAD~1  //抵消commit和add命令 但是文件仍然在修改后的状态。

git reset --hard HEAD~1   //抵消commit和add命令 文件在修改前的状态（即上一次commit之后的状态）。

### git restore

丢弃工作区的改动

```
# 丢弃单个文件在工作区的修改，回到“暂存区里的版本”（若未暂存则回到 HEAD）
git restore path/to/file

# 丢弃整个项目的工作区修改
git restore .
```

撤销已暂存（等价于旧命令 `git reset HEAD <paths>`）

```
# 把文件从暂存区撤回到工作区，改动仍保留在工作区
git restore --staged path/to/file
```

从某个提交恢复文件内容到工作区

```
# 把 file 恢复成 HEAD~2 那次提交里的样子（仅工作区改变）
git restore --source=HEAD~2 path/to/file
```

恢复被误删的已跟踪文件

```
# 如果你删了一个已跟踪文件（未提交），直接恢复
git restore path/to/deleted-file
```

.................

## Branch

### 创建 切换 重命名 删除

git branch  //查看本地分支

git branch -a  //查看所有分支（包括远程仓库）

git branch <branch name>  //创建新分支

git switch <branchname>   //切换到新分支

git switch -c <branchname>  //创建并切换到新分支 

git branch -d <branchname>   //删除分支

git branch -D <branchname>   //强制删除分支

git branch -m <branchname> <newname>  //重命名分支



git diff <branch1> <branch2>  //查看分支差异

### 推送

git push //更新远程仓库使其与本地仓库同步  

本地仓库在向远程仓库推送时，必须保证自己的版本比远程仓库更新，才可以将进行push操作。所以在推送时需要先git fetch,git merge,然后再git push

### 拉取

git fetch <branchname>  //将指定分支的内容下载下来 但是未合并

git merge <branchname>   //将指定分支指定到当前分支 

git pull //更新本地仓库 使其与远程仓库同步

**Tip：**git pull = git fetch  + git merge

## .gitignore的规则

#:注释符号

*:匹配任意数量的字符

```
*.out      //匹配文件夹下所有.out文件
```

?:代替任意单个字符

```
123?5.txt   //匹配12345.txt  12365.txt 但是不忽略12235.txt
```

[]:匹配大括号中其中任意一个字符

```
file[abc].txt   // 匹配 filea.txt、fileb.txt、filec.txt
log[0-9].txt    // 匹配 log0.txt…log9.txt
```

!:如果要重新跟踪某个之前忽略的文件，可以使用 !，例如：!important.txt 会确保 important.txt 被跟踪，即使它匹配了上面的规则。

目录匹配：在目录名后加 / 来匹配目录。

```
logs/    //匹配 logs 目录下的所有文件和子目录。
```

**：代替任意层数的文件夹

```
src/**/a.java   //匹配 src/main/java/a.java  src/text/java/a.java
```

