Question 3
----------

1.

```
a[i+1] + b.field

E
E + F
F + F
G + F
G [ E ] + F
A [ E ] + F
ID [ E + F ] + F
ID [ F + F ] + F
ID [ G + F ] + F
ID [ A + F ] + F
ID [ ID + F ] + F
ID [ ID + G ] + F
ID [ ID + A ] + F
ID [ ID + NUM ] + F
ID [ ID + NUM ] + G
ID [ ID + NUM ] + G . ID
ID [ ID + NUM ] + A . ID
ID [ ID + NUM ] + ID . ID

              E
             /|\
            E + F
           /    |
          F     G
         /     /|\
        G     G . ID
       /|     |
      / |     A
     / /|\    |
    G [ E ]   ID
   /   /|\
  A   E + F
 /    |   |
ID    F   G
      |   |
      G   A
      |   |
      A   ID
      |
      ID
```

```
((Type) x).i - 10 + y

E
E + F
E - F + F
F - F + F
G - F + F
G . ID - F + F
A . ID - F + F
( E ) . ID - F + F
( F ) . ID - F + F
( ( ID ) F ) . ID - F + F
( ( ID ) G ) . ID - F + F
( ( ID ) A ) . ID - F + F
( ( ID ) ID ) . ID - F + F
( ( ID ) ID ) . ID - G - F
( ( ID ) ID ) . ID - A - F
( ( ID ) ID ) . ID - NUM - F
( ( ID ) ID ) . ID - NUM - G
( ( ID ) ID ) . ID - NUM - A
( ( ID ) ID ) . ID - NUM - ID

             E
            /|\
           E + F
          /|\   \
         E - F   G
         |   |   |
         F   G   A
         |   |   |
         G   A   ID
        /|\   \
       G . ID  NUM
       |
       A
       |
     ( E )
       |
       F
      /|\
     / | \
( ID ) .  F
          |
          G
          |
          A
          |
          ID
```

2.

-

3.

```
1.1 E  -> F E'
2.1 E' -> '+' F E'
2.2    | '-' F E'
2.3    | epsilon
3.1 F  -> '(' ID ')' F
3.2    |  G
4.1 G  -> A G'
5.1 G' -> '[' E ']' G'
5.2    | '.' ID G'
5.3    | epsilon
6.1 A  -> '(' E ')'
6.2    |  NUM
6.3    |  ID
```

4.
### FIRST

| - |           1 |           2 |           3 |           4 |
|---|-------------|-------------|-------------|-------------|
| E |           Ø |           ( |    ( num id |    ( num id |  
| E'| + - epsilon | + - epsilon | + - epsilon | + - epsilon |
| F |           ( |           ( |    ( num id |    ( num id |
| G |           Ø |    ( num id |    ( num id |    ( num id |
| G'| [ . epsilon | [ . epsilon | [ . epsilon | [ . epsilon |
| A |    ( num id |    ( num id |    ( num id |    ( num id |

### FOLLOW

| - | init |               1 |               2 |
|---|------|-----------------|-----------------|
| E |  eof |         eof ] ) |         eof ] ) |
| E'|    Ø |         eof ] ) |             eof |
| F |    Ø | eof + - epsilon | eof + - epsilon |
| G |    Ø | eof + - epsilon | eof + - epsilon |
| G'|    Ø | eof + - epsilon | eof + - epsilon |
| A |    Ø |     [ . epsilon |     [ . epsilon |

### FIRST+

|   - |                  first |          follow | first+
|-----|------------------------|-----------------|------
| 1.1 |               ( num id |                 | num id
| 2.1 |                      + |                 | +
| 2.2 |                      - |                 | -
| 2.3 |                epsilon |         eof ] ) | epsilon eof
| 3.1 |                      ( |                 | (
| 3.2 |               ( num id |                 | ( num id
| 4.1 |               ( num id |                 | ( num id
| 5.1 |                      [ |                 | [
| 5.2 |                      . |                 | .
| 5.3 |                epsilon | eof [ . epsilon | epsilon [ .
| 6.1 |               ( num id |                 | ( num id
| 6.2 |                    num |                 | num
| 6.3 |                     id |                 | id

