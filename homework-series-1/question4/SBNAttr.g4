grammar SBNAttr;

number returns [int value]
		: s=sign l=list[0] { $value = ($s.negative ? -$l.value : $l.value); };

sign returns [boolean negative]
		: '+' { $negative = false; }
		| '-' { $negative = true; };

list [int position] returns [int value]
        : l = list[$position+1] b = bit[$position] {
            $value = $b.value + $l.value;
        }
        | b = bit[$position] {
            $value = $b.value;
        };

bit [int position] returns [int value]
		: '0' {$value = 0; }
		| '1' {$value = (int) Math.pow(2, $position); };

WS : [ \t\n\r]+ -> skip;
