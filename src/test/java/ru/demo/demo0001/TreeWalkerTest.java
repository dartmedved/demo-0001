package ru.demo.demo0001;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

@Slf4j
public class TreeWalkerTest {
    Tree root;

    @Before
    public void setup(){

        final Tree h = Tree.builder().letter('h').build();

        final Tree d = Tree.builder().letter('d').build();
        final Tree e = Tree.builder().letter('e').left(h).build();
        final Tree f = Tree.builder().letter('f').build();
        final Tree g = Tree.builder().letter('g').build();

        final Tree b = Tree.builder().letter('b')
                .left(d)
                .right(e)
                .build();


        final Tree c = Tree.builder().letter('c')
                .left(f)
                .right(g)
                .build();

        root = Tree.builder()
                .letter('a')
                .left(b)
                .right(c)
                .build();
    }

    @Test
    public void testWalk(){
        final TreeResult result = TreeWalker.findLetter('h',root);
        assertThat(result,is(notNullValue()));
        assertThat(result.getLetter(),is(equalTo('h')));
        assertThat(result.getTrail().size()>0,is(equalTo(true)));
        log.info("Trail : {}",result.getTrail());
        assertThat(result.getTrail(),contains('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'));
    }

    @Test
    public void testNoWalk(){
        final TreeResult result = TreeWalker.findLetter('q',root);
        assertThat(result,is(notNullValue()));
        assertThat(result.getLetter(),is(nullValue()));
        log.info("Trail : {}",result.getTrail());
        assertThat(result.getTrail(),contains('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'));
    }
}
