package ru.demo.demo0001;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@UtilityClass
@Slf4j
public class TreeWalker {
    public TreeResult findLetter(final char letter, final Tree root) {
        if (root == null) {
            return null;
        }
        return findLetterInternal(letter, root, new ArrayList<>());
    }

    private TreeResult findLetterInternal(final char letter, Tree root, final List<Character> trail) {
        final Queue<Tree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            final Tree target = queue.poll();
            trail.add(target.getLetter());
            if (target.getLetter() == letter) {
                return TreeResult.builder().letter(letter).trail(trail).build();
            }
            if (target.terminal()) {
                continue;
            }
            if (target.getLeft() != null) {
                queue.add(target.getLeft());
            }
            if (target.getRight() != null) {
                queue.add(target.getRight());
            }
        }
        return TreeResult.builder().trail(trail).build();
    }
}
