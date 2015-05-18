grammar SBN;

number : sign list;
sign : '+' | '-';
list : list bit | bit;
bit : '0' | '1';
