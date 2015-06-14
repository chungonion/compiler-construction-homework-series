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
* 8:printStat
