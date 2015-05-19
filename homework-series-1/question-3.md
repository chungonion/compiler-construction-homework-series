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
1  E  -> F E'
2  E' -> '+' F E'
3     |  '-' F E'
4     |  epsilon
5  F  -> '(' ID ')' F
6     |  G
7  G  -> A G'
8  G' -> '[' E ']' G'
9     |  '.' ID G'
10    |  epsilon
11  A -> '(' E ')'
12    |  NUM
13    |  ID
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
| E'|    Ø |         eof ] ) |         eof ] ) |
| F |    Ø |     + - eof ] ) |     + - eof ] ) |
| G |    Ø |     + - eof ] ) |     + - eof ] ) |
| G'|    Ø |     + - eof ] ) |     + - eof ] ) |
| A |    Ø | [ . + - eof ] ) | [ . + - eof ] ) |

### FIRST+

|  - |    first |      follow |          first+ |
|----|----------|-------------|-----------------|
|  1 | ( num id |             |        ( num id |
|  2 |        + |             |               + |
|  3 |        - |             |               - |
|  4 |  epsilon |     eof ] ) | epsilon eof ] ) |
|  5 |        ( |             |               ( |
|  6 |   num id |             |        ( num id |
|  7 |   num id |             |        ( num id |
|  8 |        [ |             |               [ |
|  9 |        . |             |               . |
| 10 |  epsilon | + - eof ] ) |     eof + - ] ) |
| 11 |        ( |             |               ( |
| 12 |      num |             |             num |
| 13 |       id |             |              id |

5.

The FIRST+ set contains non-empty intersections for the F non-terminal, which makes it not LL(1) compliant. For example, this goes wrong on input `(35)`, because at the F rule this can either go to 5 or 11, through 7. For a LL(1) parser, this has decision should be clear by just looking one step ahead.
