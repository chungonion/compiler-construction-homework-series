grammar G0;

@header{package question3;}

e : e ('+' | '-') f | f;
f : '(' ID ')' f | g;
g : g ('[' e ']' | '.' ID) | a;
a : '(' e ')' | NUM | ID;

NUM : [0-9]+;
ID : [a-zA-Z0-9]+;
