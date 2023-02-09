package ru.levelp.at.lesson0304.junit.suites;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import ru.levelp.at.lesson0304.junit.tags.SymbolDeliterPositiveIT;

@Suite
//@IncludeTags({"positive"})
//@SelectPackages("ru.levelp.at.lesson0304.junit.tags")
@SelectClasses({SymbolDeliterPositiveIT.class})
public class PositiveSuite {
}
