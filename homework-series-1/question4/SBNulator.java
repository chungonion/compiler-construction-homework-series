package question4;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class SBNulator extends SBNBaseListener {
    private ParseTreeProperty<Integer> values;
    private ParseTreeProperty<Integer> positions;

    public SBNulator () {
        values = new ParseTreeProperty<>();
        positions = new ParseTreeProperty<>();
    }

    private void set(ParseTree node, int val) {
        values.put(node, val);
    }

    private void setDepth(ParseTree node, int pos){
        positions.put(node, pos);
    }

    public int getValue(ParseTree node) {
        return values.get(node);
    }

    public int getPosition(ParseTree node) {
        return positions.get(node);
    }

    @Override
    public void enterNumber (@NotNull SBNParser.NumberContext ctx) {
        setDepth(ctx.list(), 0);
    }

    @Override
    public void exitNumber(@NotNull SBNParser.NumberContext ctx) {
        set(ctx, getValue(ctx.list()) * getValue(ctx.sign()));
    }

    @Override
    public void exitPos(@NotNull SBNParser.PosContext ctx) {
        set(ctx, 1);
    }

    @Override
    public void exitNeg(@NotNull SBNParser.NegContext ctx) {
        set(ctx, -1);
    }

    @Override
    public void enterListListBit(@NotNull SBNParser.ListListBitContext ctx) {
        setDepth(ctx.list(), getPosition(ctx) + 1);
        setDepth(ctx.bit(), getPosition(ctx));
    }

    @Override
    public void exitListListBit(@NotNull SBNParser.ListListBitContext ctx) {
        set(ctx, getValue(ctx.bit()) + getValue(ctx.list()));
    }

    @Override
    public void enterListBit(@NotNull SBNParser.ListBitContext ctx) {
        setDepth(ctx.bit(), getPosition(ctx));
    }

    @Override
    public void exitListBit(@NotNull SBNParser.ListBitContext ctx) {
        set(ctx, getValue(ctx.bit()));

    }

    @Override public void exitZero(@NotNull SBNParser.ZeroContext ctx) {
        set(ctx, 0);
    }

    @Override public void exitOne(@NotNull SBNParser.OneContext ctx) {
        set(ctx, (int) Math.pow(2, getPosition(ctx)));
    }
}
