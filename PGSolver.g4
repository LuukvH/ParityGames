grammar PGSolver;

parityGame : (header)? nodeSpec*;

header : 'parity' identifier ';';
nodeSpec : identifier priority owner successors (name)? ;

identifier : NUMBER;
priority : NUMBER;
owner : '0' | '1';
successors: identifier (',' identifier)*;
name : STRING;

NUMBER : [0-9]+;
STRING : [a-zA-Z0-9]+;