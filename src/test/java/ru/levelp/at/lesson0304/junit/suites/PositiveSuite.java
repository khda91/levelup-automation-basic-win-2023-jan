package ru.levelp.at.lesson0304.junit.suites;

import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeTags({"positive"})
@SelectPackages("ru.levelp.at.lesson0304.junit")
@IncludeClassNamePatterns(".*IT")
//@SelectClasses({SymbolDeliterPositiveIT.class})
public class PositiveSuite {
}
