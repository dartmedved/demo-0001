package ru.demo.demo0001;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@Builder
@ToString
public class TreeResult {
    private Character letter;
    private List<Character> trail;
}
