package com.gismatullin.rabbitapp.dataproviders;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class TestStringsProvider implements ArgumentsProvider {

    private final static List<String> strings = Arrays.asList(
        "hello rabbit!",
        "12345",
        "?a=1%",
        ""
    );

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        List<Arguments> args = strings.stream()
            .map(Arguments::of)
            .collect(Collectors.toList());
        return args.stream();
    }
    
}
