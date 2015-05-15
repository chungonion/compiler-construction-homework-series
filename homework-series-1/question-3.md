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