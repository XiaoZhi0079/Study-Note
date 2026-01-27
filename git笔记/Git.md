# Git

## 指令规则

![image-20251103150028238](./media/image-20251103150028238.png)

### 基本操作

git init //初始化仓库 

git add //添加至暂存处

git commit -m "简单摘要" //将更改提交至存储库

#### 推送

git branch -M main  //指定分支为main  默认分支名为master，改名是为了与github这样的平台匹配

git remote add origin <URL>  //关联远程仓库  origin是远程的代号 也可以取其他名                                                                                                                                                

git remote -v //查看当前绑定的远程仓库

git remote set-url origin <URL>  //更改设置远程仓库url

git push -u origin main  // 绑定upstream为远程origin的main分支。首次推送时， 应绑定远程仓库的分支

git push //推送执行该命令的本地分支的新内容至远程仓库与之绑定的分支

Tips：本地仓库在向远程仓库推送时，必须保证自己的版本比远程仓库更新，才可以将进行push操作。所以在推送时需要先git pull(git fetch,git merge),然后再git push

git pull //更新本地仓库 使其与远程仓库同步

#### 拉取

git fetch <branchname>  //将指定分支的内容下载下来 但是未合并

git merge <branchname>   //将指定分支指定到当前分支 

git pull //更新本地仓库 使其与远程仓库同步

**Tip：**git pull = git fetch  + git merge

#### *变基- rebase

在git中，base的概念类似于祖先 设想如下场景，我在main分支上最新的提交点拉取了分支补丁A，同事在main分支拉去了分支补丁B，然后我和同事分别进行了不同模块的开发，此时，main上的此提交点就是A和B的祖先。同事开发了模块B，提交代码至main，此时我完成了模块A的开发，我无法将代码直接提交到main，因为main上的最新提交是同事开发B模块的提交点，我需要先拉取代码，此时会有一个分支合并的问题。

##### 路线一：常规合并 (Merge)

这是最基础的操作。当你拉取并合并时，Git 会执行“三向合并”。

- **过程**：Git 寻找 祖先`C1`，对比 `C2` 和 `C3` 的差异，然后生成一个全新的提交 **`C4 (Merge Commit)`**。
- **结果**：历史线会出现一个分叉又合拢的“小辫子”。

------

##### 路线二：变基 (Rebase)

当你执行 `git pull --rebase` 时：

- **过程**：
  1. Git 把 `C3` 暂时“拔掉”。
  2. 把本地代码起点更新到最新的 `C2` 上。
  3. 把 `C3` 重新“贴”在 `C2` 的后面。  //如若两人修改了相同的代码 发生冲突 C3会不会直接覆盖C2？见下文。
- **结果**：**历史线是一条完美的直线**。在别人看来，就像是等同事写完模块 B 之后，才开始写模块 A 的。

**问：变基（Rebase）过程中，如果我的代码和同事的代码有冲突，会发生“强制覆盖”导致同事代码丢失吗？**

**答：** **绝对不会。** * **安全机制**：Git 在“重演”代码时，如果发现两边改了同一行，会立即**中断变基**并发出警告。

- **人工介入**：你需要手动解决冲突、标记已解决（`git add`），然后告诉 Git 继续（`git rebase --continue`）。
- **本质区别**：变基是**修改你自己的历史**去适应别人的现状，而不是抹除别人的工作。除非你最后错误地使用了 `git push --force`，否则代码非常安全。

### git log 

#### 基本语法

```
git log [选项] [范围]
```

#### 案例

git log //默认打印所在分支的日志

git log main //打印main分支的log

git log --oneline  //提交一行显示

git log -n  //只显示前n行数据

## 回滚操作

### git revert：反转提交，不会更改历史，将记录加到提交记录的后边。

Tips:在sourcetree中，对应 回滚提交。

#### 基本语法

```
git revert [<选项>] <commit_hash>...        //commit_hash对应sourcetree中的sha    
```

git revert head     //撤销最近一次提交，文件会自动修改为上一次提交的状态。

git revert <commit_hash>   //自动生成一次新提交，撤销某次特定提交。

git revert -n <commit_hash>  //撤销这次提交的改动，但不要马上提交，之后手动提交。

#### 特殊案例

如果在一个提交里同时改了文件 a、b、c，但**只想要文件 a 回到过去**，不影响其他，可以这样做：

1. **直接签出该文件的旧版本**：

   ```
   git checkout <文件a正常的那个提交ID> -- a.txt
   ```

2. **提交更改**： 这时你的工作区里，文件 a 已经变回去了，而文件 b，c 还是新的。你只需要：

   ```
   git add a.txt
   git commit -m "将文件a恢复到旧版本，保留文件b的修改"
   ```

### git reset：会改变历史的提交，直接回到历史某个提交

Tips:在sourcetree中，对应 重置至此提交。

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

git reset --soft HEAD~1  //抵消commit命令，相当于执行了git add，文件也是修改后的状态。

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

## Branch-分支

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

## .gitignore的规则

#:注释符号

*:匹配任意数量的字符

```
*.out      //匹配文件夹下所有.out文件
*.jpg      //匹配文件夹下所有jpg文件
```

?:代替任意单个字符

```
123?5.txt   //匹配12305.txt 12315.txt 12325.txt...... 
```

[]:匹配大括号中其中任意一个字符

```
file[abc].txt   // 匹配 filea.txt、fileb.txt、filec.txt
log[0-9].txt    // 匹配 log0.txt…log9.txt
```

!:反向匹配 如果要重新跟踪某个之前忽略的文件，可以使用 !，例如：!important.txt 会确保 important.txt 被跟踪，即使它匹配了上面的规则。

目录匹配：在目录名后加 / 来匹配目录。

```
logs/    //匹配 logs 目录下的所有文件和子目录。
```

**：代替任意层数的文件夹

```
src/**/a.java   //匹配 src/main/java/a.java  src/text/java/a.java
```

