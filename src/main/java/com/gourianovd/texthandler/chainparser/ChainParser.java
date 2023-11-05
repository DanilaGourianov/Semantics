package com.gourianovd.texthandler.chainparser;


import com.gourianovd.texthandler.entity.TextComposite;

public interface ChainParser {
    TextComposite parse(String from, TextComposite to);
}
