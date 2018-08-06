package ru.demo.demo0001;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
class Tree {
    private char letter;
    private Tree left;
    private Tree right;

    public boolean terminal(){
        return left==null &&  right==null;
    }
}

