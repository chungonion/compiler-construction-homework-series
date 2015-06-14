Question 1
----------

1.

```
    1:decl
    v
    1:inExpr
    v
    2:decl
    v
    3:forStat
    v
    3:constExpr
    v
 -- 3:compExpr <-
|   v            |
|   3:addExpr    |
|   v            |
|   3:blockStat  |
|   v            |
|   3:ifStat     |
|   v            |
|   4:compExpr --
|   v
|   4:blockStat
|   v
|   4:breakStat
|   v
 -> 8:printStat
```

### Basic blocks
* 1:decl - 3:constExpr
* 3:compExpr
* 3:addExpr - 4:compExpr
* 4:blockStat - 4:breakStat
* 8:printStat

2.

```
    1:decl
    v
    1:inExpr
    v
    2:decl
    v
    3:forStat
    v
    3:constExpr
    v
    3:compExpr <--
    v             |
    3:idExpr (1)  |
    v             |
 -- 3:fieldExpr   |
|   v             |
|   3:idExpr (2)  |
|   v             |
|   3:addExpr     |
|   v             |
|   3:idExpr (3)  |
|   v             |
|   3:constExpr   |
|   v             |
|   3:blockStat   |
|   v             |
|   3:ifStat      |
|   v             |
|   4:compExpr    |
|   v             |
|   4:arrayExpr   |
|   v             |
|   4:idExpr (1)  |
|   v             |
|   4:idExpr (2) --
|   v
|   4:blockStat
|   v
|   4:breakStat
|   v
 -> 8:printStat
```

### Basic blocks
* 1:decl - 3:contExpr
* 3:compExpr - 3:fieldExpr
* 3:idExpr (2) - 4:idExpr (2)
* 4:blockStat - 4:breakStat
* 8:printStat
