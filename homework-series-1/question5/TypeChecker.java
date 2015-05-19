package question5;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TypeChecker extends TypeUseBaseListener {

    private final AwesomeSymbolTable symbolTable;
    private List<String> errors;

    public TypeChecker() {
        symbolTable = new AwesomeSymbolTable();
        errors = new ArrayList<>();
    }

    @Override
    public void enterSeries(TypeUseParser.SeriesContext ctx) {
        symbolTable.openScope();
    }

    @Override
    public void exitSeries(TypeUseParser.SeriesContext ctx) {
        symbolTable.closeScope();
    }

    @Override
    public void enterDecl(TypeUseParser.DeclContext ctx) {
        String id = ctx.ID(0).getText();
        String type = ctx.ID(1).getText();

        if (symbolTable.contains(id)) {
            errors.add(String.format("Error on line %s, pos %s", ctx.ID().get(0).getSymbol().getLine(), ctx.ID().get(0).getSymbol().getCharPositionInLine()));
        } else {
            symbolTable.add(id, type);
        }
    }


    @Override
    public void enterAssign(TypeUseParser.AssignContext ctx) {
        String symbol0 = ctx.ID(0).getText();
        String symbol1 = ctx.ID(1).getText();

        if (!symbolTable.getType(symbol0).equals(symbolTable.getType(symbol1))) {
            errors.add(String.format("Error on line %s, pos %s", ctx.ID().get(0).getSymbol().getLine(), ctx.ID().get(0).getSymbol().getCharPositionInLine()));
        }
    }
    
    public List<String> getErrors() {
        return errors;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("USAGE: <file>");
        }
        String text = null;
        try {
            System.out.println(args[0]);
            text = new String(Files.readAllBytes(Paths.get(args[0])));
        } catch (IOException e) {
            System.err.println("Could not open file");
        }

        TypeChecker typeChecker = new TypeChecker();
        ParseTree tree = typeChecker.parseTypeUse(text);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(typeChecker, tree);
        typeChecker.getErrors().stream().forEach(System.out::println);
    }

    private ParseTree parseTypeUse(String text) {
        CharStream chars = new ANTLRInputStream(text);
        Lexer lexer = new TypeUseLexer(chars);
        TokenStream tokens = new CommonTokenStream(lexer);
        TypeUseParser parser = new TypeUseParser(tokens);
        return parser.program();
    }
}
