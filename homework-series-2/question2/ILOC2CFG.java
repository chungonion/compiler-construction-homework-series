package question2;

import pp.iloc.Assembler;
import pp.iloc.model.*;
import pp.iloc.parse.FormatException;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ILOC2CFG {
    /**
     * The singleton instance of this class.
     */
    private static final ILOC2CFG instance = new ILOC2CFG();

    /**
     * Returns the singleton instance of this class.
     */
    public static ILOC2CFG instance() {
        return instance;
    }

    /**
     * Converts an ILOC file given as parameter and prints out the
     * resulting CFG.
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: filename");
        }
        try {
            Program prog = Assembler.instance().assemble(new File(args[0]));
            System.out.println(instance().convert(prog));
        } catch (FormatException | IOException exc) {
            exc.printStackTrace();
        }
    }

    /**
     * Private constructor for the singleton instance.
     */
    private ILOC2CFG() {
        // empty by design
    }

    public Graph convert(Program prog) {
        Map<String, Node> nodes = new HashMap<>();
        Graph graph = new Graph();

        Node currentNode = null;
        for (Instr instruction : prog.getInstr()) {
            if (currentNode == null || instruction.hasLabel() && currentNode.getEdges().size() > 0) {
                currentNode = ILOC2CFG.getOrCreate(instruction.getLabel().getValue(), nodes, graph);
            }

            for (Op op : instruction) {
                if (op.getOpCode() == OpCode.cbr) {
                    for (Operand arg : op.getArgs()) {
                        if (arg == op.getArgs().get(0)) { // skip register arg
                            continue;
                        }
                        currentNode.addEdge(ILOC2CFG.getOrCreate(arg.toString(), nodes, graph));
                    }
                } else if (op.getOpCode() == OpCode.jumpI) {
                    currentNode.addEdge(ILOC2CFG.getOrCreate(op.getArgs().get(0).toString(), nodes, graph));
                }
            }
        }

        Map<String, Node> minimalNodes = new HashMap<>();
        Set<Node> visitedNodes = new HashSet<>();
        Graph minimalGraph = new Graph();

        for (Node node : graph.getNodes()) {
            Node minimalNode = getOrCreate(node.getId(), minimalNodes, minimalGraph);
            visitedNodes.add(minimalNode);

            for (Node edge : node.getEdges()) {
                minimalNode.addEdge(getOrCreate(edge.getId(), minimalNodes, minimalGraph));
            }

            if (visitedNodes.containsAll(node.getEdges())) {
                break; // apparently, we are only looking back
            }
        }

        return minimalGraph;
    }

    public static Node getOrCreate(String label, Map<String, Node> nodes, Graph graph) {
        Node node = nodes.get(label);
        if (node == null) {
            node = graph.addNode(label);
            nodes.put(label, node);
        }
        return node;
    }

}
