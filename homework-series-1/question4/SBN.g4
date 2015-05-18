grammar SBN;

@header{package question4;}

number : sign list;
sign : '+' #pos
     | '-' #neg;
list : list bit #listListBit
     | bit #listBit;
bit : '0' #zero
    | '1' #one;
