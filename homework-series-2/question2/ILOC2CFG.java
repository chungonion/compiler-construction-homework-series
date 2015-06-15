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
        Set<String> reachableNodes = new HashSet<>();
        Graph graph = new Graph();

        Node currentNode = null;
        for (Instr instruction : prog.getInstr()) {
            String label;
            if (instruction.hasLabel() && currentNode.getEdges().size() > 0) {
                label = instruction.getLabel().getValue();
                currentNode = ILOC2CFG.getOrCreate(label, nodes, graph);
            }

            for (Op op : instruction) {
                if (op.getClaz() == OpClaz.CONTROL) {
                    reachableNodes.add(currentNode.getId());

                    if (op.getOpCode() == OpCode.cbr) {
                        for (Operand arg : op.getArgs()) {
                            if (arg == op.getArgs().get(0)) { // skip register arg
                                continue;
                            }
                            reachableNodes.add(arg.toString());
                            currentNode.addEdge(ILOC2CFG.getOrCreate(arg.toString(), nodes, graph));
                        }
                    } else {
                        reachableNodes.add(op.getArgs().get(0).toString());
                        currentNode.addEdge(ILOC2CFG.getOrCreate(op.getArgs().get(0).toString(), nodes, graph));
                    }
                }
            }
        }

        Map<String, Node> minimalNodes = new HashMap<>();
        Set<Node> visitedNodes = new HashSet<>();
        Graph minimalGraph = new Graph();
        Node previousMinimalNode = null;

        for (Node node : graph.getNodes()) {
            if (reachableNodes.contains(node.getId())) {
                if (previousMinimalNode != null) {
                    previousMinimalNode.addEdge(node);
                }

                Node minimalNode = getOrCreate(node.getId(), minimalNodes, minimalGraph);
                visitedNodes.add(minimalNode);

                if (node.getEdges().size() > 0) {
                    for (Node edge : node.getEdges()) {
                        minimalNode.addEdge(getOrCreate(edge.getId(), minimalNodes, minimalGraph));
                    }

                    if (visitedNodes.containsAll(node.getEdges())) {
                        break; // apparently, we are only looking back
                    }

                } else {
                    previousMinimalNode = minimalNode;
                }
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
